/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author RodrigoSoldi
 */
@Remote
public interface iPersistenceRemote {
    void save(Object o);
    void delete(Object o);
    void update(Object o);
    List<Object> list(Class classe);
}
