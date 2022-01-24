/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.services;

import com.drimay.medicines.models.Prescripcion;
import com.drimay.medicines.repositories.PrescripcionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextQuery;

/**Clase service de precripcion que contiene la lógica de negocio de la entidad prescripción
 *
 * @version v1.0
 * @author jaime(github: j23rl07)
 */

/*
Se tiene que usar el mismo analyzer tanto a la hora de crear el indice (entidad) como a la hora de buscar elementos en el mismo (queries)
Fuente: https://docs.jboss.org/hibernate/search/5.11/reference/en-US/pdf/hibernate_search_reference.pdf    Página 82 del PDF

Pero no hace farta declararlo aquí también, la query sabe que analizer usar puesto que se le pasa la clase que va a buscar que tiene asociado su analyzer.
Fuente: https://docs.jboss.org/hibernate/search/5.11/reference/en-US/pdf/hibernate_search_reference.pdf    Página 124 del PDF
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
    
    /**Método para buscar por id en la base de datos
     * 
     * @param Id
     * @return opcional de Prescripción (se puede usar el optional posteriormente para lanzar escepciones)
     */
    @Transactional
    public Optional<Prescripcion> findById(String Id){
        return prescripcionRepository.findById(Id);
    }
    
    /**Método para guardar en la base de datos un objeto prescripción en su tabla correspondiente
     * 
     * @param prescripcion 
     */
    @Transactional
    public void save(Prescripcion prescripcion){
        prescripcionRepository.save(prescripcion);
    }
    
    /**Método para hacer una búsqueda en la base de datos de prescripciones
     * 
     * @param desNomco (query de búsqueda insertada por el usuario)
     * @return Iterable de prescripciones (lista, set,...) para luego recorrerlo en la vista y mostrarlo
     */
    @Transactional
    public Iterable<Prescripcion> findPrescripcionByDesNomco(String desNomco){
        return prescripcionRepository.findByDesNomco(desNomco);
    }
    
    /**Método para hacer una búsqueda indexada de prescripciones
     * 
     * @param desPrese (query de búsqueda insertada por el usuario)
     * @return Iterable de prescripciones (lista, set,...) para luego recorrerlo en la vista y mostrarlo
     */
    @Transactional
    public Iterable<Prescripcion> findIndexedPrescripcionByDesNomco(String desPrese){
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prescripcion.class).get();
        
        Query query1 = queryBuilder.simpleQueryString()     //primera query
            .onField("desPrese")                            //busca en el campo desprese
            .andField("dcpf.nombreDcpf")                    //busca en el campo dcpf(relacion) y dentro de el busca el nombreDcpf
            .andField("prioridad.palabra").boostedTo(100f)  //busca en la lista de prioridades si se encuentra la palabra buscada (le da un peso muy grande (x100))
            .withAndAsDefaultOperator()
            .matching(desPrese).createQuery();              //busca por desPrese(query de busqueda insertada por el usuario) 
        
        Query query2 = queryBuilder.simpleQueryString()     //segunda query
            .onField("prioritario")                         //busca en el campo prioridad
            .withAndAsDefaultOperator()
            .matching("prioritario*").createQuery();         //busca la palabra prioritario
        
        Query combinedQuery1 = queryBuilder                  //combinamos las query con la query bool
            .bool()
            .must(query1)                                   //la primera query es obligatorio que esté, si no está no me vale la búsqueda
            .must(query2)                                 //una vez encontrados los elementos de la primera query, miramos si alguno de ellos cumplen la segunda query
            .createQuery();
        
        Query combinedQuery2 = queryBuilder                  //combinamos las query con la query bool
            .bool()
            .must(query1)                                   //la primera query es obligatorio que esté, si no está no me vale la búsqueda
            .must(query2).not()                                 //una vez encontrados los elementos de la primera query, miramos si alguno de ellos cumplen la segunda query
            .createQuery();
        
        /* He usado la combinacion de queries bool, porque al meterne lo de prioritario, no puedo usar 1 sola query puesto que lo que tiene que buscar en prioritario 
            no es lo mismo que tiene que buscar en los otros campos
            
            Fuente de la búsqueda combinada: https://www.baeldung.com/hibernate-search
        */
        
        FullTextQuery jpaQuery1 
            = fullTextEntityManager.createFullTextQuery(combinedQuery1, Prescripcion.class);
        
        FullTextQuery jpaQuery2 
            = fullTextEntityManager.createFullTextQuery(combinedQuery2, Prescripcion.class);
        
       org.apache.lucene.search.Sort sort = new Sort(                //ordenar por un parametro
            new SortField("prioritario", SortField.Type.STRING));
        
        jpaQuery1.setSort(sort);
        
        
        
        //int y = 20;                             //numero de elementos por a mostrar por página
        
        //jpaQuery.setFirstResult(y * (pagina-1));  //empezar por el elemento x
        //jpaQuery.setMaxResults(y);              //devolver y resultados
        
        
        
        List<Prescripcion> results1 = jpaQuery1.getResultList();
        List<Prescripcion> results2 = jpaQuery2.getResultList();
        List<Prescripcion> results = Stream.concat(results1.stream(), results2.stream()).collect(Collectors.toList());
        
        return results;
    }
    
}
