package br.com.luizsoftware.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.luizsoftware.dto.FuncionarioDTO;
import br.com.luizsoftware.util.JPAUtil;

public class FuncionarioDAO {

    public List<FuncionarioDTO> listarDTO() {

        EntityManager em = JPAUtil.getEntityManager();

        String jpql =
          "SELECT new br.com.luizsoftware.dto.FuncionarioDTO(" +
          "f.id, f.nome, f.email, d.nome, c.nome, f.salario) " +
          "FROM Funcionario f " +
          "JOIN f.departamento d " +
          "JOIN f.cargo c";

        return em.createQuery(jpql, FuncionarioDTO.class)
                 .getResultList();
    }
}
