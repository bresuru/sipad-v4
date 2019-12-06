/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "registropago")
@NamedQueries({
    @NamedQuery(name = "Registropago.findAll", query = "SELECT r FROM Registropago r")
    , @NamedQuery(name = "Registropago.findByIdRegistroPago", query = "SELECT r FROM Registropago r WHERE r.idRegistroPago = :idRegistroPago")
    , @NamedQuery(name = "Registropago.findByFechaPago", query = "SELECT r FROM Registropago r WHERE r.fechaPago = :fechaPago")
    , @NamedQuery(name = "Registropago.findByMesesSinPagar", query = "SELECT r FROM Registropago r WHERE r.mesesSinPagar = :mesesSinPagar")})
public class Registropago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_registro_pago")
    private Integer idRegistroPago;
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "meses_sin_pagar")
    private Integer mesesSinPagar;

    public Registropago() {
    }

    public Registropago(Integer idRegistroPago) {
        this.idRegistroPago = idRegistroPago;
    }

    public Integer getIdRegistroPago() {
        return idRegistroPago;
    }

    public void setIdRegistroPago(Integer idRegistroPago) {
        this.idRegistroPago = idRegistroPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getMesesSinPagar() {
        return mesesSinPagar;
    }

    public void setMesesSinPagar(Integer mesesSinPagar) {
        this.mesesSinPagar = mesesSinPagar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroPago != null ? idRegistroPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registropago)) {
            return false;
        }
        Registropago other = (Registropago) object;
        if ((this.idRegistroPago == null && other.idRegistroPago != null) || (this.idRegistroPago != null && !this.idRegistroPago.equals(other.idRegistroPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Registropago[ idRegistroPago=" + idRegistroPago + " ]";
    }
    
}
