package Trainingslager;

import Aufgaben.IO;

public class Pi {

    public static void start(){
        System.out.println("Bis zu welcher Stelle möchten Sie?");
        int n = IO.readInteger();
        double i1 = 0;
        double i2 = 0;

        double summe = 0;

        for(int i = 0; i < n; i++){
             i1 = Math.pow(-1, i);
             i2 = 2 * i + 1;

            //System.out.println("i1: " + i1 + " i2: " + i2 + " Summe = " + i1/i2);
            System.out.println(summe);
            summe += i1 / i2;
            //summe += Math.pow(-1, i) / 2 * i + 1;
        }
        System.err.println(summe * 4);
        //System.err.println(summe / 4);
        //System.err.println(summe);
    }
}
