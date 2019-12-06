/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.AlumnoHasEvento;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface AlumnoHasEventoFacadeLocal {

    void create(AlumnoHasEvento alumnoHasEvento);

    void edit(AlumnoHasEvento alumnoHasEvento);

    void remove(AlumnoHasEvento alumnoHasEvento);

    AlumnoHasEvento find(Object id);

    List<AlumnoHasEvento> findAll();

    List<AlumnoHasEvento> findRange(int[] range);

    int count();
    
    void removeAlum(Object alumno);
    
}
