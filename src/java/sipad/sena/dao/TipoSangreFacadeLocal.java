/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.TipoSangre;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface TipoSangreFacadeLocal {

    void create(TipoSangre tipoSangre);

    void edit(TipoSangre tipoSangre);

    void remove(TipoSangre tipoSangre);

    TipoSangre find(Object id);

    List<TipoSangre> findAll();

    List<TipoSangre> findRange(int[] range);

    int count();
    
}
