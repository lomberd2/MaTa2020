package Trainingslager;

import Aufgaben.IO;

public class Fakultae {

    public static void start(){
        System.out.println("Bitte gib deine Fakultät ein: ");
        int fak = IO.readInteger();
        int ergebniss = 1;

        for(int i = 1; i <= fak; i++){
            System.out.println(ergebniss + " * " + i);
            ergebniss = ergebniss * i;
        }

        System.err.println(ergebniss);
    }
}
