package com.hwk.leetCode;

public class BitwiseComplement {
	
	// 5 2 101 1000 3
		// 7 0 111 1000 1
		// 10 5
		public static void main(String[] args) {
			System.out.println(process(5));
			System.out.println(process(7));
			System.out.println(process(10));

			System.out.println(isPerfectSquare(16));
			System.out.println(isPerfectSquare(14));
			
			System.out.println(dominantIndex(new int[] { 3, 6, 1, 0}));
			System.out.println(dominantIndex(new int[] { 1, 2, 3, 4}));
		}


	public static int dominantIndex(int[] nums) {
		int max = 0,maxindex = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(max < nums[i] ) {
				max = nums[i];
				maxindex = i ;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i != maxindex && max >> 1 < nums[i]) {
				return -1;
			} 
		}

		return maxindex;
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		if (num < 4) {
			return false;
		}
		long left = 1;
		long right = num;
		while (left <= right) {
			long mid = (long) (left + ((right - left) >> 1));
			long temp = mid * mid;
			if (temp < num) {
				left = mid + 1;
				continue;
			} else if (temp == num) {
				return true;
			} else if (temp > num) {
				right = mid - 1;
			}
		}
		return false;
	}

	
	public static int process(int N) {
		StringBuilder sb = new StringBuilder();

		while (N != 0) {
			sb.insert(0, (N & 1) == 1 ? 0 : 1);
			N >>= 1;
		}
		while (sb.length() != 0) {
			N <<= 1;
			N += sb.charAt(0) - '0';
			sb.deleteCharAt(0);
		}
		return N;
	}
}
