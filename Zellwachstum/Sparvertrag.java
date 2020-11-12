package Zellwachstum;

import Aufgaben.IO;

import java.text.DecimalFormat;

public class Sparvertrag {

    public static void start(){
        DecimalFormat df = new DecimalFormat("####0.00");

        System.out.println("Kapital eingeben:");
        double kapital = IO.readDouble();

        System.out.println("Zinssatz eingeben:");
        double zinssatz = IO.readDouble();

        System.out.println("Laufzeit in Jahre eingeben:");
        int laufzeit = IO.readInteger();

        System.out.println("Jahr \t Anfangskapital \t Zinsbetrag \t Jahresendbetrag");

        double endbetrag = kapital;
        double zinsbetrag;

        for (int i = 1; i <= laufzeit; i++) {
            zinsbetrag = kapital * zinssatz / 100;
            endbetrag += zinsbetrag;

            System.out.println(i + " \t\t " + df.format(kapital) + " \t\t\t " + df.format(zinsbetrag) + " \t\t\t " + df.format(endbetrag));
            kapital += zinsbetrag;
        }
    }
}
