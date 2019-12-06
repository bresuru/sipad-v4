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
import sipad.sena.entidades.Profesor;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class ProfesorFacade extends AbstractFacade<Profesor> implements ProfesorFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesorFacade() {
        super(Profesor.class);
    }

    @Override
    public List<Profesor> findProfesor(Object estado) {
        List<Profesor> profe = null;

        try {

            Query query = em.createQuery("SELECT p FROM Profesor p WHERE p.documento.idEstadoUsuario.idEstadoUsuario = :estado");

            query.setParameter("estado", estado);

            profe = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return profe;
    }

    @Override
    public List<Profesor> findProfesorA(Object profesor) {
        List<Profesor> profe = null;

        try {

            Query query = em.createQuery("SELECT p FROM Profesor p WHERE p.idProfesor = :estado");

            query.setParameter("estado", profesor);

            profe = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return profe;
    }

    @Override
    public Profesor findUser(int isUser) {
        List<Profesor> profe = null;
        Profesor pro = null;

        try {

            Query query = em.createQuery("SELECT p FROM Profesor p WHERE p.documento.documento = :estado");

            query.setParameter("estado", isUser);

            profe = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return pro;
    }

}
