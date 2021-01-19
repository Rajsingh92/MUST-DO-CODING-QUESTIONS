'''
Max Sum Subarray of size K 
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.

'''
class Solution:
    def maximumSumSubarray (self,K,Arr,N):
        if K>N:
            return -1
            
        window = 0
        for i in range(K):  # sum of first k numbers/first window
            window +=Arr[i]
            
        curr = window
        for i in range(K,N):
            curr+=Arr[i]-Arr[i-K]
            window = max(curr,window)
            
        return window


