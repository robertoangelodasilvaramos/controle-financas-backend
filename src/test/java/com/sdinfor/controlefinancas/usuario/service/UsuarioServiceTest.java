package com.sdinfor.controlefinancas.usuario.service;



import com.sdinfor.controlefinancas.exeption.ErroAutenticationException;
import com.sdinfor.controlefinancas.exeption.RegraNegocioExcepition;
import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import com.sdinfor.controlefinancas.usuario.repository.UsuarioRepository;
import com.sdinfor.controlefinancas.usuario.service.impl.UsuarioServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @MockBean
    UsuarioRepository repository;

    @Before
    public void setUp(){
        service = new UsuarioServiceImpl(repository);
    }

    @Test(expected = ErroAutenticationException.class)
    public void LancarErroQuandoNaoEncontrarUsuarioCadastradoComOEmailInformado(){
    Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
    service.autenticar("email@email.com", "senha");
    }

    @Test
    public void deveLancarErroQuandoASenhaForIncorreta(){
        String senha = "senha";
        Usuario usu = Usuario.builder().nome("usuario").email("email@email.com").senha(senha).id(2L).build();
        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(usu));


       Assertions.assertThat(service.autenticar("email@email.com", "senha")).overridingErrorMessage("Senha invalidos!");
    }

    @Test()
    public void deveAutenticarUmUsuarioComSucesso(){
        String email = "email@email.com";
        String senha = "senha";

        Usuario usuario = Usuario.builder().email(email).senha(senha).id(1L).build();

        Mockito.when(repository.findByEmail(email) ).thenReturn(Optional.of(usuario));

        Usuario result = service.autenticar(email, senha);

        Assertions.assertThat(result).isNotNull();
    }

    @Test()
    public void deveValidarEmail(){
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
        service.validarEmail("email@elamil.com");
    }

    @Test(expected = RegraNegocioExcepition.class)
    public void deveLancarExcpitionAoValidarEmailQuandoEmailCadastrado(){
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
        service.validarEmail("usuario@email.com");

    }
}
