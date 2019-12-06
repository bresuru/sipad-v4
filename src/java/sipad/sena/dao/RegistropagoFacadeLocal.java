/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.Registropago;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface RegistropagoFacadeLocal {

    void create(Registropago registropago);

    void edit(Registropago registropago);

    void remove(Registropago registropago);

    Registropago find(Object id);

    List<Registropago> findAll();

    List<Registropago> findRange(int[] range);

    int count();
    
}
