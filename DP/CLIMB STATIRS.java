
// you are allowed to climb 1, 2 or 3 stairs.
public class Main {

    public static int countPaths(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        int a = countPaths(n - 1);
        int b = countPaths(n - 2);
        int c = countPaths(n - 3);

        return a + b + c;
    }

    public static int countPaths_MEMO(int n, int[] lookup) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (lookup[n] > 0) {
            return lookup[n];
        }

        int a = countPaths(n - 1);
        int b = countPaths(n - 2);
        int c = countPaths(n - 3);
        lookup[n] = a + b + c;
        return lookup[n];
    }

    public static int countPaths_DP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }

}

// variable jumps

public class Main {

    public static int countPaths(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }

}



// min jumps

public class Main {

    public static int countPaths(int[] arr, int n) {
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }

}
















//               MINIMUM NUMBER OF JUMPS
//               MINIMUM NUMBER OF JUMPS
//               MINIMUM NUMBER OF JUMPS

// | 746 | Min Cost Climbing Stairs |  Easy | Amazon |
/**

find minimum jumps
minimum steps to minimize n as per given condition
minimum operations
egg drop
optimal starategy for game
encoding
minimum number of square





 // Leetcode 70.

 public static int climbStairs(int n, int[] dp) {
    if (n <= 1)
        return dp[n] = 1;
    if (dp[n] != 0)
        return dp[n];

    return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
}

public static int climbStairs(int n) {

    int[] dp = new int[n + 1];
    return climbStairs(n, dp);
}

public static int minCostClimbingStairs(int[] cost, int n, int[] dp) {
    if (n <= 1)
        return dp[n] = cost[n];
    if (dp[n] != 0)
        return dp[n];

    int minCost = Math.min(minCostClimbingStairs(cost, n - 1, dp), minCostClimbingStairs(cost, n - 2, dp));

    return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
}

public static int minCostClimbingStairs_Opti(int[] cost) {
    int a = cost[0];
    int b = cost[1];

    for (int i = 2; i < cost.length; i++) {
        int ans = Math.min(a, b) + cost[i];
        a = b;
        b = ans;
    }
    return Math.min(a, b);
}

public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];

    return minCostClimbingStairs(cost, cost.length, dp);
}
 */

/*
public int minCostClimbingStairs(int[] cost,int n,int[] dp){
    if(n<=1){
      return dp[n] = cost[n]; 
    }

    if(dp[n]!=0) return dp[n];

    int a = minCostClimbingStairs(cost, n-1,dp);
    int b = minCostClimbingStairs(cost, n-2,dp);

    return Math.min(a,b) + (n != cost.length ? cost[n] : 0);
}

public int minCostClimbingStairs(int[] cost,int n,int[] dp){
  
  int N = n;
  for(n = 0; n <= N ; n++){
      if(n<=1){
          dp[n] = cost[n];
          continue;
        }

        int a = dp[n-1]; //minCostClimbingStairs(cost, n-1,dp);
        int b = dp[n-2]; //minCostClimbingStairs(cost, n-2,dp);

        Math.min(a,b) + (n != cost.length ? cost[n] : 0);
  
  }

  return dp[N];
}





public  int minCostClimbingStairs(int[] cost) {
  int n = cost.length;
  int[] dp = new int[cost.length + 1];
  int ans = minCostClimbingStairs(cost,n,dp);
  // int ans = minCostClimbingStairs_DP(cost,n,dp);
  return ans;
}

//leetcode 746

    public int minCostClimbingStairs(int[] cost, int n, int[] dp) {
        if(n<=1) return dp[n]=cost[n];
        if(dp[n]!=0) return dp[n];
        
        int ans = Math.min(minCostClimbingStairs(cost,n-1,dp),minCostClimbingStairs(cost,n-2,dp));

        return dp[n] = ans + (n != cost.length ? cost[n] : 0);
    }

    public int minCostClimbingStairs_DP(int[] cost, int n, int[] dp) {
        for(n=0;n<=cost.length;n++){
            if(n<=1){
                dp[n]=cost[n];
                continue;
            }

            int ans = Math.min(dp[n-1],dp[n-2]);
            dp[n] = ans + (n != cost.length ? cost[n] : 0);
        }
        
        return dp[cost.length];
    }

    public  int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int ans = minCostClimbingStairs(cost,dp.length,dp);
        // ans = minCostClimbingStairs_DP(cost,dp.length,dp);
        return ans;
    }

       //Leetcode 746.==============================================================
    public int minCostClimbingStairs(int[] cost,int n,int[] dp){
        if(n<=1){
            return dp[n] = cost[n];
        }

        if(dp[n]!=0) return dp[n];

        int ans = Math.min(minCostClimbingStairs(cost,n-1,dp),minCostClimbingStairs(cost,n-2,dp));

        return dp[n] = ans + (n!=cost.length?cost[n]:0);
    }

    public int minCostClimbingStairs_DP(int[] cost,int N, int[] dp){
        for(int n = 0 ;n<=N;n++){
            if(n<=1){
                dp[n] = cost[n];
                continue;
            }
    
            int ans = Math.min(dp[n-1],dp[n-2]);
    
            dp[n] = ans + (n != cost.length ? cost[n] : 0);
        }
        return dp[N];
    }

    public  int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length + 1];
        int ans = minCostClimbingStairs(cost,n,dp);
        // int ans = minCostClimbingStairs_DP(cost,n,dp);
        return ans;
    }

    //leetcode 70.
	public static int climbStairs(int n) {
		if (n <= 1) return 1;

		int count = climbStairs(n - 1) + climbStairs(n - 2);
		return count;
	}

	public static int climbStairs_DP(int n) {
		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i <= 1) {
				dp[i] = 1;
				continue;
			}

			dp[i] = dp[i - 1] + dp[i - 2];
		}

		display(dp);
		return dp[n];
	}

	public static int climbStairs_fast(int n) {
		int a = 1;
		int b = 1;
		int ans = 1;
		for (int i = 2; i <= n; i++) {
			ans = a + b;
			a = b;
			b = ans;
		}

		return ans;
	}

	//leetcode 746
	public static int minCostClimbingStairs_(int i, int[] cost, int[] dp) {
		if (i <= 1) return cost[i];

		if (dp[i] != 0) return dp[i];
		int c1 = minCostClimbingStairs_(i - 1, cost, dp);
		int c2 = minCostClimbingStairs_(i - 2, cost, dp);

		return dp[i] = Math.min(c1, c2) + ((i != cost.length) ? cost[i] : 0);
	}

	public static void minCostClimbingStairs_DP(int i, int[] cost, int[] dp) {

		for (i = 0; i <= cost.length; i++) {
			if (i <= 1) {
				dp[i] = cost[i];
				continue;
			}

			int c1 = dp[i - 1];
			int c2 = dp[i - 2];

			dp[i] = Math.min(c1, c2) + ((i != cost.length) ? cost[i] : 0);
		}
	}

	public static int minCostClimbingStairs_fast(int[] cost) {
		int a = cost[0];
		int b = cost[1];
		int sum = 0;
		for (int i = 2; i < cost.length; i++) {

			sum = cost[i] + Math.min(a, b);
			// sum=Math.min(a,b) + ((i!=cost.length)?cost[i]:0);
			a = b;
			b = sum;
		}

		return Math.min(a, b);
	}

	public static int minCostClimbingStairs_03_(int idx, int[] cost, int[] dp) {
		if (idx >= cost.length) return 0;
		if (dp[idx] != 0) return dp[idx];

		return dp[idx] = Math.min(minCostClimbingStairs_03_(idx + 1, cost, dp), minCostClimbingStairs_03_(idx + 2, cost, dp)) + cost[idx];
	}

	public static int minCostClimbingStairs_03(int[] cost) {
		int[] dp = new int[cost.length];
		minCostClimbingStairs_03_(0, cost, dp);
		return Math.min(dp[0], dp[1]);
	}

	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		// minCostClimbingStairs_(cost.length,cost,dp);
		// minCostClimbingStairs_DP(cost.length,cost,dp);

		return minCostClimbingStairs_fast(cost);

		// return dp[dp.length-1];

	}

    // Leetcode 70 .=============================================================
    public int climbStairs(int n,int[] dp) {
        if(n<=1){
            return dp[n] = 1;
        }

        if(dp[n]!=0) return dp[n];
        
        int ans = climbStairs(n-1,dp) + climbStairs(n-2,dp);
        
        return dp[n] = ans;
    }

    public int climbStairs_DP(int N,int[] dp) {
        for(int n = 0;n<=N;n++){
            if(n<=1){
                dp[n] = 1;
                continue;
            }
    
            int ans = dp[n-1] + dp[n-2];//climbStairs(n-1,dp) + climbStairs(n-2,dp);
            
            dp[n] = ans;
        }
        return dp[N];
    }

    public  int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // return climbStairs(n, dp);
        return climbStairs_DP(n,dp);
    }
*/