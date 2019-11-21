/**
 * @author Bollu Himana
 * refernce Bob Sedgewick
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;         
    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  
        private int size;

        //parameterised constructor.         
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    //checks whether it is empty or not.
    
    public boolean isEmpty() {
        return size() == 0;
    }

    //return size of bst.
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    //to get value of the node based on key.
    public Value get(Key key) {
        return get(root, key);
    }

    //gets value based on key(recursion).
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    //insert a node with key and value.
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    //insertion is done using recursion.
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    //returns min key.
    public Key min() {
        return min(root).key;
    }

    //returns min node.
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    //returns max key.
    public Key max() {
      return max(root).key;
    }

    //returns max node.
    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }

    //checks whether all keys are in between min and max.
    private boolean isOrdered() {
        return isOrdered(root, min(), max());
    }

    //checks whether all keys are in between min and max using recursion.
    private boolean isOrdered(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) < 0) return false;
        if (max != null && x.key.compareTo(max) > 0) return false;
        return isOrdered(x.left, min,max) && isOrdered(x.right, min, max);
    }
    
    public static void main(String[] args) {
        //creating an object.
        BST bs = new BST();
        bs.put("h",17);
        bs.put("p",26);
        bs.put("C",14);
        bs.put("v",10);
        bs.put("n",5);
        System.out.println(bs.isOrdered());
    }
}