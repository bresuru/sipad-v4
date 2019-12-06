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
@Table(name = "tipo_sangre")
@NamedQueries({
    @NamedQuery(name = "TipoSangre.findAll", query = "SELECT t FROM TipoSangre t")
    , @NamedQuery(name = "TipoSangre.findByIdtipoSangre", query = "SELECT t FROM TipoSangre t WHERE t.idtipoSangre = :idtipoSangre")
    , @NamedQuery(name = "TipoSangre.findByRh", query = "SELECT t FROM TipoSangre t WHERE t.rh = :rh")})
public class TipoSangre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoSangre")
    private Integer idtipoSangre;
    @Column(name = "rh")
    private String rh;
    @OneToMany(mappedBy = "idtipoSangre", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public TipoSangre() {
    }

    public TipoSangre(Integer idtipoSangre) {
        this.idtipoSangre = idtipoSangre;
    }

    public Integer getIdtipoSangre() {
        return idtipoSangre;
    }

    public void setIdtipoSangre(Integer idtipoSangre) {
        this.idtipoSangre = idtipoSangre;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoSangre != null ? idtipoSangre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSangre)) {
            return false;
        }
        TipoSangre other = (TipoSangre) object;
        if ((this.idtipoSangre == null && other.idtipoSangre != null) || (this.idtipoSangre != null && !this.idtipoSangre.equals(other.idtipoSangre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.TipoSangre[ idtipoSangre=" + idtipoSangre + " ]";
    }
    
}
