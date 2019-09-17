package com.hwk.leetCode;

public class TitleToNumber {

	public static void main(String[] args) {
		System.out.println(proccse("A"));
		System.out.println(proccse("AA"));
		System.out.println(proccse("AB"));
		System.out.println(proccse("ZY"));
	}
	
	public static int proccse(String s) {
		int ret = 0 ;
		char[] ascs = s.toCharArray();
		
		for(int i = ascs.length - 1; i >= 0 ; i --) {
			int tmp = ascs.length - 1 - i;
			ret += tmp == 0 ? ascs[i] - '0' - 16 : (ascs[i] - '0' - 16) * func(tmp) ;
		}
		
		return ret;
	}
	
	public static int func(int count) {
		int ret = 1;
		while(count != 0) {
			ret *= 26;
			count --;
		}
		return ret;
	}
}
