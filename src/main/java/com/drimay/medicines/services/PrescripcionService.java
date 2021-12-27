/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Prescripcion;
import com.drimay.medicines.repositories.PrescripcionRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextQuery;

/**
 *
 * @author jaime
 */

@Service
public class PrescripcionService {
    
    @Autowired
    private EntityManager entityManager;
    
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
    
    @Transactional
    public Iterable<Prescripcion> findIndexedPrescripcionByDesNomco(String desPrese){
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prescripcion.class).get();
        
        Query query = queryBuilder.phrase().withSlop(1)
            .onField("desPrese").sentence(desPrese).createQuery();
        
        /*Query combinedQuery = queryBuilder.bool()
            .should(queryBuilder.phrase().withSlop(1)
                .onField("desPrese").sentence(desPrese).createQuery())
            .should(queryBuilder.phrase().withSlop(1)
                .onField("dcpf.nombreDcpf").sentence(desPrese).createQuery())
            .createQuery();*/
        
        FullTextQuery jpaQuery 
            = fullTextEntityManager.createFullTextQuery(query, Prescripcion.class);
        
        List<Prescripcion> results = jpaQuery.getResultList();
        
        return results;
    }
    
}
