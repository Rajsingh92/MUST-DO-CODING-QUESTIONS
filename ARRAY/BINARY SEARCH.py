'''
| 704 | Binary Search |  Easy | Google |
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





"""
Find floor and ceil in an sorted array
Given an sorted array arr[] and an element x, find floor and ceiling of x in arr[0..n-1].
Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is 
smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greates element of arr[].

arr = {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array

"""


class BinarySearch:
    def binarySearch(self,arr,low,high,key):

        if high>=low:
            mid = (low+high)//2

            if arr[mid] == key:
                return mid
            elif arr[mid]>key:
                return self.binarySearch(arr,low,mid-1,key)
            else:
                return self.binarySearch(arr,mid+1,high,key)
        else:
            return -1


    # Find Floor of an element in a Sorted Array
    def findFloor(self,arr,k):
        low = 0
        high = len(arr)-1
        floor = -1

        while low<=high:
            mid = (low+high)//2

            if arr[mid]==k:
                return arr[mid]
            elif arr[mid]>k:
                high =mid-1
            else:
                floor = arr[mid]
                low = mid+1
        return floor
    

    # Ceil of an element in a Sorted Array
    def findCeil(self,arr,k):
        low = 0
        high = len(arr)-1
        ceil = -1

        while low<=high:
            mid = (low+high)//2

            if arr[mid]==k:
                return arr[mid]
            elif arr[mid]>k:
                ceil = arr[mid]
                high = mid-1
            else:
                low= mid+1

        return ceil

    # Find position of an element in a sorted array of infinite numbers
    def findKeyInInfiniteSortedArray(self,arr,key):
        low = 0
        high = 1

        while arr[high]<key:
            low= high
            high = high*2

        return self.binarySearch(arr,low,high,key)







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









'''
Search in Rotated Sorted Array
You are given an integer array nums sorted in ascending order, and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

'''
        
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while high>=low:
            
            mid =  low+(high-low)//2
            
            if nums[mid] == target:
                return mid
            
            elif nums[low]<=nums[mid]: #first part is sorted
                if nums[low]<=target<=nums[mid] : # lie between low and mid
                    high = mid-1
                else:
                    low = mid+1
     
            else: # second part sorted
                if nums[mid]<=target<=nums[high]: # lie between mid and high
                    low = mid+1
                else:
                    high = mid-1
            
                
        return -1     
        




        
'''
Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

'''

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        low = 0
        high = len(nums)-1
        
        while high>=low:
            
            mid =  low+(high-low)//2
            
            if nums[mid] == target:
                return True
            while low<mid and nums[low] == nums[mid]:
                low+=1
            
            if nums[low]<=nums[mid]: #first half is sorted
                if nums[low]<=target<=nums[mid] : # lie between low and mid
                    high = mid-1
                else:
                    low = mid+1
     
            else: # second half sorted
                if nums[mid]<=target<=nums[high]: # lie between mid and high
                    low = mid+1
                else:
                    high = mid-1
            
                
        return False 