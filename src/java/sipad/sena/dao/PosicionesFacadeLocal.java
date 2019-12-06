/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.Posiciones;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface PosicionesFacadeLocal {

    void create(Posiciones posiciones);

    void edit(Posiciones posiciones);

    void remove(Posiciones posiciones);

    Posiciones find(Object id);

    List<Posiciones> findAll();

    List<Posiciones> findRange(int[] range);

    int count();
    
}
