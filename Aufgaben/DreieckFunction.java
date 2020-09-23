package Aufgaben;

import GUI.TestGUI;

public class DreieckFunction {

    public DreieckFunction(){

    }

    public static void Init(TestGUI win){
        int p1;
        int p2;
        int p3;

        double s1; //a²
        double s2; //b²
        double s3;

        double grundSeite;
        double height;
        double sRoot;

        height = 15;
        grundSeite = 25;

        sRoot = grundSeite * height / 2;

        System.out.println("Grundseite = " + grundSeite);
        System.out.println("Höhe = " + height);
        System.out.println("Fläche vom Dreieck = " + sRoot);

        System.out.println();
        System.out.println("===================");
        System.out.println();

        s1 = Math.sqrt(25);
        s2 = Math.sqrt(10);

        s3 = s1 + s2;

        System.out.println("A² = " + s1);
        System.out.println("B² = " + s2);
        System.out.println("C² = " + s3);

    }
}
