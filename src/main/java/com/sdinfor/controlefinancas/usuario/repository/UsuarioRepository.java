package com.sdinfor.controlefinancas.usuario.repository;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
