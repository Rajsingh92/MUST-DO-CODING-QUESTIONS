/**

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

class Solution:
    

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
 */


class Solution {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] lookup = new int[m][n];
    
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    lookup[i][j] = -1;
                }
            }
    
            return LCS_DP(text1, text2, m, n);
        }
    
        public int LCS_rec(String text1, String text2, int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }
    
            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                return 1 + LCS_rec(text1, text2, m - 1, n - 1);
            } else {
                return Math.max(LCS_rec(text1, text2, m - 1, n), LCS_rec(text1, text2, m, n - 1));
            }
        }
    
        public int LCS_MEMO(String text1, String text2, int m, int n, int[][] lookup) {
            if (m == 0 || n == 0) {
                return 0;
            }
    
            if (lookup[m - 1][n - 1] != -1) {
                return lookup[m - 1][n - 1];
            }
    
            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                lookup[m - 1][n - 1] = 1 + LCS_MEMO(text1, text2, m - 1, n - 1, lookup);
                return lookup[m - 1][n - 1];
            } else {
                lookup[m - 1][n - 1] = Math.max(LCS_MEMO(text1, text2, m - 1, n, lookup),
                        LCS_MEMO(text1, text2, m, n - 1, lookup));
                return lookup[m - 1][n - 1];
            }
        }
    
        public int LCS_DP(String text1, String text2, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
    
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
    
            return dp[m][n];
        }
    
        public int LCS3_DP(String text1, String text2, String text3, int m, int n, int o) {
            int[][][] dp = new int[m + 1][n + 1][o + 1];
    
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 1; k < o + 1; k++) {
                        if (text1.charAt(i - 1) == text2.charAt(j - 1) && text1.charAt(j - 1) == text2.charAt(k - 1)) {
                            dp[i][j] = 1 + dp[i - 1][j - 1][k - 1];
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1][k], Math.max(dp[i - 1][j][k], dp[i][j][k - 1]));
                        }
                    }
                }
            }
    
            return dp[m][n][o];
        }
    
    }
}













/**
Shortest Common Supersequence
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers
exist, you may return any of them.
(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are 
chosen anywhere from T) results in the string S.)

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.


class Solution:
        
    def PRINT_SCS(self,X,Y,m,n):
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        
        for i in range(m+1):
            dp[i][0] = i
        for j in range(n+1):
            dp[0][j] = j
            
        for i in range(1,m+1):
            for j in range(1,n+1):
                if X[i-1]==Y[j-1]:
                    dp[i][j] = dp[i-1][j-1]+1
                else:
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1)
            
        index = dp[m][n]
        scs = [""]*(index+1)
        scs[index] = ""
        
        i = m
        j = n
        
        while i>0 and j>0:
            if X[i-1]==Y[j-1]:
                scs[index-1] = X[i-1]
                i-=1
                j-=1
                index-=1
            elif dp[i-1][j]>dp[i][j-1]:
                scs[index-1] = Y[j-1]
                j-=1
                index-=1
            else:
                scs[index-1] = X[i-1]
                i-=1
                index-=1
        
        while i>0:
            scs[index-1] = X[i-1]
            i-=1
            index-=1
        while j>0:
            scs[index-1] = Y[j-1]
            j-=1
            index-=1
        
        return "".join(scs)
                
            
        
 */



class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] lookup = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lookup[i][j] = -1;
            }
        }
        // System.out.println(SCS_DP(str1,str2,m,n));
        // System.out.println(m+n-LCS_DP(str1,str2,m,n));
        return "";
    }

    public int SCS_rec(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + SCS_rec(str1, str2, m - 1, n - 1);
        } else {
            return Math.min(1 + SCS_rec(str1, str2, m - 1, n), 1 + SCS_rec(str1, str2, m, n - 1));
        }
    }

    public int SCS_MEMO(String text1, String text2, int m, int n, int[][] lookup) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (lookup[m - 1][n - 1] != -1) {
            return lookup[m - 1][n - 1];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            lookup[m - 1][n - 1] = 1 + SCS_MEMO(text1, text2, m - 1, n - 1, lookup);
            return lookup[m - 1][n - 1];
        } else {
            lookup[m - 1][n - 1] = Math.min(1 + SCS_MEMO(text1, text2, m - 1, n, lookup),
                    1 + SCS_MEMO(text1, text2, m, n - 1, lookup));
            return lookup[m - 1][n - 1];
        }
    }

    public int SCS_DP(String text1, String text2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public int LCS_DP(String text1, String text2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

}


/**
 Longest Common Substring 
 Shortest Uncommon Subsequence Medium


 LCS:
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
https://leetcode.com/problems/regular-expression-matching/
https://leetcode.com/problems/wildcard-matching/
https://leetcode.com/problems/edit-distance/
https://leetcode.com/problems/interleaving-string/
https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
https://leetcode.com/problems/max-dot-product-of-two-subsequences/
https://leetcode.com/problems/distinct-subsequences/
https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
