package com.hibernate.test;

import com.hibernate.Model.Employee;
import javax.persistence.*;
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

    }
}
