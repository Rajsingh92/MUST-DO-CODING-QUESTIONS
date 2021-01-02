'''
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


'''

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        no_of_nodes = 0
        
        #count nodes
        tmp = head
        while tmp:
            no_of_nodes+=1
            tmp = tmp.next
        
        #traverse upto count//2
        no_of_nodes = no_of_nodes//2
        tmp = head
        while no_of_nodes>0:
            tmp = tmp.next
            no_of_nodes-=1
            
        return tmp


class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        slow = head
        fast = head
        
        while slow and slow.next and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        return slow

    def middleNodeCircularList(self,head):
        slow = fast = head
        
        while fast.next!=head and fast.next.next!=head:
            slow = slow.next
            fast = fast.next.next
            
        return slow

