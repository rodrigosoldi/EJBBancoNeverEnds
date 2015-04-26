/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author RodrigoSoldi
 */
public class PersistenceImpl{
    
    private final EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;
    
    private PersistenceImpl() {
        factory = Persistence.createEntityManagerFactory("EJBBancoNeverEndsPU");   
        manager = factory.createEntityManager();
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }    
    
    public static PersistenceImpl getInstance() {
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
    
    public List<Object> list(Class classe){
        try{
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();            
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(classe);
            Root objectos = criteriaQuery.from(classe);
            criteriaQuery.select(objectos);                        
            return manager.createQuery(criteriaQuery).getResultList();
        }catch(PersistenceException e){
        }
        return null;
    }
    
    private static class PersistenciaImplHolder {

        private static final PersistenceImpl INSTANCE = new PersistenceImpl();
    }
}
