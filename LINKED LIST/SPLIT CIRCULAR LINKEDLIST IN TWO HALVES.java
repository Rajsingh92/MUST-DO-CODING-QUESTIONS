
public class Solution{
    static Node head, head1, head2; 

    public static void splitList(){
        if(head == null){
            return;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next!=head && fast.next.next!=head){
            slow = slow.next;
            fast = fast.next.next;
        }

        //even elements
        if(fast.next.next == head){
            fast = fast.next;
        }

        head1 = head;
        if(head.next != head){
            head2 = slow.next;
        }

        fast.next = slow.next;
        slow.next = head;
    }
}


/**
| 86 | Partition List |  Medium | Amazon, Microsoft |
| 725 | Split Linked List in Parts |  Medium | Google |
modify linkedlist https://www.geeksforgeeks.org/modify-contents-linked-list/
 */