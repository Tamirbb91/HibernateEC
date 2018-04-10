package mum.edu.cs544.dao;

import mum.edu.cs544.JpaUtil;
import mum.edu.cs544.model.Admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class AdminDAO {

    public static Admin getAdmin(String name) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select a from Admin a " +
                    "where a.name = ?1 ");
            query.setParameter(1, name);
            return (Admin) query.getSingleResult();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }
}
