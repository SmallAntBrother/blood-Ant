package com.hwk.leetCode.dp;

public class NumArray {

	int[] dp = null;
	public NumArray(int[] nums) {
		dp = new int[nums.length];
		
		for(int i = 0 ; i < nums.length ; i ++) {
			dp[i] = i == 0 ? nums[i] : dp[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {

		return i == 0 ? dp[j] : dp[j] - dp[i - 1];
	}
	
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		
	}
}
