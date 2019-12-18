/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.AlumnoHasTorneo;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface AlumnoHasTorneoFacadeLocal {

    void create(AlumnoHasTorneo alumnoHasTorneo);

    void edit(AlumnoHasTorneo alumnoHasTorneo);

    void remove(AlumnoHasTorneo alumnoHasTorneo);

    AlumnoHasTorneo find(Object id);

    List<AlumnoHasTorneo> findAll();

    List<AlumnoHasTorneo> findRange(int[] range);

    int count();

    void removeAlumno(Object alumno);

    List<AlumnoHasTorneo> findAlumnoT(Object alumno);
    
    AlumnoHasTorneo findAlumnoTorneo(int idAlumno, int idTorneo);

}
