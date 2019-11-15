/** @author Bollu Himana
 * 
 */
class Solution {
    class Node {
        Node address;
        int item;
        Node (int i) {
            item = i;
            address = null;
        }
    }
    int n;
    Node last;
    Solution () {  
        n = 0;         
        last = null;
    }
    /**
     * adds an element into the queue
     * @param item,the element which is to be inserted into queue
     */
    public void enqueue (int item) {   // to add a new node
    if(n == 0) {
        last = new Node(item);
        last.address = last;
       // System.out.println(last.item);
        n++;
    }
    else if (n > 0) {                    
    Node temp1 = last;
    //System.out.println(temp1.item);
    last = new Node(item);
    // System.out.println(last.item);
    last.address = temp1.address;
    temp1.address = last;
    n++;
    }
    }
    /** it deletes an element from the queue 
     * @return int which is a deleted item
    */

    public int dequeue() {    // to delete
        if(n == 0)
            // System.out.println("........");
            return -1;
        else {
            int k = last.address.item;
            last.address = last.address.address;
            n--;
            return k;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();  
        s.enqueue(5);
        //System.out.println(s.last.item+" "+s.last.address.item);                
        s.enqueue(3);
        //System.out.println(s.last.item+" "+s.last.address.item);                

        s.enqueue(12);
        //System.out.println(s.last.item+" "+s.last.address.item);                

        //System.out.println(s.last.item);             
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());  
        System.out.println(s.dequeue());

        // s.enqueue(100);
        // System.out.println(s.dequeue());
        // System.out.println(s.dequeue());
    }
}