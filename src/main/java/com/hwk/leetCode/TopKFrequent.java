package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopKFrequent {

	public static void main(String[] args) {
//		long start = System.nanoTime();
//		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
//		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 1));
//		System.out.println(System.nanoTime() - start);
//		System.out.println(topKFrequent(
//				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
//		System.out.println(System.nanoTime() - start);
//
//		System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
//		System.out.println(topKFrequent(new int[] { 1 }, 1));

//		show(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3));// 5,6,7,1,2,3,4,
//		show(rotate(new int[] { -1, -100, 3, 99 }, 2));// 3,99,-1,-100,
//		show(rotate(new int[] { 1, 2, 3, 4, 5, 6 }, 11)); // 2,3,4,5,6,1
//		show(rotate(new int[] { 1, 2, 3 }, 4));// 3,1,2
		// show(rotate(new int[] { 1, 2, 3, 4, 5, 6 }, 1)); // 6,1,2,3,4,5

		System.out.println(removeDuplicateLetters("bcabc"));// abc
		System.out.println(removeDuplicateLetters("cbacdcbc"));// "acdb"
		System.out.println(removeDuplicateLetters("bbcaac"));// "bac"
		System.out.println(removeDuplicateLetters("abacb"));// "abc"

	}

	public static String removeDuplicateLetters(String s) {

		LinkedList<String> linked = new LinkedList<>();
		int[] chars = new int[26];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			setLinked(linked, chars, t);

		}

		String ret = "";
		while (!linked.isEmpty()) {
			ret += linked.pollFirst();
		}

		return ret;
	}

	private static void setLinked(LinkedList<String> linked, int[] chars, char t) {
		if (!linked.contains(String.valueOf(t))) {
			if (linked.isEmpty() || linked.getLast().charAt(0) < t || chars[linked.getLast().charAt(0) - 'a'] == 1) {
				linked.addLast(String.valueOf(t));
			} else if (linked.getLast().charAt(0) > t) {
				String last = linked.pollLast();
				chars[last.charAt(0) - 'a']--;

				setLinked(linked, chars, t);
			}
		} else {
			chars[t - 'a']--;
		}

	}

	// 5671234
	public static int[] rotate(int[] nums, int k) {
		k %= nums.length;
		int end = (nums.length & 1) == 1 || (k & 1) == 1 ? nums.length - 1 : nums.length;
		for (int i = 0; i < end; i++) {
			int j = i + k;
			j = j < nums.length ? j : j % nums.length;

			ap(nums, i < k ? i : i - k, j);
		}

		return nums;
	}

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> list = new ArrayList<>(k);

		Map<String, Integer> mapCount = new HashMap<>();
		TreeMap<Integer, TreeSet<String>> map = new TreeMap<>();

		for (int i = 0; i < words.length; i++) {
			int count = mapCount.getOrDefault(words[i], 0);
			mapCount.put(words[i], count + 1);

			TreeSet<String> set = map.getOrDefault(mapCount.get(words[i]), new TreeSet<String>());
			set.add(words[i]);
			map.put(mapCount.get(words[i]), set);

			if (count > 0) {
				TreeSet<String> tmpSet = map.get(count);
				tmpSet.remove(words[i]);
				map.put(count, tmpSet);
			}
		}

		while (k != 0) {
			TreeSet<String> set = map.get(map.lastKey());

			if (k >= set.size()) {
				k -= set.size();
				list.addAll(set);
				map.remove(map.lastKey());
			} else {
				for (; k > 0; k--) {
					list.add(set.pollFirst());
				}
			}
		}

		return list;
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<>(k);

		Map<Integer, Integer> mapCount = new HashMap<>();
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {
			int count = mapCount.getOrDefault(nums[i], 0);
			mapCount.put(nums[i], count + 1);

			TreeSet<Integer> set = map.getOrDefault(mapCount.get(nums[i]), new TreeSet<Integer>());
			set.add(nums[i]);
			map.put(mapCount.get(nums[i]), set);

			if (count > 0) {
				TreeSet<Integer> tmpSet = map.get(count);
				tmpSet.remove(nums[i]);
				map.put(count, tmpSet);
			}
		}

		while (k != 0) {
			TreeSet<Integer> set = map.get(map.lastKey());

			if (k >= set.size()) {
				k -= set.size();
				list.addAll(set);
				map.remove(map.lastKey());
			} else {
				for (; k > 0; k--) {
					list.add(set.pollFirst());
				}
			}
		}

		return list;
	}

	private static void ap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;

//		nums[i] = nums[i] ^ nums[j];
//		nums[j] = nums[i] ^ nums[j];
//		nums[i] = nums[i] ^ nums[j];
	}

	private static void show(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}

}
