package Zellwachstum;

import Aufgaben.IO;

public class Zellwachstum {

    static double[] tabelle = new double[5];

    public static void start(){
        System.out.println("Start Zellen Menge: ");
        int zellenMenge = IO.readInteger();

        System.out.println("Wachstumsfaktor");
        int wachstumsFaktor = IO.readInteger();

        System.out.println("Laufzeit");
        int laufzeit = IO.readInteger();

        double summe = 0;
        System.out.println("Tag \t Zellenmenge");

        for(int i = 0; i <= laufzeit; i++){
            summe = zellenMenge * Math.pow(wachstumsFaktor, i);
            System.out.println(i + " \t\t " + summe);
        }
    }
}
