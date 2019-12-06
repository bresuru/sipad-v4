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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "posiciones")
@NamedQueries({
    @NamedQuery(name = "Posiciones.findAll", query = "SELECT p FROM Posiciones p")
    , @NamedQuery(name = "Posiciones.findByIdPosicion", query = "SELECT p FROM Posiciones p WHERE p.idPosicion = :idPosicion")
    , @NamedQuery(name = "Posiciones.findByPosicion", query = "SELECT p FROM Posiciones p WHERE p.posicion = :posicion")})
public class Posiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_posicion")
    private Integer idPosicion;
    @Column(name = "posicion")
    private String posicion;

    public Posiciones() {
    }

    public Posiciones(Integer idPosicion) {
        this.idPosicion = idPosicion;
    }

    public Integer getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Integer idPosicion) {
        this.idPosicion = idPosicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosicion != null ? idPosicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posiciones)) {
            return false;
        }
        Posiciones other = (Posiciones) object;
        if ((this.idPosicion == null && other.idPosicion != null) || (this.idPosicion != null && !this.idPosicion.equals(other.idPosicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Posiciones[ idPosicion=" + idPosicion + " ]";
    }
    
}
