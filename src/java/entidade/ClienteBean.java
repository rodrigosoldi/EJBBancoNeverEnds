/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import conta.ContaCorrenteBean;
import java.util.Date;
import javax.ejb.Stateful;

/**
 *
 * @author Emannuel
 */
@Stateful
public class ClienteBean implements ClienteRemote, java.io.Serializable {
    
    private String nome;
    private String cpf;
    private Date nascimento;
    
    private ContaCorrenteBean contaCorrente;
    
    public ClienteBean() {}

    public ContaCorrenteBean getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrenteBean contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    

    @Override
    public String sayMyName() {
        return "Emannuel";
    }
    
}
