'''
Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

'''

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        
        k = 0
        
        for i in nums:
            if i!=0:
                nums[k] = i
                k+=1
        
        while k<len(nums):
            nums[k] = 0
            k+=1
            
        return nums