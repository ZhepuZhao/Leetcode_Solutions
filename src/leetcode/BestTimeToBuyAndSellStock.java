package leetcode;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,2,4 };
		System.out.println(maxProfit(arr));

	}

	public static int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;
		int profit = 0;
		int min_index = 0;
		int max_index = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[min_index] >= prices[i] && i < prices.length-1) {
				min_index = i;
				max_index = min_index + 1;
				profit = Math.max(profit, prices[max_index] - prices[min_index]);
			}
			if (prices[max_index] <= prices[i]) {
				max_index = i;
				profit = Math.max(profit, prices[max_index] - prices[min_index]);
			}
		}
		if (profit > 0) {
			return profit;
		} else {
			return 0;
		}

	}
}
