/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import javax.ejb.Remote;

/**
 *
 * @author Emannuel
 */
@Remote
public interface ClienteRemote {
    public String sayMyName();
}
