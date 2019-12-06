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
@Table(name = "nivel_has_horario")
@NamedQueries({
    @NamedQuery(name = "NivelHasHorario.findAll", query = "SELECT n FROM NivelHasHorario n")
    , @NamedQuery(name = "NivelHasHorario.findByIdNivelHasHorario", query = "SELECT n FROM NivelHasHorario n WHERE n.idNivelHasHorario = :idNivelHasHorario")})
public class NivelHasHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_has_horario")
    private Integer idNivelHasHorario;
    @JoinColumn(name = "id_horario_entrenamiento", referencedColumnName = "id_horario_entrenamiento")
    @ManyToOne(fetch = FetchType.LAZY)
    private HorarioEntrenamiento idHorarioEntrenamiento;
    @JoinColumn(name = "id_nivel", referencedColumnName = "Id_Nivel")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivel idNivel;

    public NivelHasHorario() {
    }

    public NivelHasHorario(Integer idNivelHasHorario) {
        this.idNivelHasHorario = idNivelHasHorario;
    }

    public Integer getIdNivelHasHorario() {
        return idNivelHasHorario;
    }

    public void setIdNivelHasHorario(Integer idNivelHasHorario) {
        this.idNivelHasHorario = idNivelHasHorario;
    }

    public HorarioEntrenamiento getIdHorarioEntrenamiento() {
        return idHorarioEntrenamiento;
    }

    public void setIdHorarioEntrenamiento(HorarioEntrenamiento idHorarioEntrenamiento) {
        this.idHorarioEntrenamiento = idHorarioEntrenamiento;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelHasHorario != null ? idNivelHasHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelHasHorario)) {
            return false;
        }
        NivelHasHorario other = (NivelHasHorario) object;
        if ((this.idNivelHasHorario == null && other.idNivelHasHorario != null) || (this.idNivelHasHorario != null && !this.idNivelHasHorario.equals(other.idNivelHasHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.NivelHasHorario[ idNivelHasHorario=" + idNivelHasHorario + " ]";
    }
    
}
