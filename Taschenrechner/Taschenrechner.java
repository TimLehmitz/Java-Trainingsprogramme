/**
 Taschenrechner für Komplexe Zahlen unterstützt:
    > Addition (2 Inputs)
    > Subtraktion (2 Inputs)
    > Multiplikation (2 Inputs)
    > Konjugation (nur 1 Input)
    > Betrag (nur 1 Input)
    > Division(2 Inputs) *hust*

 */
import java.util.Scanner;
public class Taschenrechner{
    public static void main(String[] args){
    

    Scanner Scanner1 = new Scanner(System.in);
    KmlxZahl kZ1 = new KmlxZahl();
    KmlxZahl kZ2 = new KmlxZahl();
    KmlxZahl kZr = new KmlxZahl();

    /*  kZ1 --> Komplexe Zahl 1
        kZ2 --> Komplexe Zahl 2
        kZr --> Komplexe Zahl Result
    */
    while (true){
        System.out.println("Was möchtest du tun?");
        System.out.println("Operationen: Addition, Subtraktion, Multiplikation, Konjugation, Betrag, Division, quit");
        String operation  = Scanner1.next();
        switch (operation) {

            case "Addition":
                KmlxZahl.Addition(kZ1, kZ2,kZr);
                break;

            case "Subtraktion":
                KmlxZahl.Subtraktion(kZ1, kZ2,kZr);
                break;

            case "Multiplikation":
                KmlxZahl.Multiplikation(kZ1, kZ2, kZr);
                break;

            case "Konjugation":
                KmlxZahl.Konjugation(kZ1, kZ2, kZr);
                break;

            case "Betrag":
                KmlxZahl.Betrag(kZ1, kZ2, kZr);
                break;

            case "Division":
                KmlxZahl.Division(kZ1, kZ2, kZr);
                break;
            
            case "quit":
                Scanner1.close();
                System.exit(0);
                break;

            default:
            System.out.println("Zu bloed eine valide Operation einzugeben? Versuche es nochmal. ");
                break;
            
            }

        }

    }

}

/* Allgemeine Fragen nach dem Programmieren 
    1. Scanner aus der Hauptdatei ließ sich nicht in der anderen datei aufrufen --> (hab den Scanner einfach nochmal erstellt)
    2. gibt es einen Weg Funktionsparameter mit default value zu erstellen, sodass diese nicht uebergeben werden muessen?
    (siehe KmlxZahl.zahlEingabe --> für Kz2 wird z.B. in der funktion für den Betrag gebraucht )
    3.Teilweise sind Sachen umstaendlich geloest bitte Ansaetze zum verbesser falls moeglich  

*/