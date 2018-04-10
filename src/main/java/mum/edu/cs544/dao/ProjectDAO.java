package mum.edu.cs544.dao;

import mum.edu.cs544.JpaUtil;
import mum.edu.cs544.model.Beneficiary;
import mum.edu.cs544.model.Project;
import mum.edu.cs544.model.Status;
import mum.edu.cs544.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class ProjectDAO {

    public static void create(Project project){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(project);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void update(Project project){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(project);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(Project project){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(project);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Project find(int projectId){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p where p.id = ?1");
            query.setParameter(1, projectId);
            return (Project) query.getSingleResult();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Project> findAll(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p");
            return (List<Project>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Project> findProjectsByStatus(Status status){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p where p.status = ?1");
            query.setParameter(1, status);
            return (List<Project>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Project> findByLocationOrKeyword(String locationKeyword){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p where (p.location = '%' + ?1 + '%')");
            query.setParameter(1, locationKeyword);
            return (List<Project>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Task> getTasks(int projectId){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select t from Task t Join t.project p where p.id = ?1");
            query.setParameter(1, projectId);
            return (List<Task>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<String> findBeneficiaryInformation(int projectId){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select b.information from Project p Join p.beneficiaries b where p.id = ?1");
            query.setParameter(1, projectId);
            return (List<String>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Project> findProjectsByResource(String resource){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p Join p.tasks t " +
                    "Join t.resources r where  KEY(r) = ?1 ");
            query.setParameter(1, resource);
            return (List<Project>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Project> listProjectByVolunteerOfferedService(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query query = entityManager.createQuery("Select p from Project p Join p.tasks t " +
                    "where t.volunteer != null ");
            return (List<Project>) query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

}
