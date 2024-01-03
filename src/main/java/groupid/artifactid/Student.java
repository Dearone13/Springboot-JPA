package groupid.artifactid;


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

//Es una buen practica nombrar la entidad sino defines va ser la misma de la clase
@Entity(name = "Student")
public class Student {
    @Id
    //Generador de secuencias con valores unicos
    @SequenceGenerator(
            //Nombre del generador de secuencias
            name = "student_sequence",
            //NOmbre de secuencias en la base de datos
            sequenceName = "student_sequence",
            //Cantidad de valores a reservar=> Por detefecto son 50
            allocationSize = 1
    )
    //Indica la estrategia de generación de valores de una clave primaria
    @GeneratedValue(
            //Estrategia de generación de valores
            strategy = SEQUENCE,
            //Nombre del generador de secuencias
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "second_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;
    @Column(name = "age")
    private Integer age;

    public Student(Long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
