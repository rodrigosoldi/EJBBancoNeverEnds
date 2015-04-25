/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conta;

import java.util.Calendar;

/**
 *
 * @author RodrigoSoldi
 */
public class CartaoBean implements java.io.Serializable{
    
    private Long        id;
    private String      bandeira;
    private String      codigoSeguranca;
    private Calendar    validade;
    private String      numero;
    private String      nomeCliente;
    private String      tipo;

    private ContaCorrenteBean contaCorrente;
    
    public CartaoBean() {
    }

    public ContaCorrenteBean getContaCorrenteBean() {
        return contaCorrente;
    }

    public void setContaCorrenteBean(ContaCorrenteBean contaCorrenteBean) {
        this.contaCorrente = contaCorrenteBean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}