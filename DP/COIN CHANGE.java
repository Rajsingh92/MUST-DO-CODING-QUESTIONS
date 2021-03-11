
// coin change combination
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        
        for(int i = 0;i<arr.length;i++){
            for(int j = arr[i];j<dp.length;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        
        System.out.println(dp[amt]);
    }
}



// coin change permutation
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(i>=arr[j]){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        
        System.out.println(dp[amt]);
    }
}

// | 322 | Coin Change |  Medium | Adobe, Airbnb, Amazon, Apple, Facebook, Microsoft |
// | 518 | Coin Change 2 |  Medium | Amazon, Facebook, Google, Microsoft |
//  Minimum number of Coins	GP				https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0	Minimum number of Coins


/**
// TargetSet/ CoinChange.==========================================================


public static int coinChangePermutation(int[] arr,int tar){
    if(tar == 0){
        return dp[tar] = 1;
    }

    if(dp[tar] != 0) return dp[tar];

    int count = 0;
    for(int ele : arr){
        if(tar - ele >= 0)
          count += coinChangePermutation(arr,tar - ele); 
    }

    return dp[tar] = count;
}

public static int coinChangePermutation_DP(int[] arr,int tar){

    int Tar = tar;
    dp[0] = 1;
    for(tar = 1 ;tar <= Tar;tar++){   
        for(int ele : arr){
            if(tar - ele >= 0)
              dp[tar] += dp[tar - ele];
        }
    }

    return dp[Tar];
}

public static int coinChangeCombination_DP(int[] arr,int tar){
    int Tar = tar;
    dp[0] = 1;
    for(int ele : arr){
        for(tar = ele ;tar <= Tar;tar++){   
              dp[tar] += dp[tar - ele];
        }
    }

    return dp[Tar];
}


//Leetcode 322

public static int coinChange(int[] coins,int tar,int[] dp){
    if(tar == 0){
        return dp[tar] = 0;
    }
    
    if(dp[tar] != -1) return dp[tar];

    int minCoin = (int)1e9;
    for(int ele: coins){
        if(tar - ele >= 0){
            int ans = coinChange(coins,tar-ele,dp);
            if(ans != (int)1e9 && ans + 1 < minCoin) minCoin = ans + 1;
        }
    }

    return dp[tar] = minCoin;
}

public static int coinChange(int[] coins,int tar,int[] dp){
    int Tar = tar;
    dp[0] = 0;
    for(tar = 1; tar <= Tar; tar++){
        int minCoin = (int)1e9;
        for(int ele: coins){
            if(tar - ele >= 0){
              int ans = dp[tar - ele];
              if(ans != (int)1e9 && ans + 1 < minCoin) minCoin = ans + 1;
            }
        }

       dp[tar] = minCoin;
    }

    return dp[Tar];
}

public int coinChange(int[] coins, int amount) {
    int[] dp=new int[amount+1];
    Arrays.fill(dp,-1);
    int ans = coinChange(coins,amount,dp);
    
    return ans!=(int)1e9?ans:-1;
}

 public static int coinChangePermutation(int[] arr,int tar,int[] dp){
        if(tar == 0){
            return dp[tar] = 1;
        }
        
        if(dp[tar]!=0) return dp[tar];

        for(int ele : arr){
            if(tar - ele >= 0){
                dp[tar] += coinChangePermutation(arr,tar-ele,dp);
            }
        }
        return dp[tar];
    }
 
    public static int coinChangePermutationDP(int[] arr,int Tar,int[] dp){
        dp[0] = 1;
        for(int tar = 1; tar <= Tar; tar++){
            for(int ele : arr){
                if(tar - ele >= 0){
                    dp[tar] += dp[tar-ele];
                }
            }            
        }

        return dp[Tar];
    }

    public static int coinChangeCobinationDP(int[] arr,int Tar,int[] dp){
        dp[0] = 1;
        for(int ele : arr){
            for(int tar = ele; tar <= Tar; tar++){
                    dp[tar] += dp[tar-ele];
            }            
        }

        return dp[Tar];
    }

    //Leetcode 377  -> coinChangePermutationDP

    //Leetcode 322

    public int minCoinsRequired(int[] arr, int tar,int[] dp) {
        if(tar == 0){
            return 0;
        }

        if(dp[tar] != -1) return dp[tar];

        int minCoin = (int)1e9;
        for(int ele : arr){
            if(tar - ele >= 0 ){
                int val = minCoinsRequired(arr,tar - ele,dp);
                if(val != (int)1e9 && val + 1 < minCoin)
                   minCoin = val + 1;
            }
        }

        return dp[tar] = minCoin;
    }

    public int minCoinsRequiredDP(int[] arr, int Tar,int[] dp){
        dp[0] = 0;
        for(int tar = 1; tar<=Tar;tar++){
            int minCoin = (int)1e9;
            for(int ele : arr){
                if(tar - ele >= 0 ){
                    int val = dp[tar - ele];
                    if(val != (int)1e9 && val + 1 < minCoin)
                       minCoin = val + 1;
                }
            }
            dp[tar] = minCoin;
        }
        return dp[Tar];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);

        int ans = minCoinsRequiredDP(coins,amount,dp);
        return ans != (int)1e9? ans: -1;
    }

// TargetSet.=========================================================================================

    public static int coinChangePermutation(int[] arr,int tar,int[] dp){
        if(tar==0){
            return dp[tar] = 1;
        }

        if(dp[tar]!=0) return dp[tar];

        int count=0;
        for(int ele: arr){
            if(tar-ele>=0){
              count+=coinChangePermutation(arr,tar-ele,dp);
            }
        }

        return dp[tar] = count;
    }

    public static int coinChangePermutation_DP(int[] arr,int tar,int[] dp){
        int Tar=tar;
        dp[0] = 1;
        for( tar=0;tar<=Tar;tar++)
            for(int ele: arr){
                if(tar-ele>=0){
                  dp[tar]+=dp[tar-ele];
                }
            }
            return dp[Tar];
    }

    public static int coinChangeCombination(int[] arr,int tar,int idx){
        if(tar==0){
            return 1;
        }

        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(tar-arr[idx]>=0){
              count+=coinChangeCombination(arr,tar-arr[idx],i);
            }
        }

        return count;
    }

    public static int coinChangeCombination_DP(int[] arr,int tar,int[] dp){
        int Tar=tar;
        dp[0]=1;
        for(int ele: arr)
            for( tar=ele;tar<=Tar;tar++)
                if(tar-ele>=0)
                  dp[tar]+=dp[tar-ele];
        return dp[Tar];
    }

    public int coinChange_(int[] coins, int amount,int[] dp) {
        if(amount==0){
            return dp[amount] = 0;
        }

        if(dp[amount]!=0) return dp[amount];
        
        int minCoins=(int)1e8;
        for(int ele: coins){
            if(amount - ele >= 0){
                minCoins = Math.min(minCoins,coinChange_(coins,amount-ele,dp)+1);
               
            }
        }

        return dp[amount]=minCoins;
    }

    public int coinChange_02(int[] coins, int amount,int[] dp) {
        Arrays.fill(dp,100000000);
        int Amount = amount;
        dp[0] = 0;
        for(int ele: coins){
            for(amount = ele;amount<=Amount;amount++){
               if(dp[amount-ele] + 1 < dp[amount]){
                   dp[amount]=dp[amount-ele] + 1;
               }
            }
        }
      return dp[Amount];
    }

    
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int ans = coinChange_(coins,amount,dp);
        
        
        return ans!=(int)1e8?ans:-1;
    }

    
	//targetSet.===================================================================

	public static int coinChangePermuatation_Rec(int[] coins, int tar) {
		if (tar == 0) return 1;

		int count = 0;
		for (int c: coins) {
			if (tar - c >= 0) count += coinChangePermuatation_Rec(coins, tar - c);
		}

		return count;
	}

	public static int coinChangePermuatation(int[] coins, int tar) {

		int[] dp = new int[tar + 1];
		dp[0] = 1;

		for (int t = 0; t <= tar; t++) {
			for (int c: coins) {
				if (t - c >= 0) {
					dp[t] += dp[t - c];
				}
			}
		}

		return dp[tar];
	}

	public static int coinChangeCombination(int[] coins, int tar) {

		int[] dp = new int[tar + 1];
		dp[0] = 1;
		for (int c: coins) {
			for (int t = 0; t <= tar; t++) {
				if (t - c >= 0) {
					dp[t] += dp[t - c];
				}
			}
		}

		return dp[tar];
	}

	public static int linearEquationOfNvariables(int[] coeff, int y) {
		return coinChangeCombination(coeff, y);
	}

	//leetcode 322
	public int coinChangeMinHeight_rec(int[] coins, int tar, int[] dp) {
		if (tar == 0) return 0;

		if (dp[tar] != 0) return dp[tar];

		int height = (int) 1e8;
		for (int c: coins) {
			if (tar - c >= 0) {
				int recH = coinChangeMinHeight_rec(coins, tar - c, dp);
				if (recH != (int) 1e8) height = Math.min(height, recH + 1);
			}
		}

		return dp[tar] = height;
	}

	public int coinChangeMinHeight_DP(int[] coins, int tar, int[] dp) {
		Arrays.fill(dp, 100000000);
		dp[0] = 0;

		for (int t = 1; t <= tar; t++) {
			for (int c: coins) {
				if (t - c >= 0) {
					// dp[t]=Math.min(dp[t],dp[t-c]+1);
					int recH = dp[t - c];
					if (recH != (int) 1e8) dp[t] = Math.min(dp[t], recH + 1);
				}
			}
		}

		return dp[tar];
	}

	public int coinChange(int[] coins, int tar) {
		int[] dp = new int[tar + 1];
		int ans = 0;
		// ans=coinChangeMinHeight_rec(coins,tar,dp);
		ans = coinChangeMinHeight_DP(coins, tar, dp);

		return ans != (int) 1e8 ? ans: -1;
	}

//https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
// same as coin change combination.

public static int targetSum(int[] arr,int idx,int tar,int[][] dp){
    if(tar == 0 || idx == arr.length){
        return dp[idx][tar] = (tar == 0)? 1 : 0;
    }

    if(dp[idx][tar]!=0) return dp[idx][tar];
    
    if(tar - arr[idx] >= 0) dp[idx][tar] += targetSum(arr,idx+1,tar-arr[idx],dp);
    dp[idx][tar] += targetSum(arr,idx+1,tar,dp); 

    return dp[idx][tar];
}

public static int targetSum(int[] arr,int n,int tar,int[][] dp){
    if(tar == 0 || n == 0){
        return dp[n][tar] = (tar == 0)? 1 : 0;
    }

    if(dp[n][tar]!=0) return dp[idx][tar];
    
    if(tar - arr[ n - 1] >= 0) dp[n][tar] += targetSum(arr,n - 1,tar - arr[n - 1],dp);
    dp[n][tar] += targetSum(arr,n - 1,tar,dp); 

    return dp[n][tar];
}

public static int targetSum(int[] arr,int N,int Tar,int[][] dp){
    for(int n = 0; n<=N;n++){
        for(int tar = 0 ; tar<=Tar;tar++){
            
            if(tar == 0 || n == 0){
                dp[n][tar] = (tar == 0)? 1 : 0;
                continue;
            }

            if(tar - arr[ n - 1] >= 0) dp[n][tar] += dp[n-1][tar];
            dp[n][tar] += dp[n-1][tar];             
        }
    }

    return dp[N][Tar];
}

// 494
public int findTargetSumWays(int[] nums,int n,int sum, int tar,int[][] dp) {
    if(n==0){
        return dp[n][sum] = ( tar == sum ) ? 1: 0;
        
    }
    
    if(dp[n][sum] != -1) return dp[n][sum];
    
    int count = 0;
    count += findTargetSumWays(nums,n - 1,sum - nums[n-1],tar,dp);    // num is positive
    count += findTargetSumWays(nums,n - 1,sum + nums[n-1],tar,dp);   // num is negative
    
    return dp[n][sum] = count;
    
}
   
 public int findTargetSumWays_DP(int[] nums,int N,int Sum, int tar,int[][] dp) {
     
     dp[0][0 + Sum] = 1;
     for(int n = 1; n <= N;n++){
         for(int sum = 0 ; sum  <= 2*Sum;sum++) {
    
            int count = 0;
            if(sum-nums[n-1] >=0 )count += dp[n-1][sum-nums[n-1]] ;
            if(sum + nums[n-1] <= 2*Sum )count += dp[n-1][sum+nums[n-1]] ;
            
             dp[n][sum] = count;
         }
     }
     
     return dp[N][tar];
}
   
public int findTargetSumWays(int[] nums, int tar) {
    int n = nums.length;
    if(n == 0) return 0;
    
    int sum = 0;
    for(int ele: nums) sum += ele;
    
    if(tar > sum || tar < -sum) return 0;
    
    int[][] dp = new int[n+1][2 * sum + 1];
    
    // for(int[] a: dp) Arrays.fill(a,-1)
    // int ans = findTargetSumWays(nums,n,sum,tar + sum,dp);
    
    int ans = findTargetSumWays_DP(nums,n,sum,tar + sum,dp);
    
    return ans;
}

/https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    public static int targetSum(int[] arr,int idx,int tar,int[][] dp){
        if(tar == 0 || idx == arr.length){
            return dp[idx][tar] = tar == 0 ? 1 : 0;
        }

        if(dp[idx][tar] != -1) return dp[idx][tar];

        int count = 0;
        if(tar - arr[idx] >= 0)
          count += targetSum(arr,idx+1,tar - arr[idx], dp);
        count += targetSum(arr,idx+1,tar, dp);

        return dp[idx][tar] = count;
    }

    public static int targetSumDP(int[] arr,int Idx,int Tar,int[][] dp){
        for(int idx = arr.length;idx >= 0;idx--){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || idx == arr.length){
                    dp[idx][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[idx] >= 0)
                   count += dp[idx + 1][tar-arr[idx]];
                count += dp[idx + 1][tar];
               
                dp[idx][tar] = count;
            }
        }

        return dp[Idx][Tar];
    }


    public static int targetSum2(int[] arr,int n,int tar,int[][] dp){
        if(tar == 0 || n == 0){
            return dp[n][tar] = (tar == 0) ? 1 : 0;
        }

        if(dp[n][tar] != -1) return dp[n][tar];

        int count = 0;
        if(tar - arr[n - 1] >= 0)
          count += targetSum2(arr,n - 1,tar - arr[n - 1], dp);
        count += targetSum2(arr,n - 1,tar, dp);

        return dp[n][tar] = count;
    }

    public static int targetSumDP2(int[] arr,int N,int Tar,int[][] dp){
        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   count += dp[n-1][tar-arr[n-1]];
                count += dp[n-1][tar];
               
                dp[n][tar] = count;
            }
        }

        return dp[N][Tar];
    }

    public static boolean targetSumPath(int[] arr,int n,int tar,int[][] dp,String psf){
        if(tar == 0 || n == 0){
           if(tar == 0){
            System.out.println(psf);
            return true;
           }
           return false;
        }

        boolean res = false;
        if(tar - arr[n - 1] >= 0 && dp[n-1][tar - arr[n-1]] > 0)
          res = res || targetSumPath(arr,n - 1,tar - arr[n - 1], dp, psf + arr[n-1] + ",");
        if(dp[n-1][tar] > 0) res = res || targetSumPath(arr,n - 1,tar, dp,psf);

        return res;
    }

    public static void targetSum(){
        int[] arr = {2,3,5,7};
        int tar = 10;

        int[][] dp = new int[arr.length+1][tar+1];
        // for(int[] d: dp) Arrays.fill(d,-1);
        // int ans = targetSumDP(arr,0,tar,dp);

        int ans = targetSumDP2(arr,arr.length,tar,dp);
        System.out.println(targetSumPath(arr,arr.length,tar,dp,""));

        print2D(dp);
    }

     //for you -> https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
    
    // 494
    public int findTargetSumWays(int[] nums, int tar,int n,int sum,int[][] dp) {
        if(n == 0){
            return dp[n][sum] = (tar == sum)? 1: 0;
        }

        if(dp[n][sum] != -1) return dp[n][sum];

        int count = 0;
        count += findTargetSumWays(nums,tar,n-1,sum + nums[n-1],dp); // positive number
        count += findTargetSumWays(nums,tar,n-1,sum + (-nums[n-1]),dp); // negative number

        return dp[n][sum] = count;
    }
    
    
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
      
        if(n == 0) return 0; 
        
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(S > sum || S < -sum) return 0;
        int[][] dp = new int[n+1][2 * sum + 1];
        for(int[] d: dp) Arrays.fill(d,-1);
        int ans = findTargetSumWays(nums,(S + sum),n,(0 + sum),dp);

        return ans;
    }

     // Leetcode 416
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int ele: nums){
            sum+=ele;
        }
        
        if(sum%2!=0) return false;
        
        boolean[][] dp=new boolean[nums.length+1][sum/2+1];
        return targetSum_01_DP(nums,sum/2,nums.length,dp);
    }
    
     public static boolean targetSum_01_DP(int[] coins,int tar,int n,boolean[][] dp){
        int N=n;
        int Tar=tar;
 
        for(n=0;n<=N;n++){
            for(tar=0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar==0)?true:false;
                    continue;
                }
                
                dp[n][tar]=false;
                if(tar-coins[n-1]>=0)
                   dp[n][tar]=dp[n][tar] || dp[n-1][tar-coins[n-1]];
                dp[n][tar]=dp[n][tar] || dp[n-1][tar];
            }
        }

        return dp[N][Tar];
    }

public static int findTargetSumWays_memo(int[] nums, int n, int sum, int tar,int[][] dp){
    if (n == 0)
        return dp[n][sum] = ((tar == (0 + sum)) ? 1 : 0);

    if (dp[n][sum] != -1)
        return dp[n][sum];

    int include = findTargetSumWays_memo(nums, n - 1, sum - nums[n - 1], tar,dp);  // positive call
    int exclude = findTargetSumWays_memo(nums, n - 1, sum + nums[n - 1], tar,dp); // nrgative call

    return dp[n][sum] = include + exclude;
}


public static int findTargetSumWays(vector<int> &nums, int s)
{
    if (nums.length == 0)
        return 0;

    int n = nums.length;
    int sum = 0;

    for (int i : nums)
        sum += i;
    if (s > sum || s < -sum)
        return 0;

    int[][] dp=new int[n+1][2*sum+1];
    for(int[] a: dp) Arrays.fill(a,-1);

    return findTargetSumWays_memo(nums, n, sum, s+sum,dp);
  }

  // Leetcode 416
public boolean canPartition(int[] nums) {
    int N = nums.length;
    if(N==0) return false;

    int sum = 0;
    for(int ele : nums) sum += ele;
    if(sum%2 != 0) return false;

    int Tar = sum/2;
    boolean[][] dp = new boolean[N+1][Tar + 1];
    
    for(int n = 0 ; n <= N;n++){
        for(int tar = 0 ; tar <= Tar;tar++){
            if(n==0 || tar == 0){
                dp[n][tar] = (tar == 0) ? true: false;
                continue;
            }

            if(tar - nums[n-1] >= 0)
               dp[n][tar] = dp[n][tar] || dp[n-1][tar - nums[n-1]];
            dp[n][tar] = dp[n][tar] || dp[n-1][tar];
        }
    }

    return dp[N][Tar];
}



   //416
    public boolean canPartition(int[] arr) {
        int N = arr.length;
        if(N==0) return false;

        int sum = 0;
        for(int ele : arr) sum+=ele;
        if(sum % 2 != 0) return false;

        int Tar = sum / 2;
        boolean[][] dp = new boolean[N + 1][Tar + 1];

        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? true : false;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   dp[n][tar] = dp[n][tar] || dp[n-1][tar-arr[n-1]];
                dp[n][tar] = dp[n][tar] ||  dp[n-1][tar];               
            }
        }

        return dp[N][Tar];
    }


  public int maxCoins(int[] nums,int si,int ei ,int[][] dp) {
        if(dp[si][ei] != -1) return dp[si][ei];

        int lVal = (si == 0) ? 1 : nums[si-1];
        int rVal = (ei == nums.length - 1) ? 1 : nums[ei + 1];


        
        int myAns = 0;
        for(int cut = si; cut <= ei; cut++){
            int leftAns = (cut == si) ? 0 : maxCoins(nums,si,cut-1,dp);
            int rightAns = (cut == ei) ? 0 : maxCoins(nums,cut+1,ei,dp);

            myAns = Math.max(myAns, leftAns + lVal * nums[cut] * rVal + rightAns);
        }

        return dp[si][ei] = myAns;
    }


    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int[][] dp = new int[n][n];
        for(int[] d: dp)Arrays.fill(d,-1);
        
        return maxCoins(nums,0,n-1,dp);   
    }

    public static int maxCoins(int[] nums,int si,int ei,int[][] dp) {
        if(dp[si][ei]!=0) return dp[si][ei];

        int lval = si == 0 ? 1 : nums[si-1];
        int rval = ei == nums.length -1 ? 1 : nums[ei+1];

        int maxAns = 0;
        for(int cut = si;cut<=ei;cut++){
            int leftRes = cut == si ? 0 : maxCoins(nums,si,cut - 1,dp);
            int rightRes = cut == ei ? 0 : maxCoins(nums,cut + 1, ei, dp); 

            int myAns = leftRes + lval * nums[cut] * rval + rightRes;
            maxAns = Math.max(maxAns, myAns);
        }

        return dp[si][ei] = maxAns;
    }

    public static int maxCoinsDP(int[] nums,int si,int ei,int[][] dp) {
        
        for(int gap = 1; gap < nums.length;gap++){
            for(si=0,ei=gap;ei<nums.length;si++,ei++){
                int lval = si == 0 ? 1 : nums[si-1];
                int rval = ei == nums.length - 1 ? 1 : nums[ei+1];

                int maxAns = 0;
                for(int cut = si;cut<=ei;cut++){
                    int leftRes = cut == si ? 0 : dp[si][cut-1];//maxCoins(nums,si,cut - 1,dp);
                    int rightRes = cut == ei ? 0 : dp[cut+1][ei];//maxCoins(nums,cut + 1, ei, dp); 

                    int myAns = leftRes + lval * nums[cut] * rval + rightRes;
                    maxAns = Math.max(maxAns, myAns);
                }

            dp[si][ei] = maxAns;
            }
        }

        return dp[0][nums.length-1];
        
    }

    
 */