package leetcode;

import java.util.*;
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		List<String> list = new ArrayList<String>();
		list.add("cats");
		list.add("dog");
		// list.add("sand");
		list.add("and");
		list.add("cat");
		list.add("an");
		System.out.println(wordBreak(s, list));
	}
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for (String c : wordDict) {
            set.add(c);
        }
        int start = 0;
        int end = 0;
        int first_end = 0;
        while (first_end < s.length()) {
            while (end < s.length()) {
                if (set.contains(s.substring(start, end + 1))) { // substring does not contain the end index char
                    if (end == s.length()-1) {
                        return true;
                    }
                    if (first_end == 0) {
                        first_end = end + 1;
                    }                    
                    start = end + 1;
                    end = end + 1;

                } else {
                    end++;
                }                
            }
            end = first_end;
            if (first_end == 0) {
                return false;
            } else {
                first_end = 0;
            }
            start = 0;
            
        }
        return false;
        
        
    }

}
