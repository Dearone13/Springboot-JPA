package com.hibernate.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter //getter, setter y toString
@Setter
@NoArgsConstructor  // constructor sin parametros // con parametros
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    public Employee( Long code, String lastName,  String firstName, LocalDateTime dateBorn) {
        Code = code;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateBorn = dateBorn;
    }

    private static  final long serialVersionUID = 1;

    @Id  // -->Identificador
    // cdt eh
    @Column(name = "e_code")
    private Long Code;


    @Column(name = "e_lastName")
    private String lastName;


    @Column(name = "e_firstName")
    private String firstName;


    @Column(name = "e_dateBorn")
    private LocalDateTime dateBorn;

    //En esta caso si solo se define de esta manera seria de tipo unidireccional
    //Se creo un relación meramente unidireecional de empleado a dirección pero no de dirección a empleado
    @OneToOne(cascade = CascadeType.ALL)  // -->Relación de uno a uno con una clave foranea a tipo dirección, tambien si un entidad es creada en relación persiste y guarda
    @JoinColumn(name = "address_fk")  //-->Determina dueño del campo de tiempo dirección
    private Address address;

    @Override
    public String toString() {
        return "Employee{" +
                "Code=" + Code +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateBorn=" + dateBorn +
                ", address=" + address.getId() +
                '}';
    }
}
