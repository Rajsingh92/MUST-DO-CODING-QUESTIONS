// Quicksort for Linked Lists  
// Roatate doubly linkedlist in group
// reverse doubly linkedlist  
// insert into sorted cyclic linkedlist
// fold unfold
// Add 1 to linked list
// addition of ploynomials



//todo
public class Solution{
    static Node head;
	static Node tail;
	static Node head2;
	static Node tail2;
	static Node reshead;
    static Node restail;
    
    public static void sumofLinkedlists(Node head1, Node head2) {

		int size1 = 0;
		int size2 = 0;
		// find length of list2

		Node temp = head1;
		while (temp != null) {
			size1++;
			temp = temp.next;
		}
		// find length of list2

		temp = head2;
		while (temp != null) {
			size2++;
			temp = temp.next;
		}

		int diff = size1 - size2;
		if (size1 > size2) {
			temp = head1;
			for (int i = 0; i < diff; i++) {
				temp = temp.next;
			}
			int carry = findsumfromendtohere(temp, head2);
			findsumfromheretostart(head1, temp, carry);
		} else if (size2 > size1) {
			temp = head2;
			for (int i = 0; i < size2-size1; i++) {
				temp = temp.next;
			}
			int carry = findsumfromendtohere(head1, temp);
			findsumfromheretostart(head2, temp, carry);
		} else {
			int carry = findsumfromendtohere(head1, head2);
			if (carry != 0) {
				Node newnode = new Node(carry, null);
				restail.next = newnode;
				restail = newnode;
			}
		}

	}


	private static int findsumfromheretostart(Node head1, Node temp, int carry) {
		if (head1 == temp) {
			return carry;
		}

		int sum = findsumfromheretostart(head1.next, temp, carry);
		sum += head1.data;
		Node newnode = new Node(sum % 10, null);
		carry = sum / 10;
		if (reshead == null) {
			reshead = newnode;
			restail = newnode;
		} else {
			restail.next = newnode;
			restail = newnode;
		}
		return carry;
	}

	private static int findsumfromendtohere(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return 0;
		}
		int sum = findsumfromendtohere(node1.next, node2.next);
		sum += node1.data + node2.data;
		Node newnode = new Node(sum % 10, null);
		int carry = sum / 10;
		if (reshead == null) {
			reshead = newnode;
			restail = newnode;
		} else {
			restail.next = newnode;
			restail = newnode;
		}
		return carry;
	}
	public static void reverseaList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		reshead = prev;
		restail = node;

	}
}



public class Solution{

    static Node head;
	static Node tail;
	static Node head2;
	static Node tail2;
	static Node reshead;
    static Node restail;
    
    public static void subLinkedlists() {

		int size1 = 0;
		int size2 = 0;
		// find length of list2

		Node temp = head;
		while (temp != null) {
			size1++;
			temp = temp.next;
		}
		// find length of list2

		temp = head2;
		while (temp != null) {
			size2++;
			temp = temp.next;
		}

		int diff = size1 - size2;
		if (size1 > size2) {
//			jitna 1st list bada h 2nd linked list h, utna 0's prepend kar denge 2nd list mai.
			for(int i=0; i<diff; i++) {
				Node nn=new Node(0,null);
				nn.next=head2;
				head2=nn;
			}
			
			//pehli list ko bhi reverse kar do 
			Node prev = null;
			Node curr = head;
			Node next = null;

			while (curr != null) {
				next = curr.next;
				curr.next = prev;

				prev = curr;
				curr = next;
			}
			tail = head;
			head= prev;
				
			//dusri list ko bhi reverse kar do
			Node prev2 = null;
			Node curr2 = head2;
			Node next2 = null;

			while (curr2 != null) {
				next2 = curr2.next;
				curr2.next = prev2;

				prev2 = curr2;
				curr2 = next2;
			}
			tail2= head2;
			head2= prev2;
			
			Node temp_itr1=head;
			Node temp_itr2=head2;
			Node resitr=reshead;
			int carry=0;
			while(temp_itr1!=null) {
				temp_itr1.data+=carry;
				if(temp_itr1.data<temp_itr2.data) {
					Node nn=new Node((temp_itr1.data+10)-temp_itr2.data,null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=-1;
				}else {
					Node nn=new Node((temp_itr1.data-temp_itr2.data),null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=0;
				}
				
				temp_itr1=temp_itr1.next;
				temp_itr2=temp_itr2.next;
			}
				
		} else {
			
			Node temp_itr1=head;
			Node temp_itr2=head2;
			Node resitr=reshead;
			int carry=0;
			while(temp_itr1!=null) {
				temp_itr1.data+=carry;
				if(temp_itr1.data<temp_itr2.data) {
					Node nn=new Node((temp_itr1.data+10)-temp_itr2.data,null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=-1;
				}else {
					Node nn=new Node((temp_itr1.data-temp_itr2.data),null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=0;
				}
				
				temp_itr1=temp_itr1.next;
				temp_itr2=temp_itr2.next;
			}
			
			
		}

	}
}


public class Solution{
    public static long multiply(Node first,Node second){
        int num1 = 0;
        int num2 = 0;
        while(first!=null || second!=null){
            if(first!=null){
                num1 = num1*10+first.data;
                first = first.next;
            }
            if(second!=null){
                num2 = num2*10+second.data;
                second = second.next;
            }    
        }

        return num1*num2;
    } 



}

