package Taschenrechner;

import Main.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Taschenrechner {
    public static boolean isTaschenrechnerRunning;

    public void initTaschenrechner(){
        stringOut("°*~Taschenrechner~*°");
        stringOut("");
        stringOut("Um den Taschenrechner zu Beenden \"exit\" schreiben!");
        stringOut("╔══════Funktionen══════╗");
        stringOut("╠══ [+] Plus Rechnen ══╣");
        stringOut("╠══ [-] Minus Rechnen ═╣");
        stringOut("╠══ [*] Addieren ══════╣");
        stringOut("╠══ [/] Dividieren ════╣");
        stringOut("╠══ [W] Wurzel ════════╣");
        stringOut("╠══ [P] Potenz ════════╣");
        stringOut("╚══════════════════════╝");

        isTaschenrechnerRunning = true;
        mainTaschenrechner();
    }

    public void mainTaschenrechner(){
        while (isTaschenrechnerRunning){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                stringOut("Bitte gib deine Rechnung ein.");
                String input = reader.readLine().replace("," , ".").toLowerCase();

                taschenrechnerFunktion(input);

            }
            catch (Exception e){
                e.printStackTrace();
                //System.err.println(e);
            }
        }
    }

    private void taschenrechnerFunktion(String input){
        double nummer1;
        double nummer2;

        if(input.contains("-")){
            //Minus
            String[] split = input.split("-");
            if(Main.isDev)
                stringOut(split);

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            outputErgebniss(input, minus(nummer1, nummer2));
        }else if(input.contains("+")){
            //Plus
            String[] split = input.split("\\+");
            if(Main.isDev)
                stringOut(split);

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            outputErgebniss(input, plus(nummer1, nummer2));
        }else if(input.contains("/")){
            //Geteilt
            String[] split = input.split("/");
            if(Main.isDev)
                stringOut(split);

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            outputErgebniss(input, divide(nummer1, nummer2));
        }else if(input.contains("*")){
            //Mal
            String[] split = input.split("\\*");
            if(Main.isDev)
                stringOut(split);

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            outputErgebniss(input, multi(nummer1, nummer2));
        }else if(input.equals("exit")){
            stringOut("Beende Taschenrechner");
            isTaschenrechnerRunning = false;
        }else if(input.contains("p")){
            //Potenz
            //Mal
            String[] split = input.split("p");
            if(Main.isDev)
                stringOut(split);

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            outputErgebniss(input, Math.pow(nummer1, nummer2));

        }else if(input.contains("w")){
            //Wurzel
            String[] split = input.split("w");
            if(Main.isDev)
                stringOut(split);

            outputErgebniss(input, Math.sqrt(Double.parseDouble(split[1])));
        }else{
            stringOut("Fehler: Es ist kein Opperator Vorhanden in deiner Eingabe.");
            stringOut("");
        }
    }

    private void stringOut(String string){
        System.out.println(string);
    }

    private void stringOut(String[] strings){
        int i = 0;
        for (String s: strings) {
            System.out.println("String nummer " + i + " : " + s);
            i++;
        }
    }

    private void outputErgebniss(String rechnung, double ergebniss){
        stringOut(rechnung + " = " + ergebniss);
        stringOut("Das Ergebniss lautet: " + ergebniss);
    }

    //Geteilt
    public static double divide(double input1, double divideBy){
        return input1 / divideBy;
    }

    //Multiplizieren
    public static double multi(double input1, double input2){
        return input1 * input2;
    }

    //Addieren
    public static double plus(double input1, double input2){
        return input1 + input2;
    }

    //Subtrahieren
    public static double minus(double input1, double minusBy){
        return input1 - minusBy;
    }

    /*private double[] input;
    private double output;

    //Test Variablen
    private double summePlus;
    private double summeMinus;
    private double summeMulti;
    private double summeDivide;

    public Taschenrechner(){

    }*/

    /*public void test(double input1, double input2){
        nummer1 = input1;
        nummer2 = input2;

        summePlus = plus(input1, input2);
        summeDivide = divide(input1, input2);
        summeMinus = minus(input1, input2);
        summeMulti = multi(input1, input2);

        System.out.println("Nummer 1: " + nummer1);
        System.out.println("Nummer 2: " + nummer2);
        System.out.println("Summe Plus: " + summePlus);
        System.out.println("Summe Minus: " + summeMinus);
        System.out.println("Summe Dividieren: " + summeDivide);
        System.out.println("Summe Multiplizieren: " + summeMulti);
    }*/
}
