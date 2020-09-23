package Main;

import FXGui.*;
import Aufgaben.*;
import GUI.TestGUI;
import Taschenrechner.Taschenrechner;
import Taschenrechner.MathTest;
import com.formdev.flatlaf.*;
import javafx.application.Application;

import javax.swing.*;

public class Main {
    public static TestGUI win;
    public static boolean isDev = false;

    public static void main(String[] args){
        //create Window
        //createUI();

        //Create FXGui
        startFXGui();

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
        Taschenrechner rechner = new Taschenrechner();
        rechner.initTaschenrechner();
        //rechner.test(12, 12.5);
        //MathTest.start();
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
