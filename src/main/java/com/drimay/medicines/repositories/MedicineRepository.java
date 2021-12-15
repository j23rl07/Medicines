/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.repositories;

import com.drimay.medicines.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jaime
 */
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
    
    @Query("SELECT m FROM Medicine m WHERE m.name LIKE name") 
    public Iterable<Medicine> findMedicinesByName(@Param("name") String name);
    
}
