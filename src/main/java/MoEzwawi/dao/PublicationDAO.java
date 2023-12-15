package MoEzwawi.dao;

import MoEzwawi.entities.Publication;
import MoEzwawi.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PublicationDAO {
    private final EntityManager em;

    public PublicationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Publication publication){
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
}
