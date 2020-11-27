package Matrizen;

public class MatrizenTest {

    public static void Aufgabe1(){
        System.out.println("Länge: ");
        int length = Aufgaben.IO.readInteger();

        System.out.println("Breite: ");
        int breite = Aufgaben.IO.readInteger();

        IO.print2dArr(IO.createInt2dArr(length, breite));
    }

    public static void Aufgabe2(){
        System.out.println("Länge: ");
        int length = Aufgaben.IO.readInteger();

        System.out.println("Breite: ");
        int breite = Aufgaben.IO.readInteger();

        IO.print2dArr(IO.createDouble2dArr(length, breite));
    }

    public static void Aufgabe3(){
        System.out.println("Länge: ");
        int length = Aufgaben.IO.readInteger();

        System.out.println("Breite: ");
        int breite = Aufgaben.IO.readInteger();

        IO.print2dArr(IO.createString2dArr(length, breite));
    }
}
