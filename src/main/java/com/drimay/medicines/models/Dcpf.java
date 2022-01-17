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
@Table(name = "pres_dcpf")
@EntityListeners(AuditingEntityListener.class)
public class Dcpf {
    
    @Id
    private String id;
    
    @Field(termVector = TermVector.YES)
    @Analyzer(definition = "customAnalyzer")
    @Column(name = "nombre_dcpf", nullable = true, length = 255)
    private String nombreDcpf;
    
    @Column(name = "nombrecorto_dcpf", nullable = true, length = 255)
    private String nombreCortoDcpf;
    
    @Column(name = "codigo_dcp_id", nullable = true, length = 255)
    private String codigoDcpId;

    public Dcpf() {
    }

    public Dcpf(String id, String nombreDcpf, String nombreCortoDcpf, String codigoDcpId) {
        this.id = id;
        this.nombreDcpf = nombreDcpf;
        this.nombreCortoDcpf = nombreCortoDcpf;
        this.codigoDcpId = codigoDcpId;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDcpf() {
        return nombreDcpf;
    }

    public void setNombreDcpf(String nombreDcpf) {
        this.nombreDcpf = nombreDcpf;
    }

    public String getNombreCortoDcpf() {
        return nombreCortoDcpf;
    }

    public void setNombreCortoDcpf(String nombreCortoDcpf) {
        this.nombreCortoDcpf = nombreCortoDcpf;
    }

    public String getCodigoDcpId() {
        return codigoDcpId;
    }

    public void setCodigoDcpId(String codigoDcpId) {
        this.codigoDcpId = codigoDcpId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.nombreDcpf);
        hash = 43 * hash + Objects.hashCode(this.nombreCortoDcpf);
        hash = 43 * hash + Objects.hashCode(this.codigoDcpId);
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
        final Dcpf other = (Dcpf) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombreDcpf, other.nombreDcpf)) {
            return false;
        }
        if (!Objects.equals(this.nombreCortoDcpf, other.nombreCortoDcpf)) {
            return false;
        }
        return Objects.equals(this.codigoDcpId, other.codigoDcpId);
    }

    @Override
    public String toString() {
        return "Dcpf{" + "id=" + id + ", nombreDcpf=" + nombreDcpf + ", nombreCortoDcpf=" + nombreCortoDcpf + ", codigoDcpId=" + codigoDcpId + '}';
    }
    
    
    
}
