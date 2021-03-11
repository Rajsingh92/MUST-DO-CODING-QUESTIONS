//  | Longest Palindromic Subsequence  | Apple, Microsoft |
public class Main {

    public static int LPS(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 1;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }



    // Minimum Deletions To Make Palindromic Sequence
    public static int minimumDeletionsToPalindrome(String str) {
        int lps = LPS(str);
        return n - lps;
    }





    //  Minimum Insertions To Make Palindrome
    public static int minimumInsertionPalindrome(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int gap = 0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = 0;
                }else if(gap==1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = 1+Math.min(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }

        return dp[0][n-1];
    }

}



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




// count palindromic  substring
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}









/**
Count All Palindromic Subsequence in a given String.
Distinct palindromic substrings	GP				https://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings/0	Distinct palindromic substrings
Count Different Palindromic Subsequences	Leet				https://leetcode.com/problems/count-different-palindromic-subsequences	Count Different Palindromic Subsequences
Count Of Distinct Palindromic Subsequences Medium
Count Palindromic Subsequences	GP				https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1	Count Palindromic Subsequences
Longest Palindromic Substring	Leet				https://leetcode.com/problems/longest-palindromic-substring	Longest Palindromic Substring
Palindromic Substrings	Leet				https://leetcode.com/problems/palindromic-substrings	Palindromic Substrings
min partition
Palindrome Partitioning II |  Hard | Google |
count palindromic subsequence
count and longest palindromic substring
| 5 | Longest Palindromic Substring |  Medium | Alibaba |
| 730 | Count Different Palindromic Subsequences |  Hard | Google |
Leetcode 516
https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
Count Palindromic Substrings 
| 647 | Palindromic Substrings |  Medium | Adobe, Amazon, Facebook, Google, Microsoft |
Leetcode 005,647.
Palindromic Strings	GP				https://practice.geeksforgeeks.org/problems/palindromic-strings/0	
 */