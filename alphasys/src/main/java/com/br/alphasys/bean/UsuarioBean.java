package com.br.alphasys.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.alphasys.model.Usuario;
import com.br.alphasys.model.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService usuarioService;   // camada de serviço

    private Usuario usuario;                 // usuário atual (cadastro/edição)
    private List<Usuario> usuarios;          // lista para tabela

    @PostConstruct
    public void init() {
        usuario = new Usuario();             // prepara objeto vazio
        listarUsuarios();                    // carrega lista logo na abertura da tela
    }

    public void salvar() {
        try {
            usuarioService.salvar(usuario);
            adicionarMensagem("Usuário salvo com sucesso!");
            listarUsuarios();                // recarrega tabela
            usuario = new Usuario();         // limpa formulário
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao salvar: " + e.getMessage());
        }
    }

    public void editar(Usuario u) {
        this.usuario = u;                    // carrega na tela
    }

    public void excluir(Usuario u) {
        try {
            usuarioService.excluir(u);
            adicionarMensagem("Usuário removido!");
            listarUsuarios();
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao excluir: " + e.getMessage());
        }
    }

    private void listarUsuarios() {
        usuarios = usuarioService.listar();
    }

    private void adicionarMensagem(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    private void adicionarMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    // GETTERS e SETTERS
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
