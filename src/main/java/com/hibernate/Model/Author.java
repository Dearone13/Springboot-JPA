package com.hibernate.Model;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "Id")
    @NonNull
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "nationality")
    @NonNull
    private String nationalitiy;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //mapeamos con la coincidencia de la columna
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL) //Un autor tiene muchos libros
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationalitiy='" + nationalitiy + '\'' +
                '}';
    }
}
