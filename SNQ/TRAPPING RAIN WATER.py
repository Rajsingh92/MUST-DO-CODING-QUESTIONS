'''
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can 
trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


public static int rainWater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);

        for (int i = 0; i < arr.length; i++) {
            while (st.peek() != -1 && arr[i] > arr[st.peek()]) {
                int h = arr[st.pop()];
                if (st.peek() == -1)
                    break;
                int width = i - st.peek() - 1;

                int height = (Math.min(arr[st.peek()], arr[i]) - h);
                ans += width * height;
            }

            st.push(i);
        }

        return ans;

    }

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
  
        Stack<Integer> st = new Stack<>();
        int water = 0;
        for(int i=0;i<n;i++){
            while(st.size()!=0 && height[st.peek()] <= height[i]){
                int h = height[st.peek()];
                st.pop();

                if(st.size()==0) break;

                int W = (i - st.peek() - 1);
                
                int h1 = height[i];
                int h2 = height[st.peek()];
                int H = Math.min(h1,h2) - h;
                
                water += H * W;   
            }

            st.push(i);
        }

        return water;
    }

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
  
        int water = 0, lmax = 0,rmax = 0, li = 0, ri = n-1;
        while(li < ri){
            lmax = Math.max(lmax,height[li]);
            rmax = Math.max(rmax,height[ri]);

            if(lmax <= rmax) water += lmax - height[li++];
            else water += rmax - height[ri--];
        }

        return water;
    }
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        
        leftMax = [0]*n
        rightMax = [0]*n
        
        leftMax[0] = height[0]
        for i in range(1,n):
            leftMax[i] = max(leftMax[i-1],height[i])
        
        rightMax[n-1] = height[n-1]
        for i in range(n-2,-1,-1):
            rightMax[i] = max(rightMax[i+1],height[i])
        
        water = 0
        for i in range(n):
            water+=min(leftMax[i],rightMax[i])-height[i]
        
        return water
        
# optimization
class Solution:
    def trap(self, arr):
        left = right = water = 0
        i, j = 0, len(arr)-1
        while i <= j:
            left, right = max(left, arr[i]), max(right, arr[j])
            while i <= j and arr[i] <= left <= right:
                water += left - arr[i]
                i += 1
            while i <= j and arr[j] <= right <= left:
                water += right - arr[j]
                j -= 1
        return water
        

        
    