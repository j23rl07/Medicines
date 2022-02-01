/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.controllers;

import com.drimay.medicines.models.Prescripcion;
import com.drimay.medicines.services.PrescripcionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**Clase controller de precripcion que conecta la logica de negocio con las vistas de prescripciones
 *
 * @version v1.0
 * @author jaime(github: j23rl07)
 */

@Controller
@RequestMapping("/prescripcion")
public class PrescripcionController {
    
    private static final Logger log = LoggerFactory.getLogger(PrescripcionController.class);
    
    @Autowired
    private PrescripcionService prescripcionService;
    
    /**GET method to fetch all prescripcion
     * 
     * @param model
     * @return redireccion a la vista
     */
    @GetMapping()
    public String getAllPrescripcion(Model model) {
        log.info("Mostrando todos las prescipciones (controlador)");
        Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
        model.addAttribute("prescripciones", prescripciones);
        return "prescripcionList";
    }
    
    /**GET method to fetch prescripcion by Id
     * 
     * @param Id
     * @param model
     * @return redireccion a la vista
     */
    @GetMapping("/{id}")
    public String getPrescripcionById(@PathVariable(value = "id") String Id, Model model){
        log.info("Mostrando prescripcion por id (controlador)");
        Prescripcion prescripcion = prescripcionService.findById(Id).get();
        model.addAttribute("prescripcion", prescripcion);
        return "prescripcionDetails";
    }
    
    /**POST method to fetch prescripcion by 
     * 
     * @param desNomco (query de búsqueda insertada por el usuario)
     * @param model
     * @return redireccion a la vista
     */
    @PostMapping("/search")
    public String getPrescripcionBydesNomco(String desNomco, Model model){
        log.info("Mostrando prescripcion por des_prese (controlador)");
        if(desNomco!=null) {
            Iterable<Prescripcion> prescripciones = prescripcionService.findPrescripcionByDesNomco(desNomco);
            model.addAttribute("prescripciones", prescripciones);
        }else {
            Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
            model.addAttribute("prescripciones", prescripciones);
        }
        return "prescripcionList";
    }
    
    /**POST method to fetch prescripcion by 
     * 
     * @param desPrese (query de búsqueda insertada por el usuario)
     * @param model
     * @return redireccion a la vista
     */
    @PostMapping("/Isearch")
    public String getIndexedPrescripcionBydesNomco(String desPrese, Model model){
        log.info("Mostrando prescripcion indexada por des_prese (controlador)");
        if(desPrese!=null) {
            Iterable<Prescripcion> prescripciones = prescripcionService.findIndexedPrescripcionByDesNomco(desPrese);
            model.addAttribute("prescripciones", prescripciones);
        }else {
            Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
            model.addAttribute("prescripciones", prescripciones);
        }
        return "prescripcionList";
    }
    
}
