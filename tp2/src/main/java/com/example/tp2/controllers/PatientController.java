package com.example.tp2.controllers;

import java.util.List;


import com.example.tp2.dao.PatientDAO;
import com.example.tp2.models.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientDAO dao;
    
   @GetMapping
   public List<Patient> patients(){
       return dao.findAll();
   }
   
   @PostMapping
   public Patient create(@RequestBody Patient patient){
        return dao.create(patient.getName(),patient.getAge(),patient.getVille());
   }

   @GetMapping("/{id}")
   public Patient findById(@PathVariable Long id){
        if(dao.findById(id).isPresent())
            return dao.findById(id).get();
        return null;
   }

   @GetMapping("/findByAgeBetween")
   public List<Patient> findByAgeBetween(@RequestParam Integer lowAge,@RequestParam Integer higherAge){
       return dao.findByAgeBetween(lowAge, higherAge);
   }

   @PutMapping
   public Patient update(@RequestBody Patient patient){
       return dao.update(patient.getId(), patient.getName(), patient.getAge(), patient.getVille());
   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
       dao.delete(id);
   }

   @GetMapping("/page/{pageNumber}")
   public Page<Patient> paginate(@PathVariable int pageNumber,@RequestParam int size){
       return dao.paginate(PageRequest.of(pageNumber, size));
   }


    

}
