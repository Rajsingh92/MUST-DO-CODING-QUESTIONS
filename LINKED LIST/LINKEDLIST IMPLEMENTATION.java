

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
}