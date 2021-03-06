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
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
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
    
    /**Método para añadir un elemento nuevo(almacenado dentro de le base de datos en este caso pero no en el índice) al indice
     * 
     * @param id 
     * 
     * Fuente: https://docs.jboss.org/hibernate/search/5.11/reference/en-US/pdf/hibernate_search_reference.pdf página: 162
     *          https://xy2401.com/local-docs/jboss/hibernate-search-5.11.1.Final/docs/api/org/hibernate/search/jpa/FullTextEntityManager.html#index-T-
     */
    @Transactional
    public void anyadeIndice(String id){
        FullTextSession fullTextSession = Search.getFullTextSession((entityManager.unwrap(Session.class)));
        Prescripcion prescripcion = prescripcionRepository.findById( id ).get();
        fullTextSession.index(prescripcion);
    }
    
    /**Método para eliminar un elemento del indice
     * CUIDADO: si el id que le entra es null, borra todos los elementos del indice y sus subclases
     * 
     * @param id 
     * 
     * Fuente: https://docs.jboss.org/hibernate/search/5.11/reference/en-US/pdf/hibernate_search_reference.pdf página: 163
     *          https://xy2401.com/local-docs/jboss/hibernate-search-5.11.1.Final/docs/api/org/hibernate/search/jpa/FullTextEntityManager.html#purge-java.lang.Class-java.io.Serializable-
     */
    @Transactional
    public void quitaIndice(String id){
        FullTextSession fullTextSession = Search.getFullTextSession((entityManager.unwrap(Session.class)));
        Prescripcion prescripcion = prescripcionRepository.findById( id ).get();
        fullTextSession.purge( Prescripcion.class, prescripcion.getId() );
    }
    
    /**Método para hacer una búsqueda indexada de prescripciones
     * 
     * @param desPrese (query de búsqueda insertada por el usuario)
     * @return Iterable de prescripciones (lista, set,...) para luego recorrerlo en la vista y mostrarlo
     */
    @Transactional
    public Iterable<Prescripcion> findIndexedPrescripcionByDesNomco(String desPrese){
        
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
            .forEntity(Prescripcion.class).get();
        
        /*  (NO SE USA)
        
        Combinacion de queries bool, para meter el campo prioritario, no se puede usar 1 sola query puesto que lo que tiene que buscar en prioritario 
            no es lo mismo que tiene que buscar en los otros campos.
            
            Fuente de la búsqueda combinada: https://www.baeldung.com/hibernate-search
        */
        
        /*Query query1 = queryBuilder.simpleQueryString()     //primera query
            .onField("desPrese")                            //busca en el campo desprese
            .andField("dcpf.nombreDcpf")                    //busca en el campo dcpf(relacion) y dentro de el busca el nombreDcpf
            .andField("prioridad.palabra").boostedTo(100f)  //busca en la lista de prioridades si se encuentra la palabra buscada (le da un peso muy grande (x100))
            .withAndAsDefaultOperator()
            .matching(desPrese).createQuery();              //busca por desPrese(query de busqueda insertada por el usuario) 
        
        Query query2 = queryBuilder.simpleQueryString()     //segunda query
            .onField("prioritario")                         //busca en el campo prioridad
            .withAndAsDefaultOperator()
            .matching("prioritario*").createQuery();         //busca la palabra prioritario
        
        Query combinedQuery = queryBuilder                  //combinamos las query con la query bool
            .bool()
            .must(query1)                                   //la primera query es obligatorio que esté, si no está no me vale la búsqueda
            .should(query2)                                   //una vez encontrados los elementos de la primera query, miramos si alguno de ellos cumplen la segunda query
            .createQuery();*/
        
        /*
        Constructor de la query de busqueda usada
        */
        Query query = queryBuilder.simpleQueryString()      
            .onField("desPrese")                                    //busca en el campo desprese
            .andField("dcpf.nombreDcpf")                            //busca en el campo dcpf(relacion) y dentro de el busca el nombreDcpf
            .andField("prioridad.palabra").boostedTo(100f)          //busca en la lista de prioridades si se encuentra la palabra buscada (le da un peso muy grande (x100))
            .andField("laboratorioComercializadorId.laboratorio")   //busca en el campo laboratorioComercializadorId(relacion) y dentro de el busca el laboratorio
            .withAndAsDefaultOperator()
            .matching(desPrese).createQuery();                      //busca por desPrese(query de busqueda insertada por el usuario) 
              
        FullTextQuery jpaQuery 
            = fullTextEntityManager.createFullTextQuery(query, Prescripcion.class);
        
        
        //-----------ordenar busqueda indexada por un parametro----------------
        /*
            No se usa porque rompe elorden de coincidencia con la query.
        */
        
        //org.apache.lucene.search.Sort sort = new Sort(                    //ordenar por un parametro
        //    new SortField("prioritario", SortField.Type.STRING));
        
        //jpaQuery1.setSort(sort);
        
        
        //------------paginado-------------
        //int y = 20;                                       //numero de elementos por a mostrar por página
        
        //jpaQuery.setFirstResult(y * (pagina-1));          //empezar por el elemento x
        //jpaQuery.setMaxResults(y);                        //devolver y resultados
        
        
        
        List<Prescripcion> results = jpaQuery.getResultList();
        
        return results;
    }
    
}
