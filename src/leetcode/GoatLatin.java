package leetcode;

import java.util.ArrayList;
public class GoatLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I speak Goat Latin";
		System.out.println(toGoatLatin(s));
	}

	public static String toGoatLatin(String S) {
		boolean new_start = true;
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> end = new ArrayList<Integer>();
		ArrayList<Character> str = new ArrayList<Character>();
		if (S.equals(" "))
			return " ";
		for (int i = 0; i < S.length(); i++) {
			if (new_start) {
				start.add(i);
				new_start = false;
			}
			if (S.charAt(i) == ' ') {
				end.add(i - 1);
				new_start = true;
			}
			if (i == S.length()-1) {
				end.add(i);
			}
		}
		for (int i = 0; i < start.size(); i++) {
			char current = S.charAt(start.get(i));
			if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u' || current == 'A'
					|| current == 'E' || current == 'I' || current == 'O' || current == 'U') {
				for (int j = start.get(i); j <= end.get(i); j++) {
					str.add(S.charAt(j));
				}
			} else {
				for (int j = start.get(i)+1; j <= end.get(i); j++) {
					str.add(S.charAt(j));
				}
				str.add(S.charAt(start.get(i)));
			}
			str.add('m');
			str.add('a');
			for (int k = 0; k <= i; k++) {
				str.add('a');
			}
			str.add(' ');

		}
        String s = "";
        for (int i = 0; i < str.size(); i++){
            s +=str.get(i);
        }
		return s;
	}

}
