package Statistik;

import Aufgaben.IO;

import java.text.DecimalFormat;

public class Temperatur {
    private static boolean isTesting = true;

    public static void start(){
        double[] wocheTemp = new double[7];
        double wochenMittelwert = 0;

        //Abfrage der Temp.
        if(isTesting){
            wocheTemp[0] = 23.3;
            wocheTemp[1] = 25.2;
            wocheTemp[2] = 24.9;
            wocheTemp[3] = 25.4;
            wocheTemp[4] = 24.7;
            wocheTemp[5] = 24.9;
            wocheTemp[6] = 25.1;
        }else {
            for (int i = 0; i < wocheTemp.length; i++) {
                System.out.print("Bitte geben sie die Temp für " + getTag(i) + " ein: ");
                wocheTemp[i] = IO.readDouble();
            }
        }

        //Mittelwert Berechnen
        for (double v : wocheTemp) {
            wochenMittelwert += v;
        }
        wochenMittelwert  = wochenMittelwert / wocheTemp.length;

        //Max
        double maxHolder = wocheTemp[0];
        String hoechstwertTag = "ERROR";
        for(int i = 0; i < wocheTemp.length; i++){
            if(i != wocheTemp.length - 1) {
                maxHolder = Math.max(maxHolder, wocheTemp[i + 1]);
            }
        }

        DecimalFormat df = new DecimalFormat("####0.00");

        double[] minTemp = getMinTemp(wocheTemp);
        double spanne = getSpannweite(minTemp[0], maxHolder);
        double[] wochenSchwankung = getSchwankung(wocheTemp);

        //Alle Tage ausgeben (Test)
        for (int i = 0; i < wocheTemp.length; i++) {
            System.out.println( "Die Temp. am " + getTag(i) + " betrug " + wocheTemp[i] + " Grad Celsius");
            if(maxHolder == wocheTemp[i]){
                hoechstwertTag = getTag(i);
            }
        }


        System.out.println("Der Mittelwert dieser Woche betrug: " + df.format(wochenMittelwert));
        System.out.println("Der Wochen höchstwert war am "+ hoechstwertTag +" und Betrug " + df.format(maxHolder) + " Grad Celsius");
        System.out.println("Die Niedrigste Temp. war am "+ getTag((int)minTemp[1])  +" und Betrug " + df.format(minTemp[0]) + " Grad Celsius");
        System.out.println("Die Spanne Betrug: " + df.format( spanne) + " Grad Celsius");
        System.out.println("Die höchste Schwankung war zwischen " + getTag((int) wochenSchwankung[1]) + " und " + getTag((int) wochenSchwankung[2]) + ". Sie Betrug " + df.format( wochenSchwankung[0]) + " Grad Celsius Unterschied.");
    }

    private static String getTag(int i){
        return switch (i) {
            case 0 -> "Montag";
            case 1 -> "Dienstag";
            case 2 -> "Mittwoch";
            case 3 -> "Donnerstag";
            case 4 -> "Freitag";
            case 5 -> "Samstag";
            case 6 -> "Sonntag";
            default -> "ERROR";
        };
    }

    private static double[] getMinTemp(double[] wocheTemp){
        double minTemp[] = new double[2];
        minTemp[0] = wocheTemp[0];

        for(int i = 1; i < wocheTemp.length; i++){
            //minTemp = Math.min(minTemp, wocheTemp[i]);
            if(minTemp[0] > wocheTemp[i]){
                minTemp[0] = wocheTemp[i];
                minTemp[1] = i;
            }
        }

        return minTemp;
    }

    private static double getSpannweite(double min, double max){
        return max - min;
    }

    private static double[] getSchwankung(double[] wocheTemp){
        double maxSchwankung[] = new double[3];
        double tempSchwank;

        maxSchwankung[0] = Math.max(wocheTemp[0], wocheTemp[1]) - Math.min(wocheTemp[0], wocheTemp[1]);
        maxSchwankung[1] = 0;
        maxSchwankung[2] = 1;

        for(int i = 0; i < wocheTemp.length - 1; i++){
            double absTag = Math.abs(wocheTemp[i]);
            double absNextTag = Math.abs(wocheTemp[i + 1]);
            tempSchwank = Math.max(absTag, absNextTag) - Math.min(absTag, absNextTag);

            if(maxSchwankung[0] < tempSchwank){
                maxSchwankung[0] =  Math.max(wocheTemp[i], wocheTemp[i + 1]) - Math.min(wocheTemp[i], wocheTemp[i + 1]);
                maxSchwankung[1] = i;
                maxSchwankung[2] = i+1;
            }
        }
        return maxSchwankung;
    }
}
