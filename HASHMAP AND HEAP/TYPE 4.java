//                      PREFIX SUM BASED 
//                      PREFIX SUM BASED 
//                      PREFIX SUM BASED 


/**
 * 
Largest subarray with 0 sum 
Given an array having both positive and negative integers. The task is to compute the length of the 
largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
 */


public class Main {
    int maxLen(int arr[], int n)
    {
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();  //sum to index
        map.put(sum,-1);
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int len = i-map.get(sum);
                if(len>ans){
                    ans = len;
                }
            }
        }
        
        return ans;
    }
    
}   



/**
Zero Sum Subarrays / count subarray with zero sum
You are given an array A[] of size N. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
N = 6
A[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].
 */



public class Main {
    public static int findSubarray(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;

        map.put(sum, 1); // sum to freq

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum) == false) {
                map.put(sum, 1);
            } else {
                int freq = map.get(sum);
                ans += freq;
                map.put(sum, freq + 1);
            }
        }

        return ans;

    }
}


/**
Print all subarrays with 0 sum
Given an array, print all subarrays in the array which has sum 0.

Examples:

Input:  arr = [6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7]
Output:  
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6          
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10
 */



class Solution {

    public static void printAllSubarrayWith0Sum(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> firstal = new ArrayList();
        firstal.add(-1);
        map.put(0, firstal);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                ArrayList<Integer> al = map.get(sum);
                al.add(i);
                map.put(sum, al);
            } else {
                ArrayList<Integer> al = new ArrayList();
                al.add(i);
                map.put(sum, al);
            }

        }

        ArrayList<Integer> al = new ArrayList<>(map.keySet());
        Collections.sort(al);
        for (int key : al) {
            ArrayList<Integer> getal = map.get(key);
           
            for (int i = 0; i < getal.size(); i++) {
                for (int j = i + 1; j < getal.size(); j++) {
                    System.out.println(getal.get(i) + 1 + " " + getal.get(j));
                }
            }
        }

    }
}




/**
 * 
Longest Sub-Array with Sum K 
Given an array containing N integers and an integer K., Your task is to find the length of the 
longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
 */


class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>(); // sum to index
        int sum = 0;
        int ans = 0;
        map.put(0,-1);
        
        for(int i = 0;i<A.length;i++){
            sum+=A[i];
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }
            
            
            int val = sum-K;
            if(map.containsKey(val)){
                int len = i-map.get(val);
                ans = Math.max(ans,len);
            }
            
        }
        
        return ans;
    }
    
    
}







/**
| 560 | Subarray Sum Equals K |  Medium | Facebook, Microsoft |
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(sum,1);   // sum to freq
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(map.containsKey(sum-k)){
                int freq = map.get(sum-k);
                ans+=freq;
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
        
        
    }
}


/**
 * 
Binary Subarrays With Sum
In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
 */

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0,1); // sum to freq
        
        for(int i =0;i<A.length;i++){
            sum+=A[i];
            int val = sum - S;
            
            if(map.containsKey(val)){
                ans+=map.get(val);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}



/**
You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.

IP : 0 1 0 2 0 1 0
OP : 3
 */



public class Main {

    public static int solution(int[] arr) {
        int zcount = 0,ocount=0,tcount=0;
        int deleta10 = ocount-zcount;
        int deleta21 = tcount-ocount;
        
        String key = deleta10+"#"+deleta21;
        
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put(key,-1);
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                zcount+=1;
            }else if(arr[i] == 1){
                ocount+=1;
            }else{
                tcount+=1;
            }
            
            deleta10 = ocount-zcount;
            deleta21 = tcount-ocount;
            key = deleta10+"#"+deleta21;
            
            if(map.containsKey(key)){
                int idx = map.get(key);
                int len = i-idx;
                if(len>ans){
                    ans = len;
                }
            }else{
                map.put(key,i);
            }
        }
        
        return ans;
    }
}




/**
You have to find the count of subarrays with equal number of 0s, 1s, and 2s.

IP : 0 1 0 2 0 1 0
OP : 2
 */

public class Main {

    public static int solution(int[] arr) {
        int zcount = 0,ocount=0,tcount=0;
        int deleta10 = ocount-zcount;
        int deleta21 = tcount-ocount;
        
        String key = deleta10+"#"+deleta21;
        
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put(key,1);
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                zcount+=1;
            }else if(arr[i] == 1){
                ocount+=1;
            }else{
                tcount+=1;
            }
            
            deleta10 = ocount-zcount;
            deleta21 = tcount-ocount;
            key = deleta10+"#"+deleta21;
            
            if(map.containsKey(key)){
                ans += map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        
        return ans;
    }

}



/**
 * 
Contiguous Array / longest subarray with equal number of 0s and 1s
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.


Example:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 */

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();  // sum to index
        map.put(0,-1);
        int sum = 0;
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                sum+=1;
            }else if(nums[i] == 0){
                sum+=-1;
            }
            
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int idx = map.get(sum);
                ans = Math.max(ans,i-idx);
            }
        }
        
        return ans;
    }
}

/**
count subarray with equal 0 and 1
 */

class Solution {
    public int solve(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();  // sum to freq
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                sum+=1;
            }else if(nums[i] == 0){
                sum+=-1;
            }
            
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int freq = map.get(sum);
                ans += freq;
                map.put(sum,freq+1);
            }
        }
        
        return ans;
    }
}





/**
 * 
Longest subarray with sum divisible by K 
Given an array containing N integers and a positive integer K, find the length of the longest sub 
array with sum of the elements divisible by the given value K.

Example 1:

Input:
A[] = {2, 7, 6, 1, 4, 5}
K = 3
Output: 4
Explanation:The subarray is {7, 6, 1, 4}
with sum 18, which is divisible by 3.
 */




class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();   // rem to index
        int sum = 0;
        int ans = 0;
        map.put(0,-1);
        
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem =  sum%k ;    // as the sum can be negative  taking modulo twice 

            if(rem<0){
                rem = rem+k;
            }

            if(map.containsKey(rem)==false){
                map.put(rem,i);
            }else{
                int len = i-map.get(rem);
                ans = Math.max(ans,len);
            }
            
            
        }
       return ans;
    }
 
}


/**
count subarray with sum divisible by k
 */


public class Main {

    public static int solution(int[] a, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();   // rem to freq
        int sum = 0;
        int ans = 0;
        map.put(0,1);
        
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem =  sum%k ;    // as the sum can be negative  taking modulo twice 

            if(rem<0){
                rem = rem+k;
            }

            if(map.containsKey(rem)==false){
                map.put(rem,1);
            }else{
                int freq = map.get(rem);
                ans += freq;
                map.put(rem,freq+1);
            }
            
            
        }
       return ans;
    }
}
