package com.hwk.leetCode;

public class Rotate {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotate(matrix);
		show(matrix);

		System.out.println();
		int[][] matrix1 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

		rotate(matrix1);
		show(matrix1);
	}

	public static void show(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		int x = 0;
		int y = 0;

		int targetX = x;
		int targetY = matrix[x].length - 1;

		while (y < targetY) {

			while (y < matrix[x].length - 1 - x) {
				aw(x, y, targetX++, targetY, matrix);
				aw(x, y, targetY, targetY, matrix);
				aw(x, y++, targetY, x, matrix);
			}

			x++;
			y = x;
			targetX = x;
			targetY = matrix[x].length - 1 - x;
		}

	}

	private static void aw(int i, int j, int k, int l, int[][] matrix) {
		matrix[i][j] = matrix[i][j] ^ matrix[k][l];
		matrix[k][l] = matrix[i][j] ^ matrix[k][l];
		matrix[i][j] = matrix[i][j] ^ matrix[k][l];
	}
}
