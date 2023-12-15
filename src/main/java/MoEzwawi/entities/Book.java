package MoEzwawi.entities;

import MoEzwawi.entities.enums.BookGenre;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="books")
@DiscriminatorValue("book")
public class Book extends Publication{
    private String author;
    private BookGenre genre;
    public Book(){

    }

    public Book(String isbn, String title, LocalDate publicationDate, int numberOfPages, String author, BookGenre genre) {
        super(isbn, title, publicationDate, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre=" + genre +
                ", title='" + title + '\'' +
                '}';
    }
}
