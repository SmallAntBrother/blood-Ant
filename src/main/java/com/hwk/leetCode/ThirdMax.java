package com.hwk.leetCode;

import java.util.Arrays;

public class ThirdMax {

	public static void main(String[] args) {
//		System.out.println(findMedianSortedArrays(new int[] {1 , 2},new int[] {3} ));
//		System.out.println(findMedianSortedArrays(new int[] {1 , 2},new int[] {3,4} ));
//		
//		
//		System.out.println(findMedianSortedArrays(new int[] {1 , 2},new int[] {3,4,6} ));
//		System.out.println(findMedianSortedArrays(new int[] {1 , 2},new int[] {3,4,6,7} ));
		
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi(" -42"));
		System.out.println(myAtoi("-42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("91283472332"));
		System.out.println(myAtoi("  0000000000012345678"));
		System.out.println(myAtoi("  -0000000000012345678"));
		
	}
	
	
	 public static int myAtoi(String str) {
	     Long num = 0L;   
		 Boolean zhengshu = true;
		 int index = 0 ;

		 boolean flag = true;
		 while(index < str.length()) {
			 if(' ' == str.charAt(index)) {
				 index ++;
				 continue;
		 }
			 if(flag && ('-' == str.charAt(index) || '+' == str.charAt(index))) {
				 zhengshu = '+' == str.charAt(index);
				 flag = !flag;
			 }else if("0123456789".indexOf(String.valueOf(str.charAt(index))) > -1) {
				 if(!flag && num == 0 && str.charAt(index) - '0' == 0) {
					 return 0;
				 }
				 
				 num = num * 10 + (zhengshu ? (str.charAt(index) - '0') : -(str.charAt(index) - '0'));
			 }else{
				 break;
			 }
			 index ++;
		 }
		 
		 num = num < Integer.MIN_VALUE ? Integer.MIN_VALUE  : num > Integer.MAX_VALUE ? Integer.MAX_VALUE : num;
		 
		 return num.intValue() ;
	 }
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length] ;
		
		for(int i = 0 ; i < nums1.length ; i ++) {
			nums[i] = nums1[i];
		}
		
		for(int i = 0 ; i < nums2.length ; i ++) {
			nums[nums1.length + i] = nums2[i];
		}
		
		Arrays.sort(nums);
		
		return (nums.length & 1) == 1 ? nums[nums.length / 2] : (nums[nums.length / 2 ] + nums[nums.length / 2 - 1]) / 2.0;
	}

	public static int thirdMax(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] smax = new int[3];
		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (index == 0) {
				smax[index++] = nums[i];
			}

		}

		return smax[2] == 0 ? smax[0] : smax[2];
	}
}
