package MoEzwawi;

import MoEzwawi.dao.LibraryLoansDAO;
import MoEzwawi.dao.PublicationsDAO;
import MoEzwawi.dao.UsersDAO;
import MoEzwawi.entities.Book;
import MoEzwawi.entities.Journal;
import MoEzwawi.entities.LibraryLoan;
import MoEzwawi.entities.User;
import MoEzwawi.entities.enums.BookCategory;
import MoEzwawi.entities.enums.JournalFrequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_database");
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PublicationsDAO pubDAO = new PublicationsDAO(em);
        UsersDAO usersDAO = new UsersDAO(em);
        LibraryLoansDAO loanDAO = new LibraryLoansDAO(em);
        /*LocalDate aldosBirthday = DateParser.parseDateForItaly("28/09/1958");
        LocalDate giovannisBirthday = DateParser.parseDateForItaly("20/02/1957");
        LocalDate giacomosBirthday = DateParser.parseDateForItaly("26/04/1956");
        LocalDate marinasBirthday = DateParser.parseDateForItaly("16/05/1963");
        LocalDate hp1Date = DateParser.parseDateForItaly("26/06/1997");
        LocalDate hp2Date = DateParser.parseDateForItaly("02/07/1998");
        LocalDate hp3Date = DateParser.parseDateForItaly("08/07/1999");
        LocalDate hp4Date = DateParser.parseDateForItaly("08/07/2000");
        LocalDate hp5Date = DateParser.parseDateForItaly("21/06/2003");
        LocalDate hp6Date = DateParser.parseDateForItaly("16/07/2005");
        LocalDate hp7Date = DateParser.parseDateForItaly("21/07/2007");
        String jk = "J.K.Rowling";
        User aldo = new User("Aldo","Baglio",aldosBirthday);
        User giovanni = new User("Giovanni","Storti",giovannisBirthday);
        User giacomo = new User("Giacomo","Poretti",giacomosBirthday);
        User marina = new User("Marina","Massironi",marinasBirthday);
        Book hp1 = new Book("978-1-234567-89-1","Harry Potter 1",hp1Date,223,jk, BookCategory.LITERATURE);
        Book hp2 = new Book("978-1-234567-89-2","Harry Potter 2",hp2Date,251,jk, BookCategory.CHEMISTRY);
        Book hp3 = new Book("978-1-234567-89-3","Harry Potter 3",hp3Date,317,jk, BookCategory.ECONOMICS);
        Book hp4 = new Book("978-1-234567-89-4","Harry Potter 4",hp4Date,636,jk, BookCategory.LITERATURE);
        Book hp5 = new Book("978-1-234567-89-5","Harry Potter 5",hp5Date,766,jk, BookCategory.SOCIAL_SCIENCES);
        Book hp6 = new Book("978-1-234567-89-6","Harry Potter 6",hp6Date,607,jk, BookCategory.LITERATURE);
        Book hp7 = new Book("978-1-234567-89-7","Harry Potter 7",hp7Date,759,jk, BookCategory.HISTORY);
        Journal nature = new Journal("978-5-678901-23-1","Nature",LocalDate.of(2020,3,3),50, JournalFrequency.MONTHLY);
        Journal science = new Journal("978-5-678901-23-2","Science",LocalDate.of(2021,3,3),50, JournalFrequency.WEEKLY);
        Journal topWebDev = new Journal("978-5-678901-23-3","TopWebDev",LocalDate.of(2020,3,3),50, JournalFrequency.SEMESTRAL);

        usersDAO.save(aldo);
        usersDAO.save(giovanni);
        usersDAO.save(giacomo);
        usersDAO.save(marina);

        pubDAO.addToLibrary(hp1);
        pubDAO.addToLibrary(hp2);
        pubDAO.addToLibrary(hp3);
        pubDAO.addToLibrary(hp4);
        pubDAO.addToLibrary(hp5);
        pubDAO.addToLibrary(hp6);
        pubDAO.addToLibrary(hp7);

        pubDAO.addToLibrary(nature);
        pubDAO.addToLibrary(science);
        pubDAO.addToLibrary(topWebDev);*/
        User aldoDB = usersDAO.findByCardNumber(5);
        User giovanniDB = usersDAO.findByCardNumber(6);
        User giacomoDB = usersDAO.findByCardNumber(7);
        User marinaDB = usersDAO.findByCardNumber(8);

        Book hp1DB = pubDAO.findBookByISBN("978-1-234567-89-1");
        Book hp2DB = pubDAO.findBookByISBN("978-1-234567-89-2");
        Book hp3DB = pubDAO.findBookByISBN("978-1-234567-89-3");
        Book hp4DB = pubDAO.findBookByISBN("978-1-234567-89-4");
        Book hp5DB = pubDAO.findBookByISBN("978-1-234567-89-5");
        Book hp6DB = pubDAO.findBookByISBN("978-1-234567-89-6");
        Book hp7DB = pubDAO.findBookByISBN("978-1-234567-89-7");

        Journal natureDB = pubDAO.findJournalByISBN("978-5-678901-23-1");
        Journal scienceDB = pubDAO.findJournalByISBN("978-5-678901-23-2");
        Journal topWebDevDB = pubDAO.findJournalByISBN("978-5-678901-23-3");

        LibraryLoan l1 = new LibraryLoan(aldoDB,hp1DB,LocalDate.now());
        loanDAO.save(l1);
    }
}
