package com.hwk.leetCode.dp;

public class PredictTheWinner {

	public static void main(String[] args) {
//		System.out.println(proccse(new int[] { 3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512,
//				753594, 5474165, 4, 2697293, 8, 7, 1 }));
//		System.out.println(proccse(new int[] { 1, 1, 1 }));
//		System.out.println(proccse(new int[] { 1, 5, 2 }));
//		System.out.println(proccse(new int[] { 1, 5, 255, 2 }));
//		System.out.println(func(new int[] { 3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512,
//				753594, 5474165, 4, 2697293, 8, 7, 1 }));
		System.out.println(func(new int[] { 1, 1, 1 }));
		System.out.println(func(new int[] { 1, 5, 2 }));
		System.out.println(func(new int[] { 1, 5, 255, 2 }));
	}

	public static boolean func(int[] nums) {
		int n = nums.length;
		int[][] temp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					temp[i][j] = nums[i];
					continue;
				}
				temp[i][j] = Math.max(nums[i] - temp[i + 1][j], nums[j] - temp[i][j - 1]);
			}
		}
		return temp[0][n - 1] >= 0;
	}

	public static boolean proccse(int[] nums) {
		if (nums == null) {
			return false;
		} else if (nums.length < 3 || nums.length % 2 == 0) {
			return true;
		}
		int count = 0;
		int left = 0, right = nums.length - 1;

		boolean add = true;
		while (left < right) {
			boolean isleft = nums[left + 1] - nums[left] <= nums[right - 1] - nums[right];

			if (isleft) {

				count = count + (add ? nums[left++] : -nums[left++]);
			} else {
				count = count + (add ? nums[right--] : -nums[right--]);
			}

			add = !add;

		}

		return count + (add ? nums[right--] : -nums[right--]) >= 0;
	}
}
