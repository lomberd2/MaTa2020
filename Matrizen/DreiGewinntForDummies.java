package Matrizen;

import java.util.Arrays;

public class DreiGewinntForDummies {
    private static String[][] spielfeldArr;
    private static int currentPlayer;


    public static void start(){
        System.out.println("Bitte geben sie die Breite des Spielfeldes an:");
        int breite = Aufgaben.IO.readInteger();

        spielfeldArr = createSpielfeld(breite);

        printSpielfeld();
    }

    private static void switchPlayer(){
        if(currentPlayer == 0){
            currentPlayer = 1;
        }else{
            currentPlayer = 0;
        }
    }

    private static String[][] createSpielfeld(int breite){
        String[][] spielfeld = new String[breite][breite];
        for(int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = "0";
            }
        }
        return spielfeld;
    }

    private static void printSpielfeld(){
        for(int i = 0; i < spielfeldArr.length; i++){
            for(int j = 0; j < spielfeldArr[i].length; j++){
                System.out.print(spielfeldArr[i][j]);
            }
            System.out.println("");
        }
    }

    private static String getSpieler(int id){
        switch (id){
            case 0 -> {
                return "X";
            }
            case 1 -> {
                return "O";
            }
            default -> {
                return "Error";
            }
        }
    }
}
