/**
 * @author Bollu Himana
 */
import java.util.*;
public  class Solution {
    public static void main(String[] args) {
        //creating an obj
        BinarySearchST obj = new BinarySearchST (8);
        obj.put(100, 'h');
        obj.put(55, 'n');
        obj.put(12, 'p');
        obj.put(14, 'c');
        obj.put(10, 'v');
        System.out.println(obj.keys[0] + " " + obj.valuesArray[0]);
        System.out.println(obj.keys[1] + " " + obj.valuesArray[1]);
        System.out.println(obj.keys[2] + " " + obj.valuesArray[2]);

    }
}