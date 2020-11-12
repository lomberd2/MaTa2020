package Trainingslager;

import Aufgaben.IO;

public class Ostern {

    public static void start(){
        System.out.println("Bitte geben sie die Jahreszahl ein");
        int jahreszeit = IO.readInteger();

        int a = jahreszeit % 19;
        int b = jahreszeit % 4;
        int c = jahreszeit % 7;
        int m = 0;
        int n = 0;

        if(jahreszeit >= 1583 && jahreszeit <= 1699){
             m = 23;
             n = 2;
        }else if(jahreszeit >= 1700 && jahreszeit <= 1799){
            m = 23;
            n = 3;
        }else if(jahreszeit >= 1800 && jahreszeit <= 1899){
            m = 23;
            n = 4;
        }else if(jahreszeit >= 1900 && jahreszeit <= 2099){
            m = 24;
            n = 5;
        }else if(jahreszeit >= 2100 && jahreszeit <= 2199){
            m = 24;
            n = 6;
        }else{
            m = 25;
            n = 0;
        }

        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;

        int osternMarze = (22 + d + e);
        int osternApril = (d + e - 9);

        if(d == 28 && e == 6 && (11* m + 11) % 30 < 19 && osternApril == 25){
            //Ausnahme 2
            System.out.println("Ostern wird am 18. April gefeiert. Warum auch immer!");
        }else {

            if (osternMarze <= 31) {
                System.out.println("Ostern ist am " + osternMarze + ". März!");
            } else {
                if (osternApril == 26) {
                    //Ausnahme 1
                    System.out.println("Ostern ist am 19. April!");
                } else {
                    System.out.println("Ostern ist am " + osternApril + ". April!");
                }
            }
        }
    }
}
