/**
Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 */

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // return return climbStairs_rec(n,dp);


        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        
        return dp[n];
        
    }

    public int climbStairs_rec(int n,int[] dp) {
        if(n<=1){
            return dp[n] = 1;
        }

        if(dp[n]!=0) return dp[n];
        
        int ans = climbStairs_rec(n-1,dp) + climbStairs_rec(n-2,dp);
        
        return dp[n] = ans;
    }

}





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

    public static class Pair {
        int i;
        int jmps;
        String psf;

        Pair(int i, int jmps,String psf) {
            this.i = i;
            this.jmps = jmps;
            this.psf = psf;
        }
    }

    //  print all paths with min jumps  -- (need to check solution)
    public static void solve(int[] arr){
        Integer[] dp = new Integer[arr.length]; 
        dp[arr.length-1] = 0;

        for(int i=arr.length-2;i>=0;i--){
            int min = Integer.MAX_VALUE;

            for(int j=1;j<=arr[i] && i+j<dp.length;j++){
                if(dp[i+j] != null && dp[i+j]<min){
                    min = dp[i+j];
                }
            }

            if(min!=Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }

        System.out.println(dp[0]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0,dp[0],""));

        while(queue.size()>0){
            Pair rem = queue.removeFirst();

            if(rem.jmps == 0){
                System.out.println(rem.psf+" .");
            }

            for(int j=1;j<=arr[rem.i] && rem.i+j<dp.length;j++){
                int ci = rem.i+j;
                if(dp[ci]!=null && dp[ci] == rem.jmps-1){
                    queue.add(new Pair(ci,rem.jmps-1,rem.psf+" - > "+ci));
                }
            }
        }
    }

}








// | 746 | Min Cost Climbing Stairs |  Easy | Amazon |
class Solution{
    
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
}

	





/**
find minimum jumps
minimum steps to minimize n as per given condition
minimum operations
egg drop
optimal starategy for game
encoding
minimum number of square
 */