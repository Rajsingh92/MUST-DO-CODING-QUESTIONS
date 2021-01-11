'''
Sort List
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

'''
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