/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sipad.sena.entidades.Bocaneiros;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class BocaneirosFacade extends AbstractFacade<Bocaneiros> implements BocaneirosFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BocaneirosFacade() {
        super(Bocaneiros.class);
    }
    
}
