package com.hwk.nowCoder.treeNode.test;

import com.hwk.nowCoder.treeNode.domian.TreeNode;

public class IsSameTree {
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1= new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		TreeNode left2 = new TreeNode(2);
		TreeNode right2= new TreeNode(6);
		
		root1.left = left1;
		root1.right = right1;
		root2.left = left2;
		root2.right = right2;
		
		System.out.println(proccse(root1, root2));
	}
	
	public static boolean proccse(TreeNode p , TreeNode q) {
		if(p == q) {
			return true;
		}
		
		if(p.val != q.val) {
			return false;
		}
		
		TreeNode pleft = p.left;
		TreeNode qleft = q.left;
		TreeNode pright = p.right;
		TreeNode qright = q.right;
		
		if((pleft == null && qleft != null) || (pleft != null && qleft == null) || (pright != null && qright == null) || (pright != null && qright == null)) {
			return false;
		}
		
		return proccse(pright, qright) && proccse(pleft, qleft);
	}
}
