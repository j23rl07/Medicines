/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.repositories;

import com.drimay.medicines.models.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaime
 */
@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long>{
    
    @Query("SELECT m FROM Medicine m WHERE m.name LIKE CONCAT('%',:name,'%')") 
    public Iterable<Medicine> findByName(@Param("name") String name);
    
}
