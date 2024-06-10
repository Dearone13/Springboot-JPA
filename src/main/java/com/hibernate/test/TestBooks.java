package com.hibernate.test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBooks {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miPersistencia");
    public static void main(String[] args) {
        createData();
        showData();
    }

    private static void showData() {
        EntityManager em = emf.createEntityManager();
        em.close();
    }

    private static void createData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
}
