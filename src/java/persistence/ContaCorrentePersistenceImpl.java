/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conta.ContaCorrente;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import transacao.Transacao;
import transacao.Transferencia;

/**
 *
 * @author RodrigoSoldi
 */
@Stateful
public class ContaCorrentePersistenceImpl{
    
    @PersistenceContext(unitName = "EJBBancoNeverEndsPU")
    EntityManager manager;
    
    public Object[] existAccount(String agencia, String conta){        
        manager = new PersistenceImpl().getManager();
        Query query = manager.createQuery("SELECT conta.senha, conta.saldo FROM ContaCorrente AS conta WHERE conta.agencia = :ag AND conta.numConta = :numC", ContaCorrente.class);        
        query.setParameter("ag", agencia);
        query.setParameter("numC", conta);
        query.setMaxResults(1);
        Object[] a = (Object[])query.getSingleResult();
        System.out.println(a[1]);
        return a;
    }
    
    public boolean login(String senha){
        return false;
    }
    
    public boolean efetuarPagamento(String agencia, String conta, float valor) throws NamingException{
        //Recuperar a conta
        ContaCorrente contaCorrente = this.recuperarConta(agencia, conta);                
        Transacao transacao = new Transacao();
        transacao.setDataTransacao(new GregorianCalendar());
        transacao.setValor(valor);    
        transacao.debitar();
        contaCorrente.addTransacao(transacao);
        return false;
    }
    
    public ContaCorrente recuperarConta(String agencia, String conta) throws NamingException{
        manager = new PersistenceImpl().getManager();
        Query query = manager.createQuery("SELECT conta FROM ContaCorrente AS conta WHERE conta.agencia = :ag AND conta.numConta = :numC", ContaCorrente.class);        
        query.setParameter("ag", agencia);
        query.setParameter("numC", conta);
        query.setMaxResults(1);
        
        Context context = new InitialContext();
        ContaCorrente contaCorrente = (ContaCorrente)context.lookup("conta.ContaCorrente");
        return (ContaCorrente)query.getSingleResult();        
    }
}
