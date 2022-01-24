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

/**Clase entidad de prioridad, para fabricar prioridades y generar su tabla en la base de datos
 *
 * @version v1.0
 * @author jaime(github: j23rl07)
 */

@Entity
@Indexed
@Table(name = "prioridad")
@EntityListeners(AuditingEntityListener.class)
public class Prioridad {
    
    @Id
    private String id;
    
    /**
     * atributo indexado, customanalyzer asignado(definido al principio de la Prescripción) 
     */
    @Field(termVector = TermVector.YES)
    @Analyzer(definition = "customAnalyzer")
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "palabra", nullable = true, length = 255)
    private String palabra;

    public Prioridad() {
    }

    public Prioridad(String id, String palabra) {
        this.id = id;
        this.palabra = palabra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.palabra);
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
        final Prioridad other = (Prioridad) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Prioridad{" + "id=" + id + ", palabra=" + palabra + '}';
    }
    
    
}
