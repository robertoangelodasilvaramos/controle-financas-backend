package com.sdinfor.controlefinancas.usuario.service.impl;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import com.sdinfor.controlefinancas.usuario.repository.UsuarioRepository;
import com.sdinfor.controlefinancas.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;


    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {

    }
}
