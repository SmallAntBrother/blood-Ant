package com.hwk.leetCode;

public class MinSubArrayLen {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(stoneGame(new int[] { 5, 3, 4, 5 }));
		System.out.println(stoneGame(new int[] { 3, 7, 3, 2, 5, 1, 6, 3, 10, 7 }));
	}
	
	
	
	

	// [3,7,3,2,5,1,6,3,10,7]
	public static boolean stoneGame(int[] piles) {
		int num = 0;

		boolean add = true;
		for(int pile : piles) {
			num += add ? pile : -pile;
			add = !add;
		}
		

		return num > 0;
	}

	/**
	 * 
	 * @param s    7 11
	 * @param nums [2,3,1,2,4,3], 1,2,3,4,5
	 * @return 2 , 3
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int minLenght = Integer.MAX_VALUE;

		int left = 0;
		int right = 0;
		int num = 0;

		while (right != nums.length) {
			if (num <= s) {
				num += nums[right++];
			} else {
				minLenght = Math.min(right - left, minLenght);
				num -= nums[left++];
			}
		}

		if (num <= s) {
			num += nums[right++];
		} else {
			minLenght = Math.min(right - left--, minLenght);
		}

		return minLenght;
	}
}
