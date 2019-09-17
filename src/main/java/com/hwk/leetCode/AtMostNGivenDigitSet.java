package com.hwk.leetCode;

public class AtMostNGivenDigitSet {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("axc", "ahbgdc"));

		
		System.out.println(process("abc", "ahbgdc"));
		System.out.println(process("axc", "ahbgdc"));
		
		
	}
	
	public static boolean process(String s, String t) {
		int index = 0 ;
		while(!s.isEmpty()) {
			index = t.indexOf(String.valueOf(s.charAt(0)));
			if(index == -1) {
				return false;
			}else {
				t = t.substring(index);
				s = s.substring(1);
			}
		}
		
		
		return true;
	}

	public static boolean isSubsequence(String s, String t) {
		if(s.isEmpty()) {
			return true;
		}else if(t.isEmpty()) {
			return false;
		}
		
		if(s.charAt(0) == t.charAt(0)) {
			return isSubsequence(s.substring(1),t.substring(1));
		}else {
			return isSubsequence(s,t.substring(1));
		}
	}

	public int trailingZeroes(int n) {
		int count = 0;

		while (n != 0) {
			count += n / 5;
			n /= 5;
		}

		return count;

	}
}
