/**
 * @author Bollu Himana
 * Quick sort
 * time complexity:O(nlogn)
 */
import java.util.Random;
class Solution{
	public static int[] quickSort(int[] arr){
		// StdRandom.shuffle(arr);
        //we are shuffling here because we should not get the worst time complixity.
		sort(arr, 0, arr.length - 1);
		return arr;
	}

    //here weare swaping the variable by using a temp variable
	private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //here the sorting technique is wriiten for quick sort.
	private static void sort(int[] arr, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
	}
    // here we are making partitioin so that it can dvide call the dsort meathod.
	private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {            
            while (arr[++i] < arr[lo]) {
                if (i == hi) break;
            }            
            while (arr[lo] < arr[--j]) {
                if (j == lo) break;      
            }           
            if (i >= j) break;
            /**we are callingg the meathid to replace elements with i and jwhen the condition
            *satisfied.
            */
            swap(arr, i, j);
        }       
        swap(arr, lo, j);        
        return j;
    }
	
	
}