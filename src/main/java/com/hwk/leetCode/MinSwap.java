package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MinSwap {
	
	 public List<List<Integer>> permuteUnique(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 
		 for(int i = 0 ; i < nums.length ; i ++) {
			 List<Integer> list1 = new ArrayList<Integer>(nums.length);
			 
			 
			 
			 list.add(list1);
		 }
		 
		 
		 return list;
	 }
	 
	 
	 public boolean repeatedSubstringPattern(String s) {
	        int size = s.length();
	        
	        if((size & 1) == 1) {
	        	return false;
	        }
	        
	        int l = 0;
	        int r = size >> 1;
	        
		 	while(r < size) {
		 		if(s.charAt(l ++) != s.charAt(r ++)) {
		 			return false;
		 		}
		 	}
		 
	        return true;
	    }
	

	public static int minSwap(int[] A, int[] B) {
		Map<String,String> map = new ConcurrentHashMap<>();
		int[] cost = new int[] { 0, 1 };
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
					cost[0] = Math.min(cost[0], cost[1]);
					cost[1] = Math.min(cost[0], cost[1]) + 1;
				} else {
					cost[1] += 1;
				}
			} else {
				int t = cost[0];
				cost[0] = cost[1];
				cost[1] = t + 1;
			}
		}
		return Math.min(cost[0], cost[1]);
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			sum += nums[i];
		}

		if ((sum & 1) == 1) {
			return false;
		}

		sum >>= 1;
		boolean[][] dp = new boolean[size + 1][sum + 1];
		dp[0][0] = true;

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= sum; j++) {
				if (dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]])) {
					dp[i][j] = true;
				}
			}
		}

		return dp[size][sum];
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		int size = nums.length;
		int max = 0;
		for (int i = 0; i < size; i++) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}

		if (sum % k != 0 || sum / k < max) {
			return false;
		}

		sum /= k;
		int target = sum * (k - 1);
		boolean[][] dp = new boolean[size + 1][target + 1];
		dp[0][0] = true;

		for (int i = 1; i <= size; i++) {
			for (int j = 0; j <= target; j++) {
				if (dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]])) {
					dp[i][j] = true;
				}
			}
		}
		int i = 1;

		while (i < k) {
			if (!dp[size][i * sum]) {
				return false;
			}
			i++;
		}

		return true;
	}

	public static int findKthNumber(int m, int n, int k) {
		 int low = 1,
					high = m * n + 1;

					
					while( low < high) {
						int mid = (low + high)/2;
						int count = less(mid, m, n);
						if (count >= k) {
							high = mid;
						} else {
							low = mid + 1;
						}
					}

					return low;
				}

	// 计算比num小的值的总数
	public static int less(int num, int m, int n) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min(num / i, n);
		}
		return count;
	}

	public static void main(String[] args) {
//		System.out.println(minSwap(new int[]{0,3,5,8,9},new int[]{2,1,4,6,9}));
//		System.out.println(minSwap(new int[]{0,4,4,5,9},new int[]{0,1,6,8,10}));
//		System.out.println(minSwap(new int[]{3,3,8,9,10},new int[]{1,7,4,6,8}));
//		
//		System.out.println(canPartition(new int[] {1,5,11,5}));
//		System.out.println(canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1} , 4));
//		System.out.println(canPartitionKSubsets(new int[] {10,10,10,7,7,7,7,7,7,6,6,6},3));
		System.out.println(canPartitionKSubsets(new int[] { 2, 2, 2, 2, 3, 4, 5 }, 4));
	}
}
