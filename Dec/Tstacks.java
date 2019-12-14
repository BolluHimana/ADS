import java.util.*;
class Tstacks{
    static Stack<Integer> s1 = new Stack<Integer>();  
    static Stack<Integer> s2 = new Stack<Integer>();
    public int Dequeue(){
        int c=0;
        while(!s1.isEmpty()){
            s2.push(s1.pop());
            c=c+1;
        if(c>0){
        int a = s2.pop();
        return a;
        }
    }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
            int a = s1.pop();
            return a;

    }
    return 0;
}
    public static void main(String[] args){
        Tstacks ts = new Tstacks();
        s1.push(25);
        s1.push(75);
        s1.push(15); 
        s1.push(3);
        s1.push(9);
        s2.push(10);
        s2.push(55);
        s2.push(95);
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
        System.out.print(ts.Dequeue()+" ");
    }

}