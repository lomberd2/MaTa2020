package Matrizen;

public class DreiGewinnt {
    private static String[][] spielFeld;
    private static int currentPlayer;


    public static void start(){
        System.out.println("Setup Game");
        System.out.println("Wie Hoch soll das Spielfeld sein?");
        int hoehe = Aufgaben.IO.readInteger();

        System.out.println("Wie Breit soll das Spielfeld sein?");
        int breite = Aufgaben.IO.readInteger();

        spielFeld = createSpielfeld(breite, hoehe);
        currentPlayer = 0;

        mainProgramm();
    }


    private static void mainProgramm(){
        System.out.println("----{ 3 Gewinnt }----");
        System.out.println("Wählen sie die Reihen zum Spielen aus. Es beginnt X.");

        while(true){
            printSpielFeld();
            System.out.println("");
            System.out.println("\n Es Spielt " + getSpieler(currentPlayer) + ". Bitte eingabe Tätigen: ");

            if(spielSteinPlatzieren(Aufgaben.IO.readInteger(), currentPlayer)){
                if(checkWin(currentPlayer)){
                    System.out.println("Spieler " +  getSpieler(currentPlayer) + " hat Gewonnen!");
                    return;
                }
                switchCurrentPlayer();
            }else{
                System.out.println("Reihe bereits Voll! Bitte eine andere Wählen!");
            };


        }
    }

    private static void switchCurrentPlayer(){
        if(currentPlayer == 0){
            currentPlayer = 1;
        }else{
            currentPlayer = 0;
        }
    }

    private static String[][] createSpielfeld(int breite, int hoehe){
        String[][] newArr = new String[hoehe][breite];
        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[i].length; j++){
                newArr[i][j] = "0";
            }
        }

        return newArr;
    }

    private static void printSpielFeld(){
        for(int i = 0; i < 1; i++){
            for(int j = 0; j < spielFeld[i].length; j++){
                System.out.print(j);
            }
            System.out.println("");
        }

        System.out.println("---------");

        for(int i = 0; i < spielFeld.length; i++){
            for(int j = 0; j < spielFeld[i].length; j++){
                System.out.print(spielFeld[i][j]);
            }
            System.out.println("");
        }
    }

    private static boolean spielSteinPlatzieren(int reihe, int spieler){
        for(int i = spielFeld.length - 1; i >= 0; i--){
            if(spielFeld[i][reihe] == "0"){
                spielFeld[i][reihe] = getSpieler(spieler);
                return true;
            }
        }

        return false;
    }

    private static boolean checkWin(int currentPlayer){

        for(int i = 0; i < spielFeld.length; i++){
            for(int j = 0; j < spielFeld[i].length; j++){
                String currentElement = spielFeld[i][j];
                String currentPly = getSpieler(currentPlayer);


                if(currentElement == "0"){
                    //Wenn es Leer ist.

                }else if(currentElement == "X" || currentElement == "O"){

                    //Abfrage 1: Links Oben Rechts Unten
                    if(checkIsValid(i - 1, j - 1 )){
                        String searchedElement = spielFeld[i - 1][j - 1];
                        if(searchedElement == currentPly){
                            if(currentElement == currentPly){
                                if(checkIsValid(i + 1,  j + 1)){
                                    if(spielFeld[i + 1][j + 1] == currentPly){
                                        return true;
                                    }
                                }
                            }
                        }
                    }

                    //Abfrage 2 Von Unten Links nach Oben Rechts
                    if(checkIsValid(i - 1, j + 1)){
                        String currentSearch = spielFeld[i - 1][j + 1];
                        if(currentSearch == currentPly){
                            if(currentElement == currentPly){
                                if(checkIsValid(i + 1,  j - 1)){
                                    currentSearch = spielFeld[i + 1][j - 1];
                                    if(currentSearch == currentPly){
                                        return true;
                                    }
                                }
                            }
                        }
                    }


                    //Abfrage 3: Von Links nach Rechts
                    if(checkIsValid(i - 1, j)){
                        String currentSearch = spielFeld[i - 1][j];
                        if(currentSearch == currentPly){
                            if(currentElement == currentPly){
                                if(checkIsValid(i + 1, j)){
                                    currentSearch = spielFeld[i + 1][j];
                                    if(currentSearch == currentPly){
                                        return true;
                                    }
                                }
                            }
                        }
                    }

                    //Abfrage 4 Oben nach Unten
                    if(checkIsValid(i, j - 1)){
                        String currentSearch = spielFeld[i][j-1];
                        if(currentSearch == currentPly){
                            if(currentElement == currentPly){
                                if(checkIsValid(i, j + 1)){
                                    currentSearch = spielFeld[i][j+1];
                                    if(currentSearch == currentPly){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkIsValid(int i, int j){
        if(i < 0){
            return false;
        }
        if(j < 0){
            return false;
        }
        if(j >= spielFeld[0].length){
            return false;
        }
        if(i >= spielFeld.length){
            return false;
        }

        return true;
    }

    private static String getSpieler(int id){
        switch (id){
            case 0 -> {
                return "X";
            }
            case 1 -> {
                return "O";
            }
            default -> {
                return "Error";
            }
        }
    }
}
