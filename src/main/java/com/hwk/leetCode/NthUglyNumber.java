package com.hwk.leetCode;

public class NthUglyNumber {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(nthUglyNumber(1226));
		System.out.println(System.nanoTime() - start);

		start = System.nanoTime();
		System.out.println(nthUglyNumberDP(1226));
		System.out.println(System.nanoTime() - start);
	
	}
	
	public static int nthUglyNumber(int n) {
		int num = 0;
		int count = 0;
		while(count < n) {
			num ++;
			if(vailnthUgly(num)){
				count ++;
				//System.out.println(count++ + ":" + n);
			}
		}
		
		return num;
    }
	
	private static boolean vailnthUgly(int n) {
		if(n < 7) {
			return true;
		}
		return n % 2 == 0 || n % 3 == 0 || n % 5 == 0;
	}

	public static int nthUglyNumberDP(int n) {
		int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }

        return dp[n - 1];
    }
}
