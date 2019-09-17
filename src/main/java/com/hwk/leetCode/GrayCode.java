package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
	
	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		if(n == 0) {
			return list;
		}
		int length = 1;
		int num = 1;
		
		list.add(num);
		while (n > length) {
			num |= num << 1 ;
			length ++;
			list.add(num);
		}
		
		int log = 1;
		num ^= log;
		while (num != 0) {
			list.add(num);
			log <<= 1;
			num ^= log;
		}
		
		
		return list;
    }
}
