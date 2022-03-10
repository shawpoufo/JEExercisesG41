package com.exercice.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.exercice.dao.*;
import com.exercice.metier.*;

public class PresentationDynamique {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, FileNotFoundException {
        /**
         * Instatition Dynamique
         */
        
        Scanner scanner = new Scanner( new File("./src/main/java/com/exercice/presentation/config.txt"));
        String className = scanner.nextLine();
        Class<?> c = Class.forName(className) ;
        IDao dao = (IDao) c.getDeclaredConstructor().newInstance();

        Class<?> cimetier = Class.forName("com.exercice.metier.MetierImpl");
        IMetier metier = (IMetier)cimetier.getDeclaredConstructor(new Class[]{IDao.class}).newInstance(dao);
        Method calculer = cimetier.getMethod("calculer");
        System.out.println(calculer.invoke(metier));
        scanner.close();
    }
}
