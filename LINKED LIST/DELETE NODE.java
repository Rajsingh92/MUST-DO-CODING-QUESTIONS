/**
| 237 | Delete Node in a Linked List |  Easy | Apple |

Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, 
instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.

 

Example 1:


Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your 
function.
 */

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}









/*
Delete nodes having greater value on right 
Given a singly linked list, remove all the nodes which have a greater value on its following nodes.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on their next node. So, after deleting
them, the linked list would like be 15,
11, 6, 3.
*/

public class Solution{
    
    public static void deleteRightNode(Node head){
        int max = head.data;
		Node node = head.next;
		Node prev = head;
		while (node != null) {
			if (node.data > max) {
				max = node.data;
				prev = node;
			} else {
				prev.next = node.next;
			}

			node = node.next;
		}
    }


    public static void deletenodes(Node head){
        reverse(head);
        deleteRightNode(head);
        reverse(head);
    }

    public static void reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}







/**
	Delete N nodes after M nodes of a linked list	GP				https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1	Delete N nodes after M nodes of a linked list
	Delete Alternate Nodes	GP				https://practice.geeksforgeeks.org/problems/delete-alternate-nodes/1	Delete Alternate Nodes
	Delete the elements in an linked list whose sum is equal to zero	GTT				https://www.careercup.com/question?id=5717797377146880	Delete the elements in an linked list whose sum is equal to zero
 */