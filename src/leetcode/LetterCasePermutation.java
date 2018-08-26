package leetcode;

import java.util.Hashtable;
import java.util.*;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
//		String a = "a";
//		StringBuilder sb = new StringBuilder();
//		a = a + 'a';
//		System.out.println(a);
		
	    String a = "a1b1";	    
	    List<String> list = letterCasePermutation(a);
	    System.out.println(list);
		
	}
	
    public static List<String> letterCasePermutation(String S) {
        ArrayList<String> s_list = new ArrayList<String>();
        HashMap<Integer, Integer> s_map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= 9; i++){
            s_map.put(i,1);
        }
        for (int i = 0; i < S.length(); i++){
            if (!s_map.containsKey(Character.getNumericValue(S.charAt(i)))){ // this means it's a letter
                String first_part = "";
                String last_part = "";
                if (i > 0){
                    first_part = S.substring(0, i);
                }
                
                if (i != S.length()-1){
                    last_part = S.substring(i+1, S.length());
                }
                String letter = "" + S.charAt(i);
                String to_append = first_part + letter.toLowerCase() + last_part;
                s_list.add(to_append); // add the lower case one
                to_append = first_part + letter.toUpperCase() + last_part;
                s_list.add(to_append); // add the upper case one
            }
        }
        return s_list;
    }

}
