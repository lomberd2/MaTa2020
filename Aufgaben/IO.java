package Aufgaben;

import Main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Fordert den Benutzer auf eine Eingabe zu tätigen, und gibt diese als String wieder.
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
            catch (Exception e){
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
                if(input.length() != 1){
                    System.out.println("Bitte geben Sie nur max. einen Buchstaben ein!");
                }else{
                    return input.charAt(0);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates an Integer Array in the desired length.
     * @param arrLength Length of the Array
     * @return int[]
     */
    public static int[] createIntArray(int arrLength){
        while(true){
            try{
                int[] intArr = new int[arrLength];
                for(int i = 0; i < intArr.length; i++){
                    System.out.println("Bitte geben Sie die " + i + " Ganzzahl im Array jetzt ein: ");
                    intArr[i] = readInteger();
                }
                return intArr;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates an Double Array in the desired length.
     * @param arrLength Length of the Array
     * @return double[]
     */
    public static double[] createDoubleArray(int arrLength){
        while(true){
            try{
                double[] doubleArr = new double[arrLength];
                for(int i = 0; i < doubleArr.length; i++){
                    System.out.println("Bitte geben Sie die " + i + " Double Zahl im Array jetzt ein: ");
                    doubleArr[i] = readDouble();
                }
                return doubleArr;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates an String Array in the desired length.
     * @param arrLength Length of the Array
     * @return String[]
     */
    public static String[] createStringArr(int arrLength){
        while(true){
            try{
                String[] stringArr = new String[arrLength];
                for(int i = 0; i < stringArr.length; i++){
                    System.out.println("Bitte geben Sie den " + i + "'ten String im Array jetzt ein: ");
                    stringArr[i] = readString();
                }
                return stringArr;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static double[] ConvertIntArrayToDouble(int[] arr){
        double[] retVal = new double[arr.length];
        for(int i = 0; i < arr.length; i++){
            retVal[i] = (double)arr[i];
        }
        return retVal;
    }

    public static int[] ConvertDoubleArrayToInt(double[] arr){
        int[] retVal = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            retVal[i] = (int)arr[i];
        }
        return retVal;
    }

    public static int readInteger01(){
        while(true){
            try{
                String input = reader.readLine();
                int in = Integer.parseInt(input);
                if(in == 0 || in == 1){
                    return in;
                }else{
                    System.out.println("Falsche eingabe! Bitte geben sie entweder 1 oder 0 ein!");
                }
            }
            catch (Exception e){
                System.out.println("Falsche eingabe! Bitte geben sie entweder 1 oder 0 ein!");
                if(Main.isDev)
                    e.printStackTrace();
            }
        }
    }


}
