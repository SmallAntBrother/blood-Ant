package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
	
	 public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 
		 for(int i = 0 ; i < nums.length ; i ++) {
			 List<Integer> tempList = new ArrayList<>();
			 int pre = -nums[i];
			 tempList.add(nums[i] );
			 
		 }
		 
		 
		 return list;
	 }

	 static Map<String, char[]> map = new HashMap<String, char[]>() {{
		put("1", new char[] { ' ' });
		put("2", new char[] { 'a', 'b', 'c' });
		put("3", new char[] { 'd', 'e', 'f' });
		put("4", new char[] { 'g', 'h', 'i' });
		put("5", new char[] { 'j', 'k', 'l' });
		put("6", new char[] { 'm', 'n', 'o' });
		put("7", new char[] { 'p', 'q', 'r', 's' });
		put("8", new char[] { 't', 'u', 'v' });
		put("9", new char[] { 'w', 'x', 'y', 'z' });
	 }};
	public static List<String> letterCombinations(String digits) {
		if (digits == null || "".equals(digits)) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<>();
		
		char[] chars = map.get(String.valueOf(digits.charAt(0)));

		for (int i = 0; i < chars.length; i++) {

			if(digits.length() > 1) {
				List<String> lowList = letterCombinations(digits.substring(1));
	
				for (int j = 0; j < lowList.size(); j++) {
					StringBuffer sb = new StringBuffer().append(chars[i]);
					sb.append(lowList.get(j));
					list.add(sb.toString());
				}
			}else {
				list.add(String.valueOf(chars[i]));
			}
			
		}

		return list;
	}
}
