package ArrayAufgaben;
import Aufgaben.IO;

public class Aufgaben {

    public static void SuchenInArray(double[] arr, double search){
        for(double i: arr){
            if(i == search){
                System.out.println("Treffer");
            }else{
                System.out.println("Niete");
            }
        }
    }

    public static void Verdoppeln(){
        System.out.println("Start Länge des Array's");
        int arrLenght = IO.readInteger();

        double[] arr = IO.createDoubleArray(arrLenght);
    }

    public static double[] Verdoppeln(double[]arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * 2;
        }
        return arr;
    }

    public static void Summen(){
        System.out.println("Bitte geben Sie die Menge der zu zählenden Zahlen ein.");
        int lenght = IO.readInteger();

        int[] intArr = IO.createIntArray(lenght);

        int anzahlGerade = 0;
        int summeGerade = 0;
        int anzahlUngerade = 0;
        int summeUngerade = 0;

        for(int integ: intArr){
            if(integ % 2 != 0){
                //ungerade
                summeUngerade += integ;
                anzahlUngerade++;
            }else{
                //Gerade
                summeGerade += integ;
                anzahlGerade++;
            }
        }

        System.out.println("Gerade Zahlen:");
        System.out.println("Anzahl = " + anzahlGerade);
        System.out.println("Summe = " + summeGerade);

        System.out.println("Ungerade Zahlen:");
        System.out.println("Anzahl = " + anzahlUngerade);
        System.out.println("Summe = " + summeUngerade);
    }

    public static void Maxima(){
        System.out.println("Wie Viele Zahlen?");
        int anzahl = IO.readInteger();


        double[] doubleArr = IO.createDoubleArray(anzahl);

        Maxima(doubleArr);
    }

    public static void Maxima(double[] doubleArr){
        double max1value = doubleArr[0];
        int max1index = 0;

        double max2value = doubleArr[0];
        int max2index = 0;

        for(int i = 1; i < doubleArr.length; i++){
            if(max1value <= doubleArr[i] && max1index != i){
                max1value = doubleArr[i];
                max1index = i;
            }
        }

        for(int i = 1; i < doubleArr.length; i++){
            if(max2value <= doubleArr[i] && max1index != i){
                max2value = doubleArr[i];
                max2index = i;
            }
        }

        System.out.println("Maxima 1 = " + max1value);
        System.out.println("Maxima 2 = " + max2value);
    }

    public static void Balkendiagramm(){
        System.out.println("Bitte geben Sie die Anzahl der Kandidaten an:");
        int anz = IO.readInteger();
        double[] kanArr = IO.createDoubleArray(anz);

        double summeArr = 0;
        for(double i: kanArr){
            summeArr += i;
        }

        if(summeArr != 100){
            System.out.println("Error die Summe aller eingebenen Prozentsätze ergibt nicht 100%");
        }

        //Sort Arr
        /*double[] sortArr = new double[kanArr.length];
        for(int i = 0; i < kanArr.length; i++){
            if(i == 0){
                sortArr[i] = kanArr[i];
            }else{
                if(kanArr[i - 1] <)

            }
        }*/

        for(int i = 0; i < kanArr.length; i++){
            System.out.print("Kandidat " + i + " : ");
            System.out.print(kanArr[i] + " %  \t");
            for(int s = 0; s < kanArr[i]; s++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void TonsignalGlätten(){
        int[] tonsignalInput = {1,5,4,5,7,6,8,6,5,4,5,4};
        double[] tonsignalConverter = IO.ConvertIntArrayToDouble(tonsignalInput);
        int[] tonsignalOutput;

        //System.out.println("Bitte geben sie den Input ein");
        //tonsignalInput = IO.createIntArray(10);
        boolean startBerechnet = false;
        boolean checkSkipOthers = false;

        for(int i = 0; i < tonsignalConverter.length; i++){
            // I = 0,1
            if(i == 0 || i == 1 && !startBerechnet){
                double mittelWertStart = (tonsignalConverter[0] + tonsignalConverter[1]) / 2;
                tonsignalConverter[0] = mittelWertStart;
                tonsignalConverter[1] = mittelWertStart;
                startBerechnet = true;
                checkSkipOthers = true;
            }

            //Mitte
            if(!checkSkipOthers && i < tonsignalConverter.length - 3){
                System.out.println("Mitte");
                tonsignalConverter[i] = (double)(tonsignalInput[i - 1] + tonsignalInput[i] + tonsignalInput[i + 1]) / 3;
            }

            //ende
            if(i > tonsignalConverter.length - 3){
                System.out.println("Letzen Zahlen: " + tonsignalConverter[i] + i);
                tonsignalConverter[i] = (double)(tonsignalInput[tonsignalInput.length - 2] + tonsignalInput[tonsignalInput.length - 1]) / 2;
            }

            checkSkipOthers = false;
        }

        tonsignalOutput = IO.ConvertDoubleArrayToInt(tonsignalConverter);

        System.out.println("output");
        for(int i: tonsignalOutput){
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void BinaerAddition(){
        //Testing
        //int binLength = 4;
        //int[] bin1 = {0,0,1,1};
        //int[] bin2 = {0,1,1,0};

        System.out.println("Wie viele Stellen haben die Binärzahlen maximal?");
        int binLength = IO.readInteger();

        System.out.println("Gib die erste Zahl ziffernweise von links ein");
        int[] bin1 = createBinArr(binLength);

        System.out.println("Gib die Zweite Zahl ziffernweise von links ein");
        int[] bin2 = createBinArr(binLength);
        
        int[] addArr = new int[bin1.length];
        boolean uebertrag = false;

        //Rechnung
        for(int i = bin1.length - 1; i >= 0; i--){
            //Übertragsrechnung
            if(uebertrag){
                uebertrag = false;
                if(bin1[i] == 0){
                    bin1[i] = 1;
                }
                else if(bin2[i] == 0){
                    bin2[i] = 1;
                }
                else{
                    uebertrag = true;
                }
            }

            //Rechnung Normal
            if(bin1[i] == 0 && bin2[i] == 0){
                addArr[i] = 0;
            }
            if(bin1[i] == 1 && bin2[i] == 0 || bin1[i] == 0 && bin2[i] == 1){
                addArr[i] = 1;
            }
            if(bin1[i] == 1 && bin2[i] == 1){
                addArr[i] = 0;
                uebertrag = true;
            }
        }

        //Ergebnisse Ausgeben
        System.out.print("Ergebnis: ");
        for(int i: addArr){
            System.out.print(i);
        }
    }

    private static int[] createBinArr(int arrLength){
        arrLength++;
        int[] binArr = new int[arrLength];

        for (int i = arrLength - 1; i >= 0; i--) {
            if (i == 0) {
                binArr[i] = 0;
            } else {
                binArr[i] = IO.readInteger01();
            }
        }

        return binArr;
    }
}
