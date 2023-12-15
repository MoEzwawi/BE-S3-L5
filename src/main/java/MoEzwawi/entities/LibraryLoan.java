package MoEzwawi.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="loan_record")
@NamedQuery(name="getLoansByUserCardNumber",query="SELECT l FROM LibraryLoan l WHERE l.user.getCardNumber() = :cardNumber AND  l.returnDate IS NULL")
public class LibraryLoan {
    @Id
    @GeneratedValue
    @Column(name="loan_id")
    private long loanId;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="isbn_code",nullable = false)
    private Publication publication;
    @Column(name = "start_date",nullable = false)
    private LocalDate startDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public LibraryLoan(){

    }

    public LibraryLoan(User user, Publication publication, LocalDate startDate) {
        this.user = user;
        this.publication = publication;
        this.startDate = startDate;
        this.dueDate = startDate.plusDays(30);
    }

    public long getLoanId() {
        return loanId;
    }
    public User getUser() {
        return user;
    }

    public Publication getPublication() {
        return publication;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LibraryLoan{" +
                "loanId=" + loanId +
                ", user=" + user +
                ", publication=" + publication +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
