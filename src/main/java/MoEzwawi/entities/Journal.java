package MoEzwawi.entities;

import MoEzwawi.entities.enums.JournalFrequency;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="journals")
@DiscriminatorValue("journal")
public class Journal extends Publication{
    @Enumerated(EnumType.STRING)
    private JournalFrequency frequency;
    public Journal(){

    }

    public Journal(String isbn, String title, LocalDate publicationDate, int numberOfPages, JournalFrequency frequency) {
        super(isbn, title, publicationDate, numberOfPages);
        this.frequency = frequency;
    }

    public JournalFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(JournalFrequency frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "frequency=" + frequency +
                ", title='" + title + '\'' +
                '}';
    }
}
