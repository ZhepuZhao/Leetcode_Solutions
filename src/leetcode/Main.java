package leetcode;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		
		int[][] team = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				team[i][j] = in.nextInt();
			}
		}
//		String s = in.next();
		in.close();
//		System.out.println(restoreIPAddresses(s));
		System.out.println(solution(team));
	}
	private int[] masks = {128, 64, 32, 16, 8};
	public int validUtf8(int[] data) {
		int len = data.length;
		for (int i = 0; i < len; i++) {
			int curr = data[i];
			int type = getType(curr);
			if (type == 0) {
				continue;
			} else if (type > 1 && i + type <= len) {
				while (type-- > 1) {
					if (getType(data[++i]) != 1) {
						return 0;
					}
				}
			} else {
				return 0;
			}
		}
		return 1;
//		if (data == null || data.length == 0) return 0;
//		int isValid = 1;
//		for (int i = 0; i < data.length; i++) {
//			if (data[i] > 255) return 0;
//			int numberOfBytes = 0;
//			if ((data[i] & 128) == 0) {
//				numberOfBytes = 1;
//			} else if ((data[i] & 224) == 192) {
//				numberOfBytes = 2;
//			} else if ((data[i] & 240) == 224) {
//				numberOfBytes = 3;
//			} else if ((data[i] & 248) == 240) {
//				numberOfBytes = 4;
//			} else {
//				return 0;
//			}
//			for (int j = 1; j < numberOfBytes; j++) {
//				if (i + j >= data.length) return 0;
//				if ((data[i + j] & 192) != 128) return 0;
//			}
//			i = i + numberOfBytes - 1;
//		}
//		return isValid;
	}
	
	public int getType(int num) {
		for (int i = 0; i < 5; i++) {
			if ((masks[i] & num) == 0) {
				return i;
			}
		}
		return -1;
	}
	public int restoreIPAddresses(String s) {
		List<String> ans = new ArrayList<String>();
		int[] path = new int[4];
		helper(ans, s, 0, path, 0);
		return ans.size();
	}
	public void helper(List<String> acc, String s, int idx, int[] path, int segment) {
		if (segment == 4 && idx == s.length()) {
			acc.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
			return;
		} else if (segment == 4 || idx == s.length()) {
			return;
		}
		for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
			int val = Integer.parseInt(s.substring(idx, idx + len));
			if (val > 255 || len >= 2 && s.charAt(idx) == '0') break;
			path[segment] = val;
			helper(acc, s, idx + len, path, segment + 1);
			path[segment] = -1;
		}
	}
	
	public static int solution(int[][] team) {
		int department_num = 0;
		int m = team.length;
		if (m == 0) return 0;
		int n = team[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (team[i][j] == 1) {
					reset(team, i, j);
					department_num++;
				}
			}
		}
		return department_num;
	}
	public static void reset(int[][] team, int i, int j) {
		int m = team.length;
		int n = team[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n || team[i][j] == 0) return;
		team[i][j] = 0;
		reset(team, i - 1, j);
		reset(team, i + 1, j);
		reset(team, i, j - 1);
		reset(team, i, j + 1);
	}
	

}
