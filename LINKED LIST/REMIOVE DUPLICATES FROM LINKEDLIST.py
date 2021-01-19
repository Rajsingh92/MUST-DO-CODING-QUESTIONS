'''
Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        
        return head;
    }
}
'''

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        
        curr = head
        
        while curr.next:
            if curr.val == curr.next.val:
                nextNext = curr.next.next
                curr.next = nextNext
            else:
                curr = curr.next
                
        return head



'''
Remove duplicates from an unsorted linked list 
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value 
appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4

class Solution
{
    public Node removeDuplicates(Node head) 
    {
         HashSet<Integer> hs = new HashSet<>();
         
         Node curr = head;
         Node prev = null;
         
         while(curr!=null){
             if(hs.contains(curr.data)){
                 prev.next = curr.next;
             }else{
                 hs.add(curr.data);
                 prev = curr;
             }
             curr = curr.next;
         }
         
         
         return head;
         
    }
}
'''

def removeDuplicates(head):
    if head is None or head.next is None:
        return head
        
    curr = head
    visited = set()
    visited.add(curr.data)
    
    while curr and curr.next:
        if curr.next.data in visited:
            nextNext = curr.next.next
            curr.next = nextNext
        else:
            visited.add(curr.next.data)
            curr = curr.next
            
            
    return head
        
    

'''
Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
'''

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummyNode = pre = ListNode(0)
        dummyNode.next = head
        
        while head and head.next:
            if head.val == head.next.val:
                while head and head.next and head.val == head.next.val :
                    head = head.next
                head = head.next
                pre.next = head
                
            else:
                pre = pre.next
                head = head.next
                
                
        return dummyNode.next