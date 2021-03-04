//          KADANES ALGO
//          KADANES ALGO
//          KADANES ALGO





/**
Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currSum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(currSum>0){
                currSum+=nums[i];
            }else{
                currSum = nums[i];
            }
            
            bestSum = Math.max(bestSum,currSum);
            
        }
        
        return bestSum;
    }
}






/**
K-Concatenation Maximum Sum
Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its 
sum in that case is 0. 

Example 1:

Input: arr = [1,2], k = 3
Output: 9
 */



public class Main {

    public static long solution(int[] arr, int k, long sum) {
        if(k==1){
            return kadanesForOne(arr);
        }
        
        if(sum<0){
            return kadanesForTwo(arr);
        }else{
            return kadanesForTwo(arr)+(k-2)*sum;
        }
    }
    
     public static int kadanesForOne(int[] arr){
        int bestSum = arr[0];
        int currSum = arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(currSum>0){
                currSum+=arr[i];
            }else{
                currSum = arr[i];
            }
            
            bestSum = Math.max(bestSum,currSum);
        }
        
        return bestSum;
    }
    
    public static int kadanesForTwo(int[] arr){
        int[] narr = new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            narr[i] = arr[i];
        }
        for(int i=0;i<arr.length;i++){
            narr[i+arr.length] = arr[i];
        }
        
        return kadanesForOne(narr);
    }

}




/**
 Print continuous subarray with maximum sumMedium
 Maximum Contiguous Circular Subarray Sum
 Largest Sum Subarray With At-Least k Numbers
 */