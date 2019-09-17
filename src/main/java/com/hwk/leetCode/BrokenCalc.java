package com.hwk.leetCode;

public class BrokenCalc {

	public static void main(String[] args) {
		System.out.println(func(1, 1_000_000_000));
		System.out.println(proccse(1, 1000000000));
	}

	public static int func(int X, int Y) {
		int result = 0;
		while (X < Y) {
			if (Y % 2 == 0) {
				Y /= 2;
				result++;
			} else {
				Y = (Y + 1) / 2;
				result += 2;
			}
		}
		return result + X - Y;

	}

	public static int proccse(int x, int y) {
		int s = 0;
		while (x != y) {

			if (x > y || (x - y / 2 > 0 && x - y / 2 < x * 2 - y)) {
				x--;
			} else if (x < y) {
				x <<= 1;
			}
			s++;
		}

		return s;

	}
}
