package com.hwk.leetCode;

public class FindPaths {

	public static void main(String[] args) {
//		System.out.println(process(2, 2, 2, 0, 0)); // 6
//		System.out.println(process(1, 3, 3, 0, 1)); //12
		long start = System.currentTimeMillis();
//		System.out.println(process(8, 7, 16, 1, 5));
		System.out.println(process(5, 5, 5, 1, 2));
		System.out.println(System.currentTimeMillis() - start);
		
		System.out.println(processdp(2, 2, 2, 0, 0));
		System.out.println(processdp(1, 3, 3, 0, 1));
		
	}

	public static int processdp2(int m, int n, int N, int i, int j) {
		  /**
        动态规划, dp[i][j][k]表示从(i, j)开始在k步内移除边界的路径数. 
        可知dp[i][j][k]只与(i, j)四周邻接点在k-1步内移除边界的路径数有关. 
        dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
        空间优化: 可以看出重复利用一个二维数组储存路径数即可(k-1步更新之后就无需保存)
        **/
        
        // 无空间优化版
        if(N <= 0) return 0;
        int mod = 1_000_000_007;
        int[][][] dp = new int[m][n][N+1];
        
        int[][] dirs = {
	        			{-1, 0}, 
	        			{1, 0}, 
	        			{0, -1}, 
	        			{0, 1}
        			};
        
        for(int k = 1; k <= N; ++k) {
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        // 边界处理, 无论在第几步只要位置处于边界都包含一步出界的情况
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) 
                            dp[x][y][k] += 1;
                        else
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k-1]) % mod;
                    }
                }
            }
        }
        
        return dp[i][j][N];
	}
	public static int processdp(int m, int n, int N, int i, int j) {
		int[][] dp = new int[m][n];
		setDP(dp, i, j,0);
		
		int count = 0;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if(dp[x][y] != 0 && dp[x][y] < N) {
					count ++;
				}
			}
		}

		return count ;
	}

	private static void setDP(int[][] dp, int i, int j,int cur) {
		if(i < 0 || i == dp.length || j < 0 || j == dp[i].length || dp[i][j] != 0) {
			return;
		}
		dp[i][j] = cur + 1;
		setDP(dp, i + 1, j, dp[i][j]);
		setDP(dp, i - 1, j, dp[i][j]);
		setDP(dp, i, j + 1, dp[i][j]);
		setDP(dp, i, j - 1, dp[i][j]);
	}

	// (n * m * N) ^ 4
	public static int process(int m, int n, int N, int i, int j) {
		if (i < 0 || i == m || j < 0 || j == n) {
			return 1;
		}
		int count = 0;
		if (N > 0) {
			count = process(m, n, N - 1, i + 1, j) + process(m, n, N - 1, i - 1, j) + process(m, n, N - 1, i, j + 1)
					+ process(m, n, N - 1, i, j - 1);
		}
		return count;
	}
}
