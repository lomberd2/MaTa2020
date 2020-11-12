package Aufgaben;

import GUI.TestGUI;

public class RechnungsAufgabe {
    public static void rechnungsAufgabe(TestGUI win){
        final int Zahl1 = 127;
        final int Zahl2 = 3;
        int Ergebniss = Zahl1 + Zahl2;

        win.displayOutput("Ergebniss =" + Ergebniss);
    }
}
