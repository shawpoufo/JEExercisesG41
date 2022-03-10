package com.exercice.presentation;
import com.exercice.dao.*;
import com.exercice.metier.*;

public class Presentation {
    public static void main(String[] args) {
        /**
         * Instantiation statique
         */
        IDao dao = new DaoImpl();
        IMetier metier = new MetierImpl(dao);
        System.out.print(metier.calculer()+"\n");

        IDao dao2 = new DaoImpl2();
        IMetier metier2 = new MetierImpl(dao2);
        System.out.print(metier2.calculer()+"\n");
    }
}
