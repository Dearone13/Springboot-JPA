package groupid.artifactid;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "book")
@Table(name = "book")

public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "created_At",
            nullable = false,
            //Almacenar datos de de valores y fecha sin tener en cuenta información de zona horaria
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;
    @Column(
            name = "book_name",
            nullable = false
    )
    private String bookName;
    @ManyToOne
    @JoinColumn(
            //Nombre de la llave
            name = "student_id",
            //Que no sea de tipo nulo
            nullable = false,
            //Referencia en la otra tabla de la columna id de entidad Student
            referencedColumnName = "id",
            //Creamos llave foreana
            foreignKey = @ForeignKey(
                    //nombre de la llave foreana
                    name = "student_book_fk"
            )
            )
    private Student student;

    public Book() {
    }

    public Book(String bookName,LocalDateTime createdAt ) {
        this.createdAt = createdAt;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }
}
