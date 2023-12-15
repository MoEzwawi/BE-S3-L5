package MoEzwawi.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="publications")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public abstract class Publication {
    @Id
    @Column(name="ISBN")
    protected String isbn;
    protected String title;
    @Column(name="publication_date")
    protected LocalDate publicationDate;
    @Column(name="pages")
    protected int numberOfPages;
    @OneToMany(mappedBy = "publication")
    private List<LibraryLoan> loanHistory;
    public Publication(){

    }

    public Publication(String isbn, String title, LocalDate publicationDate, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<LibraryLoan> getLoanHistory() {
        return loanHistory;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
