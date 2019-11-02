/**
 * @author Bollu Himana
 */
import  java.util.*;
class ThreeSum { 
	public static int method1() {
	int[] arr = {-1,-3,-4,0,1,3,4};
	Arrays.sort(arr); 
	int n=arr.length;; 
	int c=0;
	for (int i=0; i<n-1; i++) 
	{ 
		int before = i + 1; 
		int next = n - 1; 
		while (before < next) 
		{ 
			if (arr[i] + arr[before] + arr[next] == 0) 
			{ 
				c++;	
				before++; 
				next--;  
			} 
			else if (arr[i] + arr[before] + arr[next] < 0) 
				before++; 
			else
				next--; 
		} 
	} 
	return c;
 }

	public static void main (String[] args) { 

	System.out.println(method1());
    }
}