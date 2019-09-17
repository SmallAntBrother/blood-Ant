package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 2, 3, 3 }));
		System.out.println(removeDuplicatesII(new int[] { 0, 0, 1, 1, 1, 1, 2, 2, 3, 3 }));

		System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100)); // 8

		System.out.println(numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3));
		System.out.println(numSubarrayBoundedMax(new int[] { 2,9,2,5,6 }, 2, 8));
	}

	/**
	 * A = [2, 1, 4, 3] L = 2 R = 3 return 3
	 */
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			if (L <= A[i] && A[i] <= R) {
				count++;
			}
			int tmp = A[i];

			for (int j = i + 1; j < A.length; j++) {
				tmp += A[j];
				if (L <= tmp && tmp <= R) {
					count++;
				} else {
					break;
				}
			}

		}
		return count;
	}

	public static int[] numsSameConsecDiff(int N, int K) {
		int[] list = new int[10];

		return list;
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				count++;
			}
			int tmp = nums[i];

			for (int j = i + 1; j < nums.length; j++) {
				tmp *= nums[j];
				if (tmp < k) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

	public static int removeDuplicatesII(int[] nums) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count < 2 || nums[i] > nums[i - 2]) {
				nums[count++] = nums[i];
			}
		}

		return count;
	}

	public static int removeDuplicates(int[] nums) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count < 1 || nums[i] > nums[i - 1]) {
				nums[count++] = nums[i];
			}
		}

		return count;
	}
}
