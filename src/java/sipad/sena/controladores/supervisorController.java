package sipad.sena.controladores;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
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
public class supervisorController {

    @EJB
    private TorneoFacadeLocal TorneoFL;
    private Torneo torneo;

    @EJB
    private LugarTorneoFacadeLocal lugarToneoFL;
    private LugarTorneo lugarTorneo;
    private List<LugarTorneo> listaLugarTorneo;

    @EJB
    private SupervisorFacadeLocal supervisorFL;
    private Supervisor supervisor;
    private List<Supervisor> supervisorL;

    @EJB
    private UsuarioFacadeLocal usuarioFL;
    private Usuario usuario;

    @EJB
    private LoginFacadeLocal loginFL;
    private Login login;

    @EJB
    private AlumnoFacadeLocal alumnoFL;
    private Alumno alumno;

    @EJB
    private EstadoUsuarioFacadeLocal estadoAFL;
    private EstadoUsuario estado;

    @EJB
    private CategoriaDeportivaFacadeLocal categroiaDFL;
    private CategoriaDeportiva categoriaD;

    private archivosController archivos;

    @EJB
    private AlumnoHasTorneoFacadeLocal alumnoTorneoFL;
    private AlumnoHasTorneo alumnoTorneo;

    @PostConstruct
    public void init() {
        torneo = new Torneo();
        lugarTorneo = new LugarTorneo();
        supervisor = new Supervisor();
        usuario = new Usuario();
        alumno = new Alumno();
        alumnoTorneo = new AlumnoHasTorneo();
        archivos = new archivosController();

        listaLugarTorneo = lugarToneoFL.findAll();
    }

    /**
     * Constructor sin parametros
     */
    public supervisorController() {
    }

    //GETTHERS Y SETTHERS
    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public LugarTorneo getLugarTorneo() {
        return lugarTorneo;
    }

    public void setLugarTorneo(LugarTorneo lugarTorneo) {
        this.lugarTorneo = lugarTorneo;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<Supervisor> getSupervisorL() {
        return supervisorL;
    }

    public void setSupervisorL(List<Supervisor> supervisorL) {
        this.supervisorL = supervisorL;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public CategoriaDeportiva getCategoriaD() {
        return categoriaD;
    }

    public void setCategoriaD(CategoriaDeportiva categoriaD) {
        this.categoriaD = categoriaD;
    }

    public List<LugarTorneo> getListaLugarTorneo() {
        return listaLugarTorneo;
    }

    public void setListaLugarTorneo(List<LugarTorneo> listaLugarTorneo) {
        this.listaLugarTorneo = listaLugarTorneo;
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

    public AlumnoHasTorneo getAlumnoTorneo() {
        return alumnoTorneo;
    }

    public void setAlumnoTorneo(AlumnoHasTorneo alumnoTorneo) {
        this.alumnoTorneo = alumnoTorneo;
    }

    public archivosController getArchivos() {
        return archivos;
    }

    public void setArchivos(archivosController archivos) {
        this.archivos = archivos;
    }

    //Metodos:
    //Metodo de iniciarsesion
    public String iniciarSession() {
        return "app/supervisor/indexSup";
    }

    //metodos de torneos
    //Crear nuevo torneo
   

    //Eliminar Torneo
    public void eliminarTorneo(int id_torneo) {
        try {

            torneo = TorneoFL.find(id_torneo);

            TorneoFL.remove(torneo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Buscar torneo
    public String buscarTorneo(int id_torneo) {
        try {

            torneo = TorneoFL.find(id_torneo);

            lugarTorneo = lugarToneoFL.find(torneo.getIdLugarTorneo());

            supervisor = supervisorFL.find(torneo.getIdSupervisor());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "modificarTorneo";
    }

    //modificar torneo
    public void modificarTorneo() {
        try {

            TorneoFL.edit(torneo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Listar torneo
    public List<Torneo> listarTorneo() {

        List<Torneo> torneoL = new VirtualFlow.ArrayLinkedList<>();
        try {
            torneoL = TorneoFL.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return torneoL;
    }

    //Metodos de categoria deportiva
    //Crear nuevo torneo
    public void crearCategoria() {

        try {

            categroiaDFL.create(categoriaD);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Listar ctagoria deportiva
    public List<CategoriaDeportiva> listarCategoria() {

        List<CategoriaDeportiva> listaC = new ArrayList();

        try {
            listaC = categroiaDFL.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaC;
    }

    //Eliminar Torneo
    public void eliminarCategoriaD(int id_categroia) {
        try {

            categoriaD.setIdCategoria(id_categroia);

            categroiaDFL.remove(categoriaD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Buscar torneo
    public String buscarCategoria(int id_categoria) {
        try {

            categoriaD = categroiaDFL.find(id_categoria);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "modificarTorneo";
    }

    //modificar torneo
    public void modificarCategoria() {
        try {

            categroiaDFL.edit(categoriaD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //usuarios
    //Consultar usuario
    public List<Alumno> listarUsuarios() {

        List<Alumno> listaUsu = null;
        List<Alumno> lista = null;

        try {
            lista = alumnoFL.findAll();

            estado.setIdEstadoUsuario(1);

            for (Alumno listaalumno : lista) {
                listaUsu.add(listaalumno);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    //desactibar Usuario
    public void desactivarAlumno(Alumno alumnoD) {

        try {
            alumno = alumnoD;
            estado.setIdEstadoUsuario(3);
            alumnoFL.edit(alumno);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: ", " " + e.getMessage()));
            e.printStackTrace();
        }

    }

    //buscar alumno para modificar
    public String buscarAlumno(int id_alumno) {

        try {

            usuario = usuarioFL.find(id_alumno);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "modificarUsuarios";
    }

    //
    public void modificarAlumno() {

        try {

            usuarioFL.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "EL usuario fue modificado exitosamente", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", " no se pudo modificar al usuario"));
            e.printStackTrace();
        }

    }
    
    
    //crear torneo
    public void createTorn() {
        Usuario user = null;

        try {

            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (user != null) {
                archivos.subirImagen();
                torneo.setImagenTorneo(archivos.getPathReal());

                supervisor.setIdSupervisor(1);
                torneo.setIdSupervisor(supervisor);
                
                torneo.setIdLugarTorneo(lugarTorneo);

                estado = estadoAFL.find(1);
                torneo.setIdEstado(estado);

                TorneoFL.create(torneo);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Se creo el torneo exitosamente"));
            } else {
                loginController loginController1 = new loginController();
                loginController1.verificarSession();
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Error"));
        }
    }

}
