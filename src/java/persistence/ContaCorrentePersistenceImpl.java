/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conta.ContaCorrente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author RodrigoSoldi
 */
public class ContaCorrentePersistenceImpl{
    
    public static ContaCorrente existAccount(String agencia, String conta){
        EntityManagerFactory factory = PersistenceImpl.getInstance().getFactory();
        EntityManager manager = factory.createEntityManager();
        
        Query query = manager.createQuery("SELECT conta FROM ContaCorrente AS conta WHERE conta.agencia = :ag AND conta.numConta = :numC", ContaCorrente.class);        
        query.setParameter("ag", agencia);
        query.setParameter("numC", conta);
        query.setMaxResults(1);
        List<ContaCorrente> contas = query.getResultList();
        return null;

    }
}
