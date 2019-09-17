package com.hwk.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Permute {

	static Map<String, Double> map = new HashMap<>();

	public static double knightProbability(int N, int K, int r, int c) {

		return getPage(N, K, r, c);
	}

	public static double getPage(int N, int K, int r, int c) {
		if (r < N && c < N && r >= 0 && c >= 0) {
			if (K == 0)
				return 1;

			String key = K + "_" + r + '_' + c;
			if (map.containsKey(key)) {
				return map.get(key);
			}

			double ret = 0;

			ret += getPage(N, K - 1, r + 2, c + 1);
			ret += getPage(N, K - 1, r + 1, c + 2);
			ret += getPage(N, K - 1, r - 2, c - 1);
			ret += getPage(N, K - 1, r - 1, c - 2);

			ret += getPage(N, K - 1, r + 2, c - 1);
			ret += getPage(N, K - 1, r - 2, c + 1);
			ret += getPage(N, K - 1, r - 1, c + 2);
			ret += getPage(N, K - 1, r + 1, c - 2);
			ret /= 8.0;
			map.put(key, ret);

			return ret;
		} else {
			return 0;
		}
	}

	private static double getTotal(int N) {
		int k = 8;
		double ret = 1;

		while (N != 0) {
			if ((N & 1) == 1) {
				ret *= k;
			}
			k *= k;
			N >>= 1;
		}

		return ret;
	}

	static int[][] move = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };
	static double[][][] dp;

	public static double knightProbabilitydp(int N, int K, int r, int c) {
		dp = new double[N][N][K + 1];
		if (K == 0)
			return 1;
		return dfs(N, K, r, c);
	}

	private static double dfs(int N, int K, int r, int c) {
		if (dp[r][c][K] != 0)
			return dp[r][c][K];
		double res = 0;
		for (int i = 0; i < 8; i++) {
			int r1 = r + move[i][0];
			int c1 = c + move[i][1];
			if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N) {
				res += (K == 1 ? 1 : dfs(N, K - 1, r1, c1));
			}
		}
		return dp[r][c][K] = res / 8;
	}

	public static void main(String[] args) {

		long start = System.nanoTime();
		System.out.println(knightProbabilitydp(89, 130, 6, 4));
		System.out.println(System.nanoTime() - start);
		
		
		
		 start = System.nanoTime();
//		System.out.println(knightProbability(3, 2, 0, 0));
		System.out.println(knightProbability(89, 130, 6, 4));
		System.out.println(System.nanoTime() - start);
	}
}
