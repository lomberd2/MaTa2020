package Aufgaben;

public class IOTest {
    public static void Init(){
        System.out.println("Bitte gib deinen Namen ein");
        String name = IO.readString();

        System.out.println("Bitte geben sie ihr Alter ein:");
        int alter = IO.readInteger();

        System.out.println("Sind sie Raucher? (Ja = ja oder j; Nein = nein oder n");
        boolean raucher = IO.readBoolean();

        System.out.println("------------------------------------");

        System.out.print("Name: ");
        System.out.println(name);

        System.out.print("Alter: ");
        System.out.println(alter);

        System.out.print("Raucher: ");
        System.out.println(raucher);
    }
}
