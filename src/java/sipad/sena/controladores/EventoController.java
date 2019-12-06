package sipad.sena.controladores;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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

public class EventoController {

    @EJB

    EventoFacadeLocal eventosFL;

    Evento evento;

    @EJB

    AlumnoHasEventoFacadeLocal alumnoHasEventoFL;

    AlumnoHasEvento alumnoHas;

    @EJB

    LugarFacadeLocal lugarFL;

    Lugar lugar;

    @EJB

    UsuarioFacadeLocal usuariosFL;

    Usuario usuario;

    @EJB

    AlumnoFacadeLocal alumnoFL;

    Alumno alumno;

    @EJB

    SupervisorFacadeLocal supervisorFL;

    Supervisor supervisor;

    @PostConstruct

    public void init() {

        evento = new Evento();
        lugar = new Lugar();
        usuario = new Usuario();
        alumno = new Alumno();
        supervisor = new Supervisor();
        
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public AlumnoHasEvento getAlumnoHas() {
        return alumnoHas;
    }

    public void setAlumnoHas(AlumnoHasEvento alumnoHas) {
        this.alumnoHas = alumnoHas;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    //crear evento
    public void crearEvento() {

        try {

            eventosFL.create(evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Se ha creado el evento exitosamente."));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso:", "No se creo el evento debido a un error."));
        }

    }

    //Modificar evento
    public void modificarEvento() {

        try {
            eventosFL.edit(evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Evento modificado exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso:", "No se creo la modificacion del evento debido a un error."));

        }
    }

    //EliminarEvento
    public void eliminarevento(int id_evento) {

        try {
            evento.setIdEvento(id_evento);
            eventosFL.remove(evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Evento eliminado exitosamente."));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso:", "No se elimino el evento debido a un error."));

        }

    }

    //Listar eventos
    public List<Evento> listarEventos() {

        List<Evento> lista = null;

        try {

            lista = eventosFL.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Consultar Evento
    public String consultarEvento(int id_Eventos) {

        try {

            evento = eventosFL.find(id_Eventos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Evento(s) consultado(s) exitosamente."));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso:", "Ha surgido un error al consultar los eventos."));

        }
        return "modificar_eventos";
    }  
    
    //Listar Lugares
    public List<Lugar> listarLugar() {

        List<Lugar> lugar = new VirtualFlow.ArrayLinkedList<>();
        try {
            lugar = lugarFL.findAll(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lugar;
    }
    
    //Inscribir Alumno a evento
    
    public void InscribirAluEvento(int Evento){
        
        Usuario user; 
        
        try {
            
            
            user =(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            alumno = alumnoFL.find("user");
            alumnoHas.setAlumnoIdAlumno(alumno);
            evento = eventosFL.find(Evento);
            alumnoHas.setEventoIdEvento(evento);
            alumnoHasEventoFL.create(alumnoHas);
        } catch (Exception e) {
            
        }
        
        
        
    }
    
}
