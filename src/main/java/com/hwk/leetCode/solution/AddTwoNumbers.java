package com.hwk.leetCode.solution;

import org.junit.Test;

import com.hwk.leetCode.solution.entity.ListNode;

/**
 * ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
 * @author Joker
 *
 */
public class AddTwoNumbers {


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode curr = new ListNode(0);
		if(l1 != null || l2 != null) {
			curr = addTwoNumbers(l1.next, l2.next);
		} else {
			return curr;
		}
		
		int sum = l1.val + l2.val + curr.val;
		System.out.println(sum % 10);
		return new ListNode(sum / 10);
	}
	
	
	
	@Test
	public  void show() {
		ListNode l1_node_1 = new ListNode(2);
		ListNode l1_node_2 = new ListNode(4);
		ListNode l1_node_3 = new ListNode(3);
		l1_node_2.next = l1_node_3;
		l1_node_1.next = l1_node_2;

		ListNode l2_node_1 = new ListNode(5);
		ListNode l2_node_2 = new ListNode(6);
		ListNode l2_node_3 = new ListNode(4);
		l2_node_2.next = l2_node_3;
		l2_node_1.next = l2_node_2;
		
		addTwoNumbers(l1_node_1,l2_node_1);
	}
	
	
	
	
	
}
