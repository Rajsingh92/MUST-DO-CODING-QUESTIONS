/**
'''
Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.
A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted 
without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.


'''


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m,n = len(text1),len(text2)
        lookup = [[-1 for j in range(n)] for i in range(m)]
        return self.LCS_DP(text1,text2,m,n)
    
    def LCS(self,text1,text2,m,n):  #TLE
        if m==0 or n==0:
            return 0
        
        if text1[m-1]==text2[n-1]:
            return 1+self.LCS(text1,text2,m-1,n-1)
        else:
            return max(self.LCS(text1,text2,m-1,n),self.LCS(text1,text2,m,n-1))
        
        
    def LCS_MEMO(self,text1,text2,m,n,lookup):  # fill lookup with -1
        if m==0 or n==0:
            return 0
        
        if lookup[m-1][n-1]!=-1:
            return lookup[m-1][n-1]
        
        if text1[m-1]==text2[n-1]:
            lookup[m-1][n-1] =  1+self.LCS_MEMO(text1,text2,m-1,n-1,lookup)
            return lookup[m-1][n-1]
        
        else:
            lookup[m-1][n-1] =  max(self.LCS_MEMO(text1,text2,m-1,n,lookup),self.LCS_MEMO(text1,text2,m,n-1,lookup))
            return lookup[m-1][n-1]
        
    def LCS_DP(self,text1,text2,m,n):
        
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if text1[i-1]==text2[j-1]:
                    dp[i][j] = 1+dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                    
        return dp[m][n]      

    def PRINT_LCS(self,text1,text2,m,n):
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if text1[i-1]==text2[j-1]:
                    dp[i][j] = 1+dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                    
        index = dp[m][n]    
        lcs = ['']*(index+1)
        lcs[index] = ''
        i = m
        j = n
        while i>0 and j>0:
            if text1[i-1]==text2[j-1]:
                lcs[index-1] = text1[i-1]
                i-=1
                j-=1
                index-=1
            elif dp[i-1][j]>dp[i][j-1]:
                i-=1
            else:
                j-=1
    

def LCS3_DP(X,Y,Z,m,n,o): #  LCS for three strings
    dp = [[[0 for k in range(o+1)] for i in range(n+1)] for i in range(m+1)]

    for i in range(1,m+1):
        for j in range(1,n+1):
            for k in range(1,o+1):
                if X[i-1] == Y[j-1] and Y[j-1] == Z[k-1]:
                    dp[i][j][k] = 1+dp[i-1][j-1][k-1]
                else:
                    dp[i][j][k] = max(dp[i-1][j][k],dp[i][j-1][k],dp[i][j][k-1])

    print(dp[m][n][o])



// Leetcode 1143
    public static int LCSubseq(String str1, int n, String str2, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            return dp[n][m] = LCSubseq(str1, n - 1, str2, m - 1, dp) + 1;
        else
            return dp[n][m] = Math.max(LCSubseq(str1, n - 1, str2, m, dp), LCSubseq(str1, n, str2, m - 1, dp));
    }

    public static int LCSubseq_DP(String str1, int n, String str2, int m, int[][] dp) {

        int N = n, M = m;
        for (n = 0; n <= N; n++) {
            for (m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }
                if (str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);

            }
        }
        return dp[N][M];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        // int ans = LCSubseq(text1, text1.length(), text2, text2.length(), dp);
        int ans = LCSubseq_DP(text1, text1.length(), text2, text2.length(), dp);

        display2D(dp);
        return ans;
    }

    // Leetcode 1143
    public int longestCommonSubsequence(String s1, String s2,int n,int m,int[][] dp) {
        if(n==0 || m == 0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = longestCommonSubsequence(s1,s2,n-1,m-1,dp) + 1;
        else dp[n][m] = Math.max(longestCommonSubsequence(s1,s2,n,m-1,dp),longestCommonSubsequence(s1,s2,n-1,m,dp));
        
        return dp[n][m];
    }

    public int longestCommonSubsequenceDP(String s1, String s2,int N,int M,int[][] dp) {
        for(int n=0;n<=N;n++){
            for(int m =0;m<=M;m++){
                if(n==0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = dp[n-1][m-1] + 1;
                else dp[n][m] = Math.max(dp[n][m-1],dp[n-1][m]);
            }
        }

        return dp[N][M];
    }
    
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        // for(int[] d : dp) Arrays.fill(d,-1);
        
        return longestCommonSubsequenceDP(s1,s2,n,m,dp);
    }
 */