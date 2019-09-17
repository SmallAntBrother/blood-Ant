package com.hwk.leetCode;

public class GetMoneyAmount {

	public static void main(String[] args) {
		System.out.println(proccse(10));
		System.out.println(func(10));
	}
	
	
	public static int proccse(int n) {
		
		return proccse(0, 0, n);
	}
	
	public static int proccse(int total, int left, int right) {
		if(left >= right - 1) {
			return total;
		}
		left = (right - left ) / 2;
		return proccse(total + left, left ,right );
	}
	
	private static int func(int n) {
		int[][] dp = new int[n+1][n+1];
        for(int i = 2; i<=n; i++){
            for(int j = i - 1; j > 0; j--){
                if(j == i - 1){
                    dp[j][i] = j;
                    continue;
                }
                int globalMin = Integer.MAX_VALUE;
                for(int k = j + 1; k < i; k++){
                    int localMax = k + Math.max(dp[j][k-1],dp[k+1][i]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[j][i] = globalMin;
            }
        }
        return dp[1][n];
	}
}
