/**
| 206 | Reverse Linked List |  Easy | Adobe, Alibaba, Facebook, Google, Microsoft |

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

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
 */


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