package Trainingslager;

import Aufgaben.IO;

public class Schaltjahre {

    public static void start(){
        while (true) {
            System.out.println("Bitte geben Sie ein start Jahr an: ");
            int jahrStart = IO.readInteger();

            System.out.println("Bitte geben Sie ein end Jahr an: ");
            int jahrEnde = IO.readInteger();

            for(int jahr = jahrStart; jahr <= jahrEnde; jahr++){


                boolean test1Schaltjahr = jahr % 4 == 0;
                boolean testKeinSchaltjahr = jahr % 100 == 0;
                boolean testAusnahmeRegel2 = jahr % 400 == 0;

                if (test1Schaltjahr) {
                    System.out.println(jahr + " Ist ein Schaltjahr!");
                } else if(testKeinSchaltjahr){
                    if(testAusnahmeRegel2){
                        System.out.println("Ist ein Schaltjahr!");
                        System.out.println(jahr);
                    }else{
                        //System.out.println("Ist kein Schaltjahr!");
                    }
                }
            }
            System.out.println("Möchten Sie nochmal wiederholen? (j/n)");
            if (!IO.readBoolean()) {
                return;
            }
        }
    }
}
