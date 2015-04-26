/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author RodrigoSoldi
 */
@Stateless
public class PersistenceImpl implements iPersistenceRemote{
    
    private final EntityManagerFactory factory;
    
    @PersistenceContext(unitName = "EJBBancoNeverEndsPU")
    private EntityManager manager;
    
    private EntityTransaction transaction;

    public PersistenceImpl() {
        factory = Persistence.createEntityManagerFactory("EJBBancoNeverEndsPU");   
        manager = factory.createEntityManager();
    }    

    public EntityManagerFactory getFactory() {
        return factory;
    }         

    public EntityManager getManager() {
        return manager;
    }
    
    @Override
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

    @Override
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

    @Override
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
    
    @Override
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

}
