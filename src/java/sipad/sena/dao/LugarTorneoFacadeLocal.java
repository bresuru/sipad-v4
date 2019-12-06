/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.LugarTorneo;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface LugarTorneoFacadeLocal {

    void create(LugarTorneo lugarTorneo);

    void edit(LugarTorneo lugarTorneo);

    void remove(LugarTorneo lugarTorneo);

    LugarTorneo find(Object id);

    List<LugarTorneo> findAll();

    List<LugarTorneo> findRange(int[] range);

    int count();
    
}
