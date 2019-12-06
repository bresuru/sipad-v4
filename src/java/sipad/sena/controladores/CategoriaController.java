    package sipad.sena.controladores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@ApplicationScoped
public class CategoriaController {

    @EJB
    private CategoriaDeportivaFacadeLocal CDFL;
    private CategoriaDeportiva categoriaDeportiva;

    @EJB
    private AlumnoFacadeLocal AFL;
    private Alumno alumno;

    @EJB
    private NivelFacadeLocal NFL;
    private Nivel nivel;

    @EJB
    private LugarFacadeLocal LFL;
    private Lugar lugar;

    @EJB
    private ProfesorFacadeLocal PFL;
    private Profesor profesor;

    @EJB
    private UsuarioFacadeLocal UFL;
    private Usuario usuario;

    @EJB
    private SupervisorFacadeLocal SFL;
    private Supervisor supervisor;

    @EJB
    private HorarioEntrenamientoFacadeLocal HEFL;
    private HorarioEntrenamiento horarioentrenamiento;

    @EJB
    private NivelHasHorarioFacadeLocal NHFL;
    private NivelHasHorario nivelhashorario;

    @PostConstruct
    public void init() {
        categoriaDeportiva = new CategoriaDeportiva();
        alumno = new Alumno();
        nivel = new Nivel();
        lugar = new Lugar();
        profesor = new Profesor();
        usuario = new Usuario();
        supervisor = new Supervisor();
        horarioentrenamiento = new HorarioEntrenamiento();
        nivelhashorario = new NivelHasHorario();
    }

    public CategoriaDeportiva getCategoriaDeportiva() {
        return categoriaDeportiva;
    }

    public void setCategoriaDeportiva(CategoriaDeportiva categoriaDeportiva) {
        this.categoriaDeportiva = categoriaDeportiva;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public HorarioEntrenamiento getHorarioentrenamiento() {
        return horarioentrenamiento;
    }

    public void setHorarioentrenamiento(HorarioEntrenamiento horarioentrenamiento) {
        this.horarioentrenamiento = horarioentrenamiento;
    }

    public NivelHasHorario getNivelhashorario() {
        return nivelhashorario;
    }

    public void setNivelhashorario(NivelHasHorario nivelhashorario) {
        this.nivelhashorario = nivelhashorario;
    }

    //Metodo para crear una categoria deportiva
    public void crearCategoria() {
        try {

            CDFL.create(categoriaDeportiva);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Categoria creada con exito"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Huy!!!... ocurrio un error"));

        }
    }
    //Metodo para crear un nivel

    public void crearNivel() {
        try {
            
            NFL.create(nivel);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Nivel creado con exito"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Huy!!!... ocurrio un error"));

        }
    }
    // Metodo para actualizar una categoria

    public void actualizarCategoria() {

        try {

            CDFL.edit(categoriaDeportiva);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Categoria actualizada con exito" + categoriaDeportiva.getIdCategoria()));

        } catch (Exception e) {

            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Error al actualizar la informacion de la categoria"));

        }

    }

    // Metodo para actualizar un nivel
    public void actualizarNivel() {

        try {

            NFL.edit(nivel);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Nivel actualizada con exito"));

        } catch (Exception e) {

            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Error al actualizar la informacion de el nivel"));

        }

    }
    //Metodo para listar una categoria

    public List<CategoriaDeportiva> listarCategorias() {

        List<CategoriaDeportiva> lista = null;

        try {

            lista = CDFL.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    //Metodo para listar niveles

    public List<Nivel> listarNiveles() {

        List<Nivel> listaN = null;

        try {

            listaN = NFL.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaN;
    }

    //metodo para consultar una categoria
    public String consultarCategoria(int idCategoria) {

        categoriaDeportiva = new CategoriaDeportiva();

        try {
            categoriaDeportiva = CDFL.find(idCategoria);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO: ", "Categoria encontrada"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Error al buscar la categoria"));

        }

        return "modificar_categoria";

    }
   


    public String consultarNivel(int idNivel) {
        try {
            nivel = NFL.find(idNivel);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO: ", "NIvel encontrado"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Error al buscar el nivel"));

        }

        return "modificar_nivel";

    }

// metodo para ir a mas informacion
    public String masInformacion(int idCategoria) {

        try {

            categoriaDeportiva = CDFL.find(idCategoria);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "mas_informacion_categoria";
    }
    public String categoria_crearNivel(int idCategoria) {

        try {

            categoriaDeportiva = CDFL.find(idCategoria);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "crear_nivel.xhtml";
    }

// metodo para ir a informacion alumno
    public String informacionAlumno(int idCategoria) {

        try {
            
            categoriaDeportiva = CDFL.find(idCategoria);
            
        } catch (Exception e) {

            e.printStackTrace();
        }

        return "informacion_alumno";
    }

    // metodo para llenar la tabla de mas informacion
    public List<Nivel> listarInfo() {
        List<Nivel> ListaInfo = null;
        try {
            ListaInfo = NFL.findInformacion(categoriaDeportiva.getIdCategoria());
            if (!ListaInfo.isEmpty()) {
 
            } else {
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaInfo;
    }
    //metodo para llenar la tabla de alumnos
    public List<Alumno> listarAlum(){
        List<Alumno> ListaAlum = null;
        try{
            ListaAlum=AFL.findInfoAlumno(categoriaDeportiva.getIdCategoria());
             if (!ListaAlum.isEmpty()) {
               
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se ha listado correctamente"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaAlum;
    }

// metodo para eliminar una categoria
    public void eliminarCategoria(int id_Categoria) {

        try {

            categoriaDeportiva.setIdCategoria(id_Categoria);

            CDFL.remove(categoriaDeportiva);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Categoria eliminada con exito "));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", "Error al eliminar"));

        }

    }

    // metodo para eliminar un nivel
    public void eliminarNivel(int id_nivel) {

        try {

            nivel.setIdNivel(id_nivel);

            NFL.remove(nivel);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "NIvel eliminado con exito"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", "Error al eliminar"));

        }

    }
}
