'''
Find first and last positions of an element in a sorted array
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element 
x in the given array. 
Examples: 

Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}    
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5


Number of occurrence 
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:
Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
'''

class Solution:
    def firstOccurence(self,arr,n,target):
        low = 0
        high = n-1
        result = -1
        
        while high>=low:
            mid = (low+high)//2
            
            if arr[mid]==target:
                result = mid
                high = mid-1
            elif arr[mid]>target:
                high = mid-1
            else:
                low = mid+1
                
        return result
        
    def lastOccurence(self,arr,n,target):
        low = 0
        high = n-1
        result = -1
        
        while high>=low:
            mid = (low+high)//2
            
            if arr[mid]==target:
                result = mid
                low = mid+1
            elif arr[mid]>target:
                high = mid-1
            else:
                low = mid+1
                
        return result

	def count(self,arr, n, x): # Number of occurrence
		if n == 0:
		    print(0)
		if self.lastOccurence(arr,n,x)==-1 and self.firstOccurence(arr,n,x) == -1:
		    return 0
		    
		return self.lastOccurence(arr,n,x)-self.firstOccurence(arr,n,x)+1