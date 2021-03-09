
/**
| 704 | Binary Search |  Easy | Google |
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in 
nums. If target exists, then return its index, otherwise return -1.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
 */

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch2(nums,0,nums.length-1,target);
    }
    
    public int binarySearch(int[] arr, int ele) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                return mid;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return -1;
    }
    
    public int binarySearch2(int[] arr,int si,int hi,int ele){
        if(si>hi){
            return -1;
        }
        
        int mid = (si+hi)>>1;
        
        if (arr[mid] == ele) {
            return mid;
        }else if(arr[mid] < ele) {
            return binarySearch2(arr,mid+1,hi,ele);
        }else{
            return binarySearch2(arr,si,mid - 1,ele);
        }
    }
}

/**
 * 
| 74 | Search a 2D Matrix |  Medium | Amazon, Facebook, Google, Microsoft |

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length-1;
        
        while(low>=0 && low< matrix.length && high>=0 && high<matrix[0].length){
            if(matrix[low][high] == target){
                return true;
            }else if(matrix[low][high] > target){
                high--;
            }else{
                low++;
            }
        }
        
        return false;
    }
}



/**
| 34 | Find First and Last Position of Element in Sorted |  Medium | Facebook |
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
 */



class Solution {
    public int[] searchRange(int[] arr, int ele) {
        int[] res = new int[2] ;
        
        
        
        res[0] = firstOccurence(arr,ele);
        res[1] = lastOccurence(arr,ele);

        return res;
    }
    
    public int firstOccurence(int[] arr,int ele){
        int si = 0;
        int ei = arr.length - 1;
        int first = -1;
        
        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                first = mid;
                ei = mid-1;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return first;
    }
    
    public int lastOccurence(int[] arr,int ele){
        int si = 0;
        int ei = arr.length - 1;
        int last = -1;
        
        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                last = mid;
                si = mid+1;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return last;
    }

    // Count of an Element in a Sorted Array
    public int numberOfOccurences(int[] arr,int ele){
        if(lastOccurence(arr,ele)==-1 && firstOccurence(arr,ele) == -1){
            return 0;
        }
		
        return lastOccurence(arr,ele)-firstOccurence(arr,ele)+1 ;
    }
}

/**
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
 */


public class Solution {
    public void floorAndCeil(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = 0;
        int floor = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data > arr[mid]) {
                left = mid + 1;
                floor = arr[mid];
            } else if (data < arr[mid]) {
                right = mid - 1;
                ceil = arr[mid];
            } else {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }
}


/**
Search in Rotated Sorted Array |  Medium | Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
You are given an integer array nums sorted in ascending order, and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
                    
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[low]<=nums[mid]){//first part is sorted
                if(nums[low]<= target && target<nums[mid]){// lie between low and mid
                    high = mid-1;
                }else{
                    low = mid+1;
                }                 
            } else{ //  second part sorted
                if(nums[mid]< target && target<=nums[high]){// lie between mid and high
                    low = mid+1;
                }else{
                    high = mid-1;
                }   
            }  
        }
            
        return nums[low] == target ? low : -1;
    }
    

}                      

/*
| 81 | Search in Rotated Sorted Array II |  Medium | Google |
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return true;
            }
            
            while(low<mid && nums[low] == nums[mid]){
                low++;
            }
             
            if(nums[low]<=nums[mid]){//first part is sorted
                if(nums[low]<= target && target<nums[mid]){// lie between low and mid
                    high = mid-1;
                }else{
                    low = mid+1;
                }                 
            } else{ //  second part sorted
                if(nums[mid]< target && target<=nums[high]){// lie between mid and high
                    low = mid+1;
                }else{
                    high = mid-1;
                }   
            }  
        }
            
        return nums[low] == target ? true : false;
    }
}


/**
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
 */
     

class Solution {
    int findKRotation(int arr[], int n) {
        // find the position of smallest element its index will be K
        int low = 0;
        int high = n - 1;

        while (high >= low) {
            if (arr[low] <= arr[high])
                return low; // already sorted array

            int mid = (low + high) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                return mid;
            else if (arr[mid] >= arr[low]) // if first part sorted search in second part
                low = mid + 1;
            else if (arr[high] >= arr[mid]) // if second part sorted search in first part
                high = mid - 1;
        }
        return -1;
    }
}


// Find position of an element in a sorted array of infinite numbers
class Solution{
    public static int findKeyInInfiniteSortedArray(int[] arr,int key){
        int low = 0;
        int high = 1;

        while(arr[high]<key){
            low = high;
            high = high*2;
        }

        return binarySearch(arr,low,high,key);
    }
}

//  Searching in a Nearly Sorted Array
class Solution{
    public static int searchElement(int[] arr,int key) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid] == target){
                return mid;
            }else if(mid-1>=low && arr[mid-1] == target){
                return mid-1;
            }else if(mid+1<=high && arr[mid+1] == target){
                return mid+1;
            }


            if(arr[mid]>target){
                high = mid-2;
            }else{
                low = mid+2;
            }
        }

        return -1;
    }
}



/* 
Smallest alphabet greater than a given character

find the smallest element in the list that is larger than K. 

Examples:  

Input : Letters = ["D", "J", "K"]
        K = "B"
Output: 'D'
*/

class Solution{
    public static char nextGreatestAlphabet2(char[] alphabets,char k){
        int low = 0;
        int high = alphabets.length-1;
        int floor = -1;

        while(low<=high){
            int mid = (low+high)/2;

            if(alphabets[mid]>target){
                high = mid-1;
                floor = mid;
            }else{
                low = mid+1;
            }
        }

        return alphabets[floor];
    }
}



/**
| 540 | Single Element in a Sorted Array |  Medium | Amazon, Google |
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Find this single element that appears only once.


Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
 */


class Solution {
	public int singleNonDuplicate(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi){
			int mid = lo + (hi - lo)/2;
						   
			if(mid % 2 == 0){
				if(nums[mid] == nums[mid + 1]){
					lo = mid + 2;
				}else{
					hi = mid;
				}
			}else{
				if(nums[mid] == nums[mid - 1]){
					lo = mid + 1;
				}else{
					hi = mid;
				}
			}

		}
		return nums[lo];
	}
}







/**
| 162 | Find Peak Element |  Medium | Amazon, Facebook, Microsoft, Google |
| 852 | Peak Index in a Mountain Array |  Easy | Amazon, Google |
| 493 | Reverse Pairs |  Hard | Apple, Facebook, Google, Microsoft |
| 153 | Find Minimum in Rotated Sorted Array |  Medium | Google |
| 154 | Find Minimum in Rotated Sorted Array II |  Hard | Facebook, Google |
| 658 | Find K Closest Elements |  Medium | Facebook |
| 4 | Median of Two Sorted Arrays |  Hard | Alibaba, Apple |
| 278 | First Bad Version |  Easy | Facebook, Google |
Book Allocation Problem
Missing Number in AP
square root of an integer
Aggressive cows
Given A Sorted And Rotated Array, Find If There Is A Pair With A Given Sum
Find a Fixed Point (Value equal to index) in a given array
Minimum Difference Element in a Sorted Array
Find maximum element in Bitonic Array
Search An Element in Bitonic Array
 */