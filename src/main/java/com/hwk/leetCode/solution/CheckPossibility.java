/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwk.leetCode.solution;

import org.junit.Test;

/**
 *
 * @author Joker
 */
public class CheckPossibility {
	
	@Test
	public void show() {
		System.out.println(checkPossibility(new int[] {4,2,1}));
	}
    
    
    public boolean checkPossibility(int[] nums) {
        int count = 0;
    	for(int i = nums.length - 1 ; i > 0 ; i--) {
    		if(nums[i] - nums[i-1] > 0 ) {
    			count ++;
    			if(count > 1) {
    				return false;
    			}
    		}
    		
    	}
    	
    	
    	return true;
    }
}
