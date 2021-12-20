/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.controllers;

import com.drimay.medicines.models.Medicine;
import com.drimay.medicines.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jaime
 */

@Controller
@RequestMapping("/medicine")
public class MedicineController {
    
    private static final Logger log = LoggerFactory.getLogger(MedicineController.class);
    
    @Autowired
    private MedicineService medicineService;
    
    // GET method to fetch all medicines
    @GetMapping()
    public String getAllMedicines(Model model) {
        log.info("Mostrando todos los medicamentos (controlador)");
        Iterable<Medicine> medicines = medicineService.findAll();
        model.addAttribute("medicines", medicines);
        return "medicinesList";
    }
    
    //POST method to create a medicine  (very simple)
    @PostMapping("/new/{id}/{name}")
    public void createMedicine(@PathVariable(value = "id") Long Id, @PathVariable(value = "name") String name, Model model){
        log.info("Creando medicamento");
        Medicine medicine = new Medicine(Id,name);
        medicineService.save(medicine);
    }
    
    // GET method to fetch medicine by Id
    @GetMapping("/details/{id}")
    public String getMedicineById(@PathVariable(value = "id") Long Id, Model model){
        log.info("Mostrando medicamento por id (controlador)");
        Medicine medicine = medicineService.findById(Id).get();
        model.addAttribute("medicine", medicine);
        return "medicinesDetails";
    }
    
    // GET method to fetch medicine by Id
    @PostMapping("/search")
    public String getMedicineByName(String name, Model model){
        log.info("Mostrando medicamentos por nombre (controlador)");
        if(name!=null) {
            Iterable<Medicine> medicines = medicineService.findMedicineByName(name);
            model.addAttribute("medicines", medicines);
        }else {
            Iterable<Medicine> medicines = medicineService.findAll();
            model.addAttribute("medicines", medicines);
        }
        return "medicinesList";
    }
    
}
