package mum.edu.cs544.dao;

import mum.edu.cs544.JpaUtil;
import mum.edu.cs544.model.Beneficiary;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class BeneficiaryDAO {

    public static void create(Beneficiary beneficiary){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(beneficiary);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void update(Beneficiary beneficiary){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(beneficiary);
            transaction.commit();
        } catch (PersistenceException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
