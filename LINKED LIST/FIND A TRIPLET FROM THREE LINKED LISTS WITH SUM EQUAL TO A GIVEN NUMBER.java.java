
public class Solution {

	public static boolean printTripletSumFromThreeList(Node one, Node two, Node three, int target) {

		two=mergeSort(two);
		
		three=mergeSort(three);
		three=reverseaList(three);

		Node temp2=two;
		Node temp3=three;
		while (one != null) {
			two=temp2;
			three=temp3;
			while (two != null && three != null) {

				int sum = one.data + two.data + three.data;
				if (sum == target) {
					System.out.println(one.data + ", " + two.data + ", " + three.data);
					return true;
				} else if (sum < target) {

					two = two.next;
				} else {
					three = three.next;

				}

			}

			one = one.next;
		}

		System.out.println("No such pair found");
		return false;
	}
	
	public static Node reverseaList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		Node myhead=prev;
		return myhead;

	}

	
	public static Node mergeLists(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data < second.data) {

			n = first;
			n.next = mergeLists(first.next, second);

		} else {

			n = second;
			n.next = mergeLists(first, second.next);

		}

		return n;

	}

	public static Node mergeSort(Node node) {

		if (node == null) {
			return null;
		}

		if (node.next == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.next = null;
		Node firstList = mergeSort(node);
		Node secondList = mergeSort(midNext);

		return mergeLists(firstList, secondList);

	}

	public static Node getMidNode(Node node) {

		Node slow = node, fast = node.next;

		while (fast != null) {

			fast = fast.next;

			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}

		}
		return slow;
	}
}