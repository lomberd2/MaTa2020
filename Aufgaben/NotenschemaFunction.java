package Aufgaben;

import GUI.TestGUI;
import Main.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NotenschemaFunction {

    public static void init() {
        boolean isRunning = true;
        boolean isStarted = false;

        if(!isStarted){
            System.out.println("====={°Noten Kalkulator°}=====");
            System.out.println("====={°Eingabe Beispiel:  25.00 || steht für 25,00%°}=====");
            System.out.println("====={°Zum Beenden \"exit\" schreiben°}=====");
            isStarted = true;
        }

        //Mit Console
        while (isRunning) {
            try {
                System.out.println("Bitte gib deine Noten Prozentzahl An:");

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String note = reader.readLine().toLowerCase();

                if(note.equals("exit")){
                    //On Exit Command
                    System.out.println("Beendet");
                    isRunning = false;
                    System.exit(1);
                } else {
                    NotenschemaFunction.berechnen(Double.parseDouble(note.trim().replace(",",".")));
                }
            }
            catch (Exception e){
                System.out.println("Nur Zahlen werden Akzeptiert. Zum Beenden \"exit\" eingeben.");

                if(Main.isDev){
                    System.out.println(e);
                }
            }
        }

        //Mit GUI
        //NotenschemaFunction.Start(win, 59.00);
    }

    public static void berechnen(TestGUI win , double ergebnis){

        final int note1minprozent = 85;
        final int note2minprozent = 73;
        final int note3minprozent = 59;
        final int note4minprozent = 45;
        final int note5minprozent = 27;

        if(ergebnis >= note1minprozent){
            win.displayOutput("Note 1 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note2minprozent){
            win.displayOutput("Note 2 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note3minprozent){
            win.displayOutput("Note 3 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note4minprozent){
            win.displayOutput("Note 4 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note5minprozent){
            win.displayOutput("Note 5 mit " + ergebnis + "% von 100%");
        }else{
            win.displayOutput("Note 6 mit " + ergebnis + "% von 100%");
        }
    }

    public static void berechnen(double ergebnis){

        final int note1minprozent = 85;
        final int note2minprozent = 73;
        final int note3minprozent = 59;
        final int note4minprozent = 45;
        final int note5minprozent = 27;

        if(ergebnis >= note1minprozent){
            System.out.println("Note 1 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note2minprozent){
            System.out.println("Note 2 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note3minprozent){
            System.out.println("Note 3 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note4minprozent){
            System.out.println("Note 4 mit " + ergebnis + "% von 100%");
        }else if(ergebnis >= note5minprozent){
            System.out.println("Note 5 mit " + ergebnis + "% von 100%");
        }else{
            System.out.println("Note 6 mit " + ergebnis + "% von 100%");
        }
    }
}
