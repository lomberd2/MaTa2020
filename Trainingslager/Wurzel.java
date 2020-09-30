package Trainingslager;

import Aufgaben.IO;

public class Wurzel {

    public static void start(){
        System.out.println("Bitte geben sie die Anfangszahl ein: ");
        int anfangsIndex = IO.readInteger();

        System.out.println("Bitte geben sie die Endeziffer ein: ");
        int endIndex = IO.readInteger();

        while (anfangsIndex <= endIndex){
            System.out.println("Zahl: " + anfangsIndex + " Wurzel: " + Math.sqrt(anfangsIndex));
            anfangsIndex++;
        }
    }
}
