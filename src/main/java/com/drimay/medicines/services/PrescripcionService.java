/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Prescripcion;
import com.drimay.medicines.repositories.PrescripcionRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaime
 */

@Service
public class PrescripcionService {
    
    @Autowired
    private PrescripcionRepository prescripcionRepository;
    
    @Transactional
    public Iterable<Prescripcion> findAll(){
        return prescripcionRepository.findAll();
    }
    
    @Transactional
    public Optional<Prescripcion> findById(String Id){
        return prescripcionRepository.findById(Id);
    }
    
    @Transactional
    public void save(Prescripcion prescripcion){
        prescripcionRepository.save(prescripcion);
    }
    
    @Transactional
    public Iterable<Prescripcion> findPrescripcionByDesNomco(String desNomco){
        return prescripcionRepository.findByDesNomco(desNomco);
    }
    
}
