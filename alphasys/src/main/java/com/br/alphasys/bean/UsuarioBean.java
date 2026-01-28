package com.br.alphasys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.br.alphasys.model.Usuario;
import com.br.alphasys.service.UsuarioService;

@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    private UsuarioService service = new UsuarioService();

    public void salvar() {
        service.salvar(usuario);
        usuario = new Usuario();
        listar();
    }

    public void listar() {
        usuarios = service.listar();
    }

    public void excluir(Usuario u) {
        service.excluir(u);
        listar();
    }

    // GETTERS E SETTERS
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
