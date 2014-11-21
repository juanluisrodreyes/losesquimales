/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sihame
 */
@Entity
@Table(name = "PELICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByIdpelicula", query = "SELECT p FROM Pelicula p WHERE p.idpelicula = :idpelicula"),
    @NamedQuery(name = "Pelicula.findByNombre", query = "SELECT p FROM Pelicula p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pelicula.findByAno", query = "SELECT p FROM Pelicula p WHERE p.ano = :ano"),
    @NamedQuery(name = "Pelicula.findByDescripcion", query = "SELECT p FROM Pelicula p WHERE p.descripcion = :descripcion")})
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPELICULA")
    private Integer idpelicula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ANO")
    private String ano;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Pelicula() {
    }

    public Pelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Pelicula(Integer idpelicula, String nombre, String ano) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.ano = ano;
    }

    public Integer getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpelicula != null ? idpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idpelicula == null && other.idpelicula != null) || (this.idpelicula != null && !this.idpelicula.equals(other.idpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Pelicula[ idpelicula=" + idpelicula + " ]";
    }
    
}
