package com.hibernate.test;

import com.hibernate.Model.Author;
import com.hibernate.Model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestAuthors {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miPersistencia");

    public static void main(String[] args) {
        createData();
        showData();
    }

    private static void showData() {
        EntityManager em = emf.createEntityManager();
        Author author = em.find(Author.class, 2L);
        List<Book> books = author.getBooks();
        for ( Book book: books) {
            System.out.println(book);
        }
        System.out.println(author);
        em.close();
    }

    private static void createData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author1 = new Author(1L,"Pablo martinez","Colombia");
        Author author2 = new Author(2L,"Maria Suarez","Costa Rica");
        Author author3 = new Author(3L,"Angela Duarte","Chile");

        em.persist(author1);
        em.persist(author2);
        em.persist(author3);

        em.persist(new Book (1L, "Programar en Java es fácil", author2));
        em.persist( new Book (2L, "Cómo vestirse con estilo", author3));
        em.persist(new Book(3L, "Cómo cocinar sin quemar la cocina", author1));
        em.persist(new Book (4L, "Programar en Cobol es divertido", author2));
        em.persist(new Book(5L, "Programar en Cobol no es divertido", author2));
        em.getTransaction().commit();
        em.close();
    }
}
