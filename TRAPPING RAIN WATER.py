'''
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can 
trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

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
        
    