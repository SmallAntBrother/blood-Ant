package com.hwk.leetCode.solution;
/**
 * @author Joker
 *
 */
public class Reverse {
	//-1563847412
	//1463847412
	public static void main(String[] args) {
		System.out.println(process(-1563847412));
	}
	
	public static int process(int x) {
		boolean flag = x < 0;
		if(flag && x == Integer.MIN_VALUE ) {
			return 0; 
		}
		int tmp = Math.abs(x);
		
		if(tmp < 10) {
			return flag ? -tmp : tmp;
		}
		
		int ret = 0;
		while(tmp != 0){
			ret *= 10;
			ret += tmp % 10;
			tmp /= 10;
			
			
			if (tmp != 0 && ((flag && (ret > Integer.MAX_VALUE / 10  || (ret == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10 + 1))) || 
					(!flag && (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10))))) {
                return 0;
            }
		}
		
		return flag ? -ret : ret;
	}
}
