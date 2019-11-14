/**
 * @author Bollu Himana
 * complexity O(n)
 */
import java.util.*;
public class Farthest {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n <= 1){
        System.out.println("give another input");
        n = sc.nextInt();
        }
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            double r = sc.nextDouble();
            arr[i] = r;
        }
        //Arrays.sort(arr); it gives complexity of nlogn.
        double min = arr[0];
        double max = arr[0];
        for (int j = 0; j < arr.length; j++) { //to get min value from array.
            if (arr[j] < min) {
               min = arr[j];
            }
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        // double a = min-max;
         System.out.println("number1:" + max + " " + "number2:" + min);
    }
}

