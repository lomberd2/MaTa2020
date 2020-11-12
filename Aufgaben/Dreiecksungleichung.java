package Aufgaben;

import Main.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dreiecksungleichung {
    public static void init(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //Seite1
            System.out.println("Bitte gib deine Erste Seite ein.");
            String note = reader.readLine().toLowerCase().trim().replace(',', '.');
            double s1 = Double.parseDouble(note);

            //Seite2
            System.out.println("Bitte gib deine Zweite Seite ein.");
            String seite2 = reader.readLine().toLowerCase().trim().replace(',', '.');
            double s2 = Double.parseDouble(seite2);

            //Seite3
            System.out.println("Bitte gib deine Dritte Seite ein.");
            String seite3 = reader.readLine().toLowerCase().trim().replace(',', '.');
            double s3 = Double.parseDouble(seite3);

            boolean isValid = checkIsValid(s1, s2, s3);

            if(Main.isDev){
                System.out.println("Seiten Variablen. s1 = " + s1 + " s2 = " + s2 + " s3 = " +s3);
                System.out.println("is Valid = " + isValid);
            }

            if(isValid){
                System.out.println("Dreieck ist Korrekt!");
                double umfang = umfang(s1, s2, s3);
                double inhalt = flacheninhalt(s1, s2, s3, umfang);
                System.out.println("Umfang = " + umfang);
                System.out.println("Flächeninhalt = " + inhalt);
            }else{
                System.out.println("Dreieck ist nicht Möglich zu erstellen!");
            }

            System.out.println("Programm ENDE!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean checkIsValid(double s1, double s2, double s3){
        double summe1 = s1 + s2;
        double summe2 = s1 + s3;
        double summe3 = s2 + s3;

        if(summe1 < s3 || summe1 == s3){
            return false;
        }
        if(summe2 < s2 || summe2 == s2){
            return false;
        }
        if(summe3 < s1 || summe3 == s1){
            return false;
        }

        return true;
    }

    public static double umfang(double s1, double s2, double s3){
        return s1 + s2 + s3;
    }

    public static double flacheninhalt(double s1, double s2, double s3, double umfang){
        double s = umfang / 2;
        double value = s*(s-s1)*(s-s2)*(s-s3);
        return Math.sqrt(value);
    }

}
