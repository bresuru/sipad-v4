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
import sipad.sena.entidades.Nivel;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class NivelFacade extends AbstractFacade<Nivel> implements NivelFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelFacade() {
        super(Nivel.class);
    }

    @Override
    public Nivel fintNivelPro(Object profesor) {
        Nivel n = null;
        List<Nivel> lista = null;

        try {

            Query query = em.createQuery("SELECT n FROM Nivel n WHERE n.idProfesor.idProfesor = :profesor");

            query.setParameter("profesor", profesor);

            lista = query.getResultList();

            if (!lista.isEmpty()) {
                n = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return n;
    }

    @Override
    public List<Nivel> findInformacion(Object idcategoria) {
        List<Nivel> listaN = null;
        try {
            Query query = em.createQuery("SELECT n FROM Nivel n WHERE n.idCategoria.idCategoria = :info");
            query.setParameter("info", idcategoria);
            listaN = query.getResultList();
        } catch (Exception e) {
            throw e;
        }

        return listaN;
    }

}
