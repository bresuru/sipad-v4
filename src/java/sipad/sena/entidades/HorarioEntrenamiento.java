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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "horario_entrenamiento")
@NamedQueries({
    @NamedQuery(name = "HorarioEntrenamiento.findAll", query = "SELECT h FROM HorarioEntrenamiento h")
    , @NamedQuery(name = "HorarioEntrenamiento.findByIdHorarioEntrenamiento", query = "SELECT h FROM HorarioEntrenamiento h WHERE h.idHorarioEntrenamiento = :idHorarioEntrenamiento")
    , @NamedQuery(name = "HorarioEntrenamiento.findByDia", query = "SELECT h FROM HorarioEntrenamiento h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioEntrenamiento.findByHoraInicio", query = "SELECT h FROM HorarioEntrenamiento h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioEntrenamiento.findByHoraFin", query = "SELECT h FROM HorarioEntrenamiento h WHERE h.horaFin = :horaFin")})
public class HorarioEntrenamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario_entrenamiento")
    private Integer idHorarioEntrenamiento;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @OneToMany(mappedBy = "idHorarioEntrenamiento", fetch = FetchType.LAZY)
    private List<NivelHasHorario> nivelHasHorarioList;

    public HorarioEntrenamiento() {
    }

    public HorarioEntrenamiento(Integer idHorarioEntrenamiento) {
        this.idHorarioEntrenamiento = idHorarioEntrenamiento;
    }

    public HorarioEntrenamiento(Integer idHorarioEntrenamiento, String dia, Date horaInicio, Date horaFin) {
        this.idHorarioEntrenamiento = idHorarioEntrenamiento;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdHorarioEntrenamiento() {
        return idHorarioEntrenamiento;
    }

    public void setIdHorarioEntrenamiento(Integer idHorarioEntrenamiento) {
        this.idHorarioEntrenamiento = idHorarioEntrenamiento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public List<NivelHasHorario> getNivelHasHorarioList() {
        return nivelHasHorarioList;
    }

    public void setNivelHasHorarioList(List<NivelHasHorario> nivelHasHorarioList) {
        this.nivelHasHorarioList = nivelHasHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioEntrenamiento != null ? idHorarioEntrenamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioEntrenamiento)) {
            return false;
        }
        HorarioEntrenamiento other = (HorarioEntrenamiento) object;
        if ((this.idHorarioEntrenamiento == null && other.idHorarioEntrenamiento != null) || (this.idHorarioEntrenamiento != null && !this.idHorarioEntrenamiento.equals(other.idHorarioEntrenamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.HorarioEntrenamiento[ idHorarioEntrenamiento=" + idHorarioEntrenamiento + " ]";
    }
    
}
