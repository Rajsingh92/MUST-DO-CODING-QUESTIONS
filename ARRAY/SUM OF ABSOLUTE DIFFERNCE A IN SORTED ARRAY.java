/**
Sum of Absolute Differences in a Sorted Array

You are given an integer array nums sorted in non-decreasing order.

Build and return an integer array result with the same length as nums such that result[i] is equal to the summation 
of absolute differences between nums[i] and all the other elements in the array.

In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 */


class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += Math.abs(nums[i] - nums[j]);
            }
            ans[i] = temp;
        }

        return ans;
    }

    // optimization
    public int[] getSumAbsoluteDifferences2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int rsum = 0, lsum = 0;

        for (int num : nums)
            rsum += num;

        for (int i = 0; i < n; i++) {
            rsum -= nums[i];
            lsum += nums[i];
            ans[i] = (rsum - (n - i - 1) * nums[i]) + ((i + 1) * nums[i] - lsum);
        }

        return ans;
    }
}

