package leetcode;

import java.util.*;
public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abcd";
		String B = "cdabcdab";
		repeatedStringMatch(A, B);
	}
    public static int repeatedStringMatch(String A, String B) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                map.put(B.charAt(i), 1);
            } else {
                map.replace(B.charAt(i), map.get(B.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < A.length(); i++) {
            if (!map2.containsKey(A.charAt(i))) {
                map2.put(A.charAt(i), 1);
            } else {
                map2.replace(A.charAt(i), map2.get(A.charAt(i)) + 1);
            }
        }        
        for (int i = 0; i < B.length(); i++) {
            if (!map2.containsKey(B.charAt(i))) return -1;
        }
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.replace(A.charAt(i), map.get(A.charAt(i)) / map2.get(A.charAt(i)) + 1);
            }
        }
        int times = 0;
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            times = Math.max(times, entry.getValue());
        }
        return times;
        
    }

}
