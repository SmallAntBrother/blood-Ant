package com.hwk.leetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestIncreasingPath {

	public static int longestIncreasingPath(int[][] matrix) {
		int max = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int cur = longestIncreasingPath(i, j, matrix, map);
				max = Math.max(cur, max);
			}
		}

		return max;
	}

	public static int longestIncreasingPath(int i, int j, int[][] matrixa, Map<String, Integer> map) {
		if (map.containsKey(i + "_" + j)) {
			return map.get(i + "_" + j);
		}
		int curCount = 1;

		int curNum = matrixa[i][j];
		int upNum = i == 0 ? 0 : matrixa[i - 1][j];
		int downNum = i == matrixa.length - 1 ? 0 : matrixa[i + 1][j];
		int leftNum = j == 0 ? 0 : matrixa[i][j - 1];
		int rightNum = j == matrixa[0].length - 1 ? 0 : matrixa[i][j + 1];

		if (upNum > curNum) {
			int nextCount = longestIncreasingPath(i - 1, j, matrixa, map) + 1;
			curCount = Math.max(nextCount, curCount);
		}
		if (downNum > curNum) {
			int nextCount = longestIncreasingPath(i + 1, j, matrixa, map) + 1;
			curCount = Math.max(nextCount, curCount);
		}
		if (leftNum > curNum) {
			int nextCount =  longestIncreasingPath(i, j - 1, matrixa, map) + 1;
			curCount = Math.max(nextCount, curCount);
		}
		if (rightNum > curNum) {
			int nextCount =  longestIncreasingPath(i, j + 1, matrixa, map) + 1;
			curCount = Math.max(nextCount, curCount);
		}

		map.put(i + "_" + j, curCount);

		return curCount;
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if(s.isEmpty())
			return list;
		
		int size = p.length();
		int l = 0,
				r = size - 1;
		Map<Character, Integer> map = new HashMap<>();
		int max = size;
		for(int i = 0 ; i < size ; i ++) {
			char c = p.charAt(i);
			map.put(c, map.getOrDefault(c , 0) + 1);
		}
		
		Map<Character, Integer> maxMap = new HashMap<>(map);
		for(int i = 0 ; i < size ; i ++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if(map.get(c) >= 0) {
					max --;
				}
			}
		}
		if(max == 0) {
			list.add(0);
		}
		
		while(r < s.length() - 1) {
			r ++;
			char add = s.charAt(l);
			char del = s.charAt(r);
			l ++;
			
			if(map.containsKey(add)) {
				map.put(add,  map.get(add) + 1);
				if(map.get(add) > 0 && map.get(add) <= maxMap.get(add)) {
					max ++;
				}
			}
			if(map.containsKey(del)) {
				map.put(del, map.get(del) - 1 );
				if(0 <= map.get(del) && map.get(del) < maxMap.get(del)) {
					max --;
				}
			}
			
			if(max == 0) {
				list.add(l);
			}
		}
		
		return list;
    }
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		
		if(strs == null || strs.length == 0)
			return list;
		
		int size = strs.length;
		Set<Integer> set = new HashSet<>(size);
		Map<Integer,String> map = new HashMap<>(size);
		
		for(int i = 0 ; i < size ; i ++) {
			if(set.contains(i))
				continue;
			List<String> tmpList = new ArrayList<>();
			char[] tmps = strs[i].toCharArray();
			
			String tmp = null;
			if(map.containsKey(i)) {
				tmp = map.get(i);
			}else {
				Arrays.sort(tmps);
				tmp = new String(tmps);
			}
			tmpList.add(strs[i]);
			
			for(int j = i + 1; j < size; j ++ ) {
				if(set.contains(j))
					continue;
				
				char[] tmpc = strs[j].toCharArray();
				String tmpj = null;
				if(map.containsKey(j)) {
					tmpj = map.get(j);
				}else {
					Arrays.sort(tmpc);
					tmpj = new String(tmpc);
				}
				if(tmp.equals(tmpj)) {
					set.add(j);
					tmpList.add(strs[j]);	
				}
			}
			
			list.add(tmpList);
		}
		
		return list;
    }
	
	 public boolean isAnagram(String s, String t) {
		 char[] sc = s.toCharArray();
		 char[] ts = t.toCharArray();
		 Arrays.sort(sc);
		 Arrays.sort(ts);
		 return new String(sc).equals(new String(ts));
	 }
	 

	public static void main(String[] args) {
//		System.out.println(longestIncreasingPath(new int[][] {
//			  {9,9,4},
//			  {6,6,8},
//			  {2,1,1}
//		}));
//		System.out.println(longestIncreasingPath(new int[][] {
//			{3,4,5},
//			  {3,2,6},
//			  {2,2,1}
//		}));
//		
//		System.out.println(findAnagrams("cbaebabacd", "abc"));
//		System.out.println(findAnagrams("abab", "ab"));
		System.out.println(findAnagrams("abacbabc", "abc"));
	}
}
