package com.exercice.presentation;

import com.exercice.metier.IMetier;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PresentationAnnotation {
    public static void main(String[] args) {
        try(AbstractApplicationContext context = 
        new AnnotationConfigApplicationContext("com.exercice.dao","com.exercice.metier");)
        {
            IMetier metier = context.getBean(IMetier.class);
            System.out.println(metier.calculer());
        }
        
    }
}
