import java.util.Scanner; // Import the Scanner class
import java.util.concurrent.ThreadLocalRandom; // needed Random Class part

public class TripleX {

    static void printIntroduction(int Difficulty) {
        System.out.println("\nDu bist ein Tresorknacker und du raubst gerade einen Tresor mit dem Level " + Difficulty
                + " aus...");
        System.out.println("Gib den korrekten Tresorcode (mit Leerzeichen getrennt) ein um fortzufahren...\n");
    }

    static void sort(int arr[]) {
        for (int i : arr) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int buffer = j;
                    arr[i] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
    }

    static boolean playGame(int Difficulty, Scanner myScanner) {

        printIntroduction(Difficulty);

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        // Generate Code
        int CodeA = ThreadLocalRandom.current().nextInt(0, Difficulty * 2) + 1;
        int CodeB = ThreadLocalRandom.current().nextInt(0, Difficulty * 2) + 1;
        int CodeC = ThreadLocalRandom.current().nextInt(0, Difficulty * 2) + 1;

        int arr[] = { CodeA, CodeB, CodeC };
        sort(arr);

        final int CodeSum = CodeA + CodeB + CodeC;
        final int CodeProduct = CodeA * CodeB * CodeC;

        // Print CodeSum and CodeProduct to the terminal
        System.out.println("+ Der Code ist 3 Zahlen lang");
        System.out.println("+ Der Code ergibt addiert: " + CodeSum);
        System.out.println("+ Multipliziert ergibt der Code: " + CodeProduct + "\n");
        // DEBUG - KEEP AS COMMENT WHEN PLAYING
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);

        // Store player guess
        int GuessA = myScanner.nextInt();
        int GuessB = myScanner.nextInt();
        int GuessC = myScanner.nextInt();

        int GuessSum = GuessA + GuessB + GuessC;
        int GuessProduct = GuessA * GuessB * GuessC;

        // Check if the players guess is correct
        if (GuessSum == CodeSum && GuessProduct == CodeProduct) {
            if (Difficulty == 5) {
                return true;
            }

            System.out.println("\n\n*** Sehr gut! Du hast den Tresor geknackt! Mach weiter! ***");
            return true;
        } else {
            System.out.println("*** Du hast den falschen Code eingegeben! Sei vorsichtig! Versuch es nochmal! ***");
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in); // Create a Scanner object

        int LevelDifficulty = 1;
        final int MaxDifficulty = Integer.valueOf(args[0]);

        while (LevelDifficulty <= MaxDifficulty) // Loop game until all levels completed
        {
            boolean bLevelComplete = playGame(LevelDifficulty, myScanner);

            if (bLevelComplete) {
                ++LevelDifficulty;
            }
        }
        System.out.println(
                "\n*** Grossartige Arbeit! Du hast alle Tresore geknackt! Du bist der beste Einbrecher aller Zeiten ***\n");
        System.out.println("\n Druecke Enter zum Beenden des Spiels...");

        myScanner.close(); // Closing the Scanner
        return;
    }
}