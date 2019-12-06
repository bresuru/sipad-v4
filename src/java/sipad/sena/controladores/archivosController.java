/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@RequestScoped
public class archivosController {

    private Part file;
    private String nombre;
    private String pathReal;

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;

    @EJB
    private AlumnoFacadeLocal alumnoFacadeLocal;
    private Alumno alumno;

    @PostConstruct
    private void init() {
        usuario = new Usuario();
        alumno = new Alumno();
    }

    /**
     * Constructor sin patametros
     */
    public archivosController() {
    }

    //GETTHER Y SETTGERS
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    //METODOS
    public void subirImagen() {

        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("archivos/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\archivos\\images\\";

        try {

            this.nombre = file.getSubmittedFileName();
            path = path + this.nombre;
            pathReal = "/archivos/images/" + this.nombre;

            InputStream in = file.getInputStream();
            File f = new File(path);
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(data);

            in.close();
            out.close();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
