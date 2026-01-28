package br.com.luizsoftware.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("ProjetoDTO");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
