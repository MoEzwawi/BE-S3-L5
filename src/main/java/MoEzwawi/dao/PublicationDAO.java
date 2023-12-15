package MoEzwawi.dao;

import MoEzwawi.entities.Book;
import MoEzwawi.entities.Journal;
import MoEzwawi.entities.Publication;
import MoEzwawi.entities.enums.BookCategory;
import MoEzwawi.entities.enums.JournalFrequency;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PublicationDAO {
    private final EntityManager em;

    public PublicationDAO(EntityManager em) {
        this.em = em;
    }

    public void addToLibrary(Publication publication){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(publication);
        transaction.commit();
        System.out.println("Publication correctly added to database");
    }
    public Publication findByISBN(String isbn){
        Publication found = null;
        try {
            found = em.find(Publication.class, isbn);
            if (found == null){
                throw new IllegalArgumentException("Publication n° "+isbn+" not found");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void findByISBNAndDelete(String isbn){
        Publication found = this.findByISBN(isbn);
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Publication " + found.getTitle() + " removed from db");
        } catch (IllegalArgumentException | NullPointerException e){
            System.err.println("User n° "+isbn+" not found");
        }
    }
    public List<Book> findBooksByAuthor(String author){
        TypedQuery<Book> tq = this.em.createQuery("SELECT b FROM Book b WHERE LOWER(b.author) = LOWER(:author)", Book.class);
        tq.setParameter("author",author);
        return tq.getResultList();
    }
    public List<Journal> findJournalsByFrequency(JournalFrequency f){
        TypedQuery<Journal> tq = this.em.createQuery("SELECT j FROM Journal j WHERE j.frequency = :f", Journal.class);
        tq.setParameter("f",f);
        return tq.getResultList();
    }
    public List<Publication> getPublicationsByYearOfPublication(int year){
        TypedQuery<Publication> tq = this.em.createQuery("SELECT p FROM Publication p WHERE EXTRACT(YEAR FROM p.publicationDate) = :year", Publication.class);
        tq.setParameter("year",year);
        return tq.getResultList();
    }
    public List<Book> getBooksByCategory(BookCategory category){
        TypedQuery<Book> tq = this.em.createQuery("SELECT b FROM Book b WHERE b.category = :category",Book.class);
        tq.setParameter("category",category);
        return tq.getResultList();
    }
    public List<Book> getBooksByCategoryAndYear(BookCategory category, int year){
        TypedQuery<Book> tq = this.em.createQuery("SELECT b FROM Book b WHERE b.category = :category AND EXTRACT(YEAR FROM b.publicationDate) = :year", Book.class);
        tq.setParameter("category",category);
        tq.setParameter("year",year);
        return tq.getResultList();
    }
    public List<Publication> findByExactTitle(String title){
        TypedQuery<Publication> tq = this.em.createNamedQuery("findByExactTitle", Publication.class);
        tq.setParameter("title",title);
        return tq.getResultList();
    }
    public List<Publication> findByTitle(String searchQuery){
        TypedQuery<Publication> tq = this.em.createNamedQuery("findByTitle", Publication.class);
        tq.setParameter("searchQuery",searchQuery);
        return tq.getResultList();
    }
}
