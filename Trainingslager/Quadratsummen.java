package Trainingslager;

import Aufgaben.IO;

public class Quadratsummen {

    public static void start(){
        System.out.println("Bitte geben sie ihr Ende an: ");
        int endeIndex = IO.readInteger();
        double summe = 0;

        for(int i = 0;  i <= endeIndex; i++){
            summe += i * i;
            //System.out.println(i + "*" + i + " = " + );
        }
        System.out.println("Das Ergebniss lautet" + summe);
    }
}
