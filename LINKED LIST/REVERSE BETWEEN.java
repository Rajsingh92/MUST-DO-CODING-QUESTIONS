
public class Solution{
    public static void reverseBetween(Node head,int m,int n){
        if (head == null || head.next == null || n == m)
            return head;
            
        Node prev = null;
        Node curr = head;
        for(int i = 1;curr!=null && i<m;i++){
            prev = curr;
            curr = curr.next;
        }



        Node start = curr;
        Node end = null;
        for(int i = 1;curr!=null && i<=n-m+1;i++){
            Node next = curr.next;
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

    }
}
