package mum.edu.cs544.dao;

import mum.edu.cs544.JpaUtil;
import mum.edu.cs544.model.Task;
import mum.edu.cs544.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class TaskDAO {
    public static void create(Task task){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void update(Task task){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(task);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(Task task){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(task);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Task> listTaskByVolunteerOfferedService() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("Select t from Task t " +
                    "where t.volunteer != null ");
            return (List<Task>) query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Task find(int taskId){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Task p where p.id = ?1");
            query.setParameter(1, taskId);
            return (Task) query.getSingleResult();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }
}
