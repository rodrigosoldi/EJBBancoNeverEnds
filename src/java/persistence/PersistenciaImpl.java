/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author RodrigoSoldi
 */
public class PersistenciaImpl{
    
    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;
    
    private PersistenciaImpl() {
        factory = Persistence.createEntityManagerFactory("EJBBancoNeverEndsPU");   
        manager = factory.createEntityManager();
    }
    
    public static PersistenciaImpl getInstance() {
        return PersistenciaImplHolder.INSTANCE;
    }        
    
    public void save(Object o) {
        try{                                           
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(o);
            transaction.commit();
        }catch(PersistenceException e){
            transaction.rollback();
        }
    }

    public void delete(Object o) {
        try{     
            transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(o);
            transaction.commit();
        }catch(PersistenceException e){
            transaction.rollback();
        }
    }

    public void update(Object o) {
        try{            
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(this);
            transaction.commit();
        }catch(PersistenceException e){
            transaction.rollback();
        }finally{
            manager.close();
        }
    }
    
    private static class PersistenciaImplHolder {

        private static final PersistenciaImpl INSTANCE = new PersistenciaImpl();
    }
}
