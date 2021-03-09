/**
 * 
 class Node:
    def __init__(self,data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
    
    def insertAtstart(self,data):
        if self.head is None:
            newNode = Node(data)
            self.head = newNode
        else:
            newNode = Node(data)
            newNode.next = self.head
            self.head = newNode

    def insertAtEnd(self,data):
        if self.head is None:
            newNode = Node(data)
            self.head = newNode
        else:
            newNode = Node(data)
            curr = self.head
            while curr.next is not None:
                curr = curr.next
            curr.next = newNode

    def getPrevNode(self,refNode):
        curr = self.head
        while curr and curr.next!=refNode:
            curr = curr.next
        return curr

    def insertBetween(self,data,prev):
        if prev is None:
            print("Nothing")
            return
        else:
            newNode = Node(data)
            newNode.next = prev.next
            prev.next = newNode

    def delete(self,node):
        prev = self.getPrevNode(node)
        if prev is None:
            self.head = self.head.next
        else:
            prev.next = node.next


    def printLinkedList(self):
        if self.head is None:
            print("Nothing")
        else:
            curr = self.head
            while curr:
                print(curr.data,end=" ")
                curr = curr.next

    def printReverse(self):
        if head is None:
            return
        
        tmp = self.head
        self.printReverse(self.head.next)
        print(tmp.data)

    def size(self):
        if head is None:
            return 0

        return 1+self.size(self.head.next)


    


class CircularLinkedList:
    def __init__(self):
        self.head = None
    
    def insertAtStart(self,data):
        newNode = Node(data)

        if self.head is None:
            self.head = newNode
            newNode.next = self.head
        else:
            curr = self.head
            while curr and curr.next!= self.head:
                curr = curr.next
            newNode.next = self.head
            curr.next =  newNode
            self.head = newNode
        

    def printLinkedList(self):
        if self.head is None:
            print("Nothing")

        curr = self.head
        while True:
            print(curr.data,end=" ")
            curr  = curr.next
            if curr == self.head:
                break



class DoublyNode:
    def __init__(self,data):
        self.data = data
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self,data):
        self.head = None
    
    def printLinkedList(self):
        if self.head is None:
            print("Nothing")
        else:
            curr = self.head
            while curr:
                print(curr.data,end=" ")
                curr = curr.next

    def insertAtStart(self,data):
        if self.head is None:
            newNode = DoublyNode(data)
            self.head = newNode
        else:
            newNode = DoublyNode(data)
            self.head.prev = newNode
            newNode.next = self.head
            self.head = newNode
    
    def insertAtEnd(self,data):
        if self.head is None:
            newNode = DoublyNode(data)
            self.head = newNode
        else:
            curr = self.head
            while curr and curr.next:
                curr = curr.next
            newNode = DoublyNode(data)
            curr.next = newNode
            newNode.prev = curr
    
    def printReverse(self):
        curr = self.head
        while curr : 
            curr = curr.next
        while curr:
            print(curr.data,end=" ")
            curr = curr.prev

    def delete(self,head,node):
        if head is None:
            return head
        
        prev = head
        while prev and prev.next!=node:
            prev = prev.next
            
        prev.next = node.next
 */

public class Main{

        public static class Node{
            int data;
            Node next;
        }

        public static class LinkedList{
            Node head;
            Node tail;
            int size;

            public int size(){
                return size;
            }

            public void display(){
                for(Node temp = head; temp!=null;temp = temp.next){
                    System.out.print(temp.data+" ");
                }
            }

            //add
            public void addFirst(int val){
                Node temp = new Node();
                temp.data = val;
                temp.next = head;
                head  = temp;

                if(size==0){
                    tail = temp;
                }

                size++;
            }

            public void addLast(int val){
                Node temp = new Node();
                temp.data = val;
                if(size==0){
                    head = temp;
                    tail = temp;
                }else{
                    tail.next = temp;
                    tail = temp;
                }

                size++;
            }

            public void addAt(int idx,int val){
                if(idx<0 || idx>size){
                    System.out.println("Invalid arguments");
                } else if(idx==0){
                    addFirst(val);
                } else if(idx == size){
                    addLast(val);
                }else{
                    Node newNode = new Node();
                    newNode.data = val;

                    Node temp = head;
                    for(int i=0;i<idx-1;i++){
                        temp = temp.next;
                    }

                    newNode.next = temp.next;
                    temp.next = newNode;

                    size++;

                }
            }

            //get
            public int getFirst(){
                if(size==0){
                    System.out.println("Empty List");
                    return -1;
                }else{
                    return head.data;
                }
            }

            public int getLast(){
                if(size==0){
                    System.out.println("Empty List");
                    return -1;
                }else{
                    return tail.data;
                }
            }

            public int getAt(int idx){
                if(idx<0 || idx>size){
                    System.out.println("Invalid arguments");
                } else if(idx==0){
                    return getFirst();
                } else if(idx == size){
                    return getLast();
                }else{
                    Node temp = head;
                    for(int i = 0;i<idx;i++){
                        temp = temp.next;
                    }
                    return temp.data;
                }
                
            }

            private Node getNodeAt(int idx){
                Node temp = head;
                for(int i=0;i<idx;i++){
                    temp = temp.next;
                }

                return temp;
            }

            //remove
            public void removeFirst(){
                if(size==0){
                    System.out.println("Empty List");
                }else if(size==1){
                    head = tail = null;
                    size = 0;
                }else{
                    head = head.next;
                    size--;
                }
            }

            public void removeLast(){
                if(size==0){
                    System.out.println("Empty List");
                }else if(size==1){
                    head = tail = null;
                    size = 0;
                }else{
                    Node temp = head;
                    for(int i = 0;i<size-2;i++){
                        temp = temp.next;
                    }

                    tail = temp;
                    tail.next = null;
                    size--;
                }
            }

            public void removeAt(ibt idx){
                if(idx<0 || idx>size){
                    System.out.println("Inavlid arguments");
                } else if(idx == 0){
                    removeFirst();
                } else if(idx == size){
                    removeLast();
                }else{
                    Node temp = head;
                    for (int i = 0; i < idx - 1; i++) {
                        temp = temp.next;
                    }
                    temp.next = temp.next.next;
                    size--;
                }
            }

            public static class LLToQueueAdapter {
                LinkedList < Integer > list;
        
                public LLToQueueAdapter() {
                    list = new LinkedList < > ();
                }
        
                int size() {
                    return list.size();
                }
        
                void add(int val) {
                    list.addLast(val);
                }
        
                int remove() {
                    if(size()==0){
                        System.out.println("Queue underflow");
                        return -1;
                    }else{
                        return list.removeFirst();
                    }
                }
        
                int peek() {
                    if(size()==0){
                        System.out.println("Queue underflow");
                        return -1;
                    }else{
                        return list.getFirst();
                    }
                }
            }
    
            public static class LLToStackAdapter {
                LinkedList < Integer > list;
        
                public LLToStackAdapter() {
                    list = new LinkedList < > ();
                }
        
        
                int size() {
                    return list.size();
                }
        
                void push(int val) {
                    list.addFirst(val);
                }
        
                int pop() {
                    if(size()==0){
                        System.out.println("Stack underflow");
                        return -1;
                    }else{
                        return list.removeFirst();
                    }
                }
        
                int top() {
                    if(size()==0){
                        System.out.println("Stack underflow");
                        return -1;
                    }else{
                        return list.getFirst();
                    }
                }
            }

        }


        public class CircularLinkedList{

            public void display(Node head){
                Node temp = head;

                if(head!=null){
                    do{
                        System.out.println(temp.data);
                        temp = temp.next;
                    }while(temp!=head);
                }
            }

            public void addFirst(Node head,int data){
                Node newNode = Node();
                newNode.data = data;

                if(head==null){
                    head = newNode;
                    newNode.next = head;
                }else{
                    curr=head;
                    while(curr!=null && curr.next!=head){
                        curr = curr.next;
                    }

                    newNode.next = head;
                    curr.next = newNode;
                    head = newNode;
                }
            }
            //todo
            public void delete(Node head,int key){
                if(head==null){
                    return;
                }
            }
        }
}



/**
	XOR Linked List	GP				https://practice.geeksforgeeks.org/problems/xor-linked-list/1	XOR Linked List

 */