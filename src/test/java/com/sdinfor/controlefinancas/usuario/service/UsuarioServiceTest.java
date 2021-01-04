package com.sdinfor.controlefinancas.usuario.service;


import com.sdinfor.controlefinancas.exeption.RegraNegocioExcepition;
import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import com.sdinfor.controlefinancas.usuario.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test()
    public void deveValidarEmail(){
        repository.deleteAll();
        service.validarEmail("email@elamil.com");
    }

    @Test(expected = RegraNegocioExcepition.class)
    public void deveLancarExcpitionAoValidarEmailQuandoEmailCadastrado(){
        var usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
        repository.save(usuario);
        service.validarEmail("usuario@email.com");

    }
}
