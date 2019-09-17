package com.hwk.leetCode;

public class FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(process(new int[] {1,2,0}));
		System.out.println(process(new int[] { 3, 4, -1, 1 }));
		System.out.println(process(new int[] {7,8,9,10}));
		System.out.println(process(new int[] {1,1}));
		System.out.println(process(new int[] {2,1}));

		System.out.println(missingNumber(new int[] {1,3,0}));
//		System.out.println(missingNumber(new int[] { 3, 4, -1, 1 }));
//		System.out.println(missingNumber(new int[] {7,8,9,10}));
//		System.out.println(missingNumber(new int[] {1,1}));
//		System.out.println(missingNumber(new int[] {2,1}));
	}
	
	public static int findJudge(int N, int[][] trust) {
		for(int i = 0;i< trust.length; i ++) {
			if(trust[i][0] == N || trust[i][1] != N) {
				return -1;
			}
		}
		
		return N ;
	}
	
	public static int missingNumber(int[] nums) {
		int index = 0;

		while (index < nums.length) {
			int tmp = nums[index]; // index 0 tmp 2
			if (tmp == index || tmp < 0 || tmp >= nums.length) {
				index++;
			} else if (nums[tmp] != tmp) {
				nums[index] = nums[tmp];
				nums[tmp] = tmp;
			} else {
				index++;
			}
		}
		index = 0;
		while (index < nums.length) {
			if (index != nums[index]) {
				return index;
			}
			index++;
		}

		return nums.length;
	}

	public static int process(int[] nums) {
		int index = 0;

		while (index < nums.length) {
			int tmp = nums[index];
			if (tmp == index + 1 || tmp <= 0 || tmp > nums.length) {
				index++;
			} else if (nums[tmp - 1] != tmp) {
				nums[index] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			} else {
				index++;
			}
		}
		index = 0;
		while (index < nums.length) {
			if (index + 1 != nums[index]) {
				return index + 1;
			}
			index++;
		}

		return nums.length + 1;
	}
}
