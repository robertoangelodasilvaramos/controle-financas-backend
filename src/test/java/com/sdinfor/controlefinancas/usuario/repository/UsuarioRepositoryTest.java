package com.sdinfor.controlefinancas.usuario.repository;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveVerificarAExistenciaDeUMEmail(){
        //cenário
        var usuario = Usuario.builder().nome("usuario").email("usuario@emaiol.com").senha("123").build();
        repository.save(usuario);
        //ação - execução
        var result = repository.existsByEmail("usuario@emaiol.com");
        //verificação
        Assertions.assertThat(result).isTrue();
    }

}
