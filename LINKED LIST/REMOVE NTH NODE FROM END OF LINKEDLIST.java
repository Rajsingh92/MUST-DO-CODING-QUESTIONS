/**
| 19 | Remove Nth Node From End of List |  Medium | Facebook |
* Given the head of a linked list, remove the nth node from the end of the list and return its head.
* Follow up: Could you do this in one pass?

 

* Example 1:
* Input: head = [1,2,3,4,5], n = 2
* Output: [1,2,3,5]
* Example 2:

* Input: head = [1], n = 1
* Output: []
 */


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        
        for(int i = 0;i<=n;i++){
            fast = fast.next;
        }
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
        
}


/**
	Find n/k th node in Linked list	GP				https://practice.geeksforgeeks.org/problems/find-nk-th-node-in-linked-list/1
	Find the Sum of Last N nodes of the Linked List	GP				https://practice.geeksforgeeks.org/problems/find-the-sum-of-last-n-nodes-of-the-linked-list/1	
	Swap Kth nodes from ends	GP				https://practice.geeksforgeeks.org/problems/swap-kth-node-from-beginning-and-kth-node-from-end-in-a-singly-linked-list/1
	Remove every k'th node	GP				https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1	Remove every k'th node
 */