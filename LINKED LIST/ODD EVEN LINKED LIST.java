/**
| 328 | Odd Even Linked List |  Medium | Amazon, Google, Microsoft |
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are 
talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
*/


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode ehead = even;
        
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        odd.next = ehead;
        return head;
    }
    
}


/**
 * 
Segregate even and odd nodes in a Linked List
modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. 
Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL
 */

public class Main{
    public static void oddEvenList(ListNode head){
        ListNode evenStart = null;
        ListNode evenEnd = null;
        ListNode oddStart = null;
        ListNode oddEnd = null;


        while(head!=null){
            if(head.data%2==0){
                if(evenStart==null){
                    evenStart = evenEnd = head;
                }else{
                    evenEnd.next = head;
                    evenEnd = evenEnd.next;
                }
            }else{
                if(oddStart == null){
                    oddStart = oddEnd = head;
                }else{
                    oddEnd.next = head;
                    oddEnd = oddEnd.next;
                }
            }
            head = head.next;
        }

        if(oddStart == null || evenStart == null){
            return;
        }

        head = evenStart;
        evenEnd.next = oddStart;
        oddEnd.next = null;

    }
}