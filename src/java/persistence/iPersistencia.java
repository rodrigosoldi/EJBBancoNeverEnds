/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;

/**
 *
 * @author RodrigoSoldi
 */
public interface iPersistencia {
    void save();
    void delete();
    void update();
    List<Object> list();
}
