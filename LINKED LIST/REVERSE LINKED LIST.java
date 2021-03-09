/**
| 206 | Reverse Linked List |  Easy | Adobe, Alibaba, Facebook, Google, Microsoft |

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */



class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // backup
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    // reverse doubly linkedlist
    public void reverse(ListNode head) {

        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}





/**
| 92 | Reverse Linked List II |  Medium | Adobe, Alibaba, Amazon, Facebook, Google, Microsoft |

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
 */


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m)
            return head;
            
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1;curr!=null && i<m;i++){
            prev = curr;
            curr = curr.next;
        }



        ListNode start = curr;
        ListNode end = null;
        for(int i = 1;curr!=null && i<=n-m+1;i++){
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }



        //fix pointers
        start.next = curr;
        if(prev!=null){
            prev.next = end;
        }else{
            head = end;
        }
        
        return head;
    }
}






/**
| 24 | Swap Nodes in Pairs |  Medium | Adobe, Amazon, Google |

Given a linked list, swap every two adjacent nodes and return its head.

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
 */


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, prev = null;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;

            if (prev == null) {
                head = temp;
            } else {
                prev.next = temp;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}


/**
Reverse alternate k node in a singly linked list	GTT				https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
| 25 | Reverse Nodes in k-Group |  Hard | Amazon | 
// Roatate doubly linkedlist in group   - k reverse ,alternate k reverse	
 */
