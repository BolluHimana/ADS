/**
 * @author Bollu Himana
 * Merge sort
 * time complexity:O(nlogn)
 */
class Solution {
    /**
     * @param arr String arr
     * @return arr.
     */
	public static String[] mergeSort(final String[] arr) {
        String[] aux = new String[arr.length];
        sort(arr, aux, 0, arr.length-1);
        return arr;
    }
    private static void sort(String[] arr, String[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    /**
     * @param arr original array
     * @param aux aux array
     * @param lo lower bound array
     * @param mid middle element
     * @param hi higher bound array.
     */

    private static void merge(String[] arr, String[] aux, int lo, int mid, int hi) {
        
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k]; 
        }
        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              arr[k] = aux[j++];
            else if (j > hi)               arr[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) arr[k] = aux[j++];
            else                           arr[k] = aux[i++];
        }        
        
    }
}
