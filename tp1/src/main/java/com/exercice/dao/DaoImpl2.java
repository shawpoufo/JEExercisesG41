package com.exercice.dao;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;
@Component("dao2")
public class DaoImpl2 implements IDao {

    @Override
    public double getData() {
        System.out.print("From Censors : ");
        return ThreadLocalRandom.current().nextDouble();
    }
    
}
