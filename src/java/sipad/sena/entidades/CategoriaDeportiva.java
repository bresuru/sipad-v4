/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
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

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "categoria_deportiva")
@NamedQueries({
    @NamedQuery(name = "CategoriaDeportiva.findAll", query = "SELECT c FROM CategoriaDeportiva c")
    , @NamedQuery(name = "CategoriaDeportiva.findByIdCategoria", query = "SELECT c FROM CategoriaDeportiva c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaDeportiva.findByNombreCategoria", query = "SELECT c FROM CategoriaDeportiva c WHERE c.nombreCategoria = :nombreCategoria")
    , @NamedQuery(name = "CategoriaDeportiva.findByFotoCategoria", query = "SELECT c FROM CategoriaDeportiva c WHERE c.fotoCategoria = :fotoCategoria")})
public class CategoriaDeportiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Categoria")
    private Integer idCategoria;
    @Column(name = "Nombre_Categoria")
    private String nombreCategoria;
    @Column(name = "foto_categoria")
    private String fotoCategoria;
    @OneToMany(mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<Nivel> nivelList;

    public CategoriaDeportiva() {
    }

    public CategoriaDeportiva(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getFotoCategoria() {
        return fotoCategoria;
    }

    public void setFotoCategoria(String fotoCategoria) {
        this.fotoCategoria = fotoCategoria;
    }

    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaDeportiva)) {
            return false;
        }
        CategoriaDeportiva other = (CategoriaDeportiva) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.CategoriaDeportiva[ idCategoria=" + idCategoria + " ]";
    }
    
}
