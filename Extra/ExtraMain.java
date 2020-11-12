package Extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtraMain {

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        System.out.println("Bitte gib deine Note ein: ");
        try {
            input = reader.readLine().replace("-",".");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Der Benutzer hat folgendes eingegeben: " + input);
    }
}
