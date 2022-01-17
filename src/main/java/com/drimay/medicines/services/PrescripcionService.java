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
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.pattern.PatternReplaceCharFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.search.Query;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.CharFilterDef;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
import org.hibernate.search.jpa.FullTextQuery;

/**
 *
 * @author jaime
 */

@Service
/*@AnalyzerDef(name = "customAnalyzerquery",
    charFilters = {
        @CharFilterDef(
            name = "replaceV",
            factory = PatternReplaceCharFilterFactory.class,
            params = {
                @Parameter(name = "pattern", value = "[v]|[V]"),
                @Parameter(name = "replacement", value = "b")
            }
        ),
        @CharFilterDef(
            name = "replaceH",
            factory = PatternReplaceCharFilterFactory.class,
            params = {
                @Parameter(name = "pattern", value = "[h]|[H]"),
                @Parameter(name = "replacement", value = "")
            }
        )
    },
    tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class),
    filters = {
        @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class), // Replace accented characeters by their simpler counterpart (è => e, etc.)
        @TokenFilterDef(factory = LowerCaseFilterFactory.class), // Lowercase all characters
        @TokenFilterDef(factory = EdgeNGramFilterFactory.class,  params = {
            @Parameter(name = "minGramSize", value = "3" ),
            @Parameter(name = "maxGramSize", value = "7" )})
    })*/
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
    
    //@Analyzer(definition = "customAnalyzerquery")
    @Transactional
    public Iterable<Prescripcion> findIndexedPrescripcionByDesNomco(String desPrese){
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prescripcion.class).get();
        
        Query combinedQuery = queryBuilder.simpleQueryString()
            .onField("desPrese")
            .andField("dcpf.nombreDcpf")
            .andField("prioridad.palabra").boostedTo(100f)
            .withAndAsDefaultOperator()
            .matching(desPrese).createQuery();
        
        FullTextQuery jpaQuery 
            = fullTextEntityManager.createFullTextQuery(combinedQuery, Prescripcion.class);
        
        List<Prescripcion> results = jpaQuery.getResultList();
        
        return results;
    }
    
}
