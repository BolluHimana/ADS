/**
 * creating a class call node to pperform linked list action
 */
class Node{
    /**
     * Value is variable used to store the value int he place
     * variable next is used to store the next element.
     * prev is the variable which stores the previous element.
     */
    int value;
    Node next;
    Node prev;

    Node(int val) {
        this.value = val;
    }
}
/**
 * making a class called linked list, 
 *which have the vaiables head and tail to mainter as pointer
 */
class linkedList {
    Node head;
    Node tail;
    /**
     * addin elements to the linked list
     * @param val is the input given to store the value.
     */
    public void add(int val) {
        Node node = new Node(val);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    // here we form a circular list , so which removing a elemnt it will again stare a back.
    public void formCircle() {
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
}

