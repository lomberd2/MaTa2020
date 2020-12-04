package Main;

//import CefTest.App;
//import FXGui.*;
//import GUI.TestGUI;
//import HTMLGui.HTMLGui;
import ArrayAufgaben.Bubblesort;
import ArrayAufgaben.Lagerbestand;
import ArrayAufgaben.Lotto;
import MiniGame.MiniGame;
//import com.formdev.flatlaf.*;
//import javafx.application.Application;

//import javax.swing.*;

public class Main {
    //public static TestGUI win;
    public static boolean isDev = false;
    //private static HTMLGui htmlGui;

    public static void main(String[] args){
        //create Window
        //createUI();

        //Create FXGui
        //startFXGui();

        //create HTML Gui
        //htmlGui = new HTMLGui();

        //Cef
        //CefTest.App.main(args);
        //App app = new App();
        //new Thread(() -> new App.start());

        //Game
        //MiniGame.Start.init();
        //MiniGame game = new MiniGame();

        //Aufgabe 1
        //RechnungsAufgabe.rechnungsAufgabe(win);

        //Aufgabe 2
        //RegenAufgabe();

        //Aufgabe 3
        //DreieckFunction.Init();

        //Aufgabe 4
        //RegenFunction.RegenFunction(win);

        //Aufgabe 5
        //NotenschemaFunction.init();

        //Aufgabe 6
        //Dreiecksungleichung.init();

        //Aufgabe 7
        //SummeAllerZahlen.init();

        //Aufgabe 8
        //Taschenrechner rechner = new Taschenrechner();
        //rechner.initTaschenrechner();
        //rechner.test(12, 12.5);
        //MathTest.start();

        //Aufgabe 9
        //IOTest.Init();

        //Trainingslager
        //Alterspruefung.init();
        //Bestellung.init(12,14,12);
        //Fuehrerschein.start();
        //Bmi.start();

        //Traininglager Schleifen
        //Wurzel.start();
        //Fakultae.start();
        //Quadratsummen.start();
        //GeometrischeReihe.start();
        //Quadrat.start();
        //ExtraMax.start();
        //Schaltjahre.start();
        //Ostern.start();
        //Pi.start();

        //PQ Formel
        //PqFormel.start();

        //Zellwachstum
        //Zellwachstum.start();
        //Sparvertrag.start();

        //Statistik
        //Statistik.Temperatur.start();

        //Extra
        //ExtraMain.main(args);
        /*System.out.println("Bitte geben Sie die länge des Arrays ein: ");
        String[] testArrInt = IO.createStringArr(IO.readInteger());

        for(String i: testArrInt){
            System.out.println(i);
        }*/

        //Aufgaben.Summen();
        //Aufgaben.Maxima();
        //Aufgaben.Balkendiagramm();
        //Aufgaben.TonsignalGlätten();
        //Aufgaben.BinaerAddition();
        //Lagerbestand.init();
        //Bubblesort.init();
        //Lotto.init();

        //Matrizen
        //Matrizen.MatrizenTest.Aufgabe1();
        //Matrizen.MatrizenTest.Aufgabe2();
        //Matrizen.MatrizenTest.Aufgabe3();
        //Matrizen.Kino.start();
        //Matrizen.DreiGewinnt.start();
        //Matrizen.DreiGewinntForDummies.start();
        Matrizen.Lieferbeziehungen.start();
    }

    /*private static void createUI(){
        try {
            LookAndFeel laf = new FlatDarkLaf();
            UIManager.setLookAndFeel(laf);

            win = new TestGUI();
        }catch (Exception e){
            System.out.println(e);
        }
    }*/

    private static void startFXGui()
    {
        //new Thread(() -> Application.launch(FXGui.class)).start();
        //FXGui gui = new FXGui(args);
        //gui.initGui(args);
    }

}
