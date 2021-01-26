
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
