package com.hibernate.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data //getter, setter y toString
@NoArgsConstructor // constructor sin parametros
@AllArgsConstructor // con parametros
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
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
    private Date dateBorn;
}
