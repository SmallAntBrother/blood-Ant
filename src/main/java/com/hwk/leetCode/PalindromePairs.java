package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class PalindromePairs {

	public static void main(String[] args) {
		List<List<Integer>> list = proccse(new String[] {"abcd","dcba","lls","s","sssll"});
		List<List<Integer>> list2 = proccse(new String[] {"bat","tab","cat"});
		
//		for(int i = 0 ; i < list.size() ; i ++) {
//			System.out.println(String.format("[%s,%s]",list.get(i).get(0),list.get(i).get(1)));
//		}
//		
		System.out.println(list);
		System.out.println(list2);
	}
	
	public static List<List<Integer>> proccse(String[] words) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0 ; i < words.length ; i ++) {
			func(words,list,i);
		}
		return list;
	} 

	private static void func(String[] words, List<List<Integer>> list, int i) {
		
		List<String> dromeList = func1(words[i]);
		
		for(int j = 0;j < words.length ; j ++ ) {
			if(j != i && dromeList.contains(words[j])) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				tmp.add(j);
				list.add(  tmp );
			}
			
		}
		
	}

	private static List<String> func1(String str) {
		if(StringUtils.isBlank(str)) {
			return new ArrayList<String>();
		}
		
		List<String> list = new ArrayList<>();
		
		char[] chars = str.toCharArray();
		list.add(func2(str));
		if(str.length() > 1) {
			int count = 0;
			list.add(func2(str.substring(1)));
			for (int i = 1; i < chars.length; i++) {
				
				if (chars[i] == chars[i - 1]) {
					count = 1;
					list.add(func2(str.substring(i + 1) ));
				} else if(count == 0) {
					break;
				} else {
					count --;
				}
			}
		
		}
		
		return list;
	}

	private static String func2(String str) {
		StringBuilder sb = new StringBuilder();
		
		char[] chars = str.toCharArray();
		
		for(int i = chars.length - 1; i >= 0 ; i --) {
			sb.append(chars[i]);
		}
		
		return sb.toString();
	}
}
