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
}







/**
questions iconMaximum Sum Bitonic Sub Sequence
| 673 | Number of Longest Increasing Subsequence |  Medium | Amazon, Facebook |
maximum non overlapping bridges
russian doll envelops
activity selection
arithmatic slices I
arithmatic slices II
Word Break
maximum sum alternating sequence
highway billboard game
word wrap problem

//LIS_series.=======================================================================================
     
    public static int LIS_Rec(int[] arr,int ei,int[] dp){        
        if(dp[ei]!=0) return dp[ei];
        
        int maxLen=1;
        for(int i=ei;i >=0 ;i--){
            
            if(arr[i] < arr[ei]){
               int len = LIS_Rec(arr,i,dp);
               maxLen = Math.max(maxLen,len+1);
            }
        }

        return dp[ei] = maxLen;
    }

    public static int LIS_Rec(int[] arr){
        if(arr.length == 0) return 0;

        int n=arr.length;
        int[] dp=new int[n];
        int max_=0;
        for(int i=n-1;i>=0;i--){
           max_=Math.max(LIS_Rec(arr,i,dp),max_);
        }

        return max_;
    }

    // Left to Right
    public static int LIS_LR(int[] arr,int[] dp){
        int max_=0;
        for(int i=0;i<arr.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(arr[j] < arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_=Math.max(max_,dp[i]);
        }
        return max_;
    }

    // Right to Left
    public static int LIS_RL(int[] arr,int[] dp){
            int max_=0;
            for(int i = arr.length-1; i>=0 ; i--){
                dp[i] = 1;
                for(int j = i+1;j < arr.length;j++){
                    if(arr[j] < arr[i]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max_=Math.max(max_,dp[i]);
            }
            return max_;
    }

    
// https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
    public static int LBS(int[] arr){
        int n=arr.length;
        int[] LIS=new int[n];
        int[] LDS=new int[n];

        LIS_LR(arr,LIS);
        LIS_RL(arr,LDS);

        int maxLen=0;
        for(int i=0;i<n;i++){
            int len=LIS[i]+LDS[i]-1;
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;
    }

//LIS_Type.=================================================================

	// LIS from left to right
	public static int LIS_DP(int[] arr, int[] dp) {

		dp[0] = 1;
		int maxLen = 0;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) { // har ek j cell apne ko include krke apne tak ka maximum Increasing subsequnece store krke rakhta hai.
				if (arr[i] > arr[j]) { // if i'th cell element is grater than j'th cell element than length will increase by 1.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}


	//LIS from right to left
	public static int LDS_DP(int[] arr, int[] dp) {
        int n=arr.length;
		dp[n-1] = 1;
		int maxLen = 0;
		for (int i = n-2 ; i >= 0 ;i--) {
			dp[i] = 1;
			for (int j = i+1; j < n; j++) { // har ek j cell apne ko include krke apne tak ka maximum Increasing subsequnece store krke rakhta hai.
				if (arr[i] > arr[j]) { // if i'th cell element is grater than j'th cell element than length will increase by 1.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}

	public static int LBS_DP(int[] arr){
	    int n=arr.length;

		int[] LIS=new int[n];
		int[] LDS=new int[n];

		LIS_DP(arr,LIS);
		LDS_DP(arr,LDS);

		int maxLen = 0;
		for(int i=0;i<n;i++){
			int bitonicLen=LIS[i]+LDS[i]-1;
			maxLen=Math.max(maxLen,bitonicLen);
		}

		return maxLen;
	}

	public static int maximumSumIncreasingSubsequnece(int[] arr){
		int n=arr.length;
		int[] dp=new int[n];
        int maxSum=0;
		for(int i=0;i<n;i++){
			  dp[i]=arr[i];
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j]){
					dp[i]=Math.max(dp[i],dp[j]+arr[i]);
				}
			}
			maxSum=Math.max(maxSum,dp[i]);
		}

		return maxSum;
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

	public static int LDS_from_left_right(int[] arr,int[] dp){
		int n=arr.length;
		dp[0]=1;

		int maxLen = 0;
		for(int i=1;i<n;i++){
			dp[i]=1;
			for(int j=0;j<i;j++){
				if(arr[i]<arr[j])
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		   maxLen = Math.max(maxLen, dp[i]);

		}

		return maxLen;
	}

	public static int LDS_from_Right_left(int[] arr,int[] dp){
		int n=arr.length;
		dp[n-1]=1;
        
        int maxLen = 0;
		for(int i=n-2;i>=0;i--){
			dp[i]=1;
			for(int j=i+1;j<n;j++){
				if(arr[i]<arr[j])
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		   maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}

	public static int LBS_DP_02(int[] arr){
	    int n=arr.length;

		int[] LIS=new int[n];
		int[] LDS=new int[n];

		LDS_from_left_right(arr,LIS);
		LDS_from_Right_left(arr,LDS);

		int maxLen = 0;
		for(int i=0;i<n;i++){
			int bitonicLen=LIS[i]+LDS[i]-1;
			maxLen=Math.max(maxLen,bitonicLen);
		}

		return maxLen;
	}
	
	// leetcode 673
	public static int findNumberOfLIS(int[] arr) {
		if(arr.length<=1) return arr.length;
		
		int n=arr.length;
		int[] dp=new int[n];
		int[] count=new int[n];
		
		int maxLen=0;
		int maxCount=0;
		
		for(int i=0;i<n;i++){
			dp[i]=1;
			count[i]=1;
			for(int j=0;j<i;j++){
			  if(arr[i]>arr[j]){
                 if(dp[j] + 1 > dp[i]){
					 dp[i]=dp[j]+1;
					 count[i]=count[j];
				 }else if(dp[j]+1==dp[i]){
					 count[i]+=count[j];
				 }
			  }	
			}

			if(dp[i]>maxLen){
				maxLen=dp[i];
				maxCount=count[i];
			}else if(dp[i]==maxLen){
				maxCount+=count[i];
			}
		}

		return maxCount;

		
	}




    public static void PathSeries() {
		int er = 3;
		int ec = 3;
		int sr = 0;
		int sc = 0;

		int ans = 0;
		// int[][] dp = new int[er + 1][ec + 1];

		// ans = mazePathHV_rec(sr, sc, er, ec, dp);

		// ans = mazePathMulti_rec(sr, sc, er, ec, dp);
		// ans = mazePathMulti_DP(sr, sc, er, ec, dp);

		// int si=0;
		// int ei=10;
		// int[] dp=new int[ei+1];
		// ans=boradPath(si,ei,dp);
		// ans=boradPath_DP(si,ei,dp);
		// ans=boradPath_opti(si,ei,dp);

		// climbStair_DP(8);

		// goldMine(arr);

		// int n = 6;
		// int[] dp = new int[n + 1];
		// ans = pairAndSingle_01(n, dp);

		int n = 11,
		k = 4;
		int[][] dp = new int[n + 1][k + 1];
		// ans = divideItemsInKGroup(n, k, dp);
		ans = divideItemsInKGroup_DP(n, k, dp);

		// display(dp);
		display2D(dp);
		System.out.println(ans);

	}

	public static void stringSet() {
		 // String str="geeksse";
		// int[][] dp=new int[str.length()][str.length()];
		// System.out.println(longestPalindromicSubsubsequence_Rec(str,0,str.length()-1,dp));
		// System.out.println(longestPalindromicSubsubsequence(str));
		// System.out.println(longestPalindromicSubsubsequence_String(str));

		// String str="baccbab";
		// int[][] dp=new int[str.length()][str.length()];
		// // System.out.println(countOfPalindromicSubsubsequence_Rec(str,0,str.length()-1,dp));
		// System.out.println(countOfPalindromicSubsubsequence_DP(str,0,str.length()-1,dp));

		// String str1="abcde";
		// String str2="ace";
		// int[][] dp=new int[str1.length()+1][str2.length()+1];
		// System.out.println(longestCommonSubsequnece_Rec(str1,str2,0,0,dp));
		// System.out.println(longestCommonSubstring_Rec(str1,str2,0,0,dp));

		String str1 = "aabbcc";
		String str2 = "abc";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		// System.out.println(string_occurs_given_string_DP(str1,str2,0,0,dp));
		// System.out.println(string_occurs_given_string_02(str1,str2,0,0,dp));
		System.out.println(string_occurs_given_string(str1, str2, str1.length(), str2.length(), dp));

		display2D(dp);
	}

	public static void targetSet() {
		int[] arr={2,3,1,5,6};
		// int[] arr = {1,1,1,1,1};
		int tar = 3;
		int ans = 0;

		int[][] dp = new int[arr.length + 1][tar + 1];
		// ans=targetSum(arr,tar,0,dp);
		// ans += targetSum_DP(arr, tar, dp);

		// display(dp);
		display2D(dp);
		System.out.println(ans);
	}

	public static void LIS_Type() {
		// int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int[] arr={1,3,5,4,7};
		int[] dp=new int[arr.length];

		int ans=0;
		// ans = LIS_DP(arr,dp);
		// ans = LDS_DP(arr,dp);
		// ans =LBS_DP(arr);

		ans=findNumberOfLIS(arr);

		
		System.out.println(ans);
		// display(dp);
	}

	public static void cutType(){
		int[] arr={10, 20, 30, 40, 30};
		int ans=0;
		int n=arr.length;

		int[][] dp=new int[n][n];
		String[][] sdp=new String[n][n];
		for(int i=0;i<n;i++) for(int j=0;j<n;j++) dp[i][j]=-1;

		// ans=MCM_rec(arr,0,n-1,dp);
		// ans=MCM_DP(arr,n,dp,sdp);
		String str="bbbbbb";
		ans=minCut(str);


		System.out.println(ans);
		display2D(dp);
	}

	  //Minimum deletion to make a array in sorted order.
    public static int minDeletion(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        
        int max_=0;
        for(int i=0;i<arr.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(arr[j] <= arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_=Math.max(max_,dp[i]);
        }

        return n - max_;
    }

    //----------------> // question for you : //https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence/0


    //Leetcode 354.
    public static int maxEnvelopes(int[][] arr) {
        if(arr.length==0) return 0;
        
        // sort(arr.begin(),arr.end(),[](vector<int>& a,vector<int>& b){
        //     return a[0] < b[0];
        // });

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];   // other - this
            return a[0]-b[0]; // this - other, increasing order.
        });
        
        int n=arr.length;
        int[] dp=new int[n];
        int max_=0;

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j][1] < arr[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_=Math.max(max_,dp[i]);
        }

        return max_;
    }

    //for you-----------> Leetcode 1027, 1235
    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    
    public int findNumberOfLIS(int[] arr) {
        
        int n=arr.length;
        int[] dp=new int[n];
        int[] count=new int[n];

        int maxLen=0;
        int maxCount=0;

        for(int i=0;i<n;i++){
            dp[i] = 1;
            count[i] = 1;
            
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1) 
                        count[i] +=count[j];
                }
            }


            if(dp[i]>maxLen){
                maxLen=dp[i];
                maxCount=count[i];
            }else if(dp[i]==maxLen){
                maxCount+=count[i];
            }
        }
        return maxCount;
    }


       // Left to Right
    public static int LIS_LR(int[] arr,int[] dp){
        int max_=0;
        for(int i=0;i<arr.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(arr[j] < arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_=Math.max(max_,dp[i]);
        }
        return max_;
    }

    // Right to Left
    public static int LIS_RL(int[] arr,int[] dp){
            int max_=0;
            for(int i = arr.length-1; i>=0 ; i--){
                dp[i] = 1;
                for(int j = i+1;j < arr.length;j++){
                    if(arr[j] < arr[i]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max_=Math.max(max_,dp[i]);
            }
            return max_;
    }

    // https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
    public static int LBS(int[] arr){
        int n=arr.length;
        int[] LIS=new int[n];
        int[] LDS=new int[n];

        LIS_LR(arr,LIS);
        LIS_RL(arr,LDS);

        int maxLen=0;
        for(int i=0;i<n;i++){
            int len=LIS[i]+LDS[i]-1;
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;
    }


    //Maximum Sum Bitonic subsequnece
    // Left to Right
    public static int LIS_LR(int[] arr,int[] dp){
        int max_=0;
        for(int i=0;i<arr.length;i++){
            dp[i] = arr[i];
            for(int j = i-1;j>=0;j--){
                if(arr[j] < arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            max_=Math.max(max_,dp[i]);
        }
        return max_;
    }

    // Right to Left
    public static int LIS_RL(int[] arr,int[] dp){
            int max_=0;
            for(int i = arr.length-1; i>=0 ; i--){
                dp[i] = arr[i];
                for(int j = i+1;j < arr.length;j++){
                    if(arr[j] < arr[i]){
                        dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                    }
                }
                max_=Math.max(max_,dp[i]);
            }
            return max_;
    }

    public static int LBS(int[] arr){
        int n=arr.length;
        int[] LIS=new int[n];
        int[] LDS=new int[n];

        LIS_LR(arr,LIS);
        LIS_RL(arr,LDS);

        int maxLen=0;
        for(int i=0;i<n;i++){
            int len=LIS[i]+LDS[i]-arr[i];
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;
    }
 */