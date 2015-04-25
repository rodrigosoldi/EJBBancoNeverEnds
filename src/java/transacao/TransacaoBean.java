/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacao;

import conta.ContaCorrenteBean;
import entidade.ClienteBean;
import java.util.Calendar;

/**
 *
 * @author RodrigoSoldi
 */
public abstract class TransacaoBean implements java.io.Serializable {
    
    private Calendar data;
    private float valor;
    
    private ClienteBean cliente;
    private ContaCorrenteBean contaCorrente;
    
    public TransacaoBean() {
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public boolean debitar(){
        if(this.contaCorrente.getSaldo() > 0 && this.contaCorrente.getSaldo() >= valor){
            this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() - valor);
            return true;
        }
        return false;
    }
    
    public boolean creditar(){
        this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() + valor);
        return true;
    }
}
