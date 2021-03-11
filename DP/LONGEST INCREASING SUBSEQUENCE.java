/**
| 300 | Longest Increasing Subsequence |  Medium | Adobe, Airbnb, Amazon, Apple, Facebook, Google, Microsoft |
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing 
the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

class Solution {
    public static int LIS_Rec(int[] arr, int ei, int[] dp) {
        if (dp[ei] != 0)
            return dp[ei];

        int maxLen = 1;
        for (int i = ei; i >= 0; i--) {

            if (arr[i] < arr[ei]) {
                int len = LIS_Rec(arr, i, dp);
                maxLen = Math.max(maxLen, len + 1);
            }
        }

        return dp[ei] = maxLen;
    }

    public static int LIS_Rec(int[] arr) {
        if (arr.length == 0)
            return 0;

        int n = arr.length;
        int[] dp = new int[n];
        int max_ = 0;
        for (int i = n - 1; i >= 0; i--) {
            max_ = Math.max(LIS_Rec(arr, i, dp), max_);
        }

        return max_;
    }

    
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

    //  | 673 | Number of Longest Increasing Subsequence |  Medium | Amazon, Facebook |
    public int findNumberOfLIS(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        int maxLen = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1)
                        count[i] += count[j];
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxCount = count[i];
            } else if (dp[i] == maxLen) {
                maxCount += count[i];
            }
        }

        return maxCount;
    }

}

// print all longest increasing subsequence
public class Main {

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }

        System.out.println(omax);

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < dp.length; i++) {
            if (omax == dp[i]) {
                queue.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();

            if (rem.l == 1) {
                System.out.println(rem.psf);
            }

            for (int j = rem.i - 1; j >= 0; j--) {
                if (dp[j] == rem.l - 1 && arr[j] <= rem.v) {
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
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



    // minimum no of deletion to make array in sorted order in increasing order.
	public static int minimum_No_of_deletion(int[] arr){
		int n=arr.length;
		int[] dp=new int[n];

		dp[0] = 1;
		int maxLen = 0;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) { 
				if (arr[i] >= arr[j]) { 
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		return n-maxLen;
	}
}


/**
Get Minimum Squares 
Given a number N. Find the minimum number of squares of any number that sums to N. For Example: If N = 100 , N can be 
expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5) but the output will be 1 as minimum number of square is 1 , 
i.e (10*10).
 

Example 1:

Input: N = 100
Output: 1
Explanation: 10 * 10 = 100
 */



class Solution {
    public int MinSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int rem = i - j * j;
                if (dp[rem] < min) {
                    min = dp[rem];
                }
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }
}




/**
Maximum Sum Bitonic Sub Sequence
maximum non overlapping bridges
Russian Doll Envelopes |  Hard | Google |
activity selection
Alternating Subsequence With Maximum Sum Medium
highway billboard game
word wrap problem
Longest Common Increasing Subsequence Lcs Lis
Find the Shortest Superstring |  Hard | Google |
Longest alternating subsequence	GP				https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence/0	
Box Stacking				https://practice.geeksforgeeks.org/problems/box-stacking/1	Box Stacking
Longest Arithmetic Sequence	Leet				https://leetcode.com/problems/longest-arithmetic-sequence	
Minimum four sum subsequence 	GP				https://practice.geeksforgeeks.org/problems/minimum-four-sum-subsequence/1	
Number of Longest Increasing Subsequence	Leet				https://leetcode.com/problems/number-of-longest-increasing-subsequence	
Delete Columns to Make Sorted III	Leet				https://leetcode.com/problems/delete-columns-to-make-sorted-iii	
*/