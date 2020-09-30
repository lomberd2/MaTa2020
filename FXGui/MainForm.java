package FXGui;

import Main.Main;
import Taschenrechner.Taschenrechner;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class MainForm {
    public TextArea outputDispl;
    public Button btnGleich;
    public Button btnMinus;
    public Button btn1;
    public Button btn4;
    public Button btn2;
    public Button btn7;
    public Button btn3;
    public Button btn0;
    public Button btn5;
    public Button btnMulti;
    public Button btnDivide;
    public Button btn6;
    public Button btn8;
    public Button btn9;
    public Button btnComma;
    public Button btnPlus;

    private boolean isEndeErgebniss;

    private static MainForm mainForm;

    public MainForm() {
        //System.out.println("first");
        if(mainForm==null){
            mainForm = this;
        }
    }

    public void initialize() {
        //System.out.println("second");
        //outputDispl.setText("Bitte deine Rechnung eingeben!");
        initClickListeners();
    }

    private void initClickListeners(){
        btn0.setOnMouseClicked(event -> addNumber("0"));
        btn1.setOnMouseClicked(event -> addNumber("1"));
        btn2.setOnMouseClicked(event -> addNumber("2"));
        btn3.setOnMouseClicked(event -> addNumber("3"));
        btn4.setOnMouseClicked(event -> addNumber("4"));
        btn5.setOnMouseClicked(event -> addNumber("5"));
        btn6.setOnMouseClicked(event -> addNumber("6"));
        btn7.setOnMouseClicked(event -> addNumber("7"));
        btn8.setOnMouseClicked(event -> addNumber("8"));
        btn9.setOnMouseClicked(event -> addNumber("9"));
        btnMinus.setOnMouseClicked(event -> addTxt("-"));
        btnPlus.setOnMouseClicked(event -> addTxt("+"));
        btnDivide.setOnMouseClicked(event -> addTxt("/"));
        btnMulti.setOnMouseClicked(event -> addTxt("*"));
        btnGleich.setOnMouseClicked(event -> ergebniss());
        btnComma.setOnMouseClicked(event -> addNumber("."));
    }

    private void ergebniss(){
        String text = outputDispl.getText();
        text.replace(",",".");

        double ergebniss = rechnung(text);
        outputDispl.setText(text + " = " + ergebniss);
        isEndeErgebniss = true;
    }

    //Text Methode Intern
    private void setTxt(String text){
        if(isEndeErgebniss) {
            isEndeErgebniss = false;
            outputDispl.setText("");
        }

        outputDispl.setText(text);
    }

    private void addTxt(String text){
        if(isEndeErgebniss) {
            isEndeErgebniss = false;
            setTxt("");
        }

        String prevText = outputDispl.getText();
        prevText = prevText + " " + text + " ";
        setTxt(prevText);
    }

    private void addNumber(String nummer){
        if(isEndeErgebniss) {
            isEndeErgebniss = false;
            setTxt("");
        }
        String prevText = outputDispl.getText();
        prevText = prevText + nummer;
        setTxt(prevText);
    }

    //Text Methode Extern
    public static void setOutputText(String text){
        mainForm.setTxt(text);
    }

    public static void addToOutput(String textToAdd){
        mainForm.addTxt(textToAdd);
    }

    //Rechnungen
    private double rechnung(String input){
        double nummer1;
        double nummer2;

        if(input.contains("-")){
            //Minus
            String[] split = input.split("-");

            int i = 0;
            for (String s: split) {
                System.out.println(s + " + " + i);
                i++;
            }
            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            return Taschenrechner.minus(nummer1, nummer2);
            //System.out.println("Das Ergebniss ist: " + minus(nummer1, nummer2));
        }
        if(input.contains("+")){
            //Plus
            String[] split = input.split("\\+");

            int i = 0;
            for (String s: split) {
                System.out.println(s + " + " + i);
                i++;
            }

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            return Taschenrechner.plus(nummer1, nummer2);
            //System.out.println("Das Ergebniss ist: " + plus(nummer1, nummer2));
        }
        if(input.contains("/")){
            //Geteilt
            String[] split = input.split("/");

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            return Taschenrechner.divide(nummer1, nummer2);
            //System.out.println("Das Ergebniss ist: " + divide(nummer1, nummer2));
        }
        if(input.contains("*")) {
            //Mal
            String[] split = input.split("\\*");

            nummer1 = Double.parseDouble(split[0]);
            nummer2 = Double.parseDouble(split[1]);

            return Taschenrechner.multi(nummer1, nummer2);
            //System.out.println("Das Ergebniss ist: " + multi(nummer1, nummer2));
        }

        return 0;
    }
}
