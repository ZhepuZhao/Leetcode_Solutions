package leetcode;

import java.util.*;
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		evalRPN(tokens);
	}
    public static int evalRPN(String[] tokens) {
        int result = 0;
        Set<String> set = new HashSet<String>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                int first = Integer.parseInt(s.pop());
                if (tokens[i].equals("+")) {
                    result = Integer.parseInt(s.pop()) + first;
                }
                if (tokens[i].equals("-")) {
                    result = Integer.parseInt(s.pop()) - first;
                }
                if (tokens[i].equals("*")) {
                    result = Integer.parseInt(s.pop()) * first;
                }
                if (tokens[i].equals("/")) {
                    result = Integer.parseInt(s.pop()) / first;
                }                
            } else {
                s.push(tokens[i]);
            }
        }
        return result;
    }

}
