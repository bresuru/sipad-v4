//BSSR


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
public class inscripcionController {

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
    private List<Especialidad> especialidadL;

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
    private EpsFacadeLocal epsFL;
    private Eps eps;
    private List<Eps> epsL;

    @EJB
    private LoginFacadeLocal loginFL;
    private Login login;

    @EJB
    private RolesFacadeLocal rolFL;
    private Roles rol;

    @EJB
    private AlumnoHasEventoFacadeLocal alumnoEFL;
    private AlumnoHasEvento alumnoE;
    
    //Para subir archibos
    private archivosController archivo;

    @EJB
    private CargoFacadeLocal cargoFL;
    private Cargo cargo;
    private List<Cargo> cargoL;

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
        eps = new Eps();
        login = new Login();
        rol = new Roles();
        alumnoE = new AlumnoHasEvento();
        cargo = new Cargo();
        archivo = new archivosController();
        
        listaTipoDoc = tipoDocFL.findAll();
        listaTipoSangre = tipoSangreFL.findAll();
        categoriaL = categoriaFL.findAll();
        epsL = epsFL.findAll();
        especialidadL = especialidadFL.findAll();
        cargoL = cargoFL.findAll();
    }

    //GETTER Y SETTHERS:
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

    public void setCategoria(CategoriaDeportiva categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaDeportiva> getCategoriaL() {
        return categoriaL;
    }

    public void setCategoriaL(List<CategoriaDeportiva> categoriaL) {
        this.categoriaL = categoriaL;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public AlumnoHasEvento getAlumnoE() {
        return alumnoE;
    }

    public void setAlumnoE(AlumnoHasEvento alumnoE) {
        this.alumnoE = alumnoE;
    }

    public List<Especialidad> getEspecialidadL() {
        return especialidadL;
    }

    public void setEspecialidadL(List<Especialidad> especialidadL) {
        this.especialidadL = especialidadL;
    }

    public List<Cargo> getCargoL() {
        return cargoL;
    }

    public void setCargoL(List<Cargo> cargoL) {
        this.cargoL = cargoL;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public archivosController getArchivo() {
        return archivo;
    }

    public void setArchivo(archivosController archivo) {
        this.archivo = archivo;
    }
    
    

    //----------------------
    //METODOS:
    public String verificarCategoriaAlumno() {
        String url = null;

        try {

            int tipoC = categoria.getIdCategoria();

            switch (tipoC) {
                case 1:

                    url = "registroFutbol";

                    break;
                case 2:

                    url = "registroPorras";

                    break;
                case 3:

                    url = "registroTeakwondo";

                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    //Metodo para registar alumno a futbol
    public void registrarAlumF() {
        Login lg;
        Usuario us;

        try {
            rol = rolFL.find(1);
            estado = estadoFL.find(1);
            nivel = nivelFL.find(5);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el alumno
            alumno.setDocumento(us);
            alumno.setFallas(0);
            alumno.setBeca("n");
            alumno.setIdFechaPago(0);
            alumno.setIdNivelCategoria(nivel);
            alumnoFL.create(alumno);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado el alumno exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " El usuario ya esta registrado en el sistema"));

        }

    }

    //Metodo para registar alumno a Teakwondo
    public void registrarAlumT() {
        Login lg;
        Usuario us;

        try {
            rol = rolFL.find(1);
            estado = estadoFL.find(1);
            nivel = nivelFL.find(3);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el alumno
            alumno.setDocumento(us);
            alumno.setFallas(0);
            alumno.setBeca("n");
            alumno.setIdFechaPago(0);
            alumno.setIdNivelCategoria(nivel);
            alumnoFL.create(alumno);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado el alumno exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al registrar al alumno"));

        }

    }

    //Metodo para registar alumno a Porras
    public void registrarAlumP() {
        Login lg;
        Usuario us;

        try {
            rol = rolFL.find(1);
            estado = estadoFL.find(1);
            nivel = nivelFL.find(4);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el alumno
            alumno.setDocumento(us);
            alumno.setFallas(0);
            alumno.setBeca("n");
            alumno.setIdFechaPago(0);
            alumno.setIdNivelCategoria(nivel);
            alumnoFL.create(alumno);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado el alumno exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al registrar al alumno"));

        }

    }

    //Eliminar alumno
    public void eliminarAlumno(int id_alumno) {

        try {
            //Para eliminar el alumno primero se debe eliminar todas los datos de las tablas que use su id
            alumno = alumnoFL.find(id_alumno);
            //Eliminar los torneos del alumno
            alumnoTFL.removeAlumno(alumno.getIdAlumno());
            //Eliminar los Eventos del alumno
            alumnoEFL.removeAlum(alumno.getIdAlumno());
            //Eliminar el Alumno
            alumnoFL.remove(alumno);
            //Eliminar el Usuario
            usuarios = usuariosFL.find(alumno.getDocumento().getDocumento());
            usuariosFL.remove(usuarios);
            //Eliminar el login del alumno
            login = loginFL.find(usuarios.getIdLogin().getIdLogin());
            loginFL.remove(login);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a eliminado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al eliminar el alumno"));

            e.printStackTrace();
        }

    }

    //Buscar alumno
    public String buscarAlumno(int alum, int use) {

        String url = null;

        try {

            usuarios = usuariosFL.find(use);

            login = loginFL.find(usuarios.getIdLogin().getIdLogin());

            alumno = alumnoFL.find(alum);

            url = "actualizarAlumno";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }
   
    public String consultarUsuario(int id_usuario, int id_alumno) {

        try {

            usuarios = usuariosFL.find(id_usuario);
            alumno = alumnoFL.find(id_alumno);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "infoAlumno";
    }

    //Actualizar alumno
    public void actualizarAlumno() {

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

            user.setIdTipoDoc(tipoDoc);
            user.setIdEps(eps);
            user.setIdtipoSangre(tipoSangre);

            alu.setDescripcion(alumno.getDescripcion());
            alu.setBeca(alumno.getBeca());

            usuariosFL.edit(user);
            alumnoFL.edit(alu);
            
            usuarios.setFotoPerfil(archivo.getPathReal());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a actualizado el alumno exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", " Se a elimiError al actualizar los datos" + usuarios.getDocumento()));

            e.printStackTrace();
        }

    }

    //Metodo para registar el profesor
    public void registrarPro() {
        Login lg;
        Usuario us;

        try {
            rol = rolFL.find(2);
            estado = estadoFL.find(2);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el profesor
            profesor.setIdEspecialidad(especialidad);
            profesor.setDocumento(us);
            profesorFL.create(profesor);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado el nuevo profesor exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al registrar al profesor"));

        }

    }

    //Metodo para registar supervisor
    public void registrarSup() {
        Login lg;
        Usuario us;

        try {
            rol = rolFL.find(3);
            estado = estadoFL.find(1);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el profesor
            supervisor.setIdCargo(cargo);
            supervisor.setDocumento(us);
            supervisorFL.create(supervisor);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a registrado el nuevo supervsior exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al registrar al supervisor"));

        }

    }
    //Metodo para actualizar supervisor
    public void modificarSup() {
        Supervisor sup =  null;
        
        try {

            //Modifica el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuariosFL.edit(usuarios);

            //Modicio el profesor
            cargo = cargoFL.find(cargo.getIdCargo());
            sup = supervisorFL.findUser(usuarios.getDocumento());
            sup.setIdCargo(cargo);
            supervisorFL.edit(sup);
            
            usuarios = usuariosFL.find(usuarios.getDocumento());
            supervisor = supervisorFL.find(sup.getIdSupervisor());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se ha actualizado el nuevo supervsior exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al modificar al supervisor"+usuarios.getDocumento()+" "+sup.getDocumento()));

        }

    }
    //buscar supervisor
     public String buscarSupervisor(int id_usuario, int id_supervisor) {
        try {

            usuarios = usuariosFL.find(id_usuario);
            supervisor = supervisorFL.find(id_supervisor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "actualizarSupervisor";
    }
    //Fin de supervisor

    //------------------------------------------
    //Inscripciones:
    //Metodo para registar alumno a futbol
    public String registrarAlumFP() {
        Login lg;
        Usuario us;

        String url = null;

        try {
            rol = rolFL.find(1);
            estado = estadoFL.find(2);
            nivel = nivelFL.find(5);

            //Crear el login
            login.setUsuario(usuarios.getDocumento().toString());
            loginFL.create(login);
            lg = loginFL.login(login);

            //Crear el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            usuarios.setIdTipoDoc(tipoDoc);
            usuarios.setIdLogin(lg);
            usuariosFL.create(usuarios);

            us = usuariosFL.find(usuarios.getDocumento());

            //Crear el alumno
            alumno.setDocumento(us);
            alumno.setFallas(0);
            alumno.setBeca("n");
            alumno.setIdFechaPago(0);
            alumno.setIdNivelCategoria(nivel);
            alumnoFL.create(alumno);
            
            url = "infoInscripcion";

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al registrar al alumno"));

        }
        
        return url;
    }
    
    
    //Actualizar profesor
    public void actualizarPro() {
        Login lg;
        Usuario us;

        try {

            //Modificar el usuario
            usuarios.setIdtipoSangre(tipoSangre);
            usuarios.setIdEps(eps);
            usuarios.setIdRol(rol);
            usuarios.setIdEstadoUsuario(estado);
            tipoDoc =tipoDocFL.find(tipoDoc.getIdTipoDoc());
            usuarios.setIdTipoDoc(tipoDoc);
            usuariosFL.edit(usuarios);

            usuarios = usuariosFL.find(usuarios.getDocumento());

            //Modificar el profesor
            profesor.setIdEspecialidad(especialidad);
            profesorFL.edit(profesor);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Se a actualizado profesor exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", " Error al modificar al profesor"+tipoDoc.getIdTipoDoc()));

        }

    }

}
