package com.hibernate.test;

import com.hibernate.Model.Address;
import com.hibernate.Model.Employee;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class App 
{
    //Interfaz de tipo entity que contiene los metodos para insertar, recuperar y borrar elementos.
    //Gestor de dependencias, metodos para inciar consultas con lenguaje JPQL
/*
    @PersistenceContext(unitName = "miPersistencia" )  // Nos permiter acceder a nuestro gestor de persistencia
          /*Creamos gestor de persistencia */
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miPersistencia");
    public static void main( String[] args )
    {   EntityManager man = emf.createEntityManager();
        Employee e = new Employee   (10L,"Cardona","Ana",LocalDateTime.now());
        e.setAddress(new Address(2l,"calle vargas","domiguez","Cundinamarca","Colombia"));
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();   //---> La entidad se vuelve detached (Ya no esta administrada)
        showAll();
    }

/*    public static void startAll(){
        EntityManager man = emf.createEntityManager();
        //Employee e = new Employee(10L,"Cardona","Ana", LocalDateTime.now());
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();
    }*/

    public static void showAll(){
        EntityManager man = emf.createEntityManager();
        List<Employee> employees = (List<Employee>) man.createQuery("FROM Employee").getResultList();
        System.out.println("Now: "+ employees.size());
        for (Employee e: employees) {
            System.out.println("Employee: "+e.toString());
        }

    }
}
