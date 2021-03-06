/**
| 155 | Min Stack |  Easy | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
 */

public static class MinStack {
    Stack < Integer > allData;
    Stack < Integer > minData;

    public MinStack() {
        allData = new Stack < > ();
        minData = new Stack < > ();
    }


    int size() {
        return allData.size();
    }

    void push(int val) {
        allData.push(val);
        if (minData.size() == 0 || val <= minData.peek()) {
            minData.push(val);
        }
    }

    int pop() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = allData.pop();
            if (val == minData.peek()) {
                minData.pop();
            }
            return val;
        }
    }

    int top() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return allData.peek();
        }
    }

    int min() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return minData.peek();
        }
    }
}




class MinStack {
    Stack<Long> st = new Stack<>();
    long globalMin = 0; 

    public MinStack() {
        
    }
    
    public void push(int x) {
        long val = x;
        if(st.size()==0){
            st.push(val);
            globalMin = val;
            return;
        }
        
        if(val < globalMin){
            st.push((val - globalMin) + val);
            globalMin = val;
        }else{
            st.push(val);
        }
    }
    
    public void pop() {
        if(st.peek() < globalMin){
            globalMin = (globalMin - st.peek()) + globalMin;
        }
        
        st.pop();
        
    }
    
    public int top() {
        if(st.peek() < globalMin) 
            return (int)globalMin; 
            
        return (int)((long)st.peek());
    }
    
    public int getMin() {
        return (int)globalMin;
    }
}



/**
|  Max Stack | Facebook |
 */


class Solution {
    public static class MyStack {
        Stack<Integer> s = new Stack<Integer>();
        int maxEle;

        public int getMax() {
            if (s.empty())
                System.out.print("Stack is empty\n");
            else
                return maxEle;
        }

        
        public int top() {
            if (s.empty()) {
                System.out.print("Stack is empty ");
                return -1;
            }
            if(s.peek()>maxEle){
                return maxEle;
            }else{
                return s.peek();
            }
        }

        public void pop() {
            if (s.empty()) {
                System.out.print("Stack is empty\n");
                return;
            }

            if(s.peek()>maxEle){
                maxEle = 2 * maxEle - t;
            }
            s.pop();
        }


        public void push(int x) {
            if (s.empty()) {
                maxEle = x;
                s.push(x);
                return;
            }

            if (x > maxEle) {
                s.push(2 * x - maxEle);
                maxEle = x;
            }else{
                s.push(x);
            }
        }
    };

 
}




// TWO STACK IN AN ARRAY
public class Main {

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (tos1 == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (tos2 == data.length) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (tos1 == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos1];
            }
        }

        int top2() {
            if (tos2 == data.length) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos2];
            }
        }
    }

   
}


/**
Efficiently Implement K Queues Single Array
Efficiently Implement K Stacks Single Array
 */