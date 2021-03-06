/**
| 148 | Sort List |  Medium | Amazon, Facebook, Google, Microsoft |
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]


class Solution(object):
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        slow = head
        fast= head.next
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        start = slow.next
        slow.next = None
        
        left = self.sortList(head)
        right = self.sortList(start)
        
        return self.merge(left,right)
    
    def merge(self,left,right):
        if left is None or right is None:
            return left or right
        
        dummy = tail = ListNode(0)
        while left and right:
            if left.val>right.val:
                tail.next = right
                tail = tail.next
                right = right.next
            else:
                tail.next = left
                tail = tail.next
                left = left.next
            
        if left:
            tail.next = left
        if right:
            tail.next = right
            
        return dummy.next

 */

class Solution {
    public ListNode sortList(ListNode head) {
       if(head == null){
           return null;
       } 
       if(head.next == null){
           return head;
       }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode start = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(start);
            
        return mergeList(left,right);
    
    
        
    }
    
    public ListNode mergeList(ListNode left,ListNode right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        ListNode res = new ListNode(); 
        ListNode dummy = res;
        
        while(left!=null && right!=null){
            if(left.val>right.val){
                res.next = right;
                res = res.next;
                right = right.next;
            }else{
                res.next = left;
                res = res.next;
                left = left.next;
            }
        }
        
        while(left!=null){
            res.next = left;
            res = res.next;
            left = left.next;
        }
        while(right!=null){
            res.next = right;
            res = res.next;
            right = right.next;
        }
        
        return dummy.next;
        
    }
}

/**
// bubble sort
// insert into sorted cyclic linkedlist

    Quick Sort on Linked List	GP				https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1	Quick Sort on Linked List
	QuickSort on Doubly Linked List	GP				https://practice.geeksforgeeks.org/problems/quicksort-on-doubly-linked-list/1	QuickSort on Doubly Linked List
	Merge Sort for Linked List	GP				https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1	Merge Sort for Linked List
	Merge Sort on Doubly Linked List	GP				https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1	Merge Sort on Doubly Linked List
	Insertion Sort List	Leet				https://leetcode.com/problems/insertion-sort-list	Insertion Sort List
	Linked List that is Sorted Alternatingly	GP				https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1	Linked List that is Sorted Alternatingly
	
 */