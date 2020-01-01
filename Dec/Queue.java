import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class for resizing arrays.
 * @author Bollu Himana.
 */
public class Queue<Item> implements Iterable<Item> {
    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot
    /**
     * Initializes an empty queue.
     * Complexity:O(1).
     */
    public Queue() {
        q = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }
    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     * Complexity:O(1).
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     * Complexity:O(n).
     */
    public int size() {
        return n;
    }

    /**
     * @param capacity capacity.
     * Complexity:O(n).
     */

    private void resize(final int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(final Item item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2 * q.length);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length) last = 0;          // wrap-around
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     * Complexity:O(1).
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = q[first];
        q[first] = null;                       
        n--;
        first++;
        if (first == q.length) {
            first = 0;
        }
        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }
    /**
     * toString method.
     * Complexity:O(n).
     * @return s
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < last; i++) {
            s += q[i] +" ";  
        }
        return s;
    }
    /**
     * Returns an iterator that iterates over the items in FIFO
     * @return an iterator that iterates over the items in FIFO
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {
        return i < n;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}