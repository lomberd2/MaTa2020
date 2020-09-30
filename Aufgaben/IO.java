package Aufgaben;

import Main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Fordert den Benutzer auf eine eingabe zu Tätigen, und gibt diese als Sring wieder.
     * @return String
     */
    public static String readString() {
        while (true) {
            try{
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gibt eine Ganz Zahl zurück die der Benutzer eingegeben hat.
     * @return integer (Ganzzahl)
     */
    public static int readInteger(){
        while(true){
            try{
                String input = reader.readLine();
                return Integer.parseInt(input);
            }catch (IOException e){
                System.out.println("Falsche eingabe! Bitte geben sie eine Ganzzahl ein!");
                if(Main.isDev)
                    e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.out.println("Falsche eingabe! Bitte geben sie eine Ganzzahl ein!");
                if(Main.isDev)
                    e.printStackTrace();
            }
        }

    }

    /**
     * Fordert den Nutzer auf eine Komma Zahl einzugeben und gibt diese zurück.
     * @return double (Kommazahl)
     */
    public static double readDouble(){
        while (true){
            try{
                return Double.parseDouble(reader.readLine().replace(",",".").trim());
            }catch (Exception e){
                System.out.println("Bitte geben Sie eine korrekte Kommazahl ein!");
                if(Main.isDev)
                    e.printStackTrace();
            }
        }
    }

    /**
     * Bittet den Nutzer eine eingabe von Ja oder Nein zu tätigen und gibt dieses als Boolean zurück.
     * @return boolean (von Eingabe Ja oder Nein)
     */
    public static boolean readBoolean(){
        while(true){
            try{
                String input = reader.readLine().toLowerCase();
                if(input.contains("ja") || input.contains("j")){
                    return true;
                }
                else if(input.contains("nein") || input.contains("n")){
                    return false;
                } else {
                    System.out.println("Die eingegebene Variable ist nicht Korrekt!");
                    System.out.println("Bitte verwende für Ja (ja oder j) für Nein (nein oder n)");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static char readChar(){
        while (true){
            try{
                String input = reader.readLine().toLowerCase();
                if(input.length() > 1 || input.length() < 1){
                    System.out.println("Bitte geben Sie nur max. einen Buchstaben ein!");
                }else{
                    return input.charAt(0);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
