/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "alumno_has_evento")
@NamedQueries({
    @NamedQuery(name = "AlumnoHasEvento.findAll", query = "SELECT a FROM AlumnoHasEvento a")
    , @NamedQuery(name = "AlumnoHasEvento.findByIdAlumnoEvent", query = "SELECT a FROM AlumnoHasEvento a WHERE a.idAlumnoEvent = :idAlumnoEvent")})
public class AlumnoHasEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alumno_event")
    private Integer idAlumnoEvent;
    @JoinColumn(name = "alumno_Id_Alumno", referencedColumnName = "Id_Alumno")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumno alumnoIdAlumno;
    @JoinColumn(name = "evento_Id_Evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Evento eventoIdEvento;

    public AlumnoHasEvento() {
    }

    public AlumnoHasEvento(Integer idAlumnoEvent) {
        this.idAlumnoEvent = idAlumnoEvent;
    }

    public Integer getIdAlumnoEvent() {
        return idAlumnoEvent;
    }

    public void setIdAlumnoEvent(Integer idAlumnoEvent) {
        this.idAlumnoEvent = idAlumnoEvent;
    }

    public Alumno getAlumnoIdAlumno() {
        return alumnoIdAlumno;
    }

    public void setAlumnoIdAlumno(Alumno alumnoIdAlumno) {
        this.alumnoIdAlumno = alumnoIdAlumno;
    }

    public Evento getEventoIdEvento() {
        return eventoIdEvento;
    }

    public void setEventoIdEvento(Evento eventoIdEvento) {
        this.eventoIdEvento = eventoIdEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumnoEvent != null ? idAlumnoEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoHasEvento)) {
            return false;
        }
        AlumnoHasEvento other = (AlumnoHasEvento) object;
        if ((this.idAlumnoEvent == null && other.idAlumnoEvent != null) || (this.idAlumnoEvent != null && !this.idAlumnoEvent.equals(other.idAlumnoEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.AlumnoHasEvento[ idAlumnoEvent=" + idAlumnoEvent + " ]";
    }
    
}
