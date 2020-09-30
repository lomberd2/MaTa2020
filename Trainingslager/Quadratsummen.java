package Trainingslager;

import Aufgaben.IO;

public class Quadratsummen {

    public static void start(){
        System.out.println("Bitte geben sie ihr Ende an: ");
        int endeIndex = IO.readInteger();
        int ergebniss = 1;

        for(int i = 0;  i <= endeIndex; i++){
            System.out.println(i + "*" + i + " = " + i * i);
        }
    }
}
