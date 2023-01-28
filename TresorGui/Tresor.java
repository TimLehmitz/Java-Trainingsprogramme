public class Tresor {
    int max = 9;
    int min = 1;
    
    public static int[] neuerCode(int max, int min){
    //System.out.println(max);
    //System.out.println(min);
    int zahl1 = (int)(Math.random()*(max-min+1)+min);
    int zahl2 = (int)(Math.random()*(max-min+1)+min);
    int zahl3 = (int)(Math.random()*(max-min+1)+min);

    int[] tresorpin = {zahl1, zahl2, zahl3};
    return tresorpin;
    }
}
