package Trainingslager;

import Aufgaben.IO;

import java.io.BufferedReader;
import java.util.stream.Stream;

public class Bmi {

    public static void start(){
        System.out.println("Bitte geben Sie ihr geschlecht an (m/w): ");
        //char geschlecht = IO.readChar();
        String geschlecht = IO.readString();

        if(!geschlecht.equals("m") && !geschlecht.equals("w")){
            System.out.println("Eingabe Falsch Breche ab");
            return;
        }

        System.out.println("Bitte geben Sie ihr gewicht in KG an: ");
        double gewicht = IO.readDouble();

        System.out.println("Bitte geben Sie ihre Größe in CM an: ");
        double height = IO.readDouble();

        double bmi = gewicht / (height / 100 * height / 100);

        if(geschlecht.equals("m")){
            //Männlich
            if(bmi < 20){
                System.out.println("Untergewichtig");
            }else if(20 <= bmi && bmi < 25){
                System.out.println("Normalgewichtig");
            }else if (25 <= bmi && bmi < 30){
                System.out.println("Übergewichtig");
            } else if (30 <= bmi && bmi < 40) {
                System.out.println("Adipositas");
            }else if(40 >= bmi){
                System.out.println("Starke Adipositas");
            }else{
                System.err.println("Du bist ein Zug du Fetter Bulle");
            }
        }

        if(geschlecht.equals("w")){
            //Weiblich
            if(bmi < 19){
                System.out.println("Untergewichtig");
            }else if(19 <= bmi && bmi < 24){
                System.out.println("Normalgewichtig");
            }else if (24 <= bmi && bmi < 30){
                System.out.println("Übergewichtig");
            } else if (30 <= bmi && bmi < 40) {
                System.out.println("Adipositas");
            }else if(40 >= bmi){
                System.out.println("Starke Adipositas");
            }else{
                System.err.println("Du bist ein Zug du fette Kuh");
            }
        }
    }


}
