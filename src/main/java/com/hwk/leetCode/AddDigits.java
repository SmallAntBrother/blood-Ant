package com.hwk.leetCode;

public class AddDigits {

	public static void main(String[] args) {
		System.out.println(proccse(38));
	}
	
	public static int proccse(int n) {
		int total = 0;
		while(n != 0 ) {
			total += n % 10;
			n /= 10;
		}
		
		
		return total > 9 ? proccse(total) : total;
	}
}
