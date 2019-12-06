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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "alumno")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno")
    , @NamedQuery(name = "Alumno.findByBeca", query = "SELECT a FROM Alumno a WHERE a.beca = :beca")
    , @NamedQuery(name = "Alumno.findByFallas", query = "SELECT a FROM Alumno a WHERE a.fallas = :fallas")
    , @NamedQuery(name = "Alumno.findByDescripcion", query = "SELECT a FROM Alumno a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Alumno.findByCedulaAcudiente", query = "SELECT a FROM Alumno a WHERE a.cedulaAcudiente = :cedulaAcudiente")
    , @NamedQuery(name = "Alumno.findByBoletin", query = "SELECT a FROM Alumno a WHERE a.boletin = :boletin")
    , @NamedQuery(name = "Alumno.findByIdFechaPago", query = "SELECT a FROM Alumno a WHERE a.idFechaPago = :idFechaPago")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Alumno")
    private Integer idAlumno;
    @Basic(optional = false)
    @Column(name = "Beca")
    private String beca;
    @Basic(optional = false)
    @Column(name = "Fallas")
    private int fallas;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cedula_acudiente")
    private String cedulaAcudiente;
    @Column(name = "boletin")
    private String boletin;
    @Column(name = "id_fecha_pago")
    private Integer idFechaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoIdAlumno", fetch = FetchType.LAZY)
    private List<AlumnoHasEvento> alumnoHasEventoList;
    @JoinColumn(name = "Documento", referencedColumnName = "Documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario documento;
    @JoinColumn(name = "id_nivel_categoria", referencedColumnName = "Id_Nivel")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivel idNivelCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoIdAlumno", fetch = FetchType.LAZY)
    private List<AlumnoHasTorneo> alumnoHasTorneoList;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String beca, int fallas) {
        this.idAlumno = idAlumno;
        this.beca = beca;
        this.fallas = fallas;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public int getFallas() {
        return fallas;
    }

    public void setFallas(int fallas) {
        this.fallas = fallas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCedulaAcudiente() {
        return cedulaAcudiente;
    }

    public void setCedulaAcudiente(String cedulaAcudiente) {
        this.cedulaAcudiente = cedulaAcudiente;
    }

    public String getBoletin() {
        return boletin;
    }

    public void setBoletin(String boletin) {
        this.boletin = boletin;
    }

    public Integer getIdFechaPago() {
        return idFechaPago;
    }

    public void setIdFechaPago(Integer idFechaPago) {
        this.idFechaPago = idFechaPago;
    }

    public List<AlumnoHasEvento> getAlumnoHasEventoList() {
        return alumnoHasEventoList;
    }

    public void setAlumnoHasEventoList(List<AlumnoHasEvento> alumnoHasEventoList) {
        this.alumnoHasEventoList = alumnoHasEventoList;
    }

    public Usuario getDocumento() {
        return documento;
    }

    public void setDocumento(Usuario documento) {
        this.documento = documento;
    }

    public Nivel getIdNivelCategoria() {
        return idNivelCategoria;
    }

    public void setIdNivelCategoria(Nivel idNivelCategoria) {
        this.idNivelCategoria = idNivelCategoria;
    }

    public List<AlumnoHasTorneo> getAlumnoHasTorneoList() {
        return alumnoHasTorneoList;
    }

    public void setAlumnoHasTorneoList(List<AlumnoHasTorneo> alumnoHasTorneoList) {
        this.alumnoHasTorneoList = alumnoHasTorneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
