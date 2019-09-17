package com.hwk.leetCode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;

		ListNode root = proccse(node1);
		System.out.println(root);
		
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n) {
		
		if(n == 1) {
			return true;
		}else if(n == 4) {
			return false;
		}
		int temp = 0;
		while(n != 0) {
			int k = n % 10;
			temp += k * k;
			n /= 10;
		}
		
		return isHappy(temp);
	}

	public static ListNode proccse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = proccse(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}
