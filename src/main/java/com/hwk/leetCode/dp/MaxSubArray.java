package com.hwk.leetCode.dp;

public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(proccse(new int[] {-1,1,2,1}));
		System.out.println(proccse1(new int[] {-1,1,2,1}));
	}
	
	public static int proccse1(int[] nums) {
		int max = Integer.MIN_VALUE;
		int curMax = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < nums.length ; i ++) {
			curMax = curMax < 0 ? nums[i] : Math.max(nums[i], curMax + nums[i]);
			max = Math.max(max, curMax);
		}
		
		return max;
	}
	
	public static int proccse(int[] nums) {
		int[] dp = new int[nums.length];
		
		dp[0] = nums[0];
		int max = dp[0];
		for(int i = 1 ; i < nums.length ; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			max = Math.max(max, dp[i]);
			dp[i] = dp[i] > 0 ? dp[i] : 0;
		}
		
		
		return max;
	}
}
