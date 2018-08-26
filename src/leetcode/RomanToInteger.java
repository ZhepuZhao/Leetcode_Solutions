package leetcode;

import java.util.*;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "IV";
		System.out.println(romanToInt(s));
	}

	public static int romanToInt(String s) {
		Map<String, Integer> matching = new HashMap<String, Integer>();
		int result = 0;
		matching.put("I", 1);
		matching.put("V", 5);
		matching.put("X", 10);
		matching.put("L", 50);
		matching.put("C", 100);
		matching.put("D", 500);
		matching.put("M", 1000);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				i = addNum('V', 'X', i, result, s, matching);
				continue;
			}
			if (s.charAt(i) == 'X') {
				i = addNum('L', 'C', i, result, s, matching);
				continue;
			}
			if (s.charAt(i) == 'C') {
				i = addNum('D', 'M', i, result, s, matching);
				continue;
			}
			result += matching.get("" + s.charAt(i));
		}
		return result;
	}

	public static int addNum(char a, char b, int i, int result, String s, Map<String, Integer> matching) {
		if (i < s.length() - 1) {
			if (s.charAt(i + 1) == a || s.charAt(i + 1) == b) {
				result += matching.get("" + s.charAt(i + 1)) - matching.get("" + s.charAt(i));
				i++;
			} else {
				result += matching.get("" + s.charAt(i));
			}

		} else {
			result += matching.get("" + s.charAt(i));
		}
		return i;
	}
}
