package MoEzwawi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_database");
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

    }
}
