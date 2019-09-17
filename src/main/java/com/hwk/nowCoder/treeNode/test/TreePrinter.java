package com.hwk.nowCoder.treeNode.test;

import com.hwk.nowCoder.treeNode.domian.TreeNode;

public class TreePrinter {

	 public int[][] printTree(TreeNode root) {
	        int[][] treeNode = getNode(root, null, new int[500][],0);
	        
	        return treeNode;
	    }
	 
	 
	 public int[][] getNode(TreeNode left,TreeNode right,int[][] treeNode,int index){
		 
		 if(left == null && right == null) {
			 return treeNode;
		 }
		 treeNode[index] = new int[] {left.getVal(),right.getVal()};
		 
		 if(left != null && right != null) {
			 treeNode = getNode(left.getLeft(),left.getRight(), treeNode, index + 1);
			 
		 }
		 return treeNode;
	 }
	 
	 public boolean chkRotation(String A, int lena, String B, int lenb) {
	        // write code here
	        if(lena != lenb)
	            return false;
	        
	        String AA = A + A;
	        
	        
	        return AA.contains(B) ;
	    }

}
