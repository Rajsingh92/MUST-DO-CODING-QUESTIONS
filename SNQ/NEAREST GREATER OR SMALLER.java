
public class Solution{

    public int[] ngor(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,n);

        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()] < arr[i])
                ans[st.pop()] = i;
            
            st.push(i);
        }

        return ans;
    }

    public int[] ngol(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i= n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()] < arr[i])
                ans[st.pop()] = i;
            
            st.push(i);
        }

        return ans;
    }

    
    public int[] nsor(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,n);

        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()] > arr[i])
                ans[st.pop()] = i;
            
            st.push(i);
        }

        return ans;
    }

    public int[] nsol(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i= n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()] > arr[i])
                ans[st.pop()] = i;
            
            st.push(i);
        }

        return ans;
    }

  
 

    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i=0;i < n * 2;i++){
            int idx = i % n; 
            while(st.size()!=0 && arr[st.peek()] < arr[idx])
                ans[st.pop()] = arr[idx];
            
            if(i < n)
               st.push(idx);
        }

        return ans;
    }

}


/**
| 84 | Largest Rectangle in Histogram |  Hard | Microsoft |
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area 
of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] rb = new int[heights.length]; // nse on the right
        Stack < Integer > st = new Stack < > ();

        st.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek();
            }

            st.push(i);
        }

        int[] lb = new int[heights.length]; // nse on the left
        st = new Stack < > ();

        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * heights[i];
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}


/**
| 85 | Maximal Rectangle |  Hard | Adobe, Amazon, Google, Microsoft |
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's 
and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
 * 
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
    if( matrix.length == 0 ||  matrix[0].length == 0)  return 0;
     int n = matrix.length;
     int m = matrix[0].length;   

     int[] heights = new int[m];
     int area = 0;
     for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
         }

         area = Math.max(area, largestRectangleArea(heights));  //ref from above question
     }
     
     return area;
    }
}