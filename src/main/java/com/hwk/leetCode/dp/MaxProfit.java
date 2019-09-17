package com.hwk.leetCode.dp;

import java.util.Stack;

public class MaxProfit {

	public static void main(String[] args) {
		System.out.println(process(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(process(new int[] { 7, 6, 4, 3, 1 }));

		System.out.println(processII(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(processII(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(processII(new int[] { 7, 6, 4, 3, 1 }));

		System.out.println(maxProfit3(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }, 0));
		System.out.println(maxProfit3(new int[] { 1, 2, 3, 4, 5 }, 0));
		System.out.println(maxProfit3(new int[] { 7, 6, 4, 3, 1 }, 0));
	}


	public static int maxProfit3(int[] prices, int day) {
		if (prices.length < 2)
			return 0;
		if (prices.length == 2)
			return Math.max(0, prices[1] - prices[0]);
		int max = 0;
		for (int i = 2; i < prices.length; i++) {
			max = Math.max(processIII(prices, 0, i - 1) + processIII(prices, i - 1, prices.length - 1), max);
		}
		return max;
	}
	
	
	public static int processIII(int[] prices,int start,int end) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = start; i <= end; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}

		return max;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static int processII(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int temp = prices[i] - prices[i - 1];
			max += temp > 0 ? temp : 0;
		}

		return max;
	}

	public static int process(int[] prices) {
		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length - 1; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i + 1] - min);
		}

		return max;
	}
}
