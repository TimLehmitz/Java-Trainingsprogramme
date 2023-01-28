import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BandC{

    public static void main(String[] args){

        while(true){
            // solange bis der user quit schreibt

            int versuch = 1;
            // versuchzahl wird wieder auf 1 gesetzt

            boolean testgleichgeheim = false;
            //  die abschlussbedingung welche auf true gesetzt wir wenn das rifhtige wort eingeben wurde

            String geheimWort = createGeheimwort();
            // geheimwort wird generiert

            int geheimWortlength = geheimWort.length();
            // laenge iwr bestimmt

            System.out.println("Die Laenge des Wortes ist: " + geheimWortlength);
            // ausgabe laenge
            
            while (versuch <= geheimWortlength){
                // solange der user noch versuche hat
                System.out.println("Versuch(" + versuch + "|" + geheimWortlength + ")");
                String testWort = getTestWort(); 
                // testwort wird vom user angefordert
                        
                int testWortlength = testWort.length(); 
                // length vom testwort wir in testWortlength gespeichert

                boolean isogramm = checkIfIsogramm(testWort,testWortlength); 
                // pruefe ob das wort vom user ein isogramm ist
                
                if(geheimWortlength == testWortlength && isogramm){
                    // wenn das wort die gleiche length wie das gehimwort hat und ein isogramm ist

                    System.out.println("Richtige Laenge und Isogramm...berechne...");
                    testgleichgeheim = wortVergleich(geheimWort, geheimWortlength, testWort, testWortlength);
                    //vergleicht die beiden worte und gibt die anzahl von Cows und bulls aus

                }
                else {
                    System.out.println("Kein Isogramm oder falsche Laenge");
                    // falls das wort die anforderungen nicht erfuellt

                }

                if(testgleichgeheim){
                    // wenn das Wort eraten wurde

                    System.out.println("Richtig! Versuchszahl: " + versuch);
                    // ausgabe der Versuchzahl

                    break;
                    // beende die Schleife

                }

                versuch++;
                // Die zahl der bisherigen Versuchen wird erhoeht
            }

            if(!testgleichgeheim){
                // falls die schleife durch zu hohe versuchszahl endet

                System.out.println("Du hast versagt...");
                // nachricht an den user
                
            }
        }
    }


    public static String createGeheimwort(){
        // gibt ein zufaelliges geheimWort zurueck

        ArrayList<String> dateiArray = new ArrayList<String>();
        // dateiArray ist ein ArrayList<String>
    
        dateiArray = dateiLaden(dateiArray);
        // datei wird geladen und in dateiarray einem ArrayList<String>

        int wortzahl  =  dateiArray.size(); 
        // anzahl der worte wird gespeichert 

        int zufallsZahl = (int)(Math.random()*(wortzahl-1)); 
        // zufaellige zahl von 0 - wortzahl wird erstellt
        
        String geheimWort = dateiArray.get(zufallsZahl);
        // das geheimwort wird aus dem Array mit allen worten entnommen(zufaellige Stelle)

        //System.out.println(geheimWort);
        //System.out.println(wortzahl);
        //System.out.println(zufallsZahl);
        // Ausgaben einiger Wete fuer debugzeug

        return geheimWort;
    }


    public static ArrayList<String> dateiLaden(ArrayList<String> dateiArray){
        // zum laden der Datei, gibt eine Liste aller Worte in der datei zurueck

        File textfile =  new File("words.txt");
        // die datei mit woertern wird festgelegt

        Scanner FileScanner = null;
        // Scanner wird 

        try {
            // versuchen

            FileScanner = new Scanner(textfile);

        } catch (FileNotFoundException fehler) {

            System.out.println("Die Datei scheint verschwunden...");

        }

        while (FileScanner.hasNext()) {
            // solange in der naechsten zeile der datei noch ein Wort steht

           dateiArray.add(FileScanner.nextLine());
           // haengt das naechste wort an die array list an an
        }

        FileScanner.close();
        // Scanner beenden

        return dateiArray;
    }

    
    public static String getTestWort(){
        // fordert Wort vom user und gibt valide Worte zurueck

        Scanner wortScanner = new Scanner(System.in);
        // Scanner wird erstellt

        System.out.println("Wortidee?(or type quit to exit)");
        // sagt dem user was zu tun ist
        
        String testWort =  wortScanner.nextLine();
        // nimmt wort an

        switch (testWort) {
            // switch fuer quit bzw. andere commands(falls spaeter eingebaut)

            case "quit":
                wortScanner.close();
                System.exit(0);
                break;
                // beendet das Programm und schießt den scanner (um die warnung zu eleminieren)
        
            default:
                break;
                // falls kein besonderer command tut es nix
        }

        //wortScanner.close();
        // schließt Scanner
        // wenn wortScanner.close(); dann crasht das programm vor der 2.Eingabe?? warum?

        return testWort;
    
    }


    public static boolean checkIfIsogramm(String testWort, int testWortlength){
        // testet ob das anggebene Wort ein Isogramm ist

        for(int z=0;z < testWortlength; z++){
            // fuer alle Buchstaben im Testwort

            for(int y = 0; y < testWortlength;y++){
                // fuer alle Worte im Testwort

                if(z != y){
                    // wenn die Stelle ungleich der zu vergleichenden Stelle ist

                    if(testWort.charAt(z) == testWort.charAt(y)){
                        // testet ob Buchstaben identisch sind

                        return false;
                        // wenn dies einmal der Fall ist, ist das Wort kein Isogramm
                    } 
                }
            }
        }   
        return true;
        // falls keine doppelten Buchstaben im Wort vorhanden sind
    }


    public static boolean wortVergleich(String geheimWort,int geheimWortlength,String testWort, int testWortlength){
        // vergleicht die beiden woerter

        geheimWort = geheimWort.toLowerCase();
        testWort = testWort.toLowerCase();
        // beide String werden zu nur kleinbuchstaben veraendert um das Vergleichen zu erleichtern
        
        int bull = 0;
        int cow = 0;
        // bull und cow wird auf 0 gesetzt
        
        // test nach bulls and cows
        for(int i = 0; i < geheimWortlength; i++){
            // fuer jeden buchstaben im geheimWort

            for(int j = 0; j < testWortlength; j++){
                // fuer jeden Bucchstaen im testwort

                if(testWort.charAt(i) == geheimWort.charAt(j)){
                    // wenn der Buchstabe des testworts einem Buchstaben aus dem geheimwort entspricht

                    if(i == j){
                        // wenn die Stelle bei beiden worten gleich ist

                        bull++;
                        // bull wird um 1 erhoeht
                    }
                    else{
                        // falls nicht

                        cow++;
                        // cow wird um 1 erhoeht
                    }
                }
            }
        }

        System.out.println("Cows:"+cow + " Bulls:" + bull);
        // ausgabe der Cows und Bulls  

        if(bull == geheimWortlength){
            // falls alle bucchstaben an der richtigen stelle sind

            return true;

        }
        else{
            // falls nicht

            return false;
        }
    }
}
