package com.exercice.presentation;

import com.exercice.metier.IMetier;
import com.exercice.metier.MetierImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationXml {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app_ctx.xml");
        IMetier metier = (MetierImpl) context.getBean("metier");
        System.out.println(metier.calculer());
        ((AbstractApplicationContext) context).close();       
    }
}
