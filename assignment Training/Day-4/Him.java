import java.util.*;
/**
 * @author Bollu Himana
 */
public class Him{
    public MinPQ meth(double[] arr, double[] arr1, int s) {
        MinPQ pq = new MinPQ();
        //Time complexity O(n)
        for(int i=0;i<arr.length;i++){
        pq.insert(arr[i]);
    }
    for(int i= (arr.length-1)-s;i>=0;i--){
    arr1[i] = pq.delMin();
    }
    return pq;
    }
    public static void main(String[] args){
        //creating an object for the class.
        Him o = new Him();
        double[] arr = {9,5,1,3,8,6,7,2,10}; // Taking elements into an array.
        int s=4;
        double[] arr1 = new double[arr.length-s];
        System.out.println(Arrays.toString(o.meth(arr, arr1, s).PQ));

    }
}