/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.HorarioEntrenamiento;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface HorarioEntrenamientoFacadeLocal {

    void create(HorarioEntrenamiento horarioEntrenamiento);

    void edit(HorarioEntrenamiento horarioEntrenamiento);

    void remove(HorarioEntrenamiento horarioEntrenamiento);

    HorarioEntrenamiento find(Object id);

    List<HorarioEntrenamiento> findAll();

    List<HorarioEntrenamiento> findRange(int[] range);

    int count();
    
}
