/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conta;

import entidade.ClienteBean;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.Stateful;

/**
 *
 * @author Emannuel
 */
@Stateful
public class ContaCorrenteBean implements ContaCorrenteRemote, java.io.Serializable {

    private Long Id;    
    private String senha;
    private Calendar dataCriacao;
    private String numConta;
    private String agencia;
    private float saldo;

    private ContaPoupancaBean contaPoupanca;
    
    private List<CartaoBean> cartoes;
    
    private ExtratoBean extrato;
    
    private ClienteBean cliente;
    
    public ContaCorrenteBean() {
    }

    public List<CartaoBean> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoBean> cartoes) {
        this.cartoes = cartoes;
    }

    public ExtratoBean getExtrato() {
        return extrato;
    }

    public void setExtrato(ExtratoBean extrato) {
        this.extrato = extrato;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public ContaPoupancaBean getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupancaBean contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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
    
    
    
    @Override
    public boolean autenticarConta(String agencia, String conta) {
        // teste fake para uma única conta
        // substituir por consulta ao banco de dados
        System.out.println("ag: " + agencia + "conta: " + conta);
        if (agencia.equalsIgnoreCase("3938") && conta.equalsIgnoreCase("010804037")) {
            System.out.println("entrou aqui!!!");
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String senha) {
        // teste fake para uma única conta
        // substituir por consulta ao banco de dados
        if (senha == "minhaSenhaSecreta") return true;
        return false;
    }    

    @Override
    public ContaCorrenteRemote create() throws CreateException, RemoteException {
        return this;
    }
    
}
