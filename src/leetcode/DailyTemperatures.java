package leetcode;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
		dailyTemperatures(t);
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int[] stack = new int[temperatures.length];
		int top = -1;
		int[] ret = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
				int idx = stack[top--];
				ret[idx] = i - idx;
			}
			stack[++top] = i;
		}
		return ret;
	}
}
