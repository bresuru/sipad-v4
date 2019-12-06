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
@Table(name = "nivel")
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n")
    , @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel")
    , @NamedQuery(name = "Nivel.findByNombreNivel", query = "SELECT n FROM Nivel n WHERE n.nombreNivel = :nombreNivel")
    , @NamedQuery(name = "Nivel.findByObjetivos", query = "SELECT n FROM Nivel n WHERE n.objetivos = :objetivos")
    , @NamedQuery(name = "Nivel.findByFotoNivel", query = "SELECT n FROM Nivel n WHERE n.fotoNivel = :fotoNivel")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Nivel")
    private Integer idNivel;
    @Basic(optional = false)
    @Column(name = "Nombre_Nivel")
    private String nombreNivel;
    @Basic(optional = false)
    @Column(name = "Objetivos")
    private String objetivos;
    @Column(name = "foto_nivel")
    private String fotoNivel;
    @OneToMany(mappedBy = "idNivel", fetch = FetchType.LAZY)
    private List<NivelHasHorario> nivelHasHorarioList;
    @OneToMany(mappedBy = "idNivelCategoria", fetch = FetchType.LAZY)
    private List<Alumno> alumnoList;
    @JoinColumn(name = "lugar_Id_Lugar", referencedColumnName = "Id_Lugar")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lugar lugarIdLugar;
    @JoinColumn(name = "id_categoria", referencedColumnName = "Id_Categoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaDeportiva idCategoria;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profesor idProfesor;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Nivel(Integer idNivel, String nombreNivel, String objetivos) {
        this.idNivel = idNivel;
        this.nombreNivel = nombreNivel;
        this.objetivos = objetivos;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getFotoNivel() {
        return fotoNivel;
    }

    public void setFotoNivel(String fotoNivel) {
        this.fotoNivel = fotoNivel;
    }

    public List<NivelHasHorario> getNivelHasHorarioList() {
        return nivelHasHorarioList;
    }

    public void setNivelHasHorarioList(List<NivelHasHorario> nivelHasHorarioList) {
        this.nivelHasHorarioList = nivelHasHorarioList;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Lugar getLugarIdLugar() {
        return lugarIdLugar;
    }

    public void setLugarIdLugar(Lugar lugarIdLugar) {
        this.lugarIdLugar = lugarIdLugar;
    }

    public CategoriaDeportiva getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaDeportiva idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.Nivel[ idNivel=" + idNivel + " ]";
    }
    
}
