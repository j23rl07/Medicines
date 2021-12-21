/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drimay.medicines.repositories;

import com.drimay.medicines.models.Prescripcion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaime
 */

@Repository
public interface PrescripcionRepository extends CrudRepository<Prescripcion, String>{
    
    @Query("SELECT p FROM Prescripcion p WHERE p.desNomco LIKE CONCAT('%',:des_nomco,'%')") 
    public Iterable<Prescripcion> findByDesNomco(@Param("des_nomco") String desNomco);
    
}
