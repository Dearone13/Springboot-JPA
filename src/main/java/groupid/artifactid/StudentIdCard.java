package groupid.artifactid;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                name = "student_id_card_number_unique",

        }
)
public class StudentIdCard {

    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(
            name = "id",
            //Significa que la columna no es actulizable
            updatable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String CardNumber;
    //Genera una relacion UnoaUno de relacion tipo cascada

    //La modificaciones se propagaran en la esntidad student en la base de datos
    @OneToOne(cascade = CascadeType.ALL)
    //Define la modificación de la columna de la entidad student
    @JoinColumn(
            //Indica el nombre de la columna de la entidad
            name = "student_id",
            //Referencia al atributo id de la clase en la columna de entidad
            referencedColumnName = "id",
            //Crea una restricción de clave foranea en la base de datos
            foreignKey = @ForeignKey(name = "student_id_fk" )
    )
    private Student student;

    public StudentIdCard(String cardNumber) {
        this.CardNumber = cardNumber;
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.CardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", CardNumber='" + CardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
