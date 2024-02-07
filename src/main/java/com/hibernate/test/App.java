package com.hibernate.test;

import com.hibernate.Model.Employee;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class App 
{
    //Interfaz de tipo entity que contiene los metodos para insertar, recuperar y borrar elementos.
    //Gestor de dependencias, metodos para inciar consultas con lenguaje JPQL
/*
    @PersistenceContext(unitName = "miPersistencia" )  // Nos permiter acceder a nuestro gestor de persistencia
*/
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    public static void main( String[] args )
    {
        /*Creamos gestor de persistencia */
         emf = Persistence.createEntityManagerFactory("miPersistencia");
        manager = emf.createEntityManager();
        //Se nombra con el nombre de la clase
        List<Employee> employees = manager.createQuery("FROM Employee").getResultList();
        System.out.println("En esta base de datos hay: "+employees.size() +" empleados");
        Employee e = new Employee(123L,"Karla","Suarez", new Date());
        Employee e2 = new Employee(124L,"Martha","Hernandez", new Date());

        //Transacción --> Es una unidad de trabajo que agrupa una serie de operaciones en la base de datos.
        //Inicio la transacción de gestor de persistencia
        manager.getTransaction().begin();
        //Guarda la instancia de la entidad en la base de datos
        manager.persist(e);
        manager.persist(e2);
        manager.getTransaction().commit();
        //Finaliza la transacción del gestor de persistencia
        showAll();
    }

    public static void showAll(){
        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("Now: "+ employees.size());
        for (Employee e: employees) {
            System.out.println("Employee: "+e.toString());
        }

    }
}
