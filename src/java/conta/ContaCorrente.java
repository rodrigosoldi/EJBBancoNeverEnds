/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta;

import entidade.Cliente;
import interfaces.ContaCorrenteRemote;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import persistence.ContaCorrentePersistenceImpl;
import transacao.Transacao;

/**
 *
 * @author RodrigoSoldi
 */
@Entity
@Stateful
public class ContaCorrente implements Serializable, ContaCorrenteRemote {
    
    @OneToMany(mappedBy = "contaCorrente", cascade = CascadeType.ALL)
    private List<Cartao> cartoes;
    
    @OneToOne(cascade = CascadeType.ALL)
    private ContaPoupanca contaPoupanca;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String senha;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataCriacao;
    
    private String numConta;
    private String agencia;
    private float saldo;
    
//    @EJB
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente = new Cliente();
    
    @OneToMany(mappedBy = "contaCorrente", cascade = CascadeType.ALL)
    private List<Transacao> transacoes; 

    public void addTransacao(Transacao transacao){
        if(this.transacoes == null)
            this.transacoes = new ArrayList<Transacao>();
        
        this.transacoes.add(transacao);
        transacao.setContaCorrente(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setContaCorrente(this);
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
        contaPoupanca.setContaCorrente(this);
    }

    public void addCartao(Cartao cartao){
        if(this.getCartoes() == null)
            this.cartoes = new ArrayList<Cartao>();
        
        this.cartoes.add(cartao);
        cartao.setContaCorrente(this);
    }
    
    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente other = (ContaCorrente) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "conta.Conta[ id=" + id + " ]";
    }

    @Override
    public Object[] autenticarConta(String agencia, String conta) {
        return new ContaCorrentePersistenceImpl().existAccount(agencia, conta);
    }

    @Override
    public boolean login(String senha) {
        return this.getSenha().equals(senha);
    }

    @Override
    public ContaCorrenteRemote create() throws CreateException, RemoteException {
        return this;
    }

    @Override
    public boolean efetuarPagamento(String agencia, String conta, float valor) {                
        return new ContaCorrentePersistenceImpl().efetuarPagamento(agencia, conta, valor);
    }



    
}
