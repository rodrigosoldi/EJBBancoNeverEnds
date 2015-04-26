/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conta.ContaCorrente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RodrigoSoldi
 */
@Stateful
public class ContaCorrentePersistenceImpl{
    
    @PersistenceContext(unitName = "EJBBancoNeverEndsPU")
    EntityManager manager;
    
    public ContaCorrente existAccount(String agencia, String conta){        
        manager = new PersistenceImpl().getManager();
        Query query = manager.createQuery("SELECT conta FROM ContaCorrente AS conta WHERE conta.agencia = :ag AND conta.numConta = :numC", ContaCorrente.class);        
        query.setParameter("ag", agencia);
        query.setParameter("numC", conta);
        query.setMaxResults(1);
        List<Object[]> contas = query.getResultList();
        
        return null;

    }
}
