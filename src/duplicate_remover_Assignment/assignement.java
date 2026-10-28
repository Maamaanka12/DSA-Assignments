package duplicate_remover_Assignment;
import java.util.Stack;

public class assignement {


    //Problem Description
    //You are given a String s containing lowercase English letters. Your task is to repeatedly remove two identical
    //characters that appear next to each other. Whenever two adjacent characters are the same, both characters must
    //be removed. Continue until no adjacent duplicate characters remain.
    //Return the final String. You must use a Stack to solve the problem without using arrays.

    //Requirements
    //• Use Stack<Character> to store characters.
    //• Use push(), pop(), peek(), and isEmpty() where appropriate.
    //• Remove adjacent duplicate pairs as they appear; this may create new duplicate pairs.
    //• Return the remaining characters in the original order.
    //• Do not use arrays, recursion, replace(), or replaceAll(). StringBuilder is allowed.
    //
    //Constraints
    //• 1 ≤ s.length() ≤ 100,000.
    //• s contains only lowercase English letters (a–z).
    //• Use Stack<Character>; arrays are not allowed.
    //• The solution must run in O(n) time




    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();

            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }



    //+marks
//
//
//    public String removeTriples(String s) {
//
//        Stack<Character> chars = new Stack<>();
//        Stack<Integer> counts = new Stack<>();
//
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (!chars.isEmpty() && chars.peek() == c) {
//
//                int count = counts.pop() + 1;
//
//                if (count == 3) {
//                    chars.pop();
//                } else {
//                    counts.push(count);
//                }
//
//            } else {
//                chars.push(c);
//                counts.push(1);
//            }
//        }
//
//
//    }


}

