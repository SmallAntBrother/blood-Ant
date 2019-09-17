package com.hwk.leetCode.dp;

import com.hwk.nowCoder.treeNode.domian.TreeNode;
 class ReturnTypeIII {
	public int curMax;
	public int lastMax;
	
	public ReturnTypeIII(int curMax,int lastMax) {
		this.curMax = curMax;
		this.lastMax = lastMax;
	}
}
public class ClimbStairs {

	/**
	 * 11111
	 * 1112
	 * 122
	 * 212
	 * 221
	 * 2111
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(proccse(5));
		
		System.out.println(rob(new int[] {2,1,1,5}));//4
		System.out.println(rob(new int[] {1,2,3,1}));//4
		System.out.println(rob(new int[]{2,7,9,3,1}));//12
		
		System.out.println(robII(new int[] {2,3,2}));//4
		System.out.println(robII(new int[] {4,1,2,7,5,3,1}));//14
		
		TreeNode nodeLeftIII = new TreeNode(3);
		TreeNode nodeLeftII = new TreeNode(2);
		TreeNode nodeRightIII = new TreeNode(1);
		TreeNode nodeRightII = new TreeNode(3);
		TreeNode root = new TreeNode(3);
		nodeRightII.setRight(nodeRightIII);
		nodeLeftII.setRight(nodeLeftIII);
		root.setLeft(nodeLeftII);
		root.setRight(nodeRightII);
		
		System.out.println(robIII(root));
		
		
		
		
		TreeNode root2 = new TreeNode(4);
		TreeNode l2 = new TreeNode(1);
		TreeNode ll2 = new TreeNode(2);
		TreeNode lll3 = new TreeNode(3);
		ll2.setLeft(lll3);
		l2.setLeft(ll2);
		root2.setLeft(l2);
		System.out.println(robIII(root2));
	}
	
	
		
	
	
	/**
	 *  [4,1,null,2,null,3]
	 *  
	 *  		4
	 *  	1
	 *  2
	 3
	 *  
	 *  
	 *  
	 * 输入: [3,2,3,null,3,null,1]
		
		     3
		    / \
		   2   3
		    \   \ 
		     3   1
		
		输出: 7 
		解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
	 * @param root
	 * @return
	 */
	public static int robIII(TreeNode root) {
		ReturnTypeIII ret = proccseIII(root);
		
		return Math.max(ret.curMax, ret.lastMax);
    }
	
	public static ReturnTypeIII proccseIII(TreeNode node) {
		if(node == null) {
			return new ReturnTypeIII(0,0);
		}
		
		ReturnTypeIII left =  proccseIII(node.getLeft()) ;
		ReturnTypeIII right = proccseIII(node.getRight());
		
		return new ReturnTypeIII(Math.max(left.curMax, left.lastMax)+Math.max(right.curMax , right.lastMax),left.curMax + right.curMax + node.getVal());
	}
	
	
	 public static int robII(int[] nums) {
	        
		 if(nums.length == 0) {
			 return 0;
		 } else if(nums.length == 1) {
			 return nums[0];
		 }else if(nums.length == 2) {
			 return Math.max(nums[0], nums[1]);
		 }
		 int[] dp = new int[nums.length];
		 int[] dp1 = new int[dp.length];
		 
		 dp[0] = nums[0];
		 dp[1] = nums[1];
		 dp1[1] = nums[1];
		 for(int i = 2;i<nums.length;i++) {
			 dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			 dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
		 }
		 
		 return Math.max(dp[dp.length - 2], dp1[dp.length - 1]);
	}
	
	
	 public static int rob(int[] nums) {
		 if(nums.length == 0) {
			 return 0;
		 } else if(nums.length == 1) {
			 return nums[0];
		 }else if(nums.length == 2) {
			 return Math.max(nums[0], nums[1]);
		 }
		 int[] dp = new int[nums.length];
		 
		 dp[0] = nums[0];
		 dp[1] = nums[1];
		 dp[2] = Math.max(nums[2] + dp[0], dp[1]);
		 for(int i = 3;i<nums.length;i++) {
			 dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i],dp[i - 3] + nums[i]));
		 }
		 
		 return dp[nums.length - 1];
	 }
	
	
	public static int proccse(int N) {
		if(N < 3) {
			return N;
		}
		int[] dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i <= N ; i ++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[N];
	}
	
}
