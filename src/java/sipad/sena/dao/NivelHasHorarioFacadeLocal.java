/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.NivelHasHorario;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface NivelHasHorarioFacadeLocal {

    void create(NivelHasHorario nivelHasHorario);

    void edit(NivelHasHorario nivelHasHorario);

    void remove(NivelHasHorario nivelHasHorario);

    NivelHasHorario find(Object id);

    List<NivelHasHorario> findAll();

    List<NivelHasHorario> findRange(int[] range);

    int count();
    
}
