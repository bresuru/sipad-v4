/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sipad.sena.entidades.AlumnoHasTorneo;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class AlumnoHasTorneoFacade extends AbstractFacade<AlumnoHasTorneo> implements AlumnoHasTorneoFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoHasTorneoFacade() {
        super(AlumnoHasTorneo.class);
    }

    @Override
    public void removeAlumno(Object alumno) {
        int row;

        try {

            Query query = em.createQuery("DELETE FROM AlumnoHasTorneo a WHERE a.alumnoIdAlumno.idAlumno = :alumno");

            query.setParameter("alumno", alumno);

            row = query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<AlumnoHasTorneo> findAlumnoT(Object alumno) {
        List<AlumnoHasTorneo> lista;

        try {

            Query query = em.createQuery("SELECT a FROM AlumnoHasTorneo a WHERE a.alumnoIdAlumno.idAlumno = :alumno");

            query.setParameter("alumno", alumno);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    @Override
    public AlumnoHasTorneo findAlumnoTorneo(int idAlumno, int idTorneo) {

        AlumnoHasTorneo aht = null;
        List<AlumnoHasTorneo> listaaht = null;

        try {

            Query query = em.createQuery("SELECT at FROM AlumnoHasTorneo at WHERE at.alumnoIdAlumno.idAlumno = :idAlumno AND at.torneoIdTorneo.idTorneo = :idTorneo");

            query.setParameter("idAlumno", idAlumno);
            query.setParameter("idTorneo", idTorneo);

            listaaht = query.getResultList();

            while (!listaaht.isEmpty()) {
                aht = listaaht.get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return aht;

    }

}
