package com.hwk.leetCode.solution;

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(func(6,2));
		System.out.println(process(7,3));
		
		int[][] obstacleGrid = {{0},{1},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{1},{0},{0},{0},{0},{1},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{1},{1},{0},{1},{0},{0},{1},{0},{0},{0},{0},{1}};;
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
	
	/**
	 * 在二维网格 grid 上，有 4 种类型的方格：
			1 表示起始方格。且只有一个起始方格。
			2 表示结束方格，且只有一个结束方格。
			0 表示我们可以走过的空方格。
			-1 表示我们无法跨越的障碍。
			返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
	 * @param dp
	 * @return
	 */
	public int uniquePathsIII(int[][] dp) {
		
		return 0;
    }
	
	public void funcIIITest() {
		
		
		
		
		
	}
	
	public int funcIII(int[][] grid) {
		int startI = 0;
		int startJ = 0;
		int needToGo = 1;
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					startI =i;
					startJ =j;
				}
				if (grid[i][j] == 0) {
					needToGo++;
				}
			}
		}
		
		return dfs(grid,startI,startJ,needToGo);
			
		
		
    }
	
	private int dfs(int[][] grid, int i, int j, int needToGo) {

		if (i<0 || i>=grid.length || j<0||j>=grid[0].length || grid[i][j] == -1) {
			return 0;
		}
		if (grid[i][j] == 2 ) {
			return  needToGo == 0?1:0;
		}
		grid[i][j] = -1;
		int res = dfs(grid, i+1, j, needToGo -1) + dfs(grid, i-1, j, needToGo-1)+dfs(grid, i, j+1, needToGo-1)+dfs(grid, i, j-1, needToGo-1);
		grid[i][j] = 0;
		return res;
		
		
	}
	


	/**
	 * @param dp
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] dp) {
		if(dp[0][0] == 1) {
			return 0;
		}
		boolean f = false;
		for(int i = 0 ; i < dp[0].length; i++) {
			if(dp[0][i] == 1 || f) {
				dp[0][i] = 0;
				f = true;
			}else {
				dp[0][i] = -1;
			}
		}
		f = false;
		for(int i = 0; i < dp.length ; i++ ) {
			if(dp[i][0] == 1 || f) {
				dp[i][0] = 0;
				f = true;
			}else {
				dp[i][0] = -1;
			}
		}
		
		for(int i = 1; i< dp.length ; i++) {
			for(int j = 1 ; j < dp[i].length ; j ++) {
					dp[i][j] = dp[i][j] > 0 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		
		return Math.abs(dp[dp.length - 1][dp[0].length - 1]);
	}
	
	
	public static int process(int m,int n) {
		int[][] dp = new int[m][n];
		
		for(int i = 0 ; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}
		for(int i = 0; i < dp.length ; i++ ) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i< dp.length ; i++) {
			for(int j = 1 ; j < dp[i].length ; j ++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		
		
		return dp[m - 1][n - 1];
	}
	
	
	
	
	public static int func(int m,int n ) {
		if(m == 0 && n == 0) {
			return 1;
		}
		int total = 0;
		if(n >0&& m>0) {
			total += func(m,n-1) + func(m - 1,n);
		} else if(m == 0 ) {
			total += func(m,n-1);
		} else if(n == 0) {
			total += func(m - 1,n);
		}
		
		return total;
	}
}
