/**
 Given a pointer to a node to be deleted, delete the node. Note that we don’t have pointer to head node.
 */

public class Solution{
    public static void delete(Node del){
        del.data = del.next.data;
        del.next = del.next.next;
    }
}