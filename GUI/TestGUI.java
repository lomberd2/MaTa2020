package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI {
    public JFrame Frame;
    private JPanel panel1;
    private JButton f$ckButton;
    private JTextArea outputArea;
    private JButton anotherButton;

    private double screenX;
    private double screenY;

    public TestGUI(){
        //InitWindow();
        if (Frame == null) {
            InitWindow();
            InitEventListeners();
        }
    }

    public TestGUI InitWindow() {
        Frame = new JFrame("TestGUI");
        Frame.setContentPane(panel1);
        Frame.setTitle("Window Test");
        Frame.setSize(600, 400);

        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Show
        Frame.setVisible(true);
        Frame.setLocation(WindowFunctions.screenCenter(WindowFunctions.getScreenSize(), Frame.getSize()));


        return this;
    }

    public void InitEventListeners() {
        f$ckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogWindow().createDialog("Titel", "Text");
            }
        });
    }

    //Output Funktionen
    public void displayOutput(String[] outputText) {
        for (String text : outputText) {
            outputArea.append(text);
        }
    }

    public void displayOutput(int outputText) {
        outputArea.append(String.valueOf(outputText));
    }

    public void displayOutput(String outputText) {
        outputArea.append(outputText);
    }

    //Ende Output Funktionen
}

/*class EventListener extends Thread {
    private Thread t;
    private String threadName;
    private JButton button;

    public EventListener (String name, JButton buttons){
        threadName = name;
        button = buttons;
    }

    public void start(){
        if(t == null){
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public void run() {
        System.out.println("Multi");

    }
}*/