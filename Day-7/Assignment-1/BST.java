/**
 * Binary search tree.
 * @author Bollu Himana.
 */
class BST<Key extends Comparable <Key>,Value>
{

    private Node root;             

    private class Node {
        private Key key;          
        private Value val;         
        private Node left, right;  
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    /**
     * @return true when tree is empty else false.
     * Complexity:O(1).
     */

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table.
     * Complexity:O(1).
     */
    public int size() {
        return size(root);
    }

    /**
     * @param x node.
     * @return size of the node.
     * Complexity:O(1).
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return true if this symbol table contains key, false otherwise
     * Complexity:O(n).
    */
    public boolean contains(Key key) {   
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key.
     * Complexity:O(n).
     */
    public Value get(Key key) {
        return get(root, key);
    }
    /**
     * @param x node.
     * @param key key.
     * @return value.
     * Complexity:O(n).
     */

    public  Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * @param key key.
     * @param val value.
     * complexity:O(n).
     */

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    /**
     * @param x node.
     * @param key key.
     * @param val value.
     * Complexity:O(n).
     */

    private  Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * Removes the smallest key and associated value from the symbol table.
     * Complexity:O(n).
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * @param x node.
     * @return node.
     * Complexity:O(n).
     */

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     * Complexity:O(n).
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * @param x node.
     * @return deleted node.
     * Complexity:O(n).
     */

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the specified key and its associated value
     * if the key is in this symbol table.
     * @param  key the key
     * Complexity:O(n).
     */
    public void delete(Key key) {
        root = delete(root, key);
    }
    /**
     * @param x node.
     * @param key key.
     * @return node.
     * Complexity:O(n).
     */

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * @return the smallest key in the symbol table.
     * Complexity:O(n).
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * @param x node.
     * @return node.
     * Complexity:O(n).
     */

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    /**
     * @return the largest key in the symbol table.
     * Complexity:O(n).
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * @param x node.
     * @return node.
     * Complexity:O(n).
     */

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /**
     * @param  key the key
     * @return the largest key in the symbol table less than
     * or equal to key
     * Complexity:O(n).
     */
    public Key floor(Key key) {        
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * @param x node.
     * @param key key.
     * @return node.
     * complexity:O(n).
     */

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    /**
    * @param  key the key
    * @return the smallest key in the symbol table greater
    * than or equal to key.
    * Complexity:O(n).
    */
    public Key ceiling(Key key) {        
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * @param x node.
     * @param key key
     * @return node.
     * Complexity:O(n). 
     */

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * This is the (k+1)st smallest key in the symbol table.
     * @param  k the order statistic
     * @return the key in the symbol table of rank k.
     * Complexity:O(n).
     */
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * @param x node.
     * @param key key
     * @return node.
     * Complexity:O(n).
     */
   
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }

    /**
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than key.
     * Complexity:O(n).
     */
    public int rank(Key key) {
        return rank(key, root);
    }

    /**
    * @param x node.
    * @param key key
    * @return node.
    * Complexity:O(n).
    */    
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    /**
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return the number of keys in the symbol table between lo and hi.
     * Complexity:O(n).
     */
    public int size(Key lo, Key hi) {
    if (lo.compareTo(hi) > 0) return 0;
    if (contains(hi)) return rank(hi) - rank(lo) + 1;
    else              return rank(hi) - rank(lo);
    }
}
