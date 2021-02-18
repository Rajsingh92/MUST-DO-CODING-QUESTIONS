/**
 * 
0 1 0 1 0 1 
1 0 1 0 1 0 
0 1 1 1 1 0 
0 0 1 1 1 0 
1 1 1 1 1 1


3
 */

public class Main {

    public static int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        int ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == arr.length - 1 || j == arr[0].length - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

}