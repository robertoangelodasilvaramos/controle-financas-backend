package com.sdinfor.controlefinancas.usuario.service;

import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);


}
