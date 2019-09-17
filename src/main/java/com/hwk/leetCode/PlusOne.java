package com.hwk.leetCode;


public class PlusOne {
	
	public static void main(String[] args) {
		
		show( process(new int[] {1,2,3}));
		show( process(new int[] {9,9}));
		
		
	}
	
	public static void show(int[] nums) {

		for(int i = 0 ; i < nums.length ; i ++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}

	public static int[] process(int[] nums) {
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 9) {
				nums[i] = 0;
				if(i == 0 ) {
					int[] original = new int[nums.length + 1];
					 System.arraycopy(original, 1, nums, 0,nums.length);
					 original[0] = 1;
					 nums = original;
				}
			} else {
				nums[i] += 1;
				break;
			}
		}

		return nums;
	}

}
