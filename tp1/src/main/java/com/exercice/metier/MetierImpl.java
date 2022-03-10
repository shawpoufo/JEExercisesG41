package com.exercice.metier;

import java.util.concurrent.ThreadLocalRandom;

import com.exercice.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    private IDao dao;

    @Autowired
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculer() {
        return dao.getData() * ThreadLocalRandom.current().nextDouble();
    }
}
