package Matrizen;

public class IO {
    public static int[][] createInt2dArr(int length, int breite){
        int[][] newArr = new int[length][breite];

        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[i].length; j++){
                System.out.println("Bitte geben Sie den Ganzzahlen Wert für die länge " + i + " und die Breite "+ j + " ein : ");
                newArr[i][j] = Aufgaben.IO.readInteger();
            }
        }

        return newArr;
    }

    public static double[][] createDouble2dArr(int length, int breite){
        double[][] newArr = new double[length][breite];

        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[i].length; j++){
                System.out.println("Bitte geben Sie den Double Wert für die länge " + i + " und die Breite "+ j + " ein : ");
                newArr[i][j] = Aufgaben.IO.readDouble();
            }
        }

        return newArr;
    }

    public static String[][] createString2dArr(int length, int breite){
        String[][] newArr = new String[length][breite];

        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[i].length; j++){
                System.out.println("Bitte geben Sie den String Wert für die länge " + i + " und die Breite "+ j + " ein : ");
                newArr[i][j] = Aufgaben.IO.readString();
            }
        }

        return newArr;
    }

    public static void print2dArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println("[I:"+i+"] [J:"+j+"] = " + arr[i][j]);
            }
        }
    }

    public static void print2dArr(double[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println("[I:"+i+"] [J:"+j+"] = " + arr[i][j]);
            }
        }
    }

    public static void print2dArr(String[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println("[I:"+i+"] [J:"+j+"] = " + arr[i][j]);
            }
        }
    }
}
