package leetcode;

import java.util.Arrays;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// brute-force: time limit exceeded: 0.00001, 2147483647
		// myPow(0.00001, 2147483647);

	}

	public static double myPow(double x, int n) {

		// Time limit Exeeded

		long N = n; // this is because if we use int and n = - 2^31, then it doesn't work, becaues
					// the positive max
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		double ans = 1;
		for (long i = 0; i < N; i++) // here it should be long as well
			ans = ans * x;
		return ans;

		/*
		 * if (n > 0) { return pow(x, n); } else { return 1.0 / pow(x, -n); }
		 */

		// iterative solution
		/*
		 * if (n == 0) return 1; double result = 1; long abs = Math.abs((long) n); while
		 * (abs > 0) { if (abs % 2 != 0) { result *= x; } x *= x; abs /= 2; } if (n < 0)
		 * { return 1.0 / result; } else { return result; }
		 */

	}

}
