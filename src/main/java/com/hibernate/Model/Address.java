package com.hibernate.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data  //Getter, setter, toString();
@NoArgsConstructor ///Constructor sin parametro
@AllArgsConstructor //Constructor con parametros

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id_address")
    private Long id;
    @Column(name = "address")
    private String address;

    @Column(name = "section")
    private String section;

    @Column(name = "deparment")
    private String department;

    @Column(name = "country")
    private String country;


}
