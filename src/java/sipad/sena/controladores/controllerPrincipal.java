
package sipad.sena.controladores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@RequestScoped
public class controllerPrincipal {
    
    @EJB
    private UsuarioFacadeLocal usuarioFL;
    private Usuario usuario;
    
    @EJB
    private TipoSangreFacadeLocal tipoSangreFL;
    private TipoSangre tipoSangre;
    List<TipoSangre> listaTipoSangre;
    
    @EJB
    private RolesFacadeLocal rolFL;
    private Roles roles;
    private List<Roles> rolesL;
    
    @EJB
    private EpsFacadeLocal epsFL;
    private Eps eps;
    private List<Eps> epsL;
    
    @EJB
    private NivelFacadeLocal nivelFL;
    private Nivel nivel;
    private List<Nivel> listaNivel;
    
    @EJB
    private RegistropagoFacadeLocal registroPFL;
    private Registropago registroP;
    
    @EJB
    private CategoriaDeportivaFacadeLocal categoriaDFL;
    private CategoriaDeportiva catgoriaD;
    private List<CategoriaDeportiva> categroiaDL;
    
    @EJB
    private AlumnoFacadeLocal alumnoFL;
    private Alumno alumno;
    
    @EJB
    private LoginFacadeLocal loginFL;
    private loginController login;
    
    @EJB
    private EstadoUsuarioFacadeLocal estadoFL;
    private EstadoUsuario estado;
    
    @PostConstruct
    private void init(){ 
        usuario =  new Usuario();
        tipoSangre = new TipoSangre();
        eps = new Eps();
        roles = new Roles();
        alumno = new Alumno();
        login = new loginController();
        registroP = new Registropago();
        
        listaTipoSangre = tipoSangreFL.findAll();
        rolesL = rolFL.findAll();
        epsL = epsFL.findAll();
        categroiaDL = categoriaDFL.findAll();
        listaNivel =  nivelFL.findAll();
    }
    
    /**
     * Contrustor sin parametros
     */
    public controllerPrincipal() {
    }
    
    
    //GETTHERS Y SETTHERS
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public List<TipoSangre> getListaTipoSangre() {
        return listaTipoSangre;
    }

    public void setListaTipoSangre(List<TipoSangre> listaTipoSangre) {
        this.listaTipoSangre = listaTipoSangre;
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

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public List<Eps> getEpsL() {
        return epsL;
    }

    public void setEpsL(List<Eps> epsL) {
        this.epsL = epsL;
    }

    public CategoriaDeportiva getCatgoriaD() {
        return catgoriaD;
    }

    public void setCatgoriaD(CategoriaDeportiva catgoriaD) {
        this.catgoriaD = catgoriaD;
    }

    public List<CategoriaDeportiva> getCategroiaDL() {
        return categroiaDL;
    }

    public void setCategroiaDL(List<CategoriaDeportiva> categroiaDL) {
        this.categroiaDL = categroiaDL;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public Registropago getRegistroP() {
        return registroP;
    }

    public void setRegistroP(Registropago registroP) {
        this.registroP = registroP;
    }

    public loginController getLogin() {
        return login;
    }

    public void setLogin(loginController login) {
        this.login = login;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Nivel> getListaNivel() {
        return listaNivel;
    }

    public void setListaNivel(List<Nivel> listaNivel) {
        this.listaNivel = listaNivel;
    }
    
    
    
    //Metodos
    
    //Insertar usuario
    public void crearUsuario(){
        try {
            roles = rolFL.find(1);
            usuario.setIdRol(roles);
            usuario.setIdtipoSangre(tipoSangre);
            usuario.setIdEps(eps);
 
            usuarioFL.create(usuario);
            
                       
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "La inscripcion fue exitosa", 
                            "Debes llegar a la academia y pagar la matricula para tener un usuario"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en ", " "+e.getMessage()));
        }
        
    }
    
    
    //Iniciar sesion
    public String iniciarSession(){
        
        String url = null;
        Usuario u;
        
        try {
            u = usuarioFL.find(usuario);
            if (u != null) {
                String rol = u.getIdRol().getRol();
                switch (rol) {
                    case "Alumno":
                        url = "app/user/principal?faces-redirect=true";
                        break;
                    case "Supervsior":
                        url = "app/admin/principal?faces-redirect=true";
                        break;
                    default:
                }
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso:", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso:", "Error al iniciar sesion"));
            e.printStackTrace();
        }
        
        return url;
        
    }
  
    //Cerrar Session
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
}
