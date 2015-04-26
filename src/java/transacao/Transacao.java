/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacao;

import conta.ContaCorrente;
import entidade.Cliente;
import persistence.iPersistencia;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import persistence.PersistenceImpl;

/**
 *
 * @author RodrigoSoldi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transacao implements Serializable, iPersistencia {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataTransacao;
    
    private float valor;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaCorrente contaCorrente;
    
    public boolean debitar(){
        if(this.contaCorrente.getSaldo() <= 0 || this.contaCorrente.getSaldo() < valor)
            return false;
        
        this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() - valor);        
        return true;       
    }
    
    public boolean creditar(){
        this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() + valor);
       return true; 
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Calendar dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
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
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "transacao.Transacao[ id=" + id + " ]";
    }

    @Override
    public void save() {
        PersistenceImpl.getInstance().save(this);
    }

    @Override
    public void delete() {
        PersistenceImpl.getInstance().delete(this);
    }

    @Override
    public void update() {
        PersistenceImpl.getInstance().update(this);
    }

    @Override
    public List<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
}
