/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

/**
 *
 * @author Emannuel
 */
@Remote
public interface ContaCorrenteRemote {
    
    public Object[] autenticarConta(String agencia, String conta);
    public boolean login(String senha);
    public boolean efetuarPagamento(String agencia, String conta, float valor);
    ContaCorrenteRemote create() throws CreateException, RemoteException;
}
