//  Longest Palindromic Substring 
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean[][] dp = new boolean[str.length()][str.length()];
        int ans = 0;

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    ans = gap + 1;
                }
            }
        }

        System.out.println(ans);
    }

}


// Count Palindromic Substrings 
// | 647 | Palindromic Substrings |  Medium | Adobe, Amazon, Facebook, Google, Microsoft |
/**
// Leetcode 005,647.
    public static int[][] longestPalindromeSubstring(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int maxLen = 0;
        int count = 0;
        int si = 0, ei = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0) // if dp[i][j] > 0 means it is a
                                                                                 // palindrome.
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    si = i;
                    ei = j;
                }
                count += (dp[i][j] > 0) ? 1 : 0;
            }
        }

        System.out.println("maxLen: " + maxLen + " and Count of total Palindromes: " + count);
        System.out.println(str.substring(si, ei + 1));

        return dp;
    }
 */