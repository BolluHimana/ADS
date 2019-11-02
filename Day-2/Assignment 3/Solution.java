/**
 * @author Bollu Himana
 */
import java.util.Stack;
class Solution{
    public static String isMatching(String str){
        // fill you code Here
        if(str.charAt(0) == ')' || str.charAt(0) == ']' || str.charAt(0) == '}'){
            return "NO";
        }
        /**
         * declaring a variable of name s.
         */
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){ 
            /**
             * checking the condition for all the open cases.
             */
            if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '('){
                s.push(str.charAt(i));
            }else if(str.charAt(i) == '}'){
                if(s.pop() == '{'){
                    continue;
                }else return "NO";
            }else if(str.charAt(i) == ')'){
                if(s.pop() == '('){
                    continue;
                }else return "NO";
            }else if(str.charAt(i) == ']'){
                if(s.pop() == '['){
                    continue;
                }else return "NO";
            }else break;

        }if(s.size() == 0){
            return "YES";
        }return "NO";
    }
}