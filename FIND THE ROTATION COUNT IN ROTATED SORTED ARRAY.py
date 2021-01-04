'''
Rotation 
Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value 
of K.

Example 1:

Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. 
The original sorted array is 1 2 3 4 5. 
We can see that the array was rotated 
1 times to the right.

'''

class Solution:
    def findKRotation(self,arr,  n):
        # find the position of smallest element its index will be K
        low = 0
        high = len(arr)-1
        
        while high>=low:
            if arr[low]<=arr[high]:
                return low #already sorted array 
            
            mid = (low+high)//2
            next = (mid+1)%len(arr)
            prev = (mid-1+len(arr))%len(arr)
            
            if arr[mid]<=arr[prev] and arr[mid]<=arr[next]:
                return mid
            elif arr[mid]>=arr[low]: #if first part sorted search in second part
                low = mid+1
            elif arr[high]>=arr[mid]: #if second part sorted search in first part
                high = mid-1
                
        return -1