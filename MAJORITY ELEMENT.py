'''
Majority Element 
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an 
element that appears more than N/2 times in the array.

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output: -1

Explanation: Since, each element in 
{1,2,3} appears only once so there 
is no majority element.

'''


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]
        
        dict = {}
        candidate = -1
        
        for i in nums:
            if i not in dict:
                dict[i] = 1
            else:
                dict[i]+=1
                if dict[i]>n//2:
                    candidate = i
                    break
                    
        return candidate

    # Moore’s Voting Algorithm
    def majorityElement(self, nums: List[int]) -> int:
        
        candidate = -1
        counter = 0
        
        for j in range(len(nums)):
            if counter==0:
                candidate = nums[j]  
                counter = 1 #reset counter 
            elif nums[j]==candidate:
                counter+=1
            else:
                counter-=1
                
                
        return candidate