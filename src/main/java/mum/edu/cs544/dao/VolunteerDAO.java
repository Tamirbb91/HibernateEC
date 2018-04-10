package mum.edu.cs544.dao;

import mum.edu.cs544.JpaUtil;
import mum.edu.cs544.model.Volunteer;
import mum.edu.cs544.model.Volunteer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class VolunteerDAO {
    public static void create(Volunteer volunteer){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(volunteer);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void update(Volunteer volunteer){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(volunteer);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(Volunteer volunteer){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(volunteer);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Volunteer find(int volunteerId){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Volunteer p where p.id = ?1");
            query.setParameter(1, volunteerId);
            return (Volunteer) query.getSingleResult();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }
}
