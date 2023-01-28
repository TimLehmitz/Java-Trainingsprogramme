import java.util.Arrays;

/**
 * Sortieren
 */
public class Sortieren {

    public static void main(String[] args) {
    int[] unsortArr = {3,1,4,32,856,2};
    int[] sortArr = quicksort(unsortArr);
    System.out.println(Arrays.toString(sortArr));



    }

public static int[] quicksort(int[] unsortArr) {
    int iWert = 0;
    int jWert = 0;
    int pivotelement = unsortArr[unsortArr.length/2];
    System.out.println(pivotelement);

    for(int i = 0; i<= unsortArr.length-1;i++){
        if(unsortArr[i] >=pivotelement){
            iWert = i;
            break;
        }
    }
    for(int j = unsortArr.length-1; j>= 0;j++){
        if(unsortArr[j]<=pivotelement){
            jWert = j;
            break;
        }
    }

    System.out.println(iWert);
    System.out.println(jWert);

    int[] sortArr = unsortArr;
    return sortArr;
    
}






}