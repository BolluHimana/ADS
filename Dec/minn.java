import java.util.*;

public class minn{
    private int[] pq;
    private int n;
    int min=10000;
    minn(){
     pq = new int[10];
     n=0;
    }   
    public minn(int capacity){
        pq= new int[capacity+1];
        n=0;
    } 
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public int max(){
        return pq[1];
    }

    public void insert(int x){
         if(min>x){
            min = x;
         }
        pq[++n]=x;
        swim(n);
    }
    public int delMax(){
    if(isEmpty()) throw new NoSuchElementException("priority underflow");
    int max=pq[1];
    exch(1,n--);
    sink(1);
    pq[n+1]=0;
    return max;
    }
    public void swim(int k){
        while(k>1 &&k/2<k){
            exch(k,k/2);
            k=k/2;
        }
    }
    public void sink(int k){
        while(2*k<=n){
            int j=2*k;
            if(j<n && j<j+1) j++;
            if(!(k<j)) break;
            exch(k,j);
            k=j;
        }
    }
    public void exch(int i,int j){
        int swap=pq[i];
        pq[i]=pq[j];
        pq[j]=swap;
    }
    public int min(){
        return min;
    }
    public static void main(String[] args){
        minn mn= new minn();
        mn.insert(55);
        mn.insert(25);
        mn.insert(4);
        mn.insert(78);
        mn.insert(45);
        System.out.println(mn.min());
    }
}