public class Solution {
    public static void circularlist(int m) {
		tail.next = head;
		Node curr = head;
		Node prev=null;
		while (size != 1) {
			for (int i = 0; i < m - 1; i++) {
				prev=curr;
				curr = curr.next;
			}
			// remove curr
			curr.data = curr.next.data;
			curr.next = curr.next.next;
			size--;
		}
		System.out.println(prev.data);
	}
}
