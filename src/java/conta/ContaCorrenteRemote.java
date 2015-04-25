/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conta;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

/**
 *
 * @author Emannuel
 */
@Remote
public interface ContaCorrenteRemote {
    public boolean autenticarConta(String agencia, String conta);
    public boolean login(String senha);

    ContaCorrenteRemote create() throws CreateException, RemoteException;
}
