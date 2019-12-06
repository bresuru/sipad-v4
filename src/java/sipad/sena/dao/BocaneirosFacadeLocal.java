/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.Bocaneiros;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface BocaneirosFacadeLocal {

    void create(Bocaneiros bocaneiros);

    void edit(Bocaneiros bocaneiros);

    void remove(Bocaneiros bocaneiros);

    Bocaneiros find(Object id);

    List<Bocaneiros> findAll();

    List<Bocaneiros> findRange(int[] range);

    int count();
    
}
