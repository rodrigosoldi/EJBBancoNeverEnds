/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conta;

import javax.ejb.Stateful;

/**
 *
 * @author RodrigoSoldi
 */
@Stateful
public class ContaPoupancaBean implements java.io.Serializable{
    
    private Long id;
    private String numConta;
    private float saldo;

    public ContaPoupancaBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
        
}
