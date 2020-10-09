package Trainingslager;

import Aufgaben.IO;

public class ExtraMax {

    public static void start(){
        int punkte = 0;
        while(true) {
            int wurfel1 = getRandomNumber(1, 6);
            int wurfel2 = getRandomNumber(1, 6);

            System.out.println("Würfel1: " + wurfel1 + " Würfel2: " + wurfel2);

            boolean isMaxchen = (wurfel1 == 1 && wurfel2 == 2) || (wurfel1 == 2 && wurfel2 == 1);
            boolean isPasch = wurfel1 == wurfel2;
            if (isMaxchen) {
                punkte += 1000;
                System.out.println("Du hast ein Mäxchen! 1000 Punkte für dich!");
            } else if (isPasch) {
                punkte += wurfel1 * 100;
                System.out.println("Pasch! Du hast " + wurfel1 * 100 + " Punkte erhalten!");
            } else {
                int points = Math.max(wurfel1, wurfel2) * 10 + Math.min(wurfel1, wurfel2);
                punkte += points;
                System.out.println("Normaler Wurf! Du hast " + points + " Punkte erhalten!");
            }

            System.out.println("Möchtest du nochmal Würfeln? (j/n)");
            if(!IO.readBoolean()){
                System.out.println("Du hast insgesammt " + punkte + " Punkte erhalten!");
                return;
            }
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
