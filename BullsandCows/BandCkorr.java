import java.util.Scanner;
import java.io.*;
// es ist keine gute Idee alles aus großen packages zu importieren
import java.util.ArrayList;

public class BandC{

    public static void main(String[] args){

        while(true){

            int versuch = 1;

            boolean testgleichgeheim = false;

            String geheimWort = createGeheimwort();

            int geheimWortlength = geheimWort.length();
            System.out.println("Die Laenge des Wortes ist: " + geheimWortlength);

            // man soll doppelt so viele versuche haben, wie das Wort lang ist
            while (versuch <= geheimWortlength){

                System.out.println("Versuch(" + versuch + "|" + geheimWortlength + ")");
                String testWort = getTestWort(); 
                        
                int testWortlength = testWort.length(); 
                boolean isogramm = checkIfIsogramm(testWort,testWortlength);                
                if(geheimWortlength == testWortlength && isogramm){
                    System.out.println("Richtige Laenge und Isogramm...berechne...");
                    testgleichgeheim = wortVergleich(geheimWort, geheimWortlength, testWort, testWortlength);

                }
                else {
                    System.out.println("Kein Isogramm oder falsche Laenge");
                    // falls das wort die anforderungen nicht erfuellt

                }

                if(testgleichgeheim){
                    // wenn das Wort eraten wurde

                    System.out.println("Richtig! Versuchszahl: " + versuch);
                    break;
                }

                versuch++;
            }

            if(!testgleichgeheim){

                System.out.println("Du hast versagt...");                
            }
        }
    }

    // Ich würde dir empfelen Kommentare die Funktionen beschriben
    // über die entsprechende Funktion zu schriebung und nicht
    // darunter.
    public static String createGeheimwort(){
        // gibt ein zufaelliges geheimWort zurueck

        ArrayList<String> dateiArray = new ArrayList<String>();
        // dateiArray ist ein ArrayList<String>
        // das sehe ich, das musst du nicht dazu schreiben
    

        dateiArray = dateiLaden(dateiArray);
        // datei wird geladen und in dateiarray einem ArrayList<String>
        // Du musst nicht zu allem einen Kommentar schreiben. 
        // gute Variablennamen und Funktionsnamen machen meißt klar, 
        // was das Programm gerade macht. unnötige Kommentare lenken 
        // visuell vom wichtigsten ab: dem Code. 

        // apropos gute namen: "wortArray" wäre besser

        int wortzahl  =  dateiArray.size(); 
        int zufallsZahl = (int)(Math.random()*(wortzahl-1));         
        String geheimWort = dateiArray.get(zufallsZahl);


        return geheimWort;
    }


    public static ArrayList<String> dateiLaden(ArrayList<String> dateiArray){

        File textfile =  new File("words.txt");

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

        // Ich weißt nicht wie schlecht es in realität ist,
        // Sätze über mehere weit entfernte Kommentare zu verteile,n 
        // doch mein erster Instinkt sagt mir, dass es keine gute idee 
        // ist. Ich würde dir abraten das zu machen. 
        // Bzw wenn du das machst, mach wenigstens "..." ans Ende jedes
        // Kommentars, damit klar wird, dass das ein zusammenhängernder Satz ist. 



        // was du hier machst ist: 
        // 1) du nimmst eine ArrayList als input
        // 2) modifizierst diese, indem du wörter dran hängst
        // 3) gibst sie als Rückgabewert wieder
        // 4) in der Funktion die diese aufruft, 
        //    setzt du das ausgangs ArrayList gleich dem Rückgabewert

        // Der letzte schritt macht nichts, weil du das ausgangsarray
        // schon in Schritt 2) die Wörter angehangen hast. 

        // Was du machen kannst um das zu beheben ist eine lokale variable 
        // in dieser Funktion zu erstellen und an sie die Wörter ranzuhängen
        // und dann diese zurückgeben

    }

    
    public static String getTestWort(){
        // fordert Wort vom user und gibt valide Worte zurueck
        // das ist nicht was die Funktion macht. Es wird hier nicht gewährleistet
        // das das wort valide, dh die selbe länge hat und ein Isogramm ist. Das wird
        // in der main Funktion gemacht

        Scanner wortScanner = new Scanner(System.in);

        System.out.println("Wortidee?(or type quit to exit)");        
        String testWort =  wortScanner.nextLine();

        switch (testWort) {
            // switch fuer quit bzw. andere commands(falls spaeter eingebaut)

            case "quit":
                wortScanner.close();
                System.exit(0);
                break;
        
            default:
                break;
                // falls kein besonderer command tut es nix
        }
        System.out.println("hit");
        wortScanner.close();
        // schließt Scanner
        // wenn wortScanner.close(); dann crasht das programm vor der 2.Eingabe?? warum?

        // immer wieder scanner in einer Funktion aufzumachen und sie wieder zu
        // scließen ist keine gute Idee. Öffne einmal einen Scanner, speicher ihn
        // in einer globalen variable und verwende immer wieder den selben scanner, 
        // bis dein programm fertig ist, und schließe dann diesen einen Scanner. 
        // das könnte dein problem Lösen. So generierst du nicht unmengen an Scannern, 
        // die du nicht schließen kannst

        return testWort;
    
    }


    public static boolean checkIfIsogramm(String testWort, int testWortlength){

        for(int z=0;z < testWortlength; z++){

            for(int y = 0; y < testWortlength;y++){

                if(z != y){
                    if(testWort.charAt(z) == testWort.charAt(y)){
                        // testet ob Buchstaben identisch sind
                        // Du willsta ja nicht, dass die bustaben idetisch sind, 
                        // sondern dass es sie selben Buchstaben sind. Groß Buchstaben
                        // sind mit ihren KLeinbuchstaben nicht gleich. Hättest darauf
                        // achten müssen, die du es in der wortVergleich Funktion gemacht hast

                        return false;
                    } 
                }
            }
        }   
        return true;
        // falls keine doppelten Buchstaben im Wort vorhanden sind
    }


    public static boolean wortVergleich(String geheimWort,int geheimWortlength,String testWort, int testWortlength){
        // vergleicht die beiden woerter
        // das ist nicht was die Funktion macht. Sie
        // berrechnet die Bulls und Cows, gibt sie aus
        // und dann vergleicht es die Wörter. Eine 
        // Funktion soll nur eine Aufgabe machen und soll
        // einen Namen haben, der diese Aufgabe wiederspiegelt. 
        // Verlagere die Berechnung der Bulls und Cows in eine
        // eigene Funktion. 


        geheimWort = geheimWort.toLowerCase();
        testWort = testWort.toLowerCase();
        
        int bull = 0;
        int cow = 0;
        

        for(int i = 0; i < geheimWortlength; i++){

            for(int j = 0; j < testWortlength; j++){

                if(testWort.charAt(i) == geheimWort.charAt(j)){
                    if(i == j){
                        bull++;
                    }
                    else{
                        cow++;
                    }
                }
            }
        }

        System.out.println("Cows:"+cow + " Bulls:" + bull);


        if(bull == geheimWortlength){
            return true;
        }
        else{
            return false;
        }
    }
}
