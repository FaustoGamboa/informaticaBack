/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fausto
 */
@Entity
@Table(catalog = "finalinformatica", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicion.findAll", query = "SELECT m FROM Medicion m")
    , @NamedQuery(name = "Medicion.findByIdMedicion", query = "SELECT m FROM Medicion m WHERE m.idMedicion = :idMedicion")
    , @NamedQuery(name = "Medicion.findByFecha", query = "SELECT m FROM Medicion m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Medicion.findBySensorOrigen", query = "SELECT m FROM Medicion m WHERE m.sensorOrigen = :sensorOrigen")
    , @NamedQuery(name = "Medicion.findByValorMedida", query = "SELECT m FROM Medicion m WHERE m.valorMedida = :valorMedida")})
public class Medicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idMedicion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int sensorOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valorMedida;

    public Medicion() {
    }

    public Medicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Medicion(Integer idMedicion, Date fecha, int sensorOrigen, double valorMedida) {
        this.idMedicion = idMedicion;
        this.fecha = fecha;
        this.sensorOrigen = sensorOrigen;
        this.valorMedida = valorMedida;
    }

    public Integer getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getSensorOrigen() {
        return sensorOrigen;
    }

    public void setSensorOrigen(int sensorOrigen) {
        this.sensorOrigen = sensorOrigen;
    }

    public double getValorMedida() {
        return valorMedida;
    }

    public void setValorMedida(double valorMedida) {
        this.valorMedida = valorMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicion != null ? idMedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        if ((this.idMedicion == null && other.idMedicion != null) || (this.idMedicion != null && !this.idMedicion.equals(other.idMedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Medicion[ idMedicion=" + idMedicion + " ]";
    }
    
}
