import java.util.*;
public class Sentinel{
    public int[] Ssort(int[] arr){
            int i=0;
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            } 
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]= temp;
            int r,t;
            for(int k=2;k<arr.length;k++){
                r=k-1;
                t=arr[k];
                while(r>0 && arr[r]>t){
                arr[r+1]= arr[r];
                r--;
            }
            arr[r+1] = t;
            }
            return arr;
    }
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println("sorted "+arr[i]+"\n ");
        }
    }
    public static void main(String[] args) {
    int n;
    Sentinel sl = new Sentinel();
    Scanner sc = new Scanner(System.in);
    n=sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
     arr[i]=sc.nextInt();
    }
    sl.Ssort(arr);
    sl.print(arr);
    }
}