package com.example.tp2.dao;

import com.example.tp2.models.Patient;
import com.example.tp2.repositories.IPatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PatientDAO {
    
    // work without @bean or @component
    @Autowired
    IPatientRepository iPatientRepository;

    public List<Patient> findAll(){
            
        return iPatientRepository.findAll();
    }

    public Optional<Patient> findById(Long id){
        return iPatientRepository.findById(id);
    }

    public Patient create(String name,Integer age,String ville){
        return iPatientRepository.save(new Patient(name,age,ville));
    }

    public List<Patient> findByAgeBetween(Integer lowAge,Integer higherAge){
        return iPatientRepository.findByAgeBetween(lowAge, higherAge);
    }
    
    public Patient update(Long id,String name,Integer age,String ville){
        var patient = iPatientRepository.findById(id).get();
        patient.setAge(age);
        patient.setName(name);
        patient.setVille(ville);
        return iPatientRepository.save(patient);
    }

    public void delete(Long id){
        iPatientRepository.delete(iPatientRepository.getById(id));
    }

    public Page<Patient> paginate(Pageable pageable)
    {   
        return iPatientRepository.findAll(pageable);
    }

}
