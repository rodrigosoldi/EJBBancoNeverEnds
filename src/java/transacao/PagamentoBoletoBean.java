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
public class PagamentoBoletoBean extends TransacaoBean implements java.io.Serializable{
    
    private String codigoDeBarras;

    public PagamentoBoletoBean() {        
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    
}
