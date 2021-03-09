/**
 * 
Rotate List
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 */


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy,fast = dummy;
    
        int i = 0;
        for(i = 0;fast.next!=null;i++){
            fast = fast.next;
        }
        
        for(int j = i-k%i;j>0;j--){
            slow = slow.next;
        }
    
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
            
        return dummy.next;
    }
}

/**
	Rotate doubly Linked List by P nodes	GP				https://practice.geeksforgeeks.org/problems/rotate-doubly-linked-list-by-p-nodes/1	
 */
