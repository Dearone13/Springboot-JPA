package com.hibernate.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data //getter, setter y toString
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

    //@Transient
    @OneToOne(cascade = CascadeType.ALL)  // -->Relación de uno a uno con una clave foranea a tipo dirección, tambien si un entidad es creada en relación persiste y guarda
    @JoinColumn(name = "address_fk")  //-->Determina dueño del campo de tiempo dirección
    private Address address;


}
