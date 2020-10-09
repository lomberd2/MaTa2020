package Main;

import CefTest.App;
import Extra.ExtraMain;
import FXGui.*;
import Aufgaben.*;
import GUI.TestGUI;
import HTMLGui.HTMLGui;
import Taschenrechner.Taschenrechner;
import Taschenrechner.MathTest;
import Trainingslager.*;
import Zellwachstum.Zellwachstum;
import com.formdev.flatlaf.*;
import javafx.application.Application;

import javax.swing.*;

public class Main {
    public static TestGUI win;
    public static boolean isDev = false;
    private static HTMLGui htmlGui;

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
        Zellwachstum.start();

        //Extra
        //ExtraMain.main(args);
    }

    private static void createUI(){
        try {
            LookAndFeel laf = new FlatDarkLaf();
            UIManager.setLookAndFeel(laf);

            win = new TestGUI();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void startFXGui()
    {
        new Thread(() -> Application.launch(FXGui.class)).start();
        //FXGui gui = new FXGui(args);
        //gui.initGui(args);
    }

}
