package com.sdinfor.controlefinancas.usuario.repository;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @BeforeAll
    public static Usuario criarUsuario(){
        return Usuario.builder()
                .nome("usuario")
                .email("usuario@gmail.com")
                .senha("123456")
                .build();
    }

    @Test
    public void deveVerificarAExistenciaDeUMEmail(){

        entityManager.persist(criarUsuario());
        //ação - execução
        var result = repository.existsByEmail("usuario@gmail.com");
        //verificação
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail(){
        var result = repository.existsByEmail("usuario@gmail.com");
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void devePesistirUmUsuarioNaBaseDeDados(){
        var result = repository.save(criarUsuario());
        Assertions.assertThat(result.getId()).isNotNull();
    }

    @Test
    public void deveBuscarOUsuarioPorEmail(){
        entityManager.persist(criarUsuario());
        var result = repository.findByEmail("usuario@gmail.com");
        Assertions.assertThat(result.isPresent()).isTrue();
    }


    @Test
    public void deveRetornarVazioAoBuscarOUsuarioPorEmail(){
        var result = repository.findByEmail("usuario@gmail.com");
        Assertions.assertThat(result.isPresent()).isFalse();
    }
}
