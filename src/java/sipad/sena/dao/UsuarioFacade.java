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
import sipad.sena.entidades.Usuario;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> fintTipoUser(Object idRol, Object idEstado) {
        List<Usuario> lista = null;

        try {

            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idRol.idRol = :idRol AND u.idEstadoUsuario.idEstadoUsuario = :idEstado");

            query.setParameter("idRol", idRol);
            query.setParameter("idEstado", idEstado);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

}
