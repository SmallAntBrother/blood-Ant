package com.hwk.leetCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import java.util.Queue;

public class RobotTest {

	public static void main(String[] args) throws AWTException {
//		Robot myRobot = new Robot();
//		// 移动鼠标到坐标（x,y)处，并点击左键
//		myRobot.mouseMove(110, 220);				// 移动鼠标到坐标（x,y）处
//		myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
//		myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
//		myRobot.setAutoDelay(200);
//		
//		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		System.out.println(aim("aab", "aac", "aacaab" ));
	}
	
	private static boolean aim(String s1 ,String s2 , String s3) {
		int alen = s1.length(),
				blen = s2.length();
		if(alen + blen != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[alen + 1][blen + 1];
		
		dp[0][0] = true;
		for(int i = 0 ; i < blen; i++ ) {
			dp[0][i + 1] = dp[0][i] && s2.charAt(i) == s3.charAt(i);
		}
		
		for(int i = 0 ; i < alen; i++ ) {
			dp[i + 1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
		}
		
		for(int i = 1 ; i <= alen; i++) {
			for(int j = 1 ; j <= blen; j++) {
				
				dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ) || 
							(dp[i - 1][j ] && s1.charAt(i - 1) == s3.charAt(i + j - 1) );
			}
		}
		
		return dp[alen][blen];
	}
}
