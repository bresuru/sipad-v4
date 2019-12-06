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
@Table(name = "alumno_has_torneo")
@NamedQueries({
    @NamedQuery(name = "AlumnoHasTorneo.findAll", query = "SELECT a FROM AlumnoHasTorneo a")
    , @NamedQuery(name = "AlumnoHasTorneo.findByIdAlumnTorn", query = "SELECT a FROM AlumnoHasTorneo a WHERE a.idAlumnTorn = :idAlumnTorn")})
public class AlumnoHasTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alumn_torn")
    private Integer idAlumnTorn;
    @JoinColumn(name = "alumno_Id_Alumno", referencedColumnName = "Id_Alumno")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumno alumnoIdAlumno;
    @JoinColumn(name = "torneo_Id_Torneo", referencedColumnName = "id_torneo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Torneo torneoIdTorneo;

    public AlumnoHasTorneo() {
    }

    public AlumnoHasTorneo(Integer idAlumnTorn) {
        this.idAlumnTorn = idAlumnTorn;
    }

    public Integer getIdAlumnTorn() {
        return idAlumnTorn;
    }

    public void setIdAlumnTorn(Integer idAlumnTorn) {
        this.idAlumnTorn = idAlumnTorn;
    }

    public Alumno getAlumnoIdAlumno() {
        return alumnoIdAlumno;
    }

    public void setAlumnoIdAlumno(Alumno alumnoIdAlumno) {
        this.alumnoIdAlumno = alumnoIdAlumno;
    }

    public Torneo getTorneoIdTorneo() {
        return torneoIdTorneo;
    }

    public void setTorneoIdTorneo(Torneo torneoIdTorneo) {
        this.torneoIdTorneo = torneoIdTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumnTorn != null ? idAlumnTorn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoHasTorneo)) {
            return false;
        }
        AlumnoHasTorneo other = (AlumnoHasTorneo) object;
        if ((this.idAlumnTorn == null && other.idAlumnTorn != null) || (this.idAlumnTorn != null && !this.idAlumnTorn.equals(other.idAlumnTorn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.AlumnoHasTorneo[ idAlumnTorn=" + idAlumnTorn + " ]";
    }
    
}
