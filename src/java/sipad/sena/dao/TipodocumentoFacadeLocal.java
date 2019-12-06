/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.Tipodocumento;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface TipodocumentoFacadeLocal {

    void create(Tipodocumento tipodocumento);

    void edit(Tipodocumento tipodocumento);

    void remove(Tipodocumento tipodocumento);

    Tipodocumento find(Object id);

    List<Tipodocumento> findAll();

    List<Tipodocumento> findRange(int[] range);

    int count();
    
}
