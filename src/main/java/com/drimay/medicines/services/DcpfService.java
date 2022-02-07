/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Dcpf;
import com.drimay.medicines.repositories.DcpfRepository;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** clase servide de prioridad que contiene la lógica de negocio de la entidad prioridad
 *
 * @version v1.0
 * @author jaime(github: j23rl07)
 */

@Service
public class DcpfService {
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private DcpfRepository dcpfRepository;
    
    public Iterable<Dcpf> findAll(){
        return dcpfRepository.findAll();
    }
    
    public Dcpf findById(String id){
        return dcpfRepository.findById(id).get();
    }
    
}
