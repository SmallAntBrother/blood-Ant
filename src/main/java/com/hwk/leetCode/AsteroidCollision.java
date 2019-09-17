package com.hwk.leetCode;

import java.util.Stack;

public class AsteroidCollision {
	
	public static void main(String[] args) {
		int[] nums = process(new int[] {5,10,-5});
		show(nums);
		
		nums = process(new int[] {-2,-2,-2,-2});
		show(nums);

		nums = process(new int[] {-2,-2,1,-2});
		show(nums);
	}
	
	public static void show(int[] nums) {
		// TODO Auto-generated method stub
		for(int i = 0; i < nums.length ; i ++ ) {
			System.out.println(nums[i]);
		}
	}

	
	public static int[] process(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < asteroids.length ; i ++ ) {
			if(stack.isEmpty()) {
				stack.push(asteroids[i]);
			}else if(asteroids[i] < 0 && stack.peek() > 0) {
				int tmp = Math.abs(asteroids[i]);
				while(!stack.isEmpty() && stack.peek() > 0 && tmp > stack.peek()) {
					stack.pop();
				}
				if(stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroids[i]);
				}else if(tmp == stack.peek()){
					stack.pop();
				}
			}else {
				stack.push(asteroids[i]);
			}
		}
		
		int[] asteroid = new int[stack.size()];
		
		while(!stack.isEmpty()) {
			asteroid[stack.size() - 1] = stack.pop();
		}
		return asteroid;
	}
}
