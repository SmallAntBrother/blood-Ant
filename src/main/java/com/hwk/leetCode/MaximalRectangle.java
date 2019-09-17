package com.hwk.leetCode;

import java.util.Arrays;

public class MaximalRectangle {

	public static void main(String[] args) {
//		long start = System.nanoTime();
//		int max = maximalRectangleII(new char[][] { 
//				{ '1', '0', '1', '0', '0' }, 
//				{ '1', '0', '1', '1', '1' },
//				{ '1', '1', '1', '1', '1' }, 
//				{ '1', '0', '0', '1', '0' } 
//			});
//
//		System.out.println(max);
//		System.out.println(System.nanoTime() - start);

		//System.out.println(Arrays.asList(sortArrayByParityII(new int[] { 4, 2, 5, 7 })));
		System.out.println(Arrays.asList(sortArrayByParityII(new int[] { 3, 4 })));
	}

	public static int[] sortArrayByParityII(int[] A) {
	    int[] B = new int[A.length];    
		int index1 = 0, index2 = 1;
	        for(int i = 0; i < A.length; i++){
	            if((A[i] & 1) == 0){ // A中出现偶数
	                B[index1] = A[i];
	                index1 += 2; // 偶数索引指针更新
	            }else{ // A中出现奇数
	                B[index2] = A[i];
	                index2 += 2; // 奇数索引指针更新
	            }
	        }

		return B;
	}

	private static void swap(int i, int j, int[] a) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static int maximalRectangleII(char[][] matrix) {
		int max = 0;
		int height = matrix.length;
		int weiht = matrix[0].length;

		int[][] tempUToT = new int[height][weiht];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < weiht; j++) {
				int t = matrix[i][j] - '0';

				if (i == 0) {
					tempUToT[i][j] = t;
				} else {
					tempUToT[i][j] = t == 0 ? 0 : tempUToT[i - 1][j] + 1;
					;
				}

			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < weiht; j++) {
				int g = tempUToT[i][j] * getMinNumCount(tempUToT, i, j);

				max = Math.max(max, g);
			}
		}

		return max;
	}

	private static int getMinNumCount(int[][] tempUToT, int i, int j) {
		int count = 1;
		for (int k = j - 1; k >= 0; k--) {
			if (tempUToT[i][k] < tempUToT[i][j]) {
				break;
			}
			count++;
		}

		for (int k = j + 1; k < tempUToT[i].length; k++) {
			if (tempUToT[i][k] < tempUToT[i][j]) {
				break;
			}
			count++;
		}

		return count;
	}

	public static int maximalRectangle(char[][] matrix) {
		int max = 0;

		int height = matrix.length;
		int weiht = matrix[0].length;

		int[][] tempLToR = new int[height][weiht];
		int[][] tempUToT = new int[height][weiht];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < weiht; j++) {
				int t = matrix[i][j] - '0';
				if (j == 0) {
					tempLToR[i][j] = t;
				} else {
					tempLToR[i][j] = t == 0 ? 0 : tempLToR[i][j - 1] + 1;
				}

				if (i == 0) {
					tempUToT[i][j] = t;
				} else {
					tempUToT[i][j] = t == 0 ? 0 : tempUToT[i - 1][j] + 1;
					;
				}

			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < weiht; j++) {

				max = Math.max(max, tempLToR[i][j] * tempUToT[i][j]);

			}
		}

		return max;
	}
}
