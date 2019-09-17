package com.hwk.leetCode;

import java.util.HashSet;
import java.util.Set;

public class FindCircleNum {

	/**
	 * [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][] {
			{1,1,0},
			{1,1,0},
			{0,0,1},
		}));
		
		System.out.println(findCircleNum(new int[][] {
			{1,0,0,1},
			{0,1,1,0},
			{0,1,1,1},
			{1,0,1,1}
		}));
	}
	
	
	public static int findCircleNum(int[][] M) {
		int count = 0;
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		for(int i = 0; i < M.length ; i ++) {
			for(int j = 0 ; j < M[i].length ; j ++) {
				if(M[i][j] == 1 ) {
					if(count > 0)
						count -= proccse(M,i,j,xSet,ySet);
					else
						proccse(M,i,j,xSet,ySet);
					count ++;
					
				}
			}
		}
		
		return count;
	}
	
	public static int proccse(int[][] M, int x, int y, Set<Integer> xSet, Set<Integer> ySet) {
		if (0 > x || x >= M.length || y < 0 || y >= M[x].length || M[x][y] != 1) {
			return 0;
		}
		int count = 0;
		M[x][y] = 2;
		count = proccse(M, x + 1, y,xSet,ySet);
		count = proccse(M, x - 1, y,xSet,ySet);
		count = proccse(M, x, y + 1,xSet,ySet);
		count = proccse(M, x, y - 1,xSet,ySet);
		count = xSet.contains(x) || ySet.contains(y) ? 1 : 0;
		xSet.add(x);
		ySet.add(y);
		return count;
	}
	
	
	
}
