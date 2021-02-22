/**
Maximum repeating number 
Given an array Arr of size N, the array contains numbers in range from 0 to K-1 where K is a positive 
integer and K <= N. Find the maximum repeating number in this array. If there are two or more maximum 
repeating numbers return the element having least value.

Example 1:

Input:
N = 4, K = 3
Arr[] = {2, 2, 1, 2}
Output: 2
Explanation: 2 is the most frequent element.
 */


class Solution {
    int maxRepeating(int[] arr, int n, int k) {
        
        for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % k] += k;
		}
		
		int max=Integer.MIN_VALUE;
		int pos=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
				pos=i;
			}
		}
        
        return pos;
    }
}



/**
Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            
            if(nums[index]>0){
                nums[index] = -nums[index];
            }else{
                res.add(Math.abs(index+1));
            }
        }
        
        
        return res;
    }
}

/**
 * 
| 287 | Find the Duplicate Number |  Medium | Adobe, Amazon, Google, Microsoft |
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
 */



class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}


/**
| 27 | Remove Element |  Easy | Amazon, Google |

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}


/**
| 26 | Remove Duplicates from Sorted Array |  Easy | Amazon, Apple, Facebook, Google, Microsoft |

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if(n == 0 || n==1){
            return n;
        }
        
        int k = 0;
        for(int i = 0;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[k] = nums[i];
                k++;
            }
        }
        
        nums[k] = nums[nums.length-1];
        k++;
        
        return k;
    }
}



/*
| 80 | Remove Duplicates from Sorted Array II |  Medium | Google |

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 
0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if(n <=2){
            return n;
        }
        
        int k = 0;
        for(int i=0;i<n-2;i++){
            if(nums[i]!=nums[i+2]){
                nums[k] = nums[i];
                k++;
            }
        }
        
        nums[k] = nums[n-2];
        k++;
        nums[k] = nums[n-1];
        k++;
        
        return k;
    }
}