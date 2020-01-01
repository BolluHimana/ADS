
public class Bst {
     Node root;       
     class Node {
     int key;           
     int val;         
     Node left, right;  
     int size;          

    public Node(int key, int val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public Bst() {
    }
    public boolean isEmpty() {
        return size() == 0;
    }
        public int size() {
        return size(root);
    }
    public int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    public boolean contains(int key) {
        return get(key) != -1;
    }
    public int get(int key) {
        return get(root, key);
    }

    private int get(Node x, int key) {
        if (x == null) return -1;
        if      (key < x.key) return get(x.left, key);
        else if (key > x.key) return get(x.right, key);
        else              return x.val;
    }

    public void put(int key, int val) {
        root = put(root, key, val);
    }

    private Node put(Node x, int key, int val) {
        if (x == null) return new Node(key, val, 1);
        if      (key < x.key) x.left  = put(x.left,  key, val);
        else if (key> x.key) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node x, int key) {
        if (x == null) return null;
        if      (key < x.key) x.left  = delete(x.left,  key);
        else if (key > x.key) x.right = delete(x.right, key);
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
    public int min() {
        return min(root).key;
    } 
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    public int max() {
        return max(root).key;
    } 
    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 
    public int rank(int key) {
        return rank(key, root);
    } 
    private int rank(int key, Node x) {
        if (x == null) return 0; 
        if      (key < x.key) return rank(key, x.left); 
        else if (key > x.key) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    public static void main(String[] args) { 
        Bst bs = new Bst();
        bs.put(1,11111);
        bs.put(2,22222);
        bs.put(3,33333);
        System.out.println(bs.get(1));
        System.out.println(bs.height());
        bs.delete(1);
        System.out.println(bs.get(1));
}
}