import java.util.Scanner;
//import java.util.Arrays;
// fuer debug

public class Tresorspiel{

    public static void main(String[] args) {
        Scanner Scanner0 = new Scanner(System.in);  
        int geloesteTresore = 0;
        int fehlversuchszahl = 0;
        int max = 9;
        int min = 1;

        int summe  = 1;
        int produkt = 1;
    
        while(geloesteTresore < 5){
            // Random zahlen
            System.out.println("Generiere Code...");
            int[] code = Tresor.neuerCode(max, min);

            // zum Testen 
            //System.out.println("("+ code[0] +"|" + code[1] +"|"+ code[2]+")");

            // summe und Produkt der zahlen werden erzeugt
            summe  = code[0] + code[1] + code[2];
            produkt = code[0] * code[1] * code[2];

            // Info für den User
            System.out.println("Der naechste Tresor ist bereit");
            System.out.println("Summe: " + summe);
            System.out.println("Produkt: " + produkt);


            while(true){
            // Schleife solange bis der Nutzer die zahlen erraet
            
            // Eingabe der zu testeten kombination
            System.out.println("Zahl1: ");
            int testZahl1 = Scanner0.nextInt();

            System.out.println("Zahl2: ");
            int testZahl2 = Scanner0.nextInt(); 

            System.out.println("Zahl3: ");
            int testZahl3 = Scanner0.nextInt();


            // testcode array aus den testzahlen
            int[] testcode = {testZahl1,testZahl2,testZahl3};
            // temporaerer array
            int[] temparr = new int[code.length];
            // so wird der code nicht veraendert
            int[] tempcode = code;

            for(int j = 0; j < code.length ;j++){
                // schleife geht 3mal durch den code
                boolean antidouble = false;
                int element = testcode[j];
                for(int i=0, stelle=0;i<code.length;i++){
                    // wird getestet ob das elment im code ist 
                    // wenn ja wird diese 1mal aus dem code geloescht
                    if(tempcode[i]!=element){
                        temparr[stelle]=tempcode[i]; 
                    }
                    else if(antidouble){
                        temparr[stelle]= tempcode[i];
                    }
                    else {
                        temparr[stelle]= 0;
                        antidouble = true;
                    }
                    stelle++;
                }
                //debug code
                //System.out.println("Before deletion :" + Arrays.toString(tempcode));
                //System.out.println("After deletion :" +Arrays.toString(temparr));
                tempcode[0] = temparr[0];
                tempcode[1] = temparr[1];
                tempcode[2] = temparr[2];
            }
            
            if (tempcode[0] == 0 && tempcode[1] == 0 && tempcode[2] == 0 ){
                // wenn alle 3 azhlen richtig sind 
                geloesteTresore++;
                System.out.println("Geloeste Tresore: ("+ geloesteTresore + "|5)" );
                break;
            }
            else {
                // falls nicht fehlermeldung + Fehlversuchscounter erhoehen 
                System.out.println("Eingabe fehlerhaft");
                fehlversuchszahl++;
            }


        }
        
        }
        System.out.println("Geschaft du hast das Spiel geschlagen");
        System.out.println("Mit nur: " + fehlversuchszahl + " Fehlversuchensuchen");
        Scanner0.close();

    }
}
