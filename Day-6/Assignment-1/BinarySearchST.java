/**
 * BinarySearchST
 * @author Bollu Himana
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Value[] valuesArray;
    private Key[] keys;
    private int count = 0;
    private int arrSize = 20;
    /**
     * constructor to initialise Arrays
     */
    public BinarySearchST() {
        keys = (Key[]) new Comparable[20];
        valuesArray = (Value[]) new Object[20];

    }
    /**
     *
     * @param key keys to put
     * @param val values to put.
     * Complexity is O(n) in all cases.
     */
    public void resize(final Key key, final Value val) {
        Key[] k1 = (Key[]) new Comparable[count * 2];
        Value[] v1 = (Value[]) new Object[count * 2];
        for (int i = 0; i < count; i++) {
            k1[i] = keys[i];
            v1[i] = valuesArray[i];
        }
        keys = k1;
        valuesArray = v1;
        int index = rank(key);
        if (contains(key)) {
            valuesArray[index] = val;
        }
    }

    /**
     * @return count.
     * Complexity is O(1).
     */
    public int size() {
        return count;
    }

    /**
     * @param key   key to place in array
     * @param value values to place in array.
     * Complexity is O(n) in all cases..
     */
    public void put(final Key key, final Value value) {
        if (count >= arrSize) {
            resize(key, value);
        } else {
            int index = rank(key);
            if (!contains(key)) {
                for (int k = count; k > index; k--) {
                    keys[k] = keys[k - 1];
                    valuesArray[k] = valuesArray[k - 1];
                }
                keys[index] = key;
                valuesArray[index] = value;
                count++;
            } else {
                valuesArray[index] = value;
            }

        }
    }

    /**
     * @param k of key type
     * @return the position to be placed in array.
     * Complexity is O(logn) in worst cases and O(1) in best cases.
     */
    public int rank(final Key k) {
        int lo = 0;
        int hi = count - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * @param k key
     * @return whether key contains in it or not.
     * Complexity is O(n).
     */
    public boolean contains(final Key k) {
        for (int i = 0; i < size(); i++) {
            if (keys[i].equals(k)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @return max element in array.
     * Complexity is O(1).
     */
    public Key max() {
        return keys[count - 1];
    }

    /***
     * @param key
     * @return the value of specified key.
     * Complexity is O(1)
     */
    public Value get(final Key key) {
        if (count == 0) {
            return null;
        }
        int index = rank(key);
        if (index < count && keys[index].compareTo(key) == 0) {
            return valuesArray[index];
        } else {
        return null;
        }
    }
    /**
     * @return the largest key less than or equal to key.
     * Complexity is O(1)
     * @param key
     */
    public Key floor(final Key key) {
        int index = rank(key);
        if (index < count && keys[index].compareTo(key) == 0) {
            return keys[index];
        } else {
            return keys[index - 1];
        }
    }
    /**
     * delete smallest key.
     * Complexity is O(n)
     */
    public void deleteMin() {
        for (int i = 0; i < count - 1; i++) {
            keys[i] = keys[i + 1];
            valuesArray[i] = valuesArray[i + 1];
        }
        keys[count - 1] = null;
        valuesArray[count - 1] = null;
        count--;
    }
    /**
     * Iterable method
     * Complexity:O(n).
     * @return key
     */
    public Iterable<Key> keys() {
        ResizingArrayQueue queue = new ResizingArrayQueue();      
        for (int i = 0; i < count; i++)
            queue.enqueue(keys[i]);
        return queue;
    }
}
