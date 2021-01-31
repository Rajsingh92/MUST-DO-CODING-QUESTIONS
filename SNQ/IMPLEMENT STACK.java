

// Normal Stack
public class NormalStack{
    public class Stack{
        int[] data ;
        int top ;

        public Stack(int cap){
            data = new int[cap];
            top = -1;
        }

        public int size(){
            return top+1;
        }

        public void display(){
            for(int i = top;i>=0;i--){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        public void push(int val){
            if(top == data.length-1){
                System.out.print("Stack Overflow");
            }else{
                top++;
                data[top] = val;
            }
        }

        public int pop(){
            if(top == -1){
                System.out.print("Stack Underflow");
                return -1;
            }else{
                int val = data[top];
                top--;
                return val;
            }
        }

        public int peek(){
            if(top == -1){
                System.out.print("Stack Underflow");
                return -1;
            }else{
                int val = data[top];
                return val;
            }
        }
    }
}









// Dynamic Stack

public class DynamicStack{
    public class Stack{
        int[] data ;
        int top ;

        public Stack(int cap){
            data = new int[cap];
            top = -1;
        }

        public int size(){
            return top+1;
        }

        public void display(){
            for(int i = top;i>=0;i--){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        public void push(int val){
            if(top == data.length-1){
                int[] ndata = new int[2*data.length];
                for(int i = 0;i<data.length;i++){
                    ndata[i] = data[i];
                }
                data = ndata;
            }

            top++;
            data[top] = val;
        }

        public int pop(){
            if(top == -1){
                System.out.print("Stack Underflow");
                return -1;
            }else{
                int val = data[top];
                top--;
                return val;
            }
        }

        public int peek(){
            if(top == -1){
                System.out.print("Stack Underflow");
                return -1;
            }else{
                int val = data[top];
                return val;
            }
        }
    }
}













// Stack using queue

public class Main {

    // push efficient
    public static class QueueToStackAdapter {
        Queue < Integer > mainQ;
        Queue < Integer > helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque < > ();
            helperQ = new ArrayDeque < > ();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();
                helperQ.add(val);

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }
    }

    // pop efficient
    public static class QueueToStackAdapter {
        Queue < Integer > mainQ;
        Queue < Integer > helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque < > ();
            helperQ = new ArrayDeque < > ();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }

            mainQ.add(val);

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return mainQ.remove();
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return mainQ.peek();
            }
        }
    }


}








// Stack using linkedlist

public class Main {

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
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                list.removeFirst();
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                return val;
            }
        }
    }

   
}
