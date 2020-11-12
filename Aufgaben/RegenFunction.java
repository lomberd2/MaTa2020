package Aufgaben;

import GUI.TestGUI;

public class RegenFunction {

    public static void RegenFunction(TestGUI win){
        Regen regen = new Regen();

        regen.april = 13.4;
        regen.juni = 8.3;
        regen.mai = 14.6;


        regen.durchschnitt = (regen.april + regen.mai + regen.juni) / regen.MonthAnzahl;

        win.displayOutput("Regendurchschnitt = " + regen.durchschnitt);
    }
}

class Regen{
    public double april;
    public double mai;
    public double juni;

    public final int MonthAnzahl = 3;
    public double durchschnitt;
}
