/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.Supervisor;
import sipad.sena.entidades.Usuario;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface SupervisorFacadeLocal {

    void create(Supervisor supervisor);

    void edit(Supervisor supervisor);

    void remove(Supervisor supervisor);

    Supervisor find(Object id);

    List<Supervisor> findAll();

    List<Supervisor> findRange(int[] range);

    int count();

    List<Supervisor> findEstado(Object estado);

    Supervisor findUser(int idUser);

}
