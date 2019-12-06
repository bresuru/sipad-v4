/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class lenguajeController implements Serializable {

    private Locale seleccionarIdioma;
    private List<Locale> listaIdioma;

    @PostConstruct
    private void init() {
        FacesContext fc = FacesContext.getCurrentInstance();

        seleccionarIdioma = new Locale("es");
        listaIdioma = new ArrayList<>();
        Iterator<Locale> it = fc.getApplication().getSupportedLocales();

        while (it.hasNext()) {
            listaIdioma.add(it.next());
        }
    }

    public Locale getSeleccionarIdioma() {
        return seleccionarIdioma;
    }

    public void setSeleccionarIdioma(Locale seleccionarIdioma) {
        this.seleccionarIdioma = seleccionarIdioma;
    }

    public List<Locale> getListaIdioma() {
        return listaIdioma;
    }

    public void setListaIdioma(List<Locale> listaIdioma) {
        this.listaIdioma = listaIdioma;
    }

    
    
    
    
    //cambiar Idioma
    public void cambiarIdioma(Locale idoma){
        
        this.seleccionarIdioma = idoma;
        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(idoma);
        
    }

}
