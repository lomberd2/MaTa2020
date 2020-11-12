package Trainingslager;

import Aufgaben.IO;
import Taschenrechner.MathTest;

public class GeometrischeReihe {

    public static void start(){
        System.out.println("Bitte geben sie N als Ganzzahl ein: ");
        int n = IO.readInteger();
        double ergebniss = 0;

        for(int i = 0; i <= n; i++){
            System.out.println("Index: " + i);
            System.out.println("Ergebniss: " + ergebniss);
            ergebniss = (1 / Math.pow(2, i)) + ergebniss;
        }

        System.err.println(ergebniss);
    }
}
