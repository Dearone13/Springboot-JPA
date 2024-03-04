package com.hibernate.Model;

import lombok.*;

import javax.persistence.*;

@Getter //Getter, setter, toString();
@Setter
@NoArgsConstructor ///Constructor sin parametro
//@AllArgsConstructor //Constructor con parametros



@Entity
@Table(name = "address")
public class Address {

    public Address(Long id, String address, String section, String department, String country) {
        this.id = id;
        this.address = address;
        this.section = section;
        this.department = department;
        this.country = country;
    }

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

    @Transient
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Employee employee;



}
