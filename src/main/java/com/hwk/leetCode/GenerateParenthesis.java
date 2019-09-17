package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
	//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
	public static List<String> generateParenthesis(int n) {
		String one = "()";
		Set<String> set = new HashSet<>();
		if (n == 1) {
			set.add(one);
			return new ArrayList<String>(set);
		}

		List<String> lowList = generateParenthesis(n - 1);
		
		for (int i = 0; i < lowList.size(); i++) {
			set.add("(" + lowList.get(i) + ")");
			set.add("()" +  lowList.get(i));
			set.add(lowList.get(i) + "()");
		}
		
		
		List<String> list = new ArrayList<String>(set);
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		return list;
	}

}
