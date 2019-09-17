package com.hwk.leetCode;

public class MinDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));

		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));

		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

	public static boolean isInterleavedp(String s1, String s2, String s3) {

		if ((s1.length() + s2.length()) != s3.length())
			return false;

		boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];

		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			dp[0][i] = dp[0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
		}

		for (int i = 1; i <= s2.length(); i++) {
			dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1))
						|| (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
			}
		}
		return dp[s2.length()][s1.length()];

	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
			return true;
		} else if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		if (!s1.isEmpty() && !s2.isEmpty() && s3.charAt(0) == s1.charAt(0) && s3.charAt(0) == s2.charAt(0)) {
			return isInterleave(s1.substring(1), s2, s3.substring(1))
					|| isInterleave(s1, s2.substring(1), s3.substring(1));
		} else if (!s1.isEmpty() && s3.charAt(0) == s1.charAt(0)) {
			return isInterleave(s1.substring(1), s2, s3.substring(1));
		} else if (!s2.isEmpty() && s3.charAt(0) == s2.charAt(0)) {
			return isInterleave(s1, s2.substring(1), s3.substring(1));
		}

		return false;
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int[][] dp = new int[dungeon.length][dungeon[0].length];

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}

			}

		}

		return dp[word1.length()][word2.length()];
	}

	public static int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];

		dp[0][0] = grid[0][0];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i > 0 && j > 0) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				} else if (i == 0 && j > 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if (j == 0 && i > 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				}
			}
		}

		return dp[grid.length - 1][grid[0].length - 1];
	}
}
