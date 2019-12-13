import java.util.*;
class Cpostfix{
public static int Postfix(String str) {
        int r;
        Stack s3 = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3'
                    || str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7'
                    || str.charAt(i) == '8' || str.charAt(i) == '9') {
                char p = str.charAt(i);
                s3.push(p);
            } else {
                int a = Integer.parseInt("" + s3.pop());
                int b = Integer.parseInt("" + s3.pop());
                if (str.charAt(i) == '+') {
                    s3.push(a + b);
                } else if (str.charAt(i) == '-') {
                    s3.push(a - b);
                } else if (str.charAt(i) == '*') {
                    s3.push(a * b);
                } else if (str.charAt(i) == '/') {
                    s3.push(a / b);
                }
            }
        }
        r = Integer.parseInt("" + s3.pop());
        return r;
    }

    public static void main(String[] args) {
        System.out.println("enter experssion");
        Cpostfix cpf = new Cpostfix();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("evalute it" + Postfix(str));


}
}