/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "lugar_torneo")
@NamedQueries({
    @NamedQuery(name = "LugarTorneo.findAll", query = "SELECT l FROM LugarTorneo l")
    , @NamedQuery(name = "LugarTorneo.findByIdLugarTorneo", query = "SELECT l FROM LugarTorneo l WHERE l.idLugarTorneo = :idLugarTorneo")
    , @NamedQuery(name = "LugarTorneo.findByNombreLugarTorneo", query = "SELECT l FROM LugarTorneo l WHERE l.nombreLugarTorneo = :nombreLugarTorneo")
    , @NamedQuery(name = "LugarTorneo.findByDireccion", query = "SELECT l FROM LugarTorneo l WHERE l.direccion = :direccion")})
public class LugarTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Lugar_Torneo")
    private Integer idLugarTorneo;
    @Basic(optional = false)
    @Column(name = "Nombre_Lugar_Torneo")
    private String nombreLugarTorneo;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Lob
    @Column(name = "foto_lugar")
    private byte[] fotoLugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugarTorneo", fetch = FetchType.LAZY)
    private List<Torneo> torneoList;

    public LugarTorneo() {
    }

    public LugarTorneo(Integer idLugarTorneo) {
        this.idLugarTorneo = idLugarTorneo;
    }

    public LugarTorneo(Integer idLugarTorneo, String nombreLugarTorneo, String direccion) {
        this.idLugarTorneo = idLugarTorneo;
        this.nombreLugarTorneo = nombreLugarTorneo;
        this.direccion = direccion;
    }

    public Integer getIdLugarTorneo() {
        return idLugarTorneo;
    }

    public void setIdLugarTorneo(Integer idLugarTorneo) {
        this.idLugarTorneo = idLugarTorneo;
    }

    public String getNombreLugarTorneo() {
        return nombreLugarTorneo;
    }

    public void setNombreLugarTorneo(String nombreLugarTorneo) {
        this.nombreLugarTorneo = nombreLugarTorneo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte[] getFotoLugar() {
        return fotoLugar;
    }

    public void setFotoLugar(byte[] fotoLugar) {
        this.fotoLugar = fotoLugar;
    }

    public List<Torneo> getTorneoList() {
        return torneoList;
    }

    public void setTorneoList(List<Torneo> torneoList) {
        this.torneoList = torneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugarTorneo != null ? idLugarTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugarTorneo)) {
            return false;
        }
        LugarTorneo other = (LugarTorneo) object;
        if ((this.idLugarTorneo == null && other.idLugarTorneo != null) || (this.idLugarTorneo != null && !this.idLugarTorneo.equals(other.idLugarTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.LugarTorneo[ idLugarTorneo=" + idLugarTorneo + " ]";
    }
    
}
