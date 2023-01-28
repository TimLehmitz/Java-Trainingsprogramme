import java.util.Scanner;

import javax.lang.model.element.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Textanalyse {

    public static void main(String[] args) {
    Buchstabe A = new Buchstabe();
    Buchstabe B = new Buchstabe();
    Buchstabe C = new Buchstabe();
    Buchstabe D = new Buchstabe();
    Buchstabe E = new Buchstabe();
    Buchstabe F = new Buchstabe();
    Buchstabe G = new Buchstabe();
    Buchstabe H = new Buchstabe();
    Buchstabe I = new Buchstabe();
    Buchstabe J = new Buchstabe();
    Buchstabe K = new Buchstabe();
    Buchstabe L = new Buchstabe();
    Buchstabe M = new Buchstabe();
    Buchstabe N = new Buchstabe();
    Buchstabe O = new Buchstabe();
    Buchstabe P = new Buchstabe();
    Buchstabe Q = new Buchstabe();
    Buchstabe R = new Buchstabe();
    Buchstabe S = new Buchstabe();
    Buchstabe T = new Buchstabe();
    Buchstabe U = new Buchstabe();
    Buchstabe V = new Buchstabe();
    Buchstabe W = new Buchstabe();
    Buchstabe X = new Buchstabe();
    Buchstabe Y = new Buchstabe();
    Buchstabe Z = new Buchstabe();

    ArrayList<String> dateiListArray = new ArrayList<String>();
    dateiListArray = dateiLaden(dateiListArray);
    //System.out.println(dateiListArray);
    for(int j = 0; j < dateiListArray.size();j++){
        String wort = dateiListArray.get(j);
        wort = wort.toLowerCase();
        for(int i = 0;i < wort.length(); i++){

            //8System.out.println(wort.charAt(i));
            switch (wort.charAt(i)) {
                case 'a':
                    A.anzahl++;
                    break;
                case 'b':
                    B.anzahl++;
                    break;
                case 'c':
                    C.anzahl++;
                    break;
                case 'd':
                    D.anzahl++;
                    break;
                case 'e':
                    E.anzahl++;
                    break;
                case 'f':
                    F.anzahl++;
                    break;
                case 'g':
                    G.anzahl++;
                    break;
                case 'h':
                    H.anzahl++;
                    break;
                case 'i':
                    I.anzahl++;
                    break;
                case 'j':
                    J.anzahl++;
                    break;
                case 'k':
                    K.anzahl++;
                    break;
                case 'l':
                    L.anzahl++;
                    break;
                case 'm':
                    M.anzahl++;
                    break;
                case 'n':
                    N.anzahl++;
                    break;
                case 'o':
                    O.anzahl++;
                    break;
                case 'p':
                    P.anzahl++;
                    break;
                case 'q':
                    Q.anzahl++;
                    break;
                case 'r':
                    R.anzahl++;
                    break;
                case 's':
                    S.anzahl++;
                    break;
                case 't':
                    T.anzahl++;
                    break;
                case 'u':
                    U.anzahl++;
                    break;
                case 'v':
                    V.anzahl++;
                    break;
                case 'w':
                    W.anzahl++;
                    break;
                case 'x':
                    X.anzahl++;
                    break;
                case 'y':
                    Y.anzahl++;
                    break;
                case 'z':
                    Z.anzahl++;
                    break;
                default:
                    System.out.println("Sonderzeichen im Wort! ");
                    break;
            }
        
        }
    }
    System.out.println("A: " + A.anzahl + " B: " + B.anzahl + " C: " + C.anzahl);
    ArrayList<Integer> anzahlarrList = new ArrayList<>(Arrays.asList(243,1243,5390,1));
    
    char[] buchstabenarr = {'a','b','c','d'};
    sort(anzahlarrList, buchstabenarr);
    Integer toStartEl = 5390;
    anzahlarrList = elementswitch(anzahlarrList,toStartEl);

    }
    public static int sort(ArrayList<Integer> zahlArrList, char[] buchstabenarr){
        int tempnich = 0;
        while(true){  
        for(int e = 1; e<= zahlArrList.size()-1; e++){
            if(zahlArrList.get(e)> zahlArrList.get(e-1)){
                System.out.println("passt nicht");
                tempnich = e;
            }
            else if(zahlArrList.get(e)<= zahlArrList.get(e-1)){
                System.out.println("passt");
            }
        }
        if (tempnich == 0){
            break;
        }
        else{
            zahlArrList = elementswitch(zahlArrList,tempnich);
            sort(zahlArrList, buchstabenarr);
        }
        }

        //System.out.println(i);
        return 0;
    }

    public static ArrayList<Integer> elementswitch(ArrayList<Integer> liste, Integer element){
        System.out.println(liste);
        liste.remove(element);
        liste.add(0, element);

        System.out.println(liste);
        return liste;
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

    
    
}

// test text zum comment

