package Matrizen;



public class Kino {
    private static int length;
    private static int breite;
    private static String[][] kinoArr;

    public static void start(){
        System.out.println("Einrichtung. Wie viele Reihen hat das Kino?");
        length = Aufgaben.IO.readInteger();

        System.out.println("Wie viele Sitzplatze Pro Reihe?");
        breite = Aufgaben.IO.readInteger();

        kinoArr = createKino(length, breite);

        mainLoop();
    }

    private static void mainLoop(){
        while(true){
            System.out.println("----{ Hauptmenü }----");
            System.out.println("1. Reservierung Hinzufügen");
            System.out.println("2. Reservierung Stornieren");
            System.out.println("3. Saal Anzeigen");
            System.out.println("4. Programm beenden");
            System.out.println("----------------------");
            System.out.println("Bitte wählen Sie eine Option aus.");
            switch (Aufgaben.IO.readInteger()){
                case 1 -> reservierePlatz();
                case 2 -> reservierungStornieren();
                case 3 -> printKino();
                case 4 -> {
                    return;
                }
                default -> System.out.println("ERROR");
            }
        }
    }

    private static String[][] createKino(int length, int breite){
        String[][] newArr = new String[length][breite];
        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[i].length; j++){
                newArr[i][j] = "O";
            }
        }
        return newArr;
    }

    private static void printKino(){
        for(int i = 0; i < kinoArr.length; i++){
            System.out.print(i  + " : ");
            for(int j = 0; j < kinoArr[i].length; j++){
                System.out.print(kinoArr[i][j]);
            }
            System.out.println("");
        }
    }

    private static void reservierePlatz(){
        System.out.println("--{ Reservierung }--");
        System.out.println("Bitte wählen Sie die Reihe aus:");
        int reihe = Aufgaben.IO.readInteger();

        System.out.println("Bitte wählen sie den Sitzplatz / Nummer von Links aus");
        int sitz = Aufgaben.IO.readInteger();

        String sitzplatz = kinoArr[reihe][sitz];
        if(sitzplatz == "O"){
            //Alles Roger in Kambodscha
            kinoArr[reihe][sitz] = "X";
        }else if(sitzplatz == "X"){
            //Schon weg
            System.out.println("Error! Platz schon Reserviert!");
        }else{
            //Was zum Fick?
            System.out.println("Was auch immer du getan hast. Mach es bitte nicht wieder!");
        }
    }

    private static void reservierungStornieren(){
        System.out.println("---{ Reverse Reservierung / Stornierung }---");
        System.out.println("Bitte wählen Sie die Reihe aus:");
        int reihe = Aufgaben.IO.readInteger();

        System.out.println("Bitte wählen sie den Sitzplatz / Nummer von Links aus");
        int sitz = Aufgaben.IO.readInteger();

        String sitzplatz = kinoArr[reihe][sitz];
        if(sitzplatz == "O"){
            //Nicht zu machen hier
            System.out.println("Sitzplatz ist nicht Reserviert du dödel!");
        }else if(sitzplatz == "X"){
            //Alles Roger in Kambodscha
            kinoArr[reihe][sitz] = "O";
            System.out.println("Sitzplatz wieder Frei!");
        }else{
            //Was zum Fick?
            System.out.println("Was auch immer du getan hast. Mach es bitte nicht wieder!");
        }
    }
}
