package br.com.luizsoftware.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.luizsoftware.bo.FuncionarioBO;
import br.com.luizsoftware.dto.FuncionarioDTO;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable {

    private List<FuncionarioDTO> lista;

    private FuncionarioBO bo = new FuncionarioBO();

    @PostConstruct
    public void init() {
        lista = bo.listar();
    }

    public List<FuncionarioDTO> getLista() {
        return lista;
    }
}
