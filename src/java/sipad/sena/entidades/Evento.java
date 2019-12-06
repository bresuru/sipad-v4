/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento")
    , @NamedQuery(name = "Evento.findByNombreEvento", query = "SELECT e FROM Evento e WHERE e.nombreEvento = :nombreEvento")
    , @NamedQuery(name = "Evento.findByHorario", query = "SELECT e FROM Evento e WHERE e.horario = :horario")
    , @NamedQuery(name = "Evento.findByInformacion", query = "SELECT e FROM Evento e WHERE e.informacion = :informacion")
    , @NamedQuery(name = "Evento.findByFotoEvento", query = "SELECT e FROM Evento e WHERE e.fotoEvento = :fotoEvento")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Column(name = "Nombre_Evento")
    private String nombreEvento;
    @Column(name = "Horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @Column(name = "Informacion")
    private String informacion;
    @Column(name = "foto_evento")
    private String fotoEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoIdEvento", fetch = FetchType.LAZY)
    private List<AlumnoHasEvento> alumnoHasEventoList;
    @JoinColumn(name = "id_lugar", referencedColumnName = "Id_Lugar")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lugar idLugar;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoUsuario idEstado;
    @JoinColumn(name = "Id_Supervisor", referencedColumnName = "id_Supervisor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Supervisor idSupervisor;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getFotoEvento() {
        return fotoEvento;
    }

    public void setFotoEvento(String fotoEvento) {
        this.fotoEvento = fotoEvento;
    }

    public List<AlumnoHasEvento> getAlumnoHasEventoList() {
        return alumnoHasEventoList;
    }

    public void setAlumnoHasEventoList(List<AlumnoHasEvento> alumnoHasEventoList) {
        this.alumnoHasEventoList = alumnoHasEventoList;
    }

    public Lugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Lugar idLugar) {
        this.idLugar = idLugar;
    }

    public EstadoUsuario getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoUsuario idEstado) {
        this.idEstado = idEstado;
    }

    public Supervisor getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Supervisor idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
