import java.util.Scanner;

public class KmlxZahl{

        float imTeil = 0;
        float realTeil = 0;

static void zahlEingabe(int anzahl,KmlxZahl kZ1, KmlxZahl kZ2){
    /*  wird verwendet um den input des User entgegen zunehmen
        je nach gewuenschter Operation von 1(z.B. Betrag) oder 2(z.B. Addition)
        erkennung nach parameter int anzahl*/ 
    Scanner Scanner1 = new Scanner(System.in);
    switch (anzahl) {

        case 1:
        System.out.println("kZ1 imTeil: ");
        kZ1.imTeil  = Scanner1.nextInt();
        System.out.println("kZ1 realTeil: ");
        kZ1.realTeil  = Scanner1.nextInt();
            break;
    
        default:
        System.out.println("kZ1 imTeil: ");
        kZ1.imTeil  = Scanner1.nextInt(); 
        System.out.println("kZ1 realTeil: ");
        kZ1.realTeil  = Scanner1.nextInt();
        System.out.println("kZ2 imTeil: ");
        kZ2.imTeil  = Scanner1.nextInt();
        System.out.println("kZ2 realTeil: ");
        kZ2.realTeil  = Scanner1.nextInt();
            break;
    }
    Scanner1.close();
}

static void Addition(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // Addiert die Komplexen Zahlen kZ1 und kZ2 miteinander

    // zahlen einlesen
    KmlxZahl.zahlEingabe(2,kZ1,kZ2);

    // Rechneoperationen
    kZr.imTeil = kZ1.imTeil + kZ2.imTeil;
    kZr.realTeil = kZ1.realTeil + kZ2.realTeil;

    // Ausgabe
    System.out.println(kZr.realTeil + " + (" + kZr.imTeil + "i)" );

    }

static void Subtraktion(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // zahlen einlesen
    KmlxZahl.zahlEingabe(2,kZ1,kZ2);

    // Rechneoperationen
    kZr.imTeil = kZ1.imTeil - kZ2.imTeil;
    kZr.realTeil = kZ1.realTeil - kZ2.realTeil;

    // Ausgabe
    System.out.println(kZr.realTeil + " + (" + kZr.imTeil + "i)" );
}

static void Division(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // zahlen einlesen
    KmlxZahl.zahlEingabe(2, kZ1, kZ2);

    //Ausgabe
    System.out.println("Srry Programmierer zu faul das zu implementieren :( mach das mal per hand");
}

static void Multiplikation(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // zahlen einlesen
    KmlxZahl.zahlEingabe(2, kZ1, kZ2);

    // Rechenoperationen
    kZr.imTeil = ((kZ1.imTeil)*(kZ2.realTeil) + (kZ2.imTeil)*(kZ1.realTeil));
    kZr.realTeil = (kZ1.realTeil * kZ2.realTeil) + (kZ1.imTeil * kZ2.imTeil * (-1));

    // Ausgabe
    System.out.println(kZr.realTeil + " + (" + kZr.imTeil + "i)" );
}

static void Konjugation(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // zahlen einlesen
    KmlxZahl.zahlEingabe(1, kZ1, kZ2);

    // Rechenoperationen
    kZr.imTeil = kZ1.imTeil * (-1);
    kZr.realTeil = kZ1.realTeil;

    // Ausgabe
    System.out.println(kZr.realTeil + "+ (" + kZr.imTeil + "i )");

}

static void Betrag(KmlxZahl kZ1, KmlxZahl kZ2, KmlxZahl kZr){
    // zahlen einlesen
    KmlxZahl.zahlEingabe(1, kZ1, kZ2);

    // zur uebersichtlichkeit switch aus kZr
    kZr.realTeil = kZ1.realTeil;
    kZr.imTeil = kZ1.imTeil;

    // Rechen und Ausgabe
    System.out.println("Betrag: " + Math.sqrt(Math.pow(kZr.realTeil, 2) + Math.pow(kZr.imTeil, 2)));
}


}