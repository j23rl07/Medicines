/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Prescripcion;
import com.drimay.medicines.models.Prioridad;
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
    
    public String findKeyWord(String search){
        
        String prioridad = null;
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prioridad.class).get();
            
        for(String palabra : search.toLowerCase().split(" ")){ 
            Query queryK = queryBuilder.phrase().withSlop(1)
                .onField("palabra").sentence(palabra).createQuery();
            
            FullTextQuery jpaQuery 
            = fullTextEntityManager.createFullTextQuery(queryK, Prioridad.class);
            
            List<Prioridad> results = jpaQuery.getResultList();
            
            for (Prioridad p : results){
                if(search.toLowerCase().contains(p.getPalabra())){
                    prioridad = p.getPalabra();
                    break;
                }
            }
        }
        
        return prioridad;
        
    }
    
    @Transactional
    public Iterable<Prescripcion> findIndexedPrescripcionByDesNomco(String desPrese){
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prescripcion.class).get();
        
        //String prioridad = findKeyWord(desPrese);
        
        //Query combinedQuery;
        
        Query combinedQuery = queryBuilder.simpleQueryString()
            .onField("desPrese")
            .andField("dcpf.nombreDcpf")
            .andField("prioridad.palabra").boostedTo(100f)
            .withAndAsDefaultOperator()
            .matching(desPrese).createQuery();
        //if(prioridad != null){
            /*combinedQuery = queryBuilder.bool()
            .should(queryBuilder.phrase().withSlop(1)
                .onField("desPrese").sentence(desPrese).createQuery())
            .should(queryBuilder.phrase().withSlop(1)
                .onField("dcpf.nombreDcpf").sentence(desPrese).createQuery())
            .should(queryBuilder.phrase().boostedTo(100.0f).withSlop(3)
                .onField("prioridad.palabra").sentence(desPrese).createQuery())
            .createQuery();
        /*}else{
            combinedQuery = queryBuilder.bool()
            .should(queryBuilder.phrase().withSlop(1)
                .onField("desPrese").sentence(desPrese).createQuery())
            .should(queryBuilder.phrase().withSlop(1)
                .onField("dcpf.nombreDcpf").sentence(desPrese).createQuery())
            .createQuery();
        }*/
        
        FullTextQuery jpaQuery 
            = fullTextEntityManager.createFullTextQuery(combinedQuery, Prescripcion.class);
        
        List<Prescripcion> results = jpaQuery.getResultList();
        
        /*jpaQuery.setProjection(
            FullTextQuery.SCORE,
            FullTextQuery.EXPLANATION,
            FullTextQuery.THIS);
        
        List<Object[]> results3 = jpaQuery.getResultList();
        if(results3.size()>0){
            System.out.println(results3.get(0)[0]+"------------------------------------------------------------");
            System.out.println(results3.get(0)[1]+"------------------------------------------------------------");
            System.out.println(results3.get(0)[2]);
        }*/
        
        
        return results;
    }
    
    /*@Transactional
    public List<Prescripcion> indexSearch(String searchTerm, Integer maxSize) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Prescripcion.class).get();
        String[] palabras = StringUtils.split(searchTerm);
        String busqueda = "";
        for (String palabra : palabras) {
            if (StringUtils.isNotEmpty(busqueda)) {
                busqueda = busqueda + " " + palabra + "*";
            } else {
                busqueda = palabra + "*";
            }
        }
//        Query luceneQuery = qb.keyword().fuzzy().onFields("desPrese", "codigoDcpf.nombreDcpf", "formasFarmaceuticas.composicionPas.codPrincipioActivo.principioActivo")
//            .matching(searchTerm).createQuery();
        Query luceneQuery = qb.simpleQueryString()
            .onField("desPrese").boostedTo(5f)
            .andField("formasFarmaceuticas.composicionPas.codPrincipioActivo.principioActivo").boostedTo(3f)
            .andField("laboratorioTitular.laboratorio").boostedTo(5f)
            .andField("laboratorioComercializador.laboratorio").boostedTo(5f)
            .andField("codigoDcpf.nombreDcpf")
            .withAndAsDefaultOperator()
            .matching(busqueda).createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Prescripcion.class);
        jpaQuery.setMaxResults(maxSize);
        List<Prescripcion> listPres = null;
        try {
            listPres = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing
        }
        return listPres;
    }*/
    
}
