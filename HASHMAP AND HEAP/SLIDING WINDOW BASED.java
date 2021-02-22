/**
 * 
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

 */

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        if(K>N){
            return -1;
        }
        
        int ans = 0;
        int sum = 0;
        for(int i=0;i<K;i++){
            sum+=Arr.get(i);
            ans = sum;
        }
        
        for(int i = K;i<Arr.size();i++){
            sum = sum+Arr.get(i)-Arr.get(i-K);
            ans = Math.max(ans,sum);
        }
        
        return ans;
    }
}


/**
 * 
Number of subarrays having sum less than K
Given an array of non-negative numbers and a non-negative number k, find the number of subarrays 
having sum less than k. We may assume that there is no overflow.

Examples :

Input : arr[] = {1, 11, 2, 3, 15}
        K = 10
Output : 4
{1}, {2}, {3} and {2, 3}
 */


class Solution {
    public int numOfSubarraysSumLessK(int[] arr, int k) {
        int si = 0, ei = 0;
        int n = arr.length;

        int count = 0;
        int sum = 0;
        while (ei < n) {
            sum += arr[ei++];
            while (sum > k && si < ei) {
                sum -= arr[si++];
            }

            count += (ei - si);
        }

        return count;
    }
}





/**
TODO:

max min subarray of size k
first negative in every size of k
count occuence of anagram
max of all subarray of size k
max of min for every window size
largest/smallest subarray of some k
largest substring of k distinct array
length of largest substring no repetive
pick toy
minimum window substring

| 713 | Subarray Product Less Than K |  Medium | Akuna Capital |
| 3 | Longest Substring Without Repeating Characters |  Medium | Akuna Capital, Alibaba |
| 76 | Minimum Window Substring |  Hard | Airbnb |
| 239 | Sliding Window Maximum |  Hard | Apple, Microsoft |
| 340 | Longest Substring with At Most K Distinct Characters |  Hard | Facebook, Google |
| 424 | Longest Repeating Character Replacement |  Medium | Google |
| 480 | Sliding Window Median |  Hard | Amazon, Google |
| 567 | Permutation in String |  Medium | Facebook, Google |
| 727 | Minimum Window Subsequence |  Hard | Google |
| 978 | Longest Turbulent Subarray |  Medium | Amazon |
| 992 | Subarrays with K Different Integers |  Hard | Amazon |
| 995 | Minimum Number of K Consecutive Bit Flips |  Hard | Akuna Capital |
| 1004 | Max Consecutive Ones III |  Medium | Facebook |
 */