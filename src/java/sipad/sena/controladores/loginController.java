//BSSR
package sipad.sena.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@ViewScoped
public class loginController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFL;
    private Usuario usuario;

    @EJB
    private AlumnoFacadeLocal alumnoFL;
    private Alumno alumno;

    @EJB
    private SupervisorFacadeLocal supervisorFL;
    private Supervisor supervisor;

    @EJB
    private ProfesorFacadeLocal profesorFL;
    private Profesor profesor;

    @EJB
    private LoginFacadeLocal loginFL;
    private Login login;

    @EJB
    private RolesFacadeLocal rolFL;
    private Roles roles;
    private List<Roles> rolesL;

    @PostConstruct
    private void init() {

        usuario = new Usuario();
        alumno = new Alumno();
        supervisor = new Supervisor();
        profesor = new Profesor();
        roles = new Roles();
        login = new Login();

        rolesL = rolFL.findAll();

    }

    /**
     * Constructor sin parametros
     */
    public loginController() {
    }

    //GETTHWES Y SETTHERS
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Roles> getRolesL() {
        return rolesL;
    }

    public void setRolesL(List<Roles> rolesL) {
        this.rolesL = rolesL;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    //METODOS:
    public String iniciarSesion() {
        String url = null;
        Login lo;
        Usuario u;
        Alumno a;

        try {
            lo = loginFL.login(login);
            if (lo != null) {

                Integer id_usuario = Integer.parseInt(lo.getUsuario());

                u = usuarioFL.find(id_usuario);

                if (u.getIdEstadoUsuario().getIdEstadoUsuario() == 1) {
                    String rol = u.getIdRol().getRol();
                    switch (rol) {
                        case "Alumno":
                            url = "/app/alumno/indexAlumno?faces-redirect=true";
                            break;
                        case "Supervisor":
                            url = "/app/supervisor/indexSup?faces-redirect=true";
                            break;
                        case "Profesor":
                            url = "/app/profesor/indexProfesor?faces-redirect=true";
                            break;
                        default:
                    }
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Aviso:", "El usuario esta desactivado por lo tanto no se puede iniciar sesion"));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Aviso:", "El usuario o la contraseña son incorrectos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso:", "Error al iniciar sesion"));
            e.printStackTrace();
        }
        return url;
    }

    //Verificar si hay una session inicada
    public void verificarSession() {

        try {

            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (user == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: ", "No hay session iniciada"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verificarSession1() {

        try {

            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (user == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: ", "No hay session iniciada"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../../index.xhtml");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verificarSession2() {

        try {

            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (user == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: ", "No hay session iniciada"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../index.xhtml");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String cerrarSession() {

        String url = null;

        try {

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            url = "/index?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

}
