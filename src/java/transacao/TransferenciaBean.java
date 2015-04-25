/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacao;

/**
 *
 * @author RodrigoSoldi
 */
public class TransferenciaBean extends TransacaoBean implements java.io.Serializable{
    private String tipo;

    public TransferenciaBean() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
