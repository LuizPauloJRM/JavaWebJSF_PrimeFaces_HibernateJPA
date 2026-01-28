package br.com.luizsoftware.bo;

import antlr.collections.List;
import br.com.luizsoftware.dao.FuncionarioDAO;
import br.com.luizsoftware.dto.FuncionarioDTO;

public class FuncionarioBO {

    private FuncionarioDAO dao = new FuncionarioDAO();

    public java.util.List<FuncionarioDTO> listar() {
        return dao.listarDTO();
    }
}