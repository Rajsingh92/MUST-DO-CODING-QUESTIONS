
//  | Longest Palindromic Subsequence  | Apple, Microsoft |
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int[][] dp = new int[str.length()][str.length()];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        System.out.println(dp[0][str.length() - 1]);
    }

}

// Count Palindromic Subsequences 


/**
// Leetcode 516
    public static int longestPlaindromeSubsequence(String str, int i, int j, int[][] dp) {
        if (i > j)
            return dp[i][j] = 0;
        if (i == j)
            return dp[i][j] = 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        int maxLen = 0;
        if (str.charAt(i) == str.charAt(j))
            maxLen = longestPlaindromeSubsequence(str, i + 1, j - 1, dp) + 2;
        else
            maxLen = Math.max(longestPlaindromeSubsequence(str, i + 1, j, dp),
                    longestPlaindromeSubsequence(str, i, j - 1, dp));

        return dp[i][j] = maxLen;
    }

    public static class pair {
        String str = "";
        int len = 0;

        pair(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }

    public static pair longestPlaindromeSubsequence_02(String str, int i, int j, pair[][] dp) {
        if (i > j)
            return dp[i][j] = new pair("", 0);
        if (i == j)
            return dp[i][j] = new pair(str.charAt(i) + "", 1);

        if (dp[i][j] != null)
            return dp[i][j];

        pair maxPair = new pair("", 0);
        if (str.charAt(i) == str.charAt(j)) {
            pair recAns = longestPlaindromeSubsequence_02(str, i + 1, j - 1, dp);
            maxPair.str = str.charAt(i) + recAns.str + str.charAt(j);
            maxPair.len = recAns.len + 2;
        } else {
            pair recAns1 = longestPlaindromeSubsequence_02(str, i + 1, j, dp);
            pair recAns2 = longestPlaindromeSubsequence_02(str, i, j - 1, dp);

            if (recAns1.len > recAns2.len) {
                maxPair.len = recAns1.len;
                maxPair.str = recAns1.str;
            } else {
                maxPair.len = recAns2.len;
                maxPair.str = recAns2.str;
            }
        }

        return dp[i][j] = maxPair;

    }

    public static int longestPlaindromeSubsequence_DP(String str, int i, int j, int[][] dp) {
        int n = str.length();

        String[][] sdp = new String[n][n];
        for (String[] d : sdp)
            Arrays.fill(d, "");

        for (int gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; j++, i++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    sdp[i][j] = str.charAt(i) + sdp[i + 1][j - 1] + str.charAt(j);

                } else if (dp[i + 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i + 1][j];
                    sdp[i][j] = sdp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                    sdp[i][j] = sdp[i][j - 1];
                }

            }
        }

        System.out.println(sdp[0][n - 1] + " @ " + dp[0][n - 1]);
        return dp[0][n - 1];
    }

// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
    public int countPS(String str,int i,int j,int[][] dp)
    {
        if(i >= j ){
            return dp[i][j] = (i == j)?1:0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        
        int x = countPS(str,i+1,j-1,dp);
        int y = countPS(str,i,j-1,dp);
        int z = countPS(str,i+1,j,dp);
        
        if(str.charAt(i) == str.charAt(j)) dp[i][j] = (x + 1) + (y + z - x); //(y + z + 1);
        else dp[i][j] = (y + z - x);
        
        return dp[i][j];
    }
    
    public int countPS_DP(String str,int I,int J,int[][] dp)
    {
        for(int gap = 0;gap < str.length();gap++){
            for(int i =0,j = gap; j < str.length();i++,j++){
        if(i >= j ){
            dp[i][j] = (i == j)?1:0;
            continue;
        }
        
        int x = dp[i+1][j-1];//countPS(str,i+1,j-1,dp);
        int y = dp[i][j-1];//countPS(str,i,j-1,dp);
        int z = dp[i+1][j];//countPS(str,i+1,j,dp);
        
        if(str.charAt(i) == str.charAt(j)) dp[i][j] = (x + 1) + (y + z - x); //(y + z + 1);
        else dp[i][j] = (y + z - x);
        
            }
        }
    
        return dp[I][J];
    }
    public  int countPS(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];

        return (countPS_DP(str, 0, n - 1 , dp));
    }
 */