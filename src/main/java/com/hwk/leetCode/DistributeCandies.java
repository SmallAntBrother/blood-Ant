package com.hwk.leetCode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[] {1,1,2,2,3,3}));
		System.out.println(distributeCandies(new int[] {1,0,1,0,1,0}));
	}
	
	
	 public static int numJewelsInStones(String J, String S) {
		 int count = 0 ;
		 Set<String> set = new HashSet<>();
		 
		 for(int i = 0; i < J.length() ; i ++) {
			 set.add(String.valueOf(J.charAt(i)));
		 }
		
		 for(int i = 0; i < S.length() ; i ++) {
			 if(set.contains(String.valueOf(S.charAt(i)))) {
				 count ++;
			 }
		 }
		 
		 return count;
	 }
	
	
	public static int distributeCandies(int[] candies) {
		int count = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0 ; i < candies.length ; i ++) {
			if(!set.contains(candies[i])) {
				count ++;
				set.add(candies[i]);
			}
		}
		
		return (count << 1) > candies.length ? candies.length >> 1 : count;
	}
}
