package ArrayAufgaben;
import Aufgaben.IO;

public class Bubblesort {

    public static void init(){
        System.out.println("Bitte geben sie die Menge der zu sortierenden Zahlen ein");
        int anzahl = IO.readInteger();

        double[] test = new double[anzahl];

        for(int i = 0; i < anzahl; i++){
            test[i] = Math.random() * 165762;
        }

        /*double[] doubleArr = IO.createDoubleArray(anzahl);

        double[] test = { 12.5, 123.12, 2.42, 14.122, 51912.12, 1231.5123 , 121.123 ,12311.124,634.43,2372.231,271.123,5136.13};

        double[] sortedArr = sortDoubleArr(test);

        */
        double[] sortedArr = sortDoubleArr(test);

        for(Double d: sortedArr){
            System.out.print(d + "; ");
        }
        System.out.println("");
    }

    private static double[] sortDoubleArr(double[] arr){
        double[] sortedArr = new double[arr.length];
        boolean isSorted = false;
        boolean foundUnsorted = false;

        while (!isSorted){
            for(int i = 0; i < arr.length; i++){
                if(i == 0){
                    //Erster
                    foundUnsorted = false;
                }
                if (i == arr.length - 1){
                    //Letzter
                    if(foundUnsorted){
                        //Wenn noch eins Sortiert wurde nochmal durchgehen!
                    }else{
                        //Aus dem loop raus
                        isSorted = true;
                    }
                } else {
                    //Normal
                    if(arr[i] > arr[i + 1]){
                        //Vorherige Größer als der andere
                        sortedArr[i] = arr[i + 1];
                        sortedArr[i + 1] = arr[i];

                        //Altes Array beschreiben
                        arr[i] = sortedArr[i];
                        arr[i + 1] = sortedArr[i + 1];

                        foundUnsorted = true;
                    }

                    System.out.println("First Arr: " + arr[i] + " Sorted arr: " + sortedArr[i]);
                }


            }
        }


        return sortedArr;
    }
}
