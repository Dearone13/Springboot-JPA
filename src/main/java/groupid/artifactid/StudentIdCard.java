package groupid.artifactid;

import jakarta.persistence.*;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                name = "student_id_card_number_unique",

        }
)
public class StudentIdCard {
    private Long id;
    private String CardNumber;
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
