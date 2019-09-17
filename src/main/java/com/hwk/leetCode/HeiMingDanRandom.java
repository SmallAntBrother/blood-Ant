package com.hwk.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeiMingDanRandom {
	
	public static void main(String[] args) {
//		HeiMingDanRandom hei = new HeiMingDanRandom(5, new int[] {4,0, 3});
//		HeiMingDanRandom hei = new HeiMingDanRandom(5, new int[] {0, 3, 1});
//		HeiMingDanRandom hei = new HeiMingDanRandom(4, new int[] { 3, 1});
		HeiMingDanRandom hei = new HeiMingDanRandom(4, new int[]  {2, 1});
		
		for(int i = 0 ; i< 1000; i ++) {
			System.out.println(hei.pick());
		}
	}

	int n;
	Map<Integer,Integer> blacklist = new HashMap<Integer,Integer>();
	
	public HeiMingDanRandom(int N, int[] blacklist) {
        this.n = N - blacklist.length;
        int index = 0;
        Arrays.parallelSort(blacklist);
        Map<Integer, Integer> keyBlack = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < blacklist.length ; i ++) {
        	boolean falg = true;
        	int num = blacklist[i];
        	int r = this.n + index;
			
        	
        	while(falg) {
	        	if(num == r) {
	        		falg = false;
	        	} else if(keyBlack.containsKey(num)) {
	        		num = keyBlack.get(num);
	        		
	        		//this.blacklist.put(keyBlack.get(num), r);
	        	} else if(this.blacklist.containsKey(r)) {
	        		falg = false;
	        		this.blacklist.put(num, this.blacklist.get(r));
	        	} else {
	        		falg = false;
	        		this.blacklist.put(num, r);
	        		keyBlack.put(r, num);
	        	}
        	}
        	
        	index ++;
        }
        
    }
    

	public int pick() {
        int random = (int) (Math.random() * n);
        if(blacklist.containsKey(random)) {
        	return blacklist.get(random) ;
        }
        return random;
    }
}
