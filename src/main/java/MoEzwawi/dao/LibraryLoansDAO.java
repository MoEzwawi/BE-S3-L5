package MoEzwawi.dao;

import MoEzwawi.entities.LibraryLoan;
import MoEzwawi.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibraryLoansDAO {
    private final EntityManager em;

    public LibraryLoansDAO(EntityManager em) {
        this.em = em;
    }
    public void save(LibraryLoan loan){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("pub.isbn: "+loan.getPublication()+"correctlt loaned");
    }
    public LibraryLoan findById(long loanId){
        LibraryLoan found = null;
        try {
            found = em.find(LibraryLoan.class, loanId);
            if (found == null){
                throw new IllegalArgumentException("Loan n° "+loanId+" not found");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void findByIdAndDelete(long loanId){
        LibraryLoan found = this.findById(loanId);
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Loan n° " + found.getLoanId() + " removed from db");
        } catch (IllegalArgumentException | NullPointerException e){
            System.err.println("User n° "+loanId+" not found");
        }
    }
}
