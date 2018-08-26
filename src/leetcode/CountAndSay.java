package leetcode;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(5);
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		String previous_sequence = "11";
		String current_sequence = "";
		int count = 1;
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < previous_sequence.length(); j++) {
				if (previous_sequence.charAt(j) == previous_sequence.charAt(j - 1)) {
					count++;
				} else {
					current_sequence = current_sequence + "" + count + previous_sequence.charAt(j - 1);
					count = 1;
				}
				if (j == previous_sequence.length() - 1) {
					current_sequence = current_sequence + "" + count + previous_sequence.charAt(j);
				}
			}
			count = 1;
			previous_sequence = current_sequence;
			current_sequence = "";
		}
		return previous_sequence;
	}

}
