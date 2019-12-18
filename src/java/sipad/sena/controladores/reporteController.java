/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
**/
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@RequestScoped
public class reporteController {
    /*
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    @EJB
    private EventoFacadeLocal eventoFacadeLocal;
    
    @EJB
    private TorneoFacadeLocal torneoFacadeLocal;

    public void reporteAlumnosB() {
        Map<String, Object> parametros = new HashMap<String, Object>();

        Usuario user = null;

        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        parametros.put("super", user.getNombre1() + user.getNombre2() + user.getApellido1() + user.getApellido2());

        List<Usuario> listaUser = usuarioFacadeLocal.findAll();

        //Genero la lista para los Fields del reporte
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaUser);

        //Traer la ruta del Jasper
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/");
        try {
            //Generar el Reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(ruta + "/alumnosBeca.jasper", parametros, beanCollectionDataSource);

            //Con estas lineas mi navegador puede leer el PDF y lo puede descargar
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReporteBocaneiros.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
    }
    
    public void reporteAlumnosT() {
        Map<String, Object> parametros = new HashMap<String, Object>();

        Usuario user = null;

        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        parametros.put("super", user.getNombre1() + user.getNombre2() + user.getApellido1() + user.getApellido2());

        List<Torneo> listaUser = torneoFacadeLocal.findAll();

        //Genero la lista para los Fields del reporte
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaUser);

        //Traer la ruta del Jasper
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/");
        try {
            //Generar el Reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(ruta + "/torneos.jasper", parametros, beanCollectionDataSource);

            //Con estas lineas mi navegador puede leer el PDF y lo puede descargar
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReporteBocaneiros.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
    }
    
    public void reporteAlumnosE() {
        Map<String, Object> parametros = new HashMap<String, Object>();

        Usuario user = null;

        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        parametros.put("super", user.getNombre1() + user.getNombre2() + user.getApellido1() + user.getApellido2());

        List<Evento> listaEv = eventoFacadeLocal.findAll();

        //Genero la lista para los Fields del reporte
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaEv);

        //Traer la ruta del Jasper
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/");
        try {
            //Generar el Reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(ruta + "/eventos.jasper", parametros, beanCollectionDataSource);

            //Con estas lineas mi navegador puede leer el PDF y lo puede descargar
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReporteBocaneiros.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
    }
     */
}
