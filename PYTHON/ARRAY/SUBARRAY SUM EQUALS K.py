'''
Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

'''


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:  #TLE
        
        count=0
        for i in range(len(nums)):
            sum = 0
            for j in range(i,len(nums)):
                sum+=nums[j]
                if sum == k:
                    count+=1
        
        return (count)
    
    def subarraySum(self, nums, k):
        count = 0
        sums = 0
        d = dict()
        d[0] = 1
        
        for i in range(len(nums)):
            sums += nums[i]
            count += d.get(sums-k,0)
            d[sums] = d.get(sums,0) + 1
        
        return(count)