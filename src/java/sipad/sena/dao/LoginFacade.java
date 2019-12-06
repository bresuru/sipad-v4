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
import sipad.sena.entidades.Login;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> implements LoginFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }

    @Override
    public Login login(Login login) {
        Login user = null;

        try {

            Query query = em.createQuery("SELECT l FROM Login l WHERE l.usuario = :user AND l.contrasena = :pass");

            query.setParameter("user", login.getUsuario());
            query.setParameter("pass", login.getContrasena());

            List<Login> lista = query.getResultList();

            if (!lista.isEmpty()) {
                user = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return user;
    }

}
