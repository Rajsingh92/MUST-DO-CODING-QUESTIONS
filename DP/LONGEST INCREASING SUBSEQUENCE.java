/**
Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing 
the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        
        for(int i = 0;i<nums.length;i++){
            Integer max = null;
            
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(max == null || dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            
            if(max!=null){
                dp[i] = max+1;
            }else{
                dp[i] = 1;
            }
            
            if(dp[i]>ans){
                ans = dp[i];
            }
            
        }
        
        return ans;
    }
}


/**
 * 
Maximum sum increasing subsequence 
Given an array arr of N positive integers, the task is to find the maximum sum increasing subsequence of the 
given array.
 

Example 1:

Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 106
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3, 100}
 */


class Solution
{
	public int maxSumIS(int nums[], int n)  
	{  
	    int ans = 0;
        int[] dp = new int[n];
        
        for(int i = 0;i<n;i++){
            Integer max = null;
            
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(max == null || dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            
            if(max!=null){
                dp[i] = max+nums[i];
            }else{
                dp[i] = nums[i];
            }
            
            if(dp[i]>ans){
                ans = dp[i];
            }
            
        }
        
        return ans;
	}  
}


/**
 * 
Longest Bitonic subsequence 
Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first increasing, then decreasing.
 

Example 1:

Input: nums = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
 */



class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer max = null;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max == null || lis[j] > max) {
                        max = lis[j];
                    }
                }
            }

            if (max != null) {
                lis[i] = max + 1;
            } else {
                lis[i] = 1;
            }
        }

        int[] lds = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer max = null;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    if (max == null || lds[j] > max) {
                        max = lds[j];
                    }
                }
            }

            if (max != null) {
                lds[i] = max + 1;
            } else {
                lds[i] = 1;
            }
        }

        int omax = lis[0]+lds[0]-1;
        for (int i = 1; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }
        
        
        return omax;
    } 
}


/**

questions iconMaximum Sum Bitonic Sub Sequence

maximum non overlapping bridges
russian doll envelops
activity selection
arithmatic slices I
arithmatic slices II
Word Break
maximum sum alternating sequence
highway billboard game
word wrap problem
 */