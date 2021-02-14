
// Normal Queue
public class NormalQueue {

    public static class Queue {
        int[] data;
        int front;
        int size;

        public Queue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue overflow");
            } else {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];

                front = (front + 1) % data.length;
                size--;

                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                return val;
            }
        }
    }
}








// Dynamic Queue

public class DynamicQueue {

    public static class Queue {
        int[] data;
        int front;
        int size;

        public Queue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front + i) % data.length;
                    ndata[i] = data[idx];
                }
                data = ndata;
                front = 0;
            }

            int idx = (front + size) % data.length;
            data[idx] = val;
            size++;
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];

                front = (front + 1) % data.length;
                size--;

                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                return val;
            }
        }
    }

}









// | 232 | Implement Queue using Stacks |  Easy | Apple, Microsoft |

public class Main {
    // add efficient
    public static class StackToQueueAdapter {
        Stack < Integer > mainS;
        Stack < Integer > helperS;

        public StackToQueueAdapter() {
            mainS = new Stack < > ();
            helperS = new Stack < > ();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();
                helperS.push(val);

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }
    }

    // remove efficient
    public static class StackToQueueAdapter {
        Stack < Integer > mainS;
        Stack < Integer > helperS;

        public StackToQueueAdapter() {
            mainS = new Stack < > ();
            helperS = new Stack < > ();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }

            mainS.push(val);

            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.peek();
            }
        }
    }
}












// Queue Using LinkedList
public class Main {

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
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }
}