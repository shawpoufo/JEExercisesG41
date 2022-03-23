package com.example.tp2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity @Data @NoArgsConstructor @RequiredArgsConstructor
public class Patient {
    @Id @GeneratedValue
    Long id;
    @NonNull
    String name;
    @NonNull 
    Integer age;
    @NonNull
    String ville;

}
