package leetcode;
import java.util.*;
public class NumberofLinesToWriteString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String S = "abcdefghijklmnopqrstuvwxyz";
		numberOfLines(w, S);
	}

	public static int[] numberOfLines(int[] widths, String S) {
		int line_count = 0;
		int num = 0;
		int[] result = new int[2];
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < widths.length; i++) {
			map.put((char) ('a' + i), widths[i]);
		}
		for (int i = 0; i < S.length(); i++) {
			while (num <= 100) {
				if (num + map.get(S.charAt(i)) > 100) {
					line_count++;
					i--;
					break;
				} else {
					num += map.get(S.charAt(i));
				}
			}
			num = 0;
		}
		result[0] = line_count;
		result[1] = num;
		return result;
	}

}
