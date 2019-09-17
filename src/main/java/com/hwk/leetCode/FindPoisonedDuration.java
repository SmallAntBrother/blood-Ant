package com.hwk.leetCode;

public class FindPoisonedDuration {

	public static void main(String[] args) {
		//System.out.println(findPoisonedDuration(new int[] {1 , 4}, 2));
		//System.out.println(findPoisonedDuration(new int[] {1 , 2}, 2));
		
		
		//System.out.println(canPlaceFlowers(new int[] {1 , 0 , 0 , 0 , 1  }, 1));
		System.out.println(canPlaceFlowers(new int[] {1 , 0 , 0 ,0, 0 , 1  }, 2));
		System.out.println(canPlaceFlowers(new int[] {0 , 0 , 1 ,0 , 1  }, 1));
		System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1,0,0  }, 2));
		System.out.println(canPlaceFlowers(new int[] {0,0  }, 1));
		System.out.println(canPlaceFlowers(new int[] {0,0  }, 2));
		System.out.println(canPlaceFlowers(new int[] {0  }, 2));
	}
	
	
	 public static int findPoisonedDuration(int[] timeSeries, int duration) {
	     
		 int total = 0;
		 int pre = 0;
		 int cur = 0;
		 for(int i = 0 ; i < timeSeries.length ; i ++) {
			 cur = timeSeries[i] + duration;
			 int tmp = cur - (pre == 0 ? timeSeries[i] : pre);
			 total += tmp > duration ? duration : tmp;
			 pre = cur;
		 }
		 
		 
		 return total;
	 }
	 
	 public static boolean  canPlaceFlowers(int[] flowerbed, int n) {
		 if(flowerbed.length == 0) {
			 return false;
		 }else if(flowerbed.length == 1){
			 return flowerbed[0] == 0 ? n < 2 : false;
		 }
		int count = 0 ;

		int cur = 0 ;
		for(int i = 0 ; i < flowerbed.length; i ++) {
			if(flowerbed[i] == 1) {
				cur = 0;
			}else if(
					(cur == 1 && flowerbed[i] == 0 && i + 1 < flowerbed.length &&flowerbed[i + 1] == 0)
					||
					(i == 0 && flowerbed[i] == 0 && i + 1 < flowerbed.length &&flowerbed[i + 1] == 0)
					||
					(cur == 1 && flowerbed[i] == 0 && i == flowerbed.length - 1)
					) {
				count ++;
				cur = 0;
			}else {
				cur ++;
			}
			
		}
		 
		 return count >= n;
	}
}
