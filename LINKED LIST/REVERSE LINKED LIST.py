'''

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;  //backup
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        return head;
    }
}
'''
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        curr = head
        prev = None
        
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        
        head = prev
        return head

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        
        def reverse(head):
            if head is None or head.next is None:
                return head
            
            tmp = reverse(head.next)
            head.next.next = head
            head.next = None
            
            return tmp
        return reverse(head)


