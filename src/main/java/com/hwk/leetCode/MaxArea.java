package com.hwk.leetCode;

public class MaxArea {
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public static int maxArea(int[] height) {
		int max = 0;

		int start = 0 ; 
		int end = height.length - 1;
		
		int left = 0;
		int right = height.length - 1 ;
		boolean curindex = height[left] < height[right];
		
		
		while(start < end) {
			if(curindex) {
				start ++;
				if(height[left] > height[start]) {
					max += height[left] - height[start];
				}else {
					left = start;
					curindex = height[left] < height[right];
				}
				
			}else {
				end --;
				if(height[right] > height[end]) {
					max += height[right] - height[end];
				}else {
					right = end;
					curindex = height[left] < height[right];
				}
				
			}
			
			
		}
		
		return max;
	}
}
