'''
Binary Search
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in 
nums. If target exists, then return its index, otherwise return -1.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while high>=low:
            mid = (low+high)//2
            
            if nums[mid] == target:
                return mid
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1
        
        return -1  #not found

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums,0,len(nums)-1,target)
    
    def binarySearch(self,arr,low,high,x):
        if low>high:
            return -1
        
        mid = (low+high)//2
        
        if arr[mid] == x:
            return mid
        elif arr[mid]>x:
            return self.binarySearch(arr,low,mid-1,x)
        else:
            return self.binarySearch(arr,mid+1,high,x)