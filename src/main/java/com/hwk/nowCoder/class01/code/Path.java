package com.hwk.nowCoder.class01.code;

import org.junit.Test;

public class Path {
	/**
	 *  9,1,4,9,0,4,8,9,0,1
	 *  0,1,2,3,4,5,6,7,8,9
	 *  
	 *  1,1,3,2,3,0,0,0,0,0
	 */
	@Test
	public void test() {
		int[] path = { 9,1,4,9,0,4,8,9,0,1};
		cityMinPaths(path);
		for(int i = 0 ; i < path.length ; i++) {
			System.out.println(path[i]);
		}
	}
	
	/**
	 * 
	 * @param paths
	 * @return
	 */
	public int[] cityMinPaths(int[] paths) {
		
		for(int i = 0 ; i < paths.length ; i++) {
			setMinPath(paths, i);
		}
		
		for(int i = 0 ; i < paths.length ; i++) {
			if(i == paths[i]) {
				paths[i] = Integer.MIN_VALUE;
			}
		}
		
		for(int i = 0 ; i < paths.length ; i++) {
			setPath(paths, i);
		}
		paths[0] -= 1;
		return paths;
	}
	
	private void setPath(int[] paths, int i) {
		if(paths[i] > 0) {
			return;
		}
		
		int next = paths[i];
		paths[i] = 0;
		while(next < 1 && next != Integer.MIN_VALUE) {
			int temp =  Math.abs(next);
			next = paths[temp];
			if(paths[temp] > 0) {
				paths[temp] += 1;
			}else {
				paths[temp] = 1;
			}
			
			
		}
		
		
	}

	private void setMinPath(int[] paths,int index) {
		if(index == paths[index]) {
			return;
		}
		
		int next = paths[index],
				cur = index;
		boolean flag = true;
		while(next > -1) {
			if(paths[next] < 0) {
				int temp = next;
				next = paths[cur];
				paths[cur] = paths[temp] - 1;
				flag = !flag;
			}else if(next == paths[next]) {
				next = paths[cur];
				paths[cur] = -1;
				flag = !flag;
			}else if(flag) {
				int temp = next;
				next = paths[next];
				paths[temp] = cur;
				cur = temp;
			} else if(index == cur) {
				break;
			} else {
				int temp = next;
				next = paths[next];
				paths[temp] = paths[cur] - 1;
				cur = temp;
			}
		}
		
	}
	
}
