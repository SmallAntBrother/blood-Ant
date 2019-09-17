package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

	public static List<Integer> process(String s, String p) {
		 List<Integer> result = new ArrayList<>();
         int[] p_letter = new int[26];
         for (int i = 0; i < p.length(); i++) {//记录p里面的数字分别有几个
             p_letter[p.charAt(i) - 'a']++;
         }
         int start = 0;
         int end = 0;
         int[] between_letter = new int[26];//记录两个指针之间的数字都有几个
         while (end < s.length()) {
             int c = s.charAt(end++) - 'a';//每一次拿到end指针对应的字母
             between_letter[c]++;//让这个字母的数量+1
             
             //如果这个字母的数量比p里面多了,说明这个start坐标需要排除
             while (between_letter[c] > p_letter[c]) {
                 between_letter[s.charAt(start++) - 'a']--;
             }
             if (end - start == p.length()) {
                 result.add(start);
             }
         }
         return result;
		
	}
}
