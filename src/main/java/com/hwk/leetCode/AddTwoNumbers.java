package com.hwk.leetCode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l111 = new ListNode(3);
		l11.next = l111;
		l1.next = l11;
		
		ListNode l2 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l211 = new ListNode(4);
		l21.next = l211;
		l2.next = l21;
		
		
		System.out.println(addTwoNumbers(l1, l2));

		ListNode r1 = new ListNode(5);
		ListNode r2 = new ListNode(5);
		
		System.out.println(addTwoNumbers(r1, r2));
	
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(9));

		
		System.out.println(mySqrt(8192));
	}
	
	 public static int mySqrt(int x) {
	     int t = x >> 1;   
		 
	     while (true) {
	    	 int h = t * t;
	    	 if(h <= x && (t + 1) * (t + 1) > x) {
	    		 break;
	    	 } else if(h < x) {
	    		 t += t >> 1;
	    	 } else {
	    		 t -= t >> 1;
	    	 }
	     }
		 
		 return t;
	 }
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	     ListNode head = new ListNode(0);  
		 
	     ListNode node = head;
	     int pre = 0;
	     while(l1 != null || l2 != null || pre != 0) {
	    	 int num = pre + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
	    	 pre = num / 10;
	    	 node.val = num % 10;
	    	 
	    	 l1 = l1 == null ? null : l1.next;
	    	 l2 = l2 == null ? null : l2.next;
	    	 
	    	 if(l1 != null || l2 != null || pre != 0) {
	    		 node.next = new ListNode(0);
		    	 node = node.next;
	    	 }
	     }
	     return head;
	 }
}
