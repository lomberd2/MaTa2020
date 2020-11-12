package Trainingslager;

import Aufgaben.IO;

public class Fuehrerschein {

    public static void start(){
        System.out.println("Bitte gib dein Alter ein: ");
        int alter = IO.readInteger();

        boolean canDriveBobyCar = alter < 14;
        boolean fuenferFahren = 14 <= alter && alter < 16;
        boolean motoradFuerer = 16 <= alter && alter < 18;
        boolean autoFahren = 18 <= alter;

        if(canDriveBobyCar)
            System.out.println("Du darfst Bobby-Car oder Fahrrad fahren.");

        if(fuenferFahren)
            System.out.println("Du darfst schon 50er fahren.");

        if(motoradFuerer)
            System.out.println("Du darfst schon 125er fahren, aber noch kein Auto.");

        if(autoFahren)
            System.out.println("Du darfst jetzt auch Auto fahren.");
    }
}
