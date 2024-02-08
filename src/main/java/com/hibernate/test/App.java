package com.hibernate.test;

import com.hibernate.Model.Employee;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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

            /*Cuando una entidad es de tipo detached, las modificaciones a sus campos no alteran la estructura de la base de datos.
             Es por ello que hay que usar merge para convertirla a una entidad managed.
            Además, con remove podemos eliminar entidades del sistema por lo que aprovecho para contarlo.*/

            /*También usamos LocalDateTime de java 8*/
    {   EntityManager man = emf.createEntityManager();
        Employee e = new Employee(10L,"Cardona","Ana",  LocalDateTime.now());
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();   //---> La entidad se vuelve detached (Ya no esta administrada)
        //manager.merge()  //Mezcla los dos estados de las entidades si una deja de estra adminsitrada
        //Cuando hago un manager.close() la entidad deja de estar administrada
        showAll();
        man = emf.createEntityManager();
        man.getTransaction().begin();
        e = man.merge(e); //Se actuliza el estado de e como entidad
        e.setFirstName("Maria");
        man.remove(e); //Elimina la entidad
        man.getTransaction().commit();
        man.close();

        showAll();
    }

    public static void startAll(){
        EntityManager man = emf.createEntityManager();
        Employee e = new Employee(10L,"Cardona","Ana", LocalDateTime.now());
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();
    }

    public static void showAll(){
        EntityManager man = emf.createEntityManager();
        List<Employee> employees = (List<Employee>) man.createQuery("FROM Employee").getResultList();
        System.out.println("Now: "+ employees.size());
        for (Employee e: employees) {
            System.out.println("Employee: "+e.toString());
        }

    }
}
