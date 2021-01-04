package com.sdinfor.controlefinancas.usuario.repository;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
