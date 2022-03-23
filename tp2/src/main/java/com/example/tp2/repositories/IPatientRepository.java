package com.example.tp2.repositories;

import java.util.List;

import com.example.tp2.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IPatientRepository extends JpaRepository<Patient,Long>{
    List<Patient> findByAgeBetween(Integer lowAge,Integer higherAge);
}
