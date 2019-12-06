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
import sipad.sena.entidades.Supervisor;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class SupervisorFacade extends AbstractFacade<Supervisor> implements SupervisorFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupervisorFacade() {
        super(Supervisor.class);
    }

    @Override
    public List<Supervisor> findEstado(Object estado) {
        List<Supervisor> sup = null;

        try {

            Query query = em.createQuery("SELECT s FROM Supervisor s WHERE s.documento.idEstadoUsuario.idEstadoUsuario = :estado");

            query.setParameter("estado", estado);

            sup = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return sup;
    }

    @Override
    public Supervisor findUser(int idUser) {
        Supervisor sup = null;
        List<Supervisor> lista = null;

        try {

            Query query = em.createQuery("SELECT s FROM Supervisor s WHERE s.documento.documento = :doc");
            query.setParameter(":dooc", idUser);

            lista = query.getResultList();

            if (!lista.isEmpty()) {
                sup = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return sup;
    }

}
