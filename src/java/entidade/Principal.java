/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import conta.Cartao;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import transacao.Transacao;
import transacao.Transferencia;

/**
 *
 * @author RodrigoSoldi
 */
public class Principal {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNome("Rodrigo Soldi");
        cliente.setCpf("43856161830");
        cliente.setNascimento(new GregorianCalendar());
        
        Endereco endereco = new Endereco();
        endereco.setBairro("Maracana");
        endereco.setCep("12951540");
        endereco.setDescricao("Geronimo de Camargo");
        endereco.setEstado("SP");
        endereco.setLogradouro("Avenida");
        endereco.setCidade("Atibaia");
        endereco.setNumero("14804");
        
        cliente.addEndereco(endereco);
        
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setAgencia("42552");
        contaCorrente.setNumConta("127957");
        contaCorrente.setSaldo((float) 500);
        contaCorrente.setDataCriacao(new GregorianCalendar());
        contaCorrente.setSenha("123456");
        contaCorrente.setCliente(cliente);
        
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setNumConta("4124");
        contaPoupanca.setSaldo((float) 500.0);
        contaCorrente.setContaPoupanca(contaPoupanca);
        
        Cartao cartao = new Cartao();
        cartao.setBandeira("Visa");
        cartao.setCodigoSeguranca("123");
        cartao.setNomeCliente("Soldi");
        cartao.setTipo("Credito/Debito");
        cartao.setValidade(new GregorianCalendar());
        contaCorrente.addCartao(cartao);
        
        Cartao cartao1 = new Cartao();
        cartao1.setBandeira("MasterCard");
        cartao1.setCodigoSeguranca("232");
        cartao1.setNomeCliente("Eliane Aparecida Soldi Lopes");
        cartao1.setTipo("Credito");
        cartao1.setValidade(new GregorianCalendar());
        contaCorrente.addCartao(cartao1);
        
        Transferencia transacao = new Transferencia();
        transacao.setDataTransacao(new GregorianCalendar());
        transacao.setValor(200);
        transacao.setContaCorrente(contaCorrente);
        transacao.setTipo("Teste");
        transacao.setCliente(cliente);        
        transacao.debitar();
        
        cliente.save();
        transacao.save();                       
    }
    
}
