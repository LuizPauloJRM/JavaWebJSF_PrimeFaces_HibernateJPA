package com.br.alphasys.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.br.alphasys.model.Usuario;
import com.br.alphasys.util.JPAUtil;

import jakarta.persistence.EntityManager;

@Named
@RequestScoped
public class UsuarioDAO {

    public void inserir(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao inserir usuário", e);
        } finally {
            em.close();
        }
    }

    public void atualizar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar usuário", e);
        } finally {
            em.close();
        }
    }

    public void excluir(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, usuario.getId());
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir usuário", e);
        } finally {
            em.close();
        }
    }

    public List<Usuario> listar() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("FROM Usuario", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }
}
