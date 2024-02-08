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
        startAll();
        showAll();
        manager.getTransaction().begin();
        Employee e = manager.find(Employee.class,123L);
        e.setFirstName("Carmensa");
        e.setLastName("Bohorquez");
        manager.getTransaction().commit();
        //manager.merge()  //Mezcla los dos estados de las entidades si una deja de estra adminsitrada
        showAll();
        //Cuando hago un manager.close() la entidad deja de estar administrada
    }

    public static void startAll(){
        //Se nombra con el nombre de la clase
        List<Employee> employees = manager.createQuery("FROM Employee").getResultList();
        System.out.println("En esta base de datos hay: "+employees.size() +" empleados");
        Employee e = new Employee(123L,"Martinez","Karla", new Date());
        e.setLastName("Guarnizo");
        //Managed permite saber cuando hay cambios al instanciar la clase manager
        //Empleado se vuelve un objeto de mitpo managed
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
    }

    public static void showAll(){
        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("Now: "+ employees.size());
        for (Employee e: employees) {
            System.out.println("Employee: "+e.toString());
        }

    }
}
