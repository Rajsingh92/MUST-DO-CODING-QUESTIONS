/**
//Leetcode 295.=============================================
class MedianFinder {
         
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            return b - a;
        });
        
        public MedianFinder() {
             
        }
        
        public void addNum(int num) {
            if( maxHeap.size() == 0 || num <= maxHeap.peek())  maxHeap.add(num);
            else minHeap.add(num);

            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.peek());
                maxHeap.remove();
            }else if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.peek());
                minHeap.remove();
            }  
        }
        
        public double findMedian() {
            if(maxHeap.size() == minHeap.size() && maxHeap.size() != 0) return (maxHeap.peek() + minHeap.peek()) / 2;
            else if(maxHeap() != minHeap.size()) return maxHeap.peek();
        }
    }
 */

public class Main {

    public static class MedianPriorityQueue {
        PriorityQueue < Integer > left;
        PriorityQueue < Integer > right;

        public MedianPriorityQueue() {
            left = new PriorityQueue < > (Collections.reverseOrder());  //max heap
            right = new PriorityQueue < > ();   // min heap
        }

        public void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            handleBalance();
        }

        private void handleBalance() {
            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }
    }
}