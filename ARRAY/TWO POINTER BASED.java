/**

| 42 | Trapping Rain Water |  Hard | Adobe, , Amazon, Apple, Facebook, Google, Microsoft |
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can 
trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
 */


class Solution {
    
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for(int i = 1;i<n;i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        
        rightMax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        
        int water = 0;
        for(int i = 0;i<n;i++){
            water+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        
        return water;

    }

    // optimization
    public int trap2(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int water = 0;
        
        int maxHeight = 0;
        int maxHeightIndex = 0;
        for(int i = 0;i<n ;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        
        int leftMax = 0;
        for(int i = 0;i<maxHeightIndex;i++){
            leftMax = Math.max(height[i],leftMax);
            water+= Math.min(leftMax,maxHeight)-height[i];
        }
        
        int rightMax = 0;
        for(int i = n-1;i>maxHeightIndex;i--){
            rightMax = Math.max(height[i],rightMax);
            water+= Math.min(rightMax,maxHeight)-height[i];
        }
        
        return water;

    }
}











/**
| 238 | Product of Array Except Self |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to 
the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n];
        left[0] = 1;
        for(int i =1;i<n;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        
        int[] res = new int[n];
        for(int i=0;i<n;i++){
           res[i] = left[i]*right[i]; 
        }
        
        return res;
    }

    // optimization
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        
        int[] res = new int[n];
        for(int i=0;i<n;i++){
           res[i] = 1; 
        }
        
        int left = 1;
        for(int i =0;i<n;i++){
            res[i] = left;
            left = left*nums[i];
        }
        
        
        int right = 1;
        for(int i=n-1;i>=0;i--){
            res[i] *= right;
            right = right*nums[i];
            
        }
        
        
        
        return res;
    }
}










/**
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
Examples : 

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)
 */


public class Solution {
    private static void maxIndexDiff(int[] arr) {

      
        int[] larr = new int[arr.length];
        int[] rarr = new int[arr.length];

        larr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            larr[i] = Math.min(larr[i - 1], arr[i]);
        }

        rarr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rarr[i] = Math.max(rarr[i + 1], arr[i]);
        }

        
        int omaxdiff = Integer.MIN_VALUE;
        int currdiff = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < arr.length && j < arr.length;) {
            if (rarr[j] > larr[i]) {
                currdiff = j - i;
                j++;
            } else {
                i++;
            }
            if (currdiff > omaxdiff) {
                omaxdiff = currdiff;
            }
        }
        if (omaxdiff != Integer.MIN_VALUE)
            System.out.println(omaxdiff);
        else {
            System.out.println(-1);
        }

    }

}












/**
| 11 | Container With Most Water |  Medium | Airbnb, Alibaba |
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical 
lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, 
together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.


Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
 */

class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0 ;
        int low = 0  ;
        int high = height.length-1;
        
        while (low<high){
            int lHeight = height[low] ;
            int rHeight = height[high] ;
            int maxHeight = Math.min(lHeight,rHeight) ;
            maxWater = Math.max(maxWater,maxHeight*(high-low));
            
            if(lHeight>rHeight)
                high-- ;
            else
                low++ ;
        }
            
                
        return maxWater ;
    }
}










/**
 * 
Find common elements in three sorted arrays
Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
Examples:

Input:
ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80
 */

public class Solution{
    public static void findCommon(int[] arr1 , int[] arr2 , int[] arr3){
        int i = 0, j = 0, k = 0;
        while(i< arr1.length && j<arr2.length && k< arr3.length){
            if(arr1[i] == arr2[j] && arr2[j] == arr2[k]){
                System.out.print(arr1[i]);
                i++;
                j++;
                k++;
            }else if(arr2[j]>arr1[i]){
                i++;
            }else if(arr3[k]>arr2[j]){
                j++;
            }else{
                k++;
            }
        }
    }
}










/**
Count triplets with sum smaller than X 
Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with 
the sum smaller than the given sum value X.

 

Example 1:

Input: N = 6, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with 
sum less than 2 (-2, 0, 1) and (-2, 0, 3). 
 */


class Solution {

    public static int countTriplets(int[] arr, int sum) {

        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;
                else {
                    ans += (k - j);
                    j++;
                }
            }
        }

        return ans;
    }

}










/**
| 18 | 4Sum |  Medium | Adobe, Amazon, Apple, Facebook |
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet < ArrayList < Integer >> s = new HashSet < > ();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ArrayList < Integer > tmp = new ArrayList < > ();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        s.add(tmp);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }


        List<List<Integer>> ret = new ArrayList < > ();
        for (ArrayList < Integer > i: s) {
            ret.add(i);
        }
        return ret;
        
    }
}







/**
| 259 | 3Sum Smaller |  Medium | Google |

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
that satisfy the condition nums[i] + nums[j] + nums[k] < target.


nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
 */

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // If i + start + end less than target then that means everything between
                // Second and third element also meets condition, so count all of them and move
                // middle by one
                if (nums[i] + nums[start] + nums[end] < target) {
                    count += end - start;
                    start++;
                } else {
                    //Sum is too big only way to get it down is by reducing last element
                    end--;
                }
            }
        }
        return count;
    }
}











/**
| 977 | Squares of a Sorted Array |  Easy | Adobe |

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted 
in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */




class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int i = nums.length-1;
        int low = 0;
        int high = nums.length-1;
        
        while(i>=0){
            if(Math.abs(nums[low])>nums[high]){
                res[i]= nums[low]*nums[low];
                low++;
            }else{
                res[i] = nums[high]*nums[high];
                high--;
            }
            i--;
        }
        
        return res;
    }
}









/**

| 283 | Move Zeroes |  Easy | Adobe, Apple, Facebook, Google, Microsoft |
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

 */


class Solution {
    public void moveZeroes(int[] nums) {
        
        
        int  k =0;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k] = nums[i];
                k++;
            }
        }
        
        while(k<nums.length){
            nums[k] = 0;
            k++;
        }
    }
}









/**
Find the closest pair from two sorted arrays

Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] 
such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30
 */

class Solution {

    public void printClosest(int ar1[], int ar2[], int m, int n, int x) {

        int diff = Integer.MAX_VALUE;
        int res_l = 0, res_r = 0; // to store indices


        int l = 0, r = n - 1;
        while (l < m && r >= 0) {

            if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }

            if (ar1[l] + ar2[r] > x)
                r--;
            else 
                l++;
        }

        System.out.print("The closest pair is [" + ar1[res_l] + ", " + ar2[res_r] + "]");
    }


}









/**
| 15 | 3Sum |  Medium | Adobe, Akuna Capital, Amazon, Apple, Google, Microsoft, Alibaba |
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets 
in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>(res);


        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > -nums[i])
                    k--;
                else if (sum < -nums[i])
                    j++;
            }

        }
        return new ArrayList<>(res);
    }
}







/**
| 16 | 3Sum Closest |  Medium | Amazon, Apple, Google, Microsoft |
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to 
target. Return the sum of the three integers. You may assume that each input would have exactly one solution.


Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */




public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                if (sum < target)
                    j++;
                else
                    k--;

                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        }

        return closest;
    }
}












/**
| 209 | Minimum Size Subarray Sum |  Medium | Google, Microsoft |
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.


Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int curr_sum = nums[i];
            
            if(curr_sum>=target){
                return 1;
            }
            
            for(int j=i+1;j<nums.length;j++){
                curr_sum+=nums[j];
                
                if(curr_sum>=target && min> j-i+1){
                    min = j-i+1;
                }
            }
        }
        
        return min == Integer.MAX_VALUE?0:min;
    }
}











/**
| 986 | Interval List Intersections |  Medium | Facebook, Google |
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] 
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as 
a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 

Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */





class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
            if(secondList[j][0]>firstList[i][1]){
                i++;
            }else if(firstList[i][0]>secondList[j][1]){
                j++;
            }else{
                int a = Math.max(firstList[i][0],secondList[j][0]);
                int b = Math.min(firstList[i][1],secondList[j][1]);
                list.add(new int[]{a,b});
                
                if(firstList[i][1]<secondList[j][1]){
                    i++;
                }else{
                    j++;
                }
            }
        }
        
        int[][] res = new int[list.size()][];
        int k = 0;
        for(int[] temp : list){
            res[k++] = temp;
        }
        
        return res;
    }
}

