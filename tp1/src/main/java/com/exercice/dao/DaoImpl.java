package com.exercice.dao;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{
    
    @Override
    public double getData() {
        System.out.print("From Data Base : ");
        return ThreadLocalRandom.current().nextDouble();
    }

}