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
import sipad.sena.entidades.Alumno;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> implements AlumnoFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }

    @Override
    public List<Alumno> findEstado(int estado) {
        List<Alumno> lista = null;

        try {

            Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.documento.idEstadoUsuario.idEstadoUsuario = :estado");

            query.setParameter("estado", estado);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    @Override
    public List<Alumno> findAlumPro(Object profesor) {
        List<Alumno> lista = null;

        try {

            Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.documento.idRol.idRol = 1 AND a.documento.idEstadoUsuario.idEstadoUsuario = 1 AND a.idNivelCategoria.idProfesor.idProfesor = :profe");

            query.setParameter("profe", profesor);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    @Override
    public List<Alumno> findInfoAlumno(Object idCategoria) {
        List<Alumno> ListaA = null;
        try {
            Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.idNivelCategoria.idCategoria.idCategoria = :info");
            query.setParameter("info", idCategoria);
            ListaA = query.getResultList();
        } catch (Exception e) {
        }
        return ListaA;
    }

    @Override
    public Alumno findAlumno(int documento) {
        Alumno alumno = null;
        List<Alumno> lista = null;

        try {

            Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.documento.documento = :doc");

            query.setParameter("doc", documento);

            lista = query.getResultList();

            if (!lista.isEmpty()) {
                alumno = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return alumno;
    }

}
