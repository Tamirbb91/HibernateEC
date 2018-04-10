package mum.edu.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager = null;
    static {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("cs544ec");
        } catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager(){
        if(entityManager == null){
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
