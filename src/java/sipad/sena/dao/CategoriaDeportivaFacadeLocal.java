/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.CategoriaDeportiva;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface CategoriaDeportivaFacadeLocal {

    void create(CategoriaDeportiva categoriaDeportiva);

    void edit(CategoriaDeportiva categoriaDeportiva);

    void remove(CategoriaDeportiva categoriaDeportiva);

    CategoriaDeportiva find(Object id);

    List<CategoriaDeportiva> findAll();

    List<CategoriaDeportiva> findRange(int[] range);

    int count();
    
}
