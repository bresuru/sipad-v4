/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.controladores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sipad.sena.dao.*;
import sipad.sena.entidades.*;

@Named
@RequestScoped
public class usuariosController {

    @EJB
    private UsuarioFacadeLocal usuariosFL;
    private Usuario usuarios;

    @EJB
    private ProfesorFacadeLocal profesorFL;
    private Profesor profesor;

    @EJB
    private SupervisorFacadeLocal supervisorFL;
    private Supervisor supervisor;

    @EJB
    private AlumnoFacadeLocal alumnoFL;
    private Alumno alumno;

    @EJB
    private TipoSangreFacadeLocal tipoSangreFL;
    private TipoSangre tipoSangre;
    private List<TipoSangre> listaTipoSangre;

    @EJB
    private TipodocumentoFacadeLocal tipoDocFL;
    private Tipodocumento tipoDoc;
    private List<Tipodocumento> listaTipoDoc;

    @EJB
    private EstadoUsuarioFacadeLocal estadoFL;
    private EstadoUsuario estado;

    @EJB
    private EspecialidadFacadeLocal especialidadFL;
    private Especialidad especialidad;
    private List<Especialidad> especialidadList;

    @EJB
    private AlumnoHasTorneoFacadeLocal alumnoTFL;
    private AlumnoHasTorneo alumnoT;

    @EJB
    private CategoriaDeportivaFacadeLocal categoriaFL;
    private CategoriaDeportiva categoria;
    private List<CategoriaDeportiva> categoriaL;

    @EJB
    private NivelFacadeLocal nivelFL;
    private Nivel nivel;

    @EJB
    private LoginFacadeLocal loginFL;
    private Login login;

    //Para subir archibos
    private archivosController archivo;

    @EJB
    private EpsFacadeLocal epsFL;
    private Eps eps;
    private List<Eps> epsL;
    
    private LugarTorneoFacadeLocal lugarTorneoFacadeLocal;
    private LugarTorneo lugarTorneo;
    
    

    @EJB
    private TorneoFacadeLocal torneosFacadeLocal;
    private Torneo torneos;

    @PostConstruct
    private void init() {

        usuarios = new Usuario();
        supervisor = new Supervisor();
        profesor = new Profesor();
        alumno = new Alumno();
        tipoSangre = new TipoSangre();
        tipoDoc = new Tipodocumento();
        estado = new EstadoUsuario();
        especialidad = new Especialidad();
        alumnoT = new AlumnoHasTorneo();
        nivel = new Nivel();
        categoria = new CategoriaDeportiva();
        login = new Login();
        archivo = new archivosController();
        eps = new Eps();
        torneos = new Torneo();
        lugarTorneo = new LugarTorneo();
        
        listaTipoDoc = tipoDocFL.findAll();
        listaTipoSangre = tipoSangreFL.findAll();
        categoriaL = categoriaFL.findAll();
        epsL = epsFL.findAll();
        especialidadList = especialidadFL.findAll();
    }

    //GETTHERS Y SETTHERS:
    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    public Tipodocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Tipodocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public List<Tipodocumento> getListaTipoDoc() {
        return listaTipoDoc;
    }

    public void setListaTipoDoc(List<Tipodocumento> listaTipoDoc) {
        this.listaTipoDoc = listaTipoDoc;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public AlumnoHasTorneo getAlumnoT() {
        return alumnoT;
    }

    public void setAlumnoT(AlumnoHasTorneo alumnoT) {
        this.alumnoT = alumnoT;
    }

    public CategoriaDeportiva getCategoria() {
        return categoria;
    }

    public void setCategroia(CategoriaDeportiva categoria) {
        this.categoria = categoria;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<CategoriaDeportiva> getCategoriaL() {
        return categoriaL;
    }

    public void setCategoriaL(List<CategoriaDeportiva> categoriaL) {
        this.categoriaL = categoriaL;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public archivosController getArchivo() {
        return archivo;
    }

    public void setArchivo(archivosController archivo) {
        this.archivo = archivo;
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

    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    public Torneo getTorneos() {
        return torneos;
    }

    public void setTorneos(Torneo torneos) {
        this.torneos = torneos;
    }

    //METODOS:
    //Opciones con alumnos-------------------------------------------------------------
    public List<Alumno> listarAlumnos() {

        List<Alumno> listarAlumnos = null;

        try {

            listarAlumnos = alumnoFL.findEstado(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listarAlumnos;
    }

    //listar alumnos por medio del profesor
    public List<Alumno> listarAlumnosPro() {

        List<Alumno> listarAlumnos = null;

        Usuario user;

        Profesor pro;

        try {

            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            pro = profesorFL.find(user.getDocumento());

            categoria = categoriaFL.find(1);

            listarAlumnos = alumnoFL.findInfoAlumno(categoria.getIdCategoria());

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ""));

        }

        return listarAlumnos;
    }

    public List<Alumno> listarAlumnosI() {

        List<Alumno> listarAlumnos = null;

        try {

            listarAlumnos = alumnoFL.findEstado(2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listarAlumnos;
    }

    //Informacion del alumno
    public String consultarUsuario(int id_usuario, int id_alumno) {

        try {

            usuarios = usuariosFL.find(id_usuario);
            alumno = alumnoFL.find(id_alumno);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "infoAlumno";
    }

    public String profesorConsultarUsuario(int id_usuario, int id_alumno) {

        alumno = new Alumno();
        usuarios = new Usuario();

        try {

            usuarios = usuariosFL.find(id_usuario);
            alumno = alumnoFL.find(id_alumno);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "indexAlumno";
    }

    //Imformacion del profesor
    public String consultarUsuarioProfesor(int id_usuario, int id_profesor) {

        try {

            usuarios = usuariosFL.find(id_usuario);
            profesor = profesorFL.find(usuarios);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "actualizarProfesor";
    }

    //desactivar usuario
    public void desactivarUsuario() {
        try {

            estado = estadoFL.find(2);

            alumno = alumnoFL.find(alumno.getIdAlumno());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            usuarios.setIdEstadoUsuario(estado);

            usuariosFL.edit(usuarios);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Activar usuario
    public void activarUsuario(int id_usuario) {
        try {

            estado = estadoFL.find(1);

            usuarios = usuariosFL.find(id_usuario);

            usuarios.setIdEstadoUsuario(estado);

            usuariosFL.edit(usuarios);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Se ha activo el usuario exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String buscarUsuario(int id_usuario) {
        try {

            usuarios = usuariosFL.find(id_usuario);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "modificarAlumnos";
    }

    public void modificarAlumno() {
        try {

            usuariosFL.edit(usuarios);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Eliminado"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Eliminado"));
            e.printStackTrace();
        }
    }

    public void eliminarAlumno(int id_alumno) {

        try {

            alumno = alumnoFL.find(id_alumno);

            alumnoTFL.removeAlumno(id_alumno);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Eliminado"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Eliminado"));
            e.printStackTrace();
        }

    }
    //Fin de alumnos ----------------------------------------------------------------------

    //--------------------------
    //Accion con el profesor--------------------------------------------------------------
    public List<Profesor> listarProfesores(int estado) {
        List<Profesor> profe = null;
        try {

            profe = profesorFL.findProfesor(estado);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return profe;
    }

    //buscar profesor
    public String buscarProfesor(int id_profesor, int id_usuario) {

        try {

            profesor = profesorFL.find(id_profesor);

            usuarios = usuariosFL.find(id_usuario);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "infoProfesor";
    }

    public String modificarProfesor(int id_profesor, int id_usuario) {

        try {

            profesor = profesorFL.find(id_profesor);

            usuarios = usuariosFL.find(id_usuario);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "actualizarProfesor";
    }

    //Buscar nievl acargo del profesor
    public String buscarNivel(int id_profesor) {
        Nivel n = null;
        Alumno alu;

        try {
            if (id_profesor == 0) {
                alu = (Alumno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("alumno");
                id_profesor = alu.getIdNivelCategoria().getIdProfesor().getIdProfesor();
            }

            n = nivelFL.fintNivelPro(id_profesor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return n.getNombreNivel();
    }

    //buscar especilisacion del profesor
    public String especilidadPro(int use) {
        String s = null;

        try {

            profesor = profesorFL.find(use);

            s = profesor.getIdEspecialidad().getNombreEspecialidad();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    //Buscar la categoria deportiva a la que pertenece el profesor
    public String buscarCategoria(int id_profesor) {
        Nivel n;
        CategoriaDeportiva c = null;
        int in;
        Alumno alu;

        try {

            if (id_profesor == 0) {
                alu = (Alumno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("alumno");
                id_profesor = alu.getIdNivelCategoria().getIdProfesor().getIdProfesor();
                profesor = profesorFL.find(id_profesor);
            }

            n = nivelFL.fintNivelPro(id_profesor);

            in = n.getIdCategoria().getIdCategoria();

            c = categoriaFL.find(in);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c.getNombreCategoria();
    }

    //listarAlumnos por el perfil del profesor
    public List<Alumno> listarAlumnosProfesor() {
        List<Alumno> listarA = null;
        Profesor profe;

        try {

            profe = (Profesor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (profe != null) {
                listarA = alumnoFL.findAlumPro(profe.getIdProfesor());
            } else {
                loginController login = new loginController();
                login.verificarSession();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listarA;
    }

    //listarAlumnos por profesor aparir del supervisor
    public List<Alumno> listarAlumnosProfesorSup(int id_profesor) {
        List<Alumno> listarA = null;

        try {

            listarA = alumnoFL.findAlumPro(id_profesor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listarA;
    }

    //Desactivar profesor
    public void desactivarUsuarioPro() {
        try {

            estado = estadoFL.find(2);

            profesor = profesorFL.find(profesor.getIdProfesor());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            usuarios.setIdEstadoUsuario(estado);

            usuariosFL.edit(usuarios);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Eliminar profesor
    public void eliminarProfesor(int id_profesor) {

        try {
            //Consultar lo que se va a aliminar
            profesor = profesorFL.find(id_profesor);
            usuarios = usuariosFL.find(profesor.getDocumento().getDocumento());
            login = loginFL.find(usuarios.getIdLogin().getIdLogin());

            //Eliminar informacion del profesor
            profesorFL.remove(profesor);
            usuariosFL.remove(usuarios);
            loginFL.remove(login);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado eleminado el profesor exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " El profesor puede estar acargo de estudiantes y por eso no se puedra eliminar"));
        }

    }

    //Fin de las acciones del profesor----------------------------------------------------------------------
    //-------------------------------------
    //---- Acciones con el perfil de supervisor----------
    public List<Supervisor> listarSup(int estado) {
        List<Supervisor> sup = null;
        try {

            sup = supervisorFL.findEstado(estado);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sup;
    }

    //buscar supervisor
    public String buscarSup(int id_sup, int id_usuario) {

        try {

            supervisor = supervisorFL.find(id_sup);

            usuarios = usuariosFL.find(id_usuario);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "infoSupervisor";
    }

    //Desactivar supervisor
    public void desactivarUsuarioSup() {
        try {

            estado = estadoFL.find(2);

            supervisor = supervisorFL.find(supervisor.getIdSupervisor());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            usuarios.setIdEstadoUsuario(estado);

            usuariosFL.edit(usuarios);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Eliminar Supervisor
    public void eliminarSup(int id_sup) {

        try {
            //Consultar lo que se va a aliminar
            supervisor = supervisorFL.find(id_sup);
            usuarios = usuariosFL.find(supervisor.getDocumento().getDocumento());
            login = loginFL.find(usuarios.getIdLogin().getIdLogin());

            //Eliminar informacion del profesor
            supervisorFL.remove(supervisor);
            usuariosFL.remove(usuarios);
            loginFL.remove(login);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado eleminado el supervsior exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al eliminar al supervisor"));
        }

    }
    //---------- fin de las acciones de supervisor--------

    //------------------------------------------------------------------
    //------ perfil del alumno -----------------
    public String verCategoria(int documento) {

        Usuario user;
        String nombre = null;

        try {

            alumno = alumnoFL.findAlumno(documento);
            nivel = nivelFL.find(alumno.getIdNivelCategoria().getIdNivel());
            categoria = categoriaFL.find(nivel.getIdCategoria().getIdCategoria());

            nombre = categoria.getNombreCategoria();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nombre;
    }

    //Consultar nivel del estudiate
    public String verNivel() {
        Usuario user;

        try {

            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            alumno = alumnoFL.findAlumno(user.getDocumento());
            nivel = nivelFL.find(alumno.getIdNivelCategoria());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nivel.getNombreNivel();
    }

    //consultar torneos del alumno
    public List<AlumnoHasTorneo> listaAlumnoT() {
        List<AlumnoHasTorneo> lista = null;

        try {

            lista = alumnoTFL.findAlumnoT(alumno.getIdAlumno());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Consultar profesor del alumno
    public String profesorAlumno() {
        Usuario user;
        String nombre = null;

        try {

            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            alumno = alumnoFL.findAlumno(user.getDocumento());
            nivel = nivelFL.find(alumno.getIdNivelCategoria().getIdNivel());
            profesor = profesorFL.find(nivel.getIdProfesor().getIdProfesor());

            nombre = profesor.getDocumento().getNombre1() + " "
                    + profesor.getDocumento().getNombre2() + " "
                    + profesor.getDocumento().getApellido1() + " "
                    + profesor.getDocumento().getApellido2() + " ";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nombre;
    }

    public String buscarNivel() {
        Nivel n = null;
        Usuario alu;
        Alumno a;
        int id_profesor = 0;

        try {

            alu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            a = alumnoFL.findAlumno(alu.getDocumento());
            id_profesor = a.getIdNivelCategoria().getIdProfesor().getIdProfesor();

            n = nivelFL.fintNivelPro(id_profesor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return n.getNombreNivel();
    }

    public String buscarCategoria() {
        Nivel n;
        CategoriaDeportiva c = null;
        int in;
        int id_profesor;
        Usuario alu;
        Alumno a;

        try {

            alu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            a = alumnoFL.findAlumno(alu.getDocumento());
            id_profesor = a.getIdNivelCategoria().getIdProfesor().getIdProfesor();

            n = nivelFL.fintNivelPro(id_profesor);

            in = n.getIdCategoria().getIdCategoria();

            c = categoriaFL.find(in);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c.getNombreCategoria();
    }

    //listarAlumnos por profesor aparir del supervisor
    public List<Alumno> listarAlumnosProfesorSup() {
        List<Alumno> listarA = null;
        int id_profesor;
        Usuario alu;
        Alumno a;

        try {

            alu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            a = alumnoFL.findAlumno(alu.getDocumento());
            id_profesor = a.getIdNivelCategoria().getIdProfesor().getIdProfesor();

            listarA = alumnoFL.findAlumPro(id_profesor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listarA;
    }

    //actualizar informacion del alumno por medio del modal
    public void actualizarAlumno() {

        Usuario user;
        Alumno alu;

        try {

            user = usuariosFL.find(usuarios.getDocumento());
            alu = alumnoFL.find(alumno.getIdAlumno());

            //Subir archivos
            if (archivo.getFile().getSubmittedFileName() != null) {
                archivo.subirImagen();
                if (archivo.getPathReal() != null) {
                    user.setFotoPerfil(archivo.getPathReal());
                }
            }

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(1);

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            alu.setDescripcion(alumno.getDescripcion());
            alu.setBeca(alumno.getBeca());

            usuariosFL.edit(user);
            alumnoFL.edit(alu);

            usuarios.setFotoPerfil(archivo.getPathReal());

            alumno = alumnoFL.find(alumno.getIdAlumno());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //Metodo para que el usuario alumno pueda actualizar su informacion
    public void informacionAlumno() {

        String url = null;

        try {

            usuarios = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (usuarios != null) {

                url = "";

                alumno = alumnoFL.findAlumno(usuarios.getDocumento());

            } else {
                loginController l = new loginController();
                l.verificarSession();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //actualizar informacion del alumno por el mismo
    public void actualizarAlumnoPerfil() {

        Usuario user;
        Alumno alu;

        try {

            archivo.subirImagen();

            user = usuariosFL.find(usuarios.getDocumento());
            alu = alumnoFL.find(alumno.getIdAlumno());

            user.setFotoPerfil(archivo.getPathReal());

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(1);

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            alu.setDescripcion(alumno.getDescripcion());
            alu.setBeca(alumno.getBeca());

            usuariosFL.edit(user);
            alumnoFL.edit(alu);

            usuarios.setFotoPerfil(archivo.getPathReal());

            alumno = alumnoFL.find(alumno.getIdAlumno());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuarios);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //actualizar informacion del profesor por el mismo
    public void actualizarProfesorPerfil() {

        Usuario user;

        try {

            user = usuariosFL.find(usuarios.getDocumento());

            archivo.subirImagen();

            user.setFotoPerfil(archivo.getPathReal());

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(eps.getIdEps());

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            usuariosFL.edit(user);

            usuarios.setFotoPerfil(archivo.getPathReal());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuarios);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado la informacion exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    public void actualizarDescripionAlumno() {

        Usuario user = null;

        Alumno alum = null;

        try {

            user = usuariosFL.find(usuarios.getDocumento());

            if (user != null) {
                alum = alumnoFL.find(alumno.getIdAlumno());
                alum.setDescripcion(alumno.getDescripcion());

                alumnoFL.edit(alum);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));
            }

            usuarios = usuariosFL.find(user.getDocumento());
            alumno = alumnoFL.find(alum.getIdAlumno());

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    public void actualizarFallasAlumno() {

        Usuario user = null;

        Alumno alum = null;

        try {

            user = usuariosFL.find(usuarios.getDocumento());

            if (user != null) {
                alum = alumnoFL.find(alumno.getIdAlumno());
                alum.setFallas(alumno.getFallas());

                alumnoFL.edit(alum);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));
            }

            usuarios = usuariosFL.find(user.getDocumento());
            alumno = alumnoFL.find(alum.getIdAlumno());

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //actualizarProfesor
    public void actualizarProfesor() {

        Usuario user;
        Profesor profe;

        try {

            user = usuariosFL.find(usuarios.getDocumento());
            profe = profesorFL.find(profesor.getIdProfesor());

            if (archivo.getFile() != null) {
                archivo.subirImagen();
                user.setFotoPerfil(archivo.getPathReal());
            }

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(eps.getIdEps());

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            //actualizar la tabla del profesor
            profe.setIdEspecialidad(especialidad);

            usuariosFL.edit(user);
            profesorFL.edit(profe);

            usuarios.setFotoPerfil(archivo.getPathReal());

            profesor = profesorFL.find(profesor.getIdProfesor());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado al profesor exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //Perfil de inicio de supervisor
    public void buscarSupervisor(int idUser) {

        String url = null;

        try {

            usuarios = usuariosFL.find(idUser);

            url = "app_supervisor/perfil/actualizarInfo?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //actualizar supp
    public void actualizarSupp() {

        Usuario user;
        Alumno alu;

        try {

            user = usuariosFL.find(usuarios.getDocumento());

            //Subir archivos
            if (archivo.getFile().getSubmittedFileName() != null) {
                archivo.subirImagen();
                if (archivo.getPathReal() != null) {
                    user.setFotoPerfil(archivo.getPathReal());
                }
            }

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(1);

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            usuariosFL.edit(user);

            usuarios.setFotoPerfil(archivo.getPathReal());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuarios);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //actualizar supp por otro supp
    public void actualizarSupervisor(int idSupp) {

        Usuario user;
        Alumno alu;

        try {

            user = usuariosFL.find(usuarios.getDocumento());

            //Subir archivos
            if (archivo.getFile().getSubmittedFileName() != null) {
                archivo.subirImagen();
                if (archivo.getPathReal() != null) {
                    user.setFotoPerfil(archivo.getPathReal());
                }
            }

            user.setNombre1(usuarios.getNombre1());
            user.setNombre2(usuarios.getNombre2());
            user.setApellido1(usuarios.getApellido1());
            user.setApellido2(usuarios.getApellido2());
            user.setFechaNacimiento(usuarios.getFechaNacimiento());

            eps = epsFL.find(1);

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            usuariosFL.edit(user);

            usuarios.setFotoPerfil(archivo.getPathReal());

            usuarios = usuariosFL.find(usuarios.getDocumento());

            supervisor = supervisorFL.find(idSupp);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Error al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //torneos
    public void torneoInscripbion() {

        try {

            usuarios = usuariosFL.find(79666596);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Torneo> buscarTorneos() {

        List<Torneo> torneos = null;

        try {

            torneos = torneosFacadeLocal.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return torneos;
    }

    
}
