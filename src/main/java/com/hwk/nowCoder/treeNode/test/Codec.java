package com.hwk.nowCoder.treeNode.test;


import com.hwk.nowCoder.treeNode.domian.TreeNode;
/**
		 * 你可以将以下二叉树：
		
		    1
		   / \
		  2   3
		     / \
		    4   5
		
		序列化为 "[1,2,3,null,null,4,5]"
 *
 */
public class Codec {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode rleft = new TreeNode(4);
		TreeNode rright = new TreeNode(5);
		right.left = rleft;
		right.right = rright;
		root.left = left;
		root.right = right;
		
		String data = serialize(root);
		System.out.println(data);
		root = deserialize(data);
		System.out.println(serialize(root));
		
	}
	
	
	 // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        
        append(root,sb);
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private static void append(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.val + ",");
		append(root.left, sb);
		append(root.right, sb);
	}

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	String[] strs = data.substring(1, data.length() - 1).split(",");
    	TreeNode root = getNode(strs,new int[] {0});
    	
        return root;
    }


	public static TreeNode getNode(String[] strs, int[] index) {
		if(index[0] >= strs.length || "null".equals(strs[index[0]]) ) {
			index[0] ++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(strs[index[0]++]));
		root.left = getNode(strs, index);
		root.right = getNode(strs, index);
		return root;
	}
}
