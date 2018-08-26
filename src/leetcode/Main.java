package leetcode;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print('1' > '3');
		for (char j = '0'; j <= '9'; j++) {
    		System.out.println(j);
    	}
		char[] c = {'a','s'};
		String s = new String(c);
		System.out.println(solution("23:00"));
	}
    public static int solution(int[] A, int K, int M) {
        // write your code in Java SE 8
        int[] count = new int[A.length]; // index is the rose number
        int temp_m = -1;
        for (int i = 0; i < A.length; i++) { // 
        	count[A[i] - 1] = 1;
        	int k_count = 0;
        	int m_count = 0;
        	for (int j = 0; j < count.length; j++) {
        		if (count[j] == 0 && k_count >= K) {
        			m_count++;
        			k_count = 0;
        			
        		} else if (count[j] != 0) {
        			k_count++;
        		}
        	}
        	if (k_count >= K) m_count++;
        	if (M <= m_count && i < A.length) {
        		temp_m = m_count;
        	} else if (M > m_count && i < A.length){
        		if (temp_m != -1) {
        			return i;
        		}
        		continue;
        	}
        }
        return -1;
    }
    public static String solution(String S) {
        // write your code in Java SE 8
        char[] digits = S.toCharArray();
        char[] result = digits.clone();
        Set<Character> set = new HashSet<Character>();
        for (char c : digits) {
        	set.add(c);
        }
        for (int i = digits.length - 1; i >= 0; i--) {
        	if (digits[i] != ':') {
            	for (char j = '9'; j >= '0'; j--) {
            		if (set.contains(j) && j < digits[i]) {
            			result[i] = j;
            			for (int k = i + 1; k < digits.length; k++) {
            				if (digits[k] != ':') {
                            	for (char l = '9'; l >= '0'; l--) {
                            		if (set.contains(l) && l > digits[k]) {
                            			result[k] = l;
                            			break;
                            		}
                            	}
            				}
            			}
            			return new String(result);
            		}
            	}
        	}
        }
        return new String(result);
    }

}
