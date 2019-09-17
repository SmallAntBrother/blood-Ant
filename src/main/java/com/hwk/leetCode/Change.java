package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.hwk.nowCoder.treeNode.domian.TreeNode;
class ReturnData{
	public int level;
	public int value;
	
	public ReturnData(int level,int value){
		this.level = level;
		this.value = value;
	}
}
public class Change {
	
	public static void main(String[] args) {
		System.out.println(change(5, new int[] {1,2,5}));
		
		TreeNode root = new TreeNode(-2);
		TreeNode left = new TreeNode(-3);
		root.left = left;
		
		System.out.println(hasPathSumII(root, -5));
		
	}
	
	
	public boolean isCousins(TreeNode root, int x, int y) {
		
		ReturnData xData = get(root, x, 0,0);
		ReturnData yData = get(root, y, 0,0);
		
		return xData.level == yData.level && xData.value != yData.value;
    }
	
	public ReturnData get(TreeNode root, int x,int level,int parent) {
		if(root == null) {
			return new ReturnData(Integer.MIN_VALUE, 0);
		} else if(root.val == x) {
			return new ReturnData(level,  parent);
		}
		
		ReturnData left = get(root.left, x, level + 1,root.val);
		ReturnData right = get(root.right, x, level + 1,root.val);
		
		return left.level > right.level ? left : right;
	}
	
	
	 public static int findBottomLeftValue(TreeNode root) {
	        
		 return findBottomLeftValueTree(root,0).value;
	 }
	 
	 public static ReturnData findBottomLeftValueTree(TreeNode root,int level) {
		 if(root == null) {
			 return new ReturnData(0, 0);
		 }
		 
		 ReturnData cur = new ReturnData(level,root.val);
		 ReturnData left = findBottomLeftValueTree(root.left,level + 1);
		 ReturnData right = findBottomLeftValueTree(root.right, level + 1);
		 
		 return cur.level > left.level ? cur : left.level >= right.level ? left : right;
	 }
	
	 public static List<Integer> addToArrayForm(int[] A, int K) {
	     List<Integer> list = new ArrayList<>();   
		 
		 
		 
		 
		 return list;
	 }
	
	 public static  boolean hasPathSum(TreeNode root, int sum) {
		 if(root == null)
			 return false;
		 
		 return hasPathSumII(root,sum);
	 }
	
	private static boolean hasPathSumII(TreeNode root, int sum) {
		 if( root == null)
			 return false;
		 
	     if(root != null && root.left == null && root.right == null) {
	    	 return sum == root.val;
	     } 
	     sum -= root.val;
		 return hasPathSumII(root.left , sum) || hasPathSumII(root.right , sum);
	}


	// 1,2,5 
	//5 
	//4
	public static int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		dp[0][0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = setDP(dp,coins,i - 1,j) ;
				}
			}
		}

		return dp[coins.length][amount];
	}

	private static int setDP(int[][] dp, int[] coins, int i, int j) {
		if(j < 0 ) {
			return 0;
		}
		
		return setDP(dp, coins, i, j - coins[i]) + dp[i][j] ;
	}
}
