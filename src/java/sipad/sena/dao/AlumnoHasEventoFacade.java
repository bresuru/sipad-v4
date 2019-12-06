/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sipad.sena.entidades.AlumnoHasEvento;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class AlumnoHasEventoFacade extends AbstractFacade<AlumnoHasEvento> implements AlumnoHasEventoFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoHasEventoFacade() {
        super(AlumnoHasEvento.class);
    }

    @Override
    public void removeAlum(Object alumno) {
        int row;

        try {

            Query query = em.createQuery("DELETE FROM AlumnoHasEvento a WHERE a.alumnoIdAlumno.idAlumno = :alumno");

            query.setParameter("alumno", alumno);

            row = query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

}
