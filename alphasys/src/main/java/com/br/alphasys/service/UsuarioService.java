package com.br.alphasys.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.br.alphasys.dao.UsuarioDAO;
import com.br.alphasys.model.Usuario;

@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    /**
     * Salva ou atualiza um usuário.
     * Regras de negócio podem ser aplicadas aqui.
     */
    public void salvar(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new RuntimeException("Nome do usuário é obrigatório.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new RuntimeException("Email do usuário é obrigatório.");
        }

        if (usuario.getId() == null) {
            usuarioDAO.inserir(usuario);
        } else {
            usuarioDAO.atualizar(usuario);
        }
    }

    /**
     * Excluir um usuário pelo objeto.
     */
    public void excluir(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }

    /**
     * Buscar todos os usuários.
     */
    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    /**
     * Buscar usuário por ID.
     */
    public Usuario buscarPorId(Long id) {
        return usuarioDAO.buscarPorId(id);
    }
}
