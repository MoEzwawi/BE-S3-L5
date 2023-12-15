package MoEzwawi.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="card_number")
    private long cardNumber;
    private String name;
    private String surname;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    public long getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
