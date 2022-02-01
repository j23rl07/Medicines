/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author jaime
 */

@Entity
@Indexed
@Table(name = "pres_laboratorios")
@EntityListeners(AuditingEntityListener.class)
public class Laboratorio {
    
    @Id
    private String id;
    
    @Column(name = "cif", nullable = true, length = 15)
    private String cif;
    
    @Column(name = "codigopostal", nullable = true, length = 255)
    private String codigopostal;
    
    @Column(name = "direccion", nullable = true, length = 1000)
    private String direccion;
    
    /**
    * atributo indexado, customanalyzer asignado(definido al principio de la clase) 
    */
    @Field(termVector = TermVector.YES, analyzer = @Analyzer(definition = "customAnalyzer"))
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "laboratorio", nullable = true, length = 1000)
    private String laboratorio;
    
    @Column(name = "localidad", nullable = true, length = 1000)
    private String localidad;

    public Laboratorio() {
    }

    public Laboratorio(String id, String cif, String codigopostal, String direccion, String laboratorio, String localidad) {
        this.id = id;
        this.cif = cif;
        this.codigopostal = codigopostal;
        this.direccion = direccion;
        this.laboratorio = laboratorio;
        this.localidad = localidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.cif);
        hash = 73 * hash + Objects.hashCode(this.codigopostal);
        hash = 73 * hash + Objects.hashCode(this.direccion);
        hash = 73 * hash + Objects.hashCode(this.laboratorio);
        hash = 73 * hash + Objects.hashCode(this.localidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laboratorio other = (Laboratorio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        if (!Objects.equals(this.codigopostal, other.codigopostal)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.laboratorio, other.laboratorio)) {
            return false;
        }
        return Objects.equals(this.localidad, other.localidad);
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id + ", cif=" + cif + ", codigopostal=" + codigopostal + ", direccion=" + direccion + ", laboratorio=" + laboratorio + ", localidad=" + localidad + '}';
    }
    
    
}
