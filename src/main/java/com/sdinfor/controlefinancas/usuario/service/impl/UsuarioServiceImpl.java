package com.sdinfor.controlefinancas.usuario.service.impl;

import com.sdinfor.controlefinancas.exeption.RegraNegocioExcepition;
import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import com.sdinfor.controlefinancas.usuario.repository.UsuarioRepository;
import com.sdinfor.controlefinancas.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@RequiredArgsConstructor
@Service
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
        var existe = repository.existsByEmail(email);
        if (existe) throw new RegraNegocioExcepition("Já existe um usuário cadastrado com esse e-mail!");
    }
}
