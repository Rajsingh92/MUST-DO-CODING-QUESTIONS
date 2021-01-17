'''
Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
begin to intersect at node c1.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the 
head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected 
node in A; There are 3 nodes before the intersected node in B.

'''
# Definition for singly-linked list.
class ListNode:
     def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        sizeA,sizeB = self.size(headA),self.size(headB)  
        delta = abs(sizeA-sizeB)
        
        currA,currB= headA,headB
        
        if sizeA>sizeB:
            for i in range(delta):
                currA = currA.next
                
        elif sizeA<sizeB:
            for i in range(delta):
                currB = currB.next
                
        while currA!=currB:
            currA = currA.next
            currB = currB.next
            
        return currA
    
    def size(self,head):
        size = 0
        curr = head
        
        while curr:
            size+=1
            curr = curr.next
            
        return size
        
        
        
        
            
        