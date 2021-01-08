'''
Merge Two Sorted Lists
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the 
nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

'''

# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        dummy = ListNode(-999)
        tail = dummy
        curr1 = l1
        curr2 = l2
        
        while curr1 and curr2:
            if curr2.val>curr1.val:
                tail.next = curr1
                tail = tail.next
                curr1 = curr1.next
            else:
                tail.next = curr2
                tail = tail.next
                curr2 = curr2.next
        if curr1:
            tail.next = curr1
        if curr2:
            tail.next = curr2

            
        self.printList(dummy.next)    
        return dummy.next
        
        
    def printList(self,l):
        curr = l
        while curr:
            print(curr.val,end=" ")
            curr = curr.next