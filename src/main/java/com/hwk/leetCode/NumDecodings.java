package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class NumDecodings {
	public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i = 1; i < s.length() + 1; i++){
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(i > 1){
                int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if(num == 0){
                    return 0;
                }
                if(num > 9 && num < 27){
                    dp[i] += dp[i - 2];
                }
            }
        }

        return s.length() == 0 ? 0 : dp[s.length()];
    }
	
	
	public static int findMaxLength(int[] nums) {
		  int res = 0, sum = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i] == 1 ? 1 : -1;
	            if (sum == 0 && i > res) {
	                res = i + 1;
	            }
	            if (map.containsKey(sum)) {
	                res = Math.max(i - map.get(sum), res);
	            } else {
	                map.put(sum, i);
	            }
	        }
	        return res;
    }

	public static boolean Find(int target, int [][] array) {
		
		int x = 0,
				y = array[x].length - 1;
		while(x != array.length && y != -1) {
			if(target == array[x][y]) {
				return true;
			}else if(target > array[x][y]) {
				x ++;
			} else {
				y -- ;
			}
		}
		
		return false;
    }


	public static void main(String[] args) {
//		System.out.println(findMaxLength(new int[] {0,1}));
//		System.out.println(findMaxLength(new int[] {0,1,0}));
//		System.out.println(findMaxLength(new int[] {0,1,0,1}));
//		System.out.println(findMaxLength(new int[] {1,1,0,1}));
//		System.out.println(findMaxLength(new int[] {1,1,1,1}));
//		System.out.println(findMaxLength(new int[] {0,1,1,1,1,0}));
		
//		7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
		System.out.println(Find(7, new int[][] {
			{1,2,8,9},
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		}));
	}
}
