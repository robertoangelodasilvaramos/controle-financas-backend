package com.sdinfor.controlefinancas.usuario.service.impl;

import com.sdinfor.controlefinancas.exeption.ErroAutenticationException;
import com.sdinfor.controlefinancas.exeption.RegraNegocioExcepition;
import com.sdinfor.controlefinancas.usuario.model.entity.Usuario;
import com.sdinfor.controlefinancas.usuario.repository.UsuarioRepository;
import com.sdinfor.controlefinancas.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.http.HttpResponse;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;


    @Override
    public Usuario autenticar(String email, String senha) {
        var usuario = repository.findByEmail(email);
        //testa email
        if(usuario.isEmpty()) {
            throw new ErroAutenticationException("Usuário não Encontrado para o E-mail informado!");
        }
        //testa senha
        else if (usuario.get().getSenha().equals(email)){
            throw new ErroAutenticationException("Senha invalidos!");
        }
        //retorna usuario logado
        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        var existe = repository.existsByEmail(email);
        if (existe) throw new RegraNegocioExcepition("Já existe um usuário cadastrado com esse e-mail!");
    }
}
