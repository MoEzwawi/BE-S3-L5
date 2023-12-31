package MoEzwawi.entities;

import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<LibraryLoan> listOfLoans;

    public User(){

    }

    public User(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        LocalDate minimumDateOfBirth = LocalDate.now().minusYears(18);
        if (dateOfBirth.isBefore(minimumDateOfBirth)) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("The library users must be of legal age.");
        }
    }

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

    public List<LibraryLoan> getListOfLoans() {
        return listOfLoans;
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
