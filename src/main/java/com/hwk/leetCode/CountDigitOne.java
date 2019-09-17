package com.hwk.leetCode;

public class CountDigitOne {

	/**
	 * 20
	 * 12
	 * 23
	 * 30
	 * 13
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(proccse(100));
	}
	
	public static int proccse(int n) {
		if(n <= 0) {
			return 0;
		}else if(n <= 9) {
			return 1;
		}

		String str = String.valueOf(n);
		int lenght = str.length();
		int num = 1;
		while (lenght != 2) {
			num *= 10;
			lenght -= 1;
		}
		int startNum = Integer.valueOf(str.substring(0,1));
		int count = startNum == 1 ? 1 + Integer.valueOf(str.substring(1)) : 
					num + (startNum - 1)  ;
		
		
		
		return str.length() == 1 ? count : count + proccse(Integer.valueOf(str.substring(1))) + 1;
	}
}
