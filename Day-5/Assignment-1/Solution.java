/**
 * @author Bollu Himana
 */
class Solution {
    public static boolean isMinHeap(final double[] arr) {
        if (arr.length <= 0) {
            return false;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr.length > i / 2) {
                if (arr[i / 2] > arr[i]) {
                return false;
                }
            }
        }
        return true;
    }
}
