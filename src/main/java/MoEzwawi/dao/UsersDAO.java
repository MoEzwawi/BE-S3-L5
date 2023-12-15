package MoEzwawi.dao;

import MoEzwawi.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsersDAO {
    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("User correctly added to database");
    }
    public User findByCardNumber(long cardNumber){
        User found = null;
        try {
            found = em.find(User.class, cardNumber);
            if (found == null){
                throw new IllegalArgumentException("User n° "+cardNumber+" not found");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void deleteByCardNumber(long cardNumber){
        User found = this.findByCardNumber(cardNumber);
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("User " + found.getSurname() + " removed from db");
        } catch (IllegalArgumentException | NullPointerException e){
            System.err.println("User n° "+cardNumber+" not found");
        }
    }
}
