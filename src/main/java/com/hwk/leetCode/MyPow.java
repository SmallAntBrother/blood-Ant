package com.hwk.leetCode;

public class MyPow {

	public static void main(String[] args) {
//		System.out.println(myPow(2.0, 10));
//		System.out.println(myPow(2.0, -2));
		System.out.println(myPow(1.0,
				-2147483648));
	}
	
	 public static int superPow(int a, int[] b) {
	        int ret = 1;
	        int t = 0;
	        
	        for(int i = 0 ; i < b.length ; i ++) {
	        	t = t * 10 + b[i];
	        }
	        
	        while(t != 0) {
				if((t & 1) == 1) {
					ret *= a;
				}
				t >>= 1;
				a *= a;
			}
	        
	        return ret;
	    }
	
	public static double myPow(double x, int n) {
		double ret = 1.0;
		long t = Math.abs((long)n);
		
		if(n == 0) {
			return 1;
		} 
		
		while(t != 0) {
			if((t & 1) == 1) {
				ret = x * ret;
			}
			t >>= 1;
			x *= x;
		}
		
		
		
		return n > 0 ? ret : 1 / ret;
    }
	
	
	
}
