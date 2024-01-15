package groupid.artifactid;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Clase de inscripción
@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {
    //Singifica para identicar una clave primaria de una entidad compuesta 
    @EmbeddedId
    private EnrolmentId id;
    //Establece una relación de muchos a uno
    @ManyToOne
    //Sirve para mapear un llave primaria compuesta externa a la entidad mapeada de la entidad student
    // studentId(Clase Enrolment)---Mapea---->id(Student)
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                name = "enrolment_student_id_fk"
    )
    )
    private Student student;
    //Establece relación Muchos a uno
    @ManyToOne
    //Sirve para mapear un llave primaria compuesta externa a la entidad mapeada de la entidad student
    // courseIdId(Clase Enrolment)---Mapea---->id(Course)
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;
    @Column(
            name = "created_at",
            nullable = false
            //columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public Enrolment(EnrolmentId id, Student student, Course course, LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
