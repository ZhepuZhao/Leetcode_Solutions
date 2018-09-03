package leetcode;

public class ShortestDistancetoACharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		char c = 'e';
		int[] a = shortestToChar(s,c);
		System.out.println(Integer.MAX_VALUE);
	}

	public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) prev = i;
            res[i] = i - prev;
        }
        
        prev = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) prev = i;
            res[i] = Math.min(res[i], prev - i);
        }
        return res;
//		int[] res = new int[S.length()];
//		for (int i = 0; i < res.length; i++) {
//			res[i] = -1;
//		}
//		int count = S.length();
//		for (int i = 0; i < S.length(); i++) {
//			if (S.charAt(i) == C) {
//				res[i] = 0;
//				count--;
//			}
//		}
//		int base = 0;
//		while (count > 0) {
//			for (int i = 0; i < S.length(); i++) {
//				if (res[i] == base) {
//					if (i - 1 >= 0) {
//						if (res[i - 1] == -1) {
//							res[i - 1] = res[i] + 1;
//							count--;
//						}
//						
//					}
//					if (i + 1 < S.length()) {
//						if (res[i + 1] == -1) {
//							res[i + 1] = res[i] + 1;
//							count--;
//						}
//						
//					}
//				}
//			}
//			base++;
//		}
//		return res;

	}
}
