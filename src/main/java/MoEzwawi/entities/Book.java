package MoEzwawi.entities;

import MoEzwawi.entities.enums.BookCategory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="books")
@DiscriminatorValue("book")
public class Book extends Publication{
    private String author;
    private BookCategory category;
    public Book(){

    }

    public Book(String isbn, String title, LocalDate publicationDate, int numberOfPages, String author, BookCategory category) {
        super(isbn, title, publicationDate, numberOfPages);
        this.author = author;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                '}';
    }
}
