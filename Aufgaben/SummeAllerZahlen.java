package Aufgaben;

import Main.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SummeAllerZahlen {

    public static void init(){
        try {
            //Define Vars
            int output = 0;
            int output2 = 0;
            int output3 = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //Input Reader
            System.out.println("Ganzzahl eingeben: ");
            String line = reader.readLine();
            int inputI = Integer.parseInt(line);

            //Iteration trough numbers
            for (int i = 1; i <= inputI; i++) {
                output += i;
                if(Main.isDev)
                    System.out.println(output);
            }

            int i2 = 0;
            //while schleife
            while(i2 <= inputI){
                output2 += i2;
                i2++;
            }

            int i3 = 0;
            do{
                output3 += i3;
                i3++;
            }while(i3 <= inputI);

            //Output
            System.out.println("Das Ergebniss 1 lautet: " + output);
            System.out.println("Das Ergebniss 2 lautet: " + output2);
            System.out.println("Das Ergebniss 3 lautet: " + output3);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }
}
