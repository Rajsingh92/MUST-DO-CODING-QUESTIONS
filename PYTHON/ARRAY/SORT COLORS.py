'''
Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color 
are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Follow up:
Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?

'''

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        start = 0
        mid = 0
        end = len(nums)-1
        
        while mid<=end:
            
            if nums[mid]==0: 
                nums[start],nums[mid] = nums[mid],nums[start]
                start+=1
                mid+=1
                
            elif nums[mid]==2: 
                nums[mid],nums[end] = nums[end],nums[mid]
                end= end-1
                
            else:  #1
                mid+=1
                
        return nums