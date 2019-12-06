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
@Table(name = "bocaneiros")
@NamedQueries({
    @NamedQuery(name = "Bocaneiros.findAll", query = "SELECT b FROM Bocaneiros b")
    , @NamedQuery(name = "Bocaneiros.findByIdBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.idBocaneiros = :idBocaneiros")
    , @NamedQuery(name = "Bocaneiros.findByLogoBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.logoBocaneiros = :logoBocaneiros")
    , @NamedQuery(name = "Bocaneiros.findByFotoPrincipalUno", query = "SELECT b FROM Bocaneiros b WHERE b.fotoPrincipalUno = :fotoPrincipalUno")
    , @NamedQuery(name = "Bocaneiros.findByFotoPrincipalDos", query = "SELECT b FROM Bocaneiros b WHERE b.fotoPrincipalDos = :fotoPrincipalDos")
    , @NamedQuery(name = "Bocaneiros.findByDescripcionBocanerios", query = "SELECT b FROM Bocaneiros b WHERE b.descripcionBocanerios = :descripcionBocanerios")
    , @NamedQuery(name = "Bocaneiros.findByCelularBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.celularBocaneiros = :celularBocaneiros")
    , @NamedQuery(name = "Bocaneiros.findByTelefonoBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.telefonoBocaneiros = :telefonoBocaneiros")
    , @NamedQuery(name = "Bocaneiros.findByCorreoBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.correoBocaneiros = :correoBocaneiros")
    , @NamedQuery(name = "Bocaneiros.findByDireccionBocaneiros", query = "SELECT b FROM Bocaneiros b WHERE b.direccionBocaneiros = :direccionBocaneiros")})
public class Bocaneiros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bocaneiros")
    private Integer idBocaneiros;
    @Column(name = "logo_bocaneiros")
    private String logoBocaneiros;
    @Column(name = "foto_principal_uno")
    private String fotoPrincipalUno;
    @Column(name = "foto_principal_dos")
    private String fotoPrincipalDos;
    @Column(name = "descripcion_bocanerios")
    private String descripcionBocanerios;
    @Column(name = "celular_bocaneiros")
    private Integer celularBocaneiros;
    @Column(name = "telefono_bocaneiros")
    private Integer telefonoBocaneiros;
    @Column(name = "correo_bocaneiros")
    private String correoBocaneiros;
    @Column(name = "direccion_bocaneiros")
    private String direccionBocaneiros;

    public Bocaneiros() {
    }

    public Bocaneiros(Integer idBocaneiros) {
        this.idBocaneiros = idBocaneiros;
    }

    public Integer getIdBocaneiros() {
        return idBocaneiros;
    }

    public void setIdBocaneiros(Integer idBocaneiros) {
        this.idBocaneiros = idBocaneiros;
    }

    public String getLogoBocaneiros() {
        return logoBocaneiros;
    }

    public void setLogoBocaneiros(String logoBocaneiros) {
        this.logoBocaneiros = logoBocaneiros;
    }

    public String getFotoPrincipalUno() {
        return fotoPrincipalUno;
    }

    public void setFotoPrincipalUno(String fotoPrincipalUno) {
        this.fotoPrincipalUno = fotoPrincipalUno;
    }

    public String getFotoPrincipalDos() {
        return fotoPrincipalDos;
    }

    public void setFotoPrincipalDos(String fotoPrincipalDos) {
        this.fotoPrincipalDos = fotoPrincipalDos;
    }

    public String getDescripcionBocanerios() {
        return descripcionBocanerios;
    }

    public void setDescripcionBocanerios(String descripcionBocanerios) {
        this.descripcionBocanerios = descripcionBocanerios;
    }

    public Integer getCelularBocaneiros() {
        return celularBocaneiros;
    }

    public void setCelularBocaneiros(Integer celularBocaneiros) {
        this.celularBocaneiros = celularBocaneiros;
    }

    public Integer getTelefonoBocaneiros() {
        return telefonoBocaneiros;
    }

    public void setTelefonoBocaneiros(Integer telefonoBocaneiros) {
        this.telefonoBocaneiros = telefonoBocaneiros;
    }

    public String getCorreoBocaneiros() {
        return correoBocaneiros;
    }

    public void setCorreoBocaneiros(String correoBocaneiros) {
        this.correoBocaneiros = correoBocaneiros;
    }

    public String getDireccionBocaneiros() {
        return direccionBocaneiros;
    }

    public void setDireccionBocaneiros(String direccionBocaneiros) {
        this.direccionBocaneiros = direccionBocaneiros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBocaneiros != null ? idBocaneiros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bocaneiros)) {
            return false;
        }
        Bocaneiros other = (Bocaneiros) object;
        if ((this.idBocaneiros == null && other.idBocaneiros != null) || (this.idBocaneiros != null && !this.idBocaneiros.equals(other.idBocaneiros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Bocaneiros[ idBocaneiros=" + idBocaneiros + " ]";
    }
    
}
