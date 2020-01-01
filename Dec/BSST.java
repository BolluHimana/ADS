
public class BSST {
    static final int INIT_CAPACITY = 8;
    int[] keys;
    int[] vals;
    int n = 0;

    public BSST() {
        this(INIT_CAPACITY);
    }
    public BSST(int capacity) { 
        keys = new int[capacity]; 
        vals = new int[capacity]; 
    }
    public int size() {
        return n;
    }
  public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(int key) {
        return get(key) != -1;
    }
    public int get(int key) {
        int i = rank(key); 
        if (i < n && keys[i]==key) return vals[i];
        return -1;
    }
    public int rank(int key) {
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            if      (key < keys[mid]) hi = mid - 1; 
            else if (key > keys[mid]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    }
    public void put(int key, int val)  {

        if (val == -1) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i]==key) {
            vals[i] = val;
            return;
        }

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public void delete(int key) {
        int i = rank(key);
        if (i == n || keys[i]!=key) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = -1;
        vals[n] = -1;
    }
    public void deleteMin() {
        delete(min());
    }
    public void deleteMax() {
        delete(max());
    }
    public int min() {
        return keys[0]; 
    }
    public int max() {
        return keys[n-1];
    }
    public static void main(String[] args) { 
        BSST st = new BSST(4);
        st.put(1,1111);
        st.put(2,2222);
        st.put(3,3333);
        for(int i=0;i<st.n;i++){
            System.out.println(st.keys[i]+"---------------"+st.vals[i]);
        }
    }
}
