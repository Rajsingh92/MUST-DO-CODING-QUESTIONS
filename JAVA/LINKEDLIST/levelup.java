import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class question{
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode midNode(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // leetcode 876:
    public ListNode middleNode(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // leetcode 206:

    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode forw = curr.next; // backup.

            curr.next = prev; // connection

            prev = curr; // move forw.
            curr = forw;
        }

        return prev;
    }

    public void reverseDataItr(){  
        int i=0;
        int j=this.size-1;
        while(i<j){
            Node left=getNodeAt(i);
            Node right=getNodeAt(j);
            swapData(left,right);
            i++;
            j--;
        }
    }

    public void recersePointerItr(){
        Node prev=null;
        Node curr=this.head;
        Node forw=null;
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;

            prev=curr;
            curr=forw;
        }

        this.tail=this.head;
        this.head=prev;
    }

    // leetcode 234.=======================================

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        nhead = reverseList(nhead);

        ListNode c1 = head, c2 = nhead;
        boolean res = true;

        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        nhead = reverseList(nhead);
        mid.next = nhead;

        return res;
    }

    // Leetcode 143.
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        nhead = reverseList(nhead);
        ListNode c1 = head, c2 = nhead;

        while (c1 != null && c2 != null) {
            ListNode f1 = c1.next, f2 = c2.next; // backup

            c1.next = c2; // connection.
            c2.next = f1;

            c1 = f1; // move forward.
            c2 = f2;
        }
    }

    //leetcode 138
    public Node copyRandomList(Node head) {
        //First: we try to make new nodes and link them next to each other.
        Node curr=head,forw=null;
        while(curr!=null){
            forw=curr.next;

            Node copyNode=new Node(curr.val);
            curr.next=copyNode;
            copyNode.next=forw;

            curr=forw;
        }

        //second: set random pointers.
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;  
            curr=curr.next.next;
        }

        //Third: extract copy List.
        curr=head;
        Node newList=new Node(-1);  // dummy Node.
        Node newCurr=newList;
        Node copyNode=null;

        while(curr!=null){
            forw=curr.next.next;

            copyNode=curr.next;
            newCurr.next=copyNode;
            curr.next=forw;

            curr=forw;
            newCurr=copyNode;
        }

        return newList.next;
    }

    //leetcode 61
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head; 
        int size=0;
        ListNode curr=head,tail=null;
        while(curr!=null){
            tail=curr;
            curr=curr.next;
            size++;
        }

        k%=size;  //k in range
        if(k<0) k+=size;  // k become positive.

        if(k==0) return head;

        curr=head;
        int count=1;
        int n=size-k;
        
        while(count<n){
            curr=curr.next;
            count++;
        }

        tail.next=head;
        head=curr.next;
        curr.next=null;
        
        return head;
    }

    // Leetcode 19:
    public ListNode removeNthFromEnd(ListNode head, int n) { // min possible value of n : 1 and it is always valid.
        if (head == null || head.next == null)
            return null;

        ListNode c1 = head, c2 = head;
        while (n-- > 0)
            c2 = c2.next;

        if (c2 == null) // if we have to remove head.
            return head.next;

        while (c2.next != null) {
            c1 = c1.next;
            c2 = c2.next;
        }

        ListNode rnode = c1.next;
        c1.next = rnode.next;
        rnode.next = null;

        // delete rnode; // for c++.

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode head = new ListNode(-1); // dummy Node.
        ListNode prev = head;

        ListNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                prev = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = c2;
                c2 = c2.next;
            }
        }

        if (c2 != null)
            prev.next = c2;
        else
            prev.next = c1;

        return head.next;
    }

    // Leetcode 023.
    public ListNode mergeKLists(ListNode[] lists) { // O(KN).
        if (lists.length == 0)
            return null;
        ArrayList<ListNode> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++)
            list.add(lists[i]);

        while (list.size() != 1) {
            ListNode l1 = list.remove(list.size() - 1);
            ListNode l2 = list.remove(list.size() - 1);

            ListNode l3 = mergeTwoLists(l1, l2);
            list.add(l3);
        }

        return list.get(0);
    }

    public ListNode mergeKLists02(ListNode[] lists, int li, int ri) { // O(Nlogk)
        if (li == ri)
            return lists[li];

        int mid = (li + ri) / 2;

        ListNode l1 = mergeKLists02(lists, li, mid);
        ListNode l2 = mergeKLists02(lists, mid + 1, ri);
        ListNode finalList = mergeTwoLists(l1, l2);

        return finalList;
    }

    public ListNode mergeKLists02(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        return mergeKLists02(lists, 0, lists.length - 1);
    }

    // Leetcode 141: linked-list-cycle.====================================

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        return fast == slow ? true : false;
    }

    // Leetcode 142.=====================================================
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast != slow)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // Leetcode 160=========================================================
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode curr = headA;
        while (curr.next != null)
            curr = curr.next;

        curr.next = headB; // cycle.
        ListNode ans = detectCycle(headA);
        curr.next = null; // destroy cycle.
        return ans;
    }

    ListNode oH = null, oT = null;
    ListNode tH = null, tT = null;

    public void addFirstNode(ListNode node) {
        if (tT == null) {
            tH = node;
            tT = node;
        } else {
            node.next = tH;
            tH = node;
        }
    }

    public int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1)
            return head;

        int len = length(head);
        if (len < k)
            return head;

        ListNode curr = head;
        while (curr != null && len >= k) {
            int temp = k;
            while (temp-- > 0) {
                ListNode rnode = curr;
                curr = curr.next;
                rnode.next = null;

                addFirstNode(rnode);
            }

            if (oH == null) {
                oH = tH;
                oT = tT;
            } else {
                oT.next = tH;
                oT = tT;
            }

            tH = null;
            tT = null;

            len -= k;
        }

        oT.next = curr;
        return oH;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m)
            return head;

        int i = 1;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            while (i >= m && i <= n) {
                ListNode rnode = curr;
                curr = curr.next;
                rnode.next = null;
                addFirstNode(rnode);
                i++;
            }

            if (i > n) {
                if (prev != null)
                    prev.next = tH;
                else
                    head = tH;
                tT.next = curr;
                break;
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        return head;
    }

    ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        while (head != null) {
            ListNode rnode = head;
            head = head.next;
            rnode.next = null;
            addFirstNode(rnode);
        }

        return th;

    }


    // Class Question: reverse Data.
    public void reverseListData(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode curr = head;
        ListNode midNode = getMidNode(curr);

        ListNode nhead = midNode.next;
        midNode.next = null;

        nhead = reverseList(nhead);
        ListNode curr1 = nhead;
        while (curr != null && curr1 != null) {

            int temp = curr.val;
            curr.val = curr1.val;
            curr1.val = temp;

            curr = curr.next;
            curr1 = curr1.next;
        }

        nhead = reverseList(nhead);
        midNode.next = nhead;
    }

    Node sNode=this.head;
    private void reverseDataRecursive(Node node,int level){
        if(node==null) return;

        reverseDataRecursive(node.next,level+1);
        if(level>=this.size/2){
            swapData(sNode,node);
            sNode=sNode.next;
        }
    }


}








public class Q001Leetcode025_reverse_nodes_in_k_group {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    ListNode oh = null;
    ListNode ot = null;

    ListNode th = null;
    ListNode tt = null;

    public void addFirstNode(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public int len(ListNode node) {
        int l = 0;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1)
            return head;

        int len = len(head);
        if (len < k)
            return head;

        ListNode curr = head;
        while (curr != null) {
            int tk = k;

            while (tk-- > 0) {
                ListNode forw = curr.next;

                curr.next = null;
                addFirstNode(curr);

                curr = forw;
            }

            len -= k;

            if (ot == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;

            if (len < k) {
                ot.next = curr;
                curr = null;
            }
        }

        return oh;
    }

    public ListNode reverseKGroup_02(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int len = len(head);

        if (len < k)
            return head;

        ListNode nhead = null;
        ListNode ntail = head;

        while (head != null) {
            int temp = k;
            ListNode ttail = null;
            ListNode rev = null;

            if (len >= k) {
                while (head != null && temp != 0) {
                    if (ttail == null) {
                        ttail = head;
                    }

                    ListNode forw = head.next;
        
                    head.next = rev;
                    
                    rev = head;
                    head = forw;

                    temp--;
                }
                len -= k;

                if (nhead == null) {
                    nhead = rev;
                } else {
                    ntail.next = rev;
                    ntail = ttail;
                }
            } else {
                ntail.next = head;
                break;
            }

        }

        return nhead;

    }

    public ListNode reverseBetween(ListNode node, int m, int n) {
        if (node.next == null || m == n)
            return node;

        int idx = 1;

        ListNode curr = node;
        ListNode prev = null;
        ListNode nhead = node;

        while (curr != null) {
            while (idx >= m && idx <= n) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                

                curr = forw;
                idx++;
            }

            if (tt != null) {
                tt.next = curr;
                if (prev != null)
                    prev.next = th;
                else
                    nhead = th;
                break;
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }

        return nhead;
    }

    // Function to convert a multilevel linked list to a singly linked list
    public static Node convertList(Node head)
    {
        // find tail node of the head node
        Node tail = findTail(head);
 
        // start from the head node
        Node curr = head;
 
        // process all nodes
        while (curr != null)
        {
            // if current node has a child
            if (curr.child != null) {
                // set the child node as next node of the tail node
                tail.next = curr.child;
 
                // update the tail to last node of the child node
                tail = findTail(curr.child);
            }
 
            // advance current node
            curr = curr.next;
        }
 
        return head;
    }

    // Function to pairwise swap adjacent nodes of a linked list
    public static Node rearrange(Node head)
    {
        // if list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }
 
        Node curr = head, prev = null;
 
        // consider two nodes at a time and swap their links
        while (curr != null && curr.next != null)
        {
            Node temp = curr.next;
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

    // Function to swap k'th node from the beginning with the
    // k'th node from the end in a linked list
    public static Node swapNodes(Node head, int k)
    {
        Node x, y, prev_x = null, prev_y = head;
 
        // find k'th node from the beginning and store it in x
        // also calculate previous node of x and store it in prev_x
        Node curr = head;
        for (int i = 1; i < k && curr != null; i++)
        {
            prev_x = curr;
            curr = curr.next;
        }
        x = curr;
 
        // k is more than number of nodes, X and Y don’t exist
        if (curr == null) {
            return null;
        }
 
        // find k'th node from the end and store it in y
        // also calculate previous node of y and store it in prev_y
        Node ptr = head;
        while (curr.next != null)
        {
            prev_y = ptr;
            ptr = ptr.next;
            curr = curr.next;
        }
        y = ptr;
 
        // Y is next to X (X . Y)
        if (x.next == y)
        {
            x.next = y.next;
            y.next = x;
            prev_x.next = y;
        }
 
        // X is next to Y (Y . X)
        else if (y.next == x)
        {
            y.next = x.next;
            x.next = y;
            prev_y.next = x;
        }
 
        // X is head node
        else if (x == head)
        {
            head = y;
            y.next = x.next;
            prev_y.next = x;
            x.next = null;
        }
 
        // Y is head node
        else if (y == head)
        {
            head = x;
            x.next = y.next;
            prev_x.next = y;
            y.next = null;
        }
 
        // otherwise
        else {
            ptr = y.next;
            y.next = x.next;
            x.next = ptr;
 
            prev_x.next = y;
            prev_y.next = x;
        }
 
        return head;
    }

}


