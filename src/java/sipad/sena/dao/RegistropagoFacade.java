/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sipad.sena.entidades.Registropago;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class RegistropagoFacade extends AbstractFacade<Registropago> implements RegistropagoFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistropagoFacade() {
        super(Registropago.class);
    }
    
}
