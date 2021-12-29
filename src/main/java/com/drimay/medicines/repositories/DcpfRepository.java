/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drimay.medicines.repositories;

import com.drimay.medicines.models.Dcpf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaime
 */

@Repository
public interface DcpfRepository extends CrudRepository<Dcpf, String>{
    
}
