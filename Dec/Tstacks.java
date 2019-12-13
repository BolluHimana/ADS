import java.util.*;
class Tstacks{
    int size;
    static Stack<Integer> s1 = new Stack<Integer>();  
    static Stack<Integer> s2 = new Stack<Integer>();

    public int Dequeue(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int a=s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return a;
    }
    public static void main(String[] args){
        Tstacks ts = new Tstacks();
        s1.push(25);
        System.out.println(ts.Dequeue());
        s1.push(75);
        s1.push(15); 
        s1.push(3);
        s1.push(9);
        System.out.println(ts.Dequeue());
        System.out.println(ts.Dequeue());
    }

}