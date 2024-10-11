package org.example.demo1.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class EntityManagerUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo1");

    public static EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();
    }
}
