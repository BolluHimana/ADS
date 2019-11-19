/**
 * @author Bollu Himana
 */
public class MinPQ {
    double[] PQ;
    int size;
    public MinPQ() {
        PQ = new double[10];
        size = 0;
    }
    // to check whether empty or not.
    public boolean isEmpty() {
        return size == 0;
    }
    //inserting a value
    public void insert(double s) { 
     PQ[++size] = s;
     swim (size);
    }
    public double  delMin() {
    double Min = PQ[1];
    exch(1,size--);
    sink(1);
    PQ[size+1] = 0;
        return Min;
    }
    // compares two values and returns true if 1st value is greater than second.
    public boolean high (int u, int v ) {
        if(PQ[u] > PQ[v]) {
            return true;
        }
        return false;
    }
    // to swap two values
    public void exch(int i ,int j) {
        double k = PQ[i];
        PQ[i] = PQ[j];
        PQ[j] = k;
    }
    // checks and swaps two values according to the heap( inserting- bottom up )
    public void swim(int p) {
        while( p > 1 && high(p/2,p)){
            exch(p/2,p);
            p = p/2;
        }
    }
     // checks and swaps two values according to the heap( deleting- top down )
    public void sink( int k){
        while(2*k <= size){
        int j = 2*k;
        if(j < size && high(j,j+1)){
            j++;
        }
        if(!high(k,j)) break;
        exch(k,j);
        k = j;
        }
    }
    // to get size
    public int size(){
        return size;
    }
}