package practice;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tesr234345346 {
    /**
     * 5 2 c d +  _> 30
     *  5 -2 4 C D 9 + + 27
     * @param args
     */
    public static void main(String[] args) {
       //String[] input= {"5", "2", "C",  "D", "+"};
        String[] input= {"5", "-2", "4",  "C", "D", "9", "+", "+"};
        System.out.println(logic(input));
        Stack<String> stack=new Stack<>();
        stack.push("HI");
        System.out.println("rrrr->"+stack.pop().equals("HI"));
        System.out.println(stack.size()) ;
        String sssss="()";
        System.out.println(sssss.charAt(0));
        System.out.println("(".equals(String.valueOf((sssss.charAt(0)))));
        System.out.println(isValid("()"));

    }

    public static  int logic(String[] ops){
        List<String> list = new ArrayList<String>();
        for(int idx=0; idx<ops.length; idx++){

            int current_size = list.size();
           if("D".equals(ops[idx])){
                list.add(String.valueOf(2*Integer.parseInt(list.get(current_size-1))));
            } else if("C".equals(ops[idx])){
                list.remove((idx-1));
            } else if("+".equals(ops[idx])){
                list.add(String.valueOf(Integer.parseInt(list.get(current_size-1))+Integer.parseInt(list.get(current_size-2))));

            } else {
                list.add(ops[idx]);
            }
        }
        //System.out.println(list);
        return list.stream().map(i->(Integer)(Integer.parseInt(i))).reduce(Integer::sum).orElse(0);
    }

    public static boolean isValid(String s) {
        if (s == null) return false; // Null check; return false for null input.

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Handle closing brackets
            else if (c == ')' || c == ']' || c == '}') {
                // Check if the stack is empty before popping
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            } else {
                // Invalid character found
                return false;
            }
        }
        // Check if there are unmatched opening brackets
        return stack.isEmpty();
    }
}
