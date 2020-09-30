package Trainingslager;

import Main.Main;

import java.util.ArrayList;
import java.util.List;

public class Bestellung {

    public static void init(int anzahlSchrauben, int anzahlMuttern, int anzahlUnterlegscheiben){
        //<editor-fold desc="Definierungen und Instanzierungen">
        List<Schraube> schrauben = new ArrayList<Schraube>();
        List<Mutter> muttern = new ArrayList<Mutter>();
        List<Unterlegscheibe> unterlegscheiben = new ArrayList<Unterlegscheibe>();
        double endsumme = 0;
        //</editor-fold>

        //<editor-fold desc="Array's add Data">

        //Fill Schrauben Array
        for (int i = 0; i < anzahlSchrauben; i++) {
            schrauben.add(new Schraube());
            if(Main.isDev)
                System.out.println("for1: " + i);
        }

        //Fill Muttern Array
        for (int i = 0; i < anzahlMuttern; i++) {
            muttern.add(new Mutter());
            if(Main.isDev)
                System.out.println("for2: " + i);
        }

        //Fill Unterlegscheiben Array
        for (int i = 0; i < anzahlUnterlegscheiben; i++) {
            unterlegscheiben.add(new Unterlegscheibe());
            if(Main.isDev)
                System.out.println("for3: " + i);
        }

        //</editor-fold>

        //<editor-fold desc="Zusammen rechnen der Preise">

        //Zusammenrechnung der Schrauben
        for (Schraube schraube: schrauben) {
            endsumme = doubleRunden(endsumme + schraube.preis);
            if(Main.isDev)
                System.out.println("Plus : " + schraube.preis + " Endsumme Danach: " + endsumme);
        }

        //Zusammenrechnung der Muttern
        for (Mutter mutter: muttern ){
            endsumme = doubleRunden(endsumme + mutter.preis);
            if(Main.isDev)
                System.out.println("Plus : " + mutter.preis + " Endsumme Danach: " + endsumme);
        }

        //Zusammenrechnung der Unterlegscheiben
        for (Unterlegscheibe unterlegscheibe: unterlegscheiben){
            endsumme = doubleRunden(endsumme + unterlegscheibe.preis);
            if(Main.isDev)
                System.out.println("Plus : " + unterlegscheibe.preis + " Endsumme Danach: " + endsumme);
        }

        //</editor-fold>

        //<editor-fold desc="Validierung der Bestellung">
        //Validierung der Anzahl der Schrauben und Muttern
        if(!checkSchrauben(anzahlMuttern, anzahlSchrauben)) {
            System.out.println("Die Anzahl der Schrauben und Muttern in der Bestellung sind nicht Identisch");
        }
        //</editor-fold>

        //Preisausgabe
        System.out.println("Der zu Zahlende Betrag lautet: " + endsumme + "€");
    }

    private static boolean checkSchrauben(int anzahlMuttern, int anzahlSchrauben){
        if(anzahlMuttern == anzahlSchrauben){
            return true;
        }
        return false;
    }

    private static double doubleRunden(double input){
         return Math.round(input * 100.0) / 100.0;
    }
}

class Schraube {
    public double preis = 0.05;
}

class Mutter {
    public double preis = 0.03;
}

class Unterlegscheibe {
    public double preis = 0.01;
}
