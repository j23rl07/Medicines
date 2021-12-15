/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Medicine;
import com.drimay.medicines.repositories.MedicineRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaime
 */

@Service
public class MedicineService {
    
    @Autowired
    private MedicineRepository medicineRepository;
    
    @Transactional
    public Iterable<Medicine> findMedicineByName(String name){
        return medicineRepository.findMedicinesByName(name);
    }
    
    @Transactional
    public Iterable<Medicine> findAll(){
        return medicineRepository.findAll();
    }
    
    @Transactional
    public Optional<Medicine> findById(Long Id){
        return medicineRepository.findById(Id);
    }
}
