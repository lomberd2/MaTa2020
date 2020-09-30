package Trainingslager;

import Aufgaben.IO;

public class Alterspruefung {

    public static void init(){
        boolean isVolljahrig = altersCheck();

    }

    private static boolean altersCheck(){
        while(true) {
            System.out.println("Bitte gib dein Alter ein");
            int alter = IO.readInteger();
            if (alter < 0) {
                System.out.println("Du kannst nich Jünger als Ungeboren sein ;)");
            }else if (alter < 18) {
                System.out.println("Du bist leider Minderjährig.");
                return false;
            } else if (18 <= alter) {
                System.out.println("Du bist Volljährig");
                return true;
            }
        }
    }
}
