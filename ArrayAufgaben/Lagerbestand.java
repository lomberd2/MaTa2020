package ArrayAufgaben;
import Aufgaben.IO;

import java.text.DecimalFormat;

public class Lagerbestand {

    public static void init(){
        System.out.println("Bitte geben Sie die Menge der Artikel ein die Sie erfassen möchten:");
        int artMenge = IO.readInteger();

        Artikel[] artikel = new Artikel[artMenge];

        for(int i = 0; i < artMenge; i++){
            Artikel art = new Artikel();

            System.out.println("Bitte geben Sie die Artikelnummer von dem " + getNumberInWord(i) + " Artikel ein:");
            //artikel[i].artikelID = IO.readInteger();
            art.artikelID = IO.readInteger();

            System.out.println("Bitte geben sie nun die Artikelbeschreibung an: ");
            art.beschreibung = IO.readString();

            System.out.println("Bitte geben sie nun den Preis des Artikels in Euro an. [xx.xx] : ");
            art.preis = IO.readDouble();

            System.out.println("Bitte geben Sie nun die vorhandene Menge des Artikels ein: ");
            art.menge = IO.readInteger();

            artikel[i] = art;
        }


        /*while(true){
            System.out.println("-------==={ MENÜ }===-------");
            System.out.println("Artikel Zählen: 1");
            System.out.println("Gesam");
        }*/

        int gesamtArtMenge = 0;
        double gesamtArtPreis = 0;
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("###.###,001");

        for(Artikel art: artikel){
            gesamtArtMenge += art.menge;
            gesamtArtPreis += art.preis * art.menge;
        }

        System.out.println("Ergebnis:");
        System.out.println("Sie haben insgesamt " + gesamtArtMenge + " Artikel im Lager. Der gesamte Warenwert beträgt " + df.format(gesamtArtPreis) + " €");
    }

    private static String getNumberInWord(int i){
        switch (i){
            case 0: return "Ersten";
            case 1: return "Zweiten";
            case 2: return "Dritten";
            case 3: return "Vierten";
            case 5: return "Fünften";
            default: return String.valueOf(i);
        }
    }
}

class Artikel{
    int artikelID;
    String beschreibung;
    double preis;
    int menge;
}