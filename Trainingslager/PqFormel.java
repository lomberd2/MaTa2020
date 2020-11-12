package Trainingslager;

import Aufgaben.IO;

public class PqFormel {
    private static double x1 = 0;
    private static double x2 = 0;

    private static double p = 0;
    private static double q = 0;

    public static void start(){
        main();
    }

    private static void main(){

        while(true){
            System.out.println("Welche Formel möchtest du eingeben?");
            System.out.println("Option 1: PQ;  Option 2: ABC");
            int option = IO.readInteger();

            switch (option){
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
            }

            double behind = 0;
            behind = Math.sqrt(((p/2) * (p/2)) - q);

            if(behind == 0){
                x1 = -(p / 2) + behind;
                System.out.println(x1);
            }else if(behind > 0){
                x1 = -(p / 2) + behind;
                x2 = -(p / 2) - behind;
                System.out.println(x1);
                System.out.println(x2);
            }else{
                System.out.println("Du bist Behindert!");
            }

        }
    }

    private static void case1(){
        System.out.println("Case 1");
        double[] dbl = pqFormel();
        p = dbl[0];
        q = dbl[1];
    }

    private static void case2(){
        System.out.println("Case 2");
        double[] dbl = abcFormel();
        p = dbl[0];
        q = dbl[1];
    }

    private static double[] pqFormel(){
        System.out.println("Bitte geben Sie p ein");
        double p = IO.readDouble();

        System.out.println("Bitte geben Sie q ein");
        double q = IO.readDouble();

        double[] dbl = new double[2];
        dbl[0] = p;
        dbl[1] = q;

        return dbl;
    }

    private static double[] abcFormel(){
        System.out.println("Bitte geben sie A ein: ");
        double a = IO.readDouble();

        System.out.println("Bitte geben sie B ein: ");
        double b = IO.readDouble();

        System.out.println("Bitte geben sie C ein: ");
        double c = IO.readDouble();

        double[] dbl = new double[2];
        dbl[0] = b/a;
        dbl[1] = c/a;

        return dbl;
    }
}
