package ArrayAufgaben;
import Aufgaben.IO;

import java.util.Arrays;

public class Lotto {

    public static void init(){
        int[] lottoZahlen = new int[7];
        int[] lottoZahlen2 = new int[7];

        //Kugeln werden Zurückgelegt
        for(int i = 0; i < lottoZahlen.length; i++){
            int lottoZahl = getLottoNumber();
            lottoZahlen[i] = lottoZahl;
        }


        //Ausgabe der Zahlen
        lottoZahlenAusgeben(lottoZahlen);

        //Kugeln werden nicht zurückgelegt
        lottoZahlen2 = getLottoNumberArr(lottoZahlen2);

        //Ausgabe der Zahlen
        lottoZahlenAusgeben(lottoZahlen2);


        //Sort beide Arr
        sortIntArr(lottoZahlen);
        sortIntArr(lottoZahlen2);

        //Ausgabe der Zahlen
        System.out.println("===={ Sorted }====\n");

        lottoZahlenAusgeben(lottoZahlen);
        lottoZahlenAusgeben(lottoZahlen2);
    }

    private static void lottoZahlenAusgeben(int[] lottoZahlen){
        System.out.println("Die Lotto Zahlen Heute: \n");
        for(int i = 0; i < lottoZahlen.length; i++){
            //6 Zahlen
            if(i < lottoZahlen.length - 1){
                System.out.print(lottoZahlen[i] + " ");
            }
            //Zusatzzahl
            if(i == lottoZahlen.length - 1){
                System.out.println("\nZusatzzahl: " + lottoZahlen[i]);
            }
        }
        System.out.println("\n---------------------\n");
    }

    private static int getLottoNumber(){
        int number = (int)(Math.random() * 49);
        while(number < 1 || number > 49){
            number = (int)(Math.random() * 49);
        }
        return number;
    }

    private static int[] getLottoNumberArr(int[] lottoZahlen){
        int number = 0;
        boolean isChecking = true;
        boolean foundSameNumber = false;

        for(int i = 0; i < lottoZahlen.length; i++){
            int lottoZahl = getLottoNumber();
            lottoZahlen[i] = lottoZahl;
        }

        while(isChecking){
            for(int i = 0; i < lottoZahlen.length; i++){
                int currentNumber = lottoZahlen[i];
                for(int j = 0; j < lottoZahlen.length; j++){
                    if(i == j){

                    }else{
                        //Selbe Nummer entdeckt.
                        if(currentNumber == lottoZahlen[j]){
                            foundSameNumber = true;
                            lottoZahlen[i] = getLottoNumber();
                        }
                    }
                }

                //Letzte Ziffer & Keine Selbe nummer & Keine Selber nummer Gefunden
                if(i == 6 && lottoZahlen[i] != number && !foundSameNumber){
                    isChecking = false;
                }

                //Letzte Ziffer & Keine Selbe nummer
                if(i == 6 && lottoZahlen[i] != number){
                    foundSameNumber = false;
                }
            }
        }

        return lottoZahlen;
    }

    private static int[] sortIntArr(int[] arr){
        int[] sortedArr = new int[arr.length];
        boolean isSorted = false;
        boolean foundUnsorted = false;

        while (!isSorted){
            for(int i = 0; i < arr.length - 1; i++){
                if (i == 0) {
                    //Erster
                    foundUnsorted = false;
                }
                if (i == arr.length - 2) {
                    //Letzter
                    if (foundUnsorted) {
                        //Wenn noch eins Sortiert wurde nochmal durchgehen!
                    } else {
                        //Aus dem loop raus
                        isSorted = true;
                    }
                } else {
                    //Normal
                    if (arr[i] > arr[i + 1]) {
                        //Vorherige Größer als der andere
                        sortedArr[i] = arr[i + 1];
                        sortedArr[i + 1] = arr[i];

                        //Altes Array beschreiben
                        arr[i] = sortedArr[i];
                        arr[i + 1] = sortedArr[i + 1];

                        foundUnsorted = true;
                    }

                    //System.out.println("First Arr: " + arr[i] + " Sorted arr: " + sortedArr[i]);
                }

            }
        }


        return sortedArr;
    }
}
