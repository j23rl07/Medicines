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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jaime
 */

@Controller
@RequestMapping("/prescripcion")
public class PrescripcionController {
    
    private static final Logger log = LoggerFactory.getLogger(PrescripcionController.class);
    
    @Autowired
    private PrescripcionService prescripcionService;
    
    // GET method to fetch all prescripcion
    @GetMapping()
    public String getAllPrescripcion(Model model) {
        log.info("Mostrando todos las prescipciones (controlador)");
        Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
        model.addAttribute("prescripciones", prescripciones);
        return "prescripcionList";
    }
    
    @GetMapping("/new")
	public String createDonation(Model model) {
	model.addAttribute("prescripcion", new Prescripcion());
	log.info("Inicializando formulario de creación de prescripcion");
	return "prescripcionForm";
	}
    
    //POST method to save a prescripcion
    @PostMapping("/save")
    public void savePrescripcion(@ModelAttribute Prescripcion prescripcion, Model model){
        log.info("guardando prescripción (Controlador)");
        prescripcionService.save(prescripcion);
    }
    
    // GET method to fetch prescripcion by Id
    @GetMapping("/{id}")
    public String getPrescripcionById(@PathVariable(value = "id") String Id, Model model){
        log.info("Mostrando prescripcion por id (controlador)");
        Prescripcion prescripcion = prescripcionService.findById(Id).get();
        model.addAttribute("prescripcion", prescripcion);
        return "prescripcionDetails";
    }
    
    // POST method to fetch prescripcion by 
    @PostMapping("/search")
    public String getPrescripcionBydesNomco(String desNomco, Model model){
        log.info("Mostrando prescripcion por des_nomco (controlador)");
        if(desNomco!=null) {
            Iterable<Prescripcion> prescripciones = prescripcionService.findPrescripcionByDesNomco(desNomco);
            model.addAttribute("prescripciones", prescripciones);
        }else {
            Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
            model.addAttribute("prescripciones", prescripciones);
        }
        return "prescripcionList";
    }
    
    // POST method to fetch prescripcion by 
    @PostMapping("/Isearch")
    public String getIndexedPrescripcionBydesNomco(String desNomco, Model model){
        log.info("Mostrando prescripcion indexada por des_nomco (controlador)");
        if(desNomco!=null) {
            Iterable<Prescripcion> prescripciones = prescripcionService.findIndexedPrescripcionByDesNomco(desNomco);
            model.addAttribute("prescripciones", prescripciones);
        }else {
            Iterable<Prescripcion> prescripciones = prescripcionService.findAll();
            model.addAttribute("prescripciones", prescripciones);
        }
        return "prescripcionList";
    }
    
}
