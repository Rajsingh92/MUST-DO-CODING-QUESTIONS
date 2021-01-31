/**

Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can 
trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
 */


class Solution {
    
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        
        for(int i = 1;i<n;i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        
        rightMax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        
        int water = 0;
        for(int i = 0;i<n;i++){
            water+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        
        return water;

    }
}



class Solution {
    
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int water = 0;
        
        int maxHeight = 0;
        int maxHeightIndex = 0;
        for(int i = 0;i<n ;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        
        int leftMax = 0;
        for(int i = 0;i<maxHeightIndex;i++){
            leftMax = Math.max(height[i],leftMax);
            water+= Math.min(leftMax,maxHeight)-height[i];
        }
        
        int rightMax = 0;
        for(int i = n-1;i>maxHeightIndex;i--){
            rightMax = Math.max(height[i],rightMax);
            water+= Math.min(rightMax,maxHeight)-height[i];
        }
        
        return water;

    }
}