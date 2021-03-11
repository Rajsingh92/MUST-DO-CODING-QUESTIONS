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

        public static void lcs(String X, String Y, int m, int n) {
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


            int index = dp[m][n];
            int temp = index;
            char[] lcs = new char[index + 1];
            lcs[index] = '\u0000'; // Set the terminating character

            int i = m;
            int j = n;
            while (i > 0 && j > 0) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcs[index - 1] = X.charAt(i - 1);
                    i--;
                    j--;
                    index--;
                }else if (L[i - 1][j] > L[i][j - 1]){
                    i--;
                }else{
                    j--;
                }   
            }

            for (int k = 0; k <= temp; k++)
                System.out.print(lcs[k]);
        }

    }
}


// Longest Repeating Subsequence
public class Main {

    public static int LRS(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][n];
    }

    public static String printLRS(String str) {

        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }


        String res = "";
        int i = n, j = n;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                res = res + str.charAt(i - 1);
                i--;
                j--;
            }else if (dp[i][j] == dp[i - 1][j]){
                i--;
            }else{
                j--;
            }
        }


        String reverse = "";
        for (int k = res.length() - 1; k >= 0; k--) {
            reverse = reverse + res.charAt(k);
        }

        return reverse;
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

    public static String printShortestSuperSeq(String X, String Y) {
        int m = X.length();
        int n = Y.length();

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


        int index = dp[m][n];
        String str = "";
        int i = m, j = n;

        while (i > 0 && j > 0){
            if (X.charAt(i - 1) == Y.charAt(j - 1)){
                str += (X.charAt(i - 1));
                i--;
                j--;
                index--;
            }else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += (Y.charAt(j - 1));
                j--;
                index--;
            } else {
                str += (X.charAt(i - 1));
                i--;
                index--;
            }
        }


        while (i > 0) {
            str += (X.charAt(i - 1));
            i--;
            index--;
        }
        while (j > 0) {
            str += (Y.charAt(j - 1));
            j--;
            index--;
        }

        String reverse = "";
        for (int k = str.length() - 1; k >= 0; k--) {
            reverse = reverse + str.charAt(k);
        }

        return reverse;
    }

}


/**
Minimum Cost To Make Two Strings Identical 

Given two strings X and Y, and two values costX and costY, the task is to find the minimum cost required to make the given two 
strings identical. You can delete characters from both the strings. The cost of deleting a character from string X is costX 
and from Y is costY. The cost of removing all characters from a string is the same.

Example 1:

Input: X = "abcd", Y = "acdb", costX = 10 
       costY = 20.
Output: 30
Explanation: For Making both strings 
identical we have to delete character 
'b' from both the string, hence cost 
will be = 10 + 20 = 30.
 */

class Solution {
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

    public int findMinCost(String X, String Y, int costX, int costY) {
        int m = X.length();
        int n = Y.length();
        int lcs = LCS_DP(X, Y, m, n);
        return costX * (m - lcs) + costY * (n - lcs);
    }
}




/**
Longest Common Substring 
Shortest Uncommon Subsequence 
Count Ways Increase Lcs Length Two Strings One
Maximum Length of Repeated Subarray	Leet				https://leetcode.com/problems/maximum-length-of-repeated-subarray	
Wildcard Matching |  Hard | Adobe, Amazon, Facebook, Google, Microsoft |
Edit Distance |  Hard | Facebook, Adobe, Amazon, Apple, Google, Microsoft |
Interleaving String |  Hard | Amazon, Apple, Microsoft |
Regular Expression Matching |  Hard | Alibaba, Amazon, Google |
Longest Repeating Subsequence 
Print Longest Common Sub Sequences Lexicographical Order
Find Longest Recurring Subsequence in String
Find Number Times String Occurs Given String
Number of Unique Paths	GP				https://practice.geeksforgeeks.org/problems/number-of-unique-paths/0
Shortest Uncommon Subsequence	GP				https://practice.geeksforgeeks.org/problems/shortest-uncommon-subsequence/0	
*/
