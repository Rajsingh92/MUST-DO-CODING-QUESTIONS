
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














/**
min partition
count palindromic subsequence
count and longest palindromic substring
minimum number of insertion



 //  | 5 | Longest Palindromic Substring |  Medium | Alibaba |
//  | 730 | Count Different Palindromic Subsequences |  Hard | Google |
// Leetcode 516
// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
// Count Palindromic Substrings 
// | 647 | Palindromic Substrings |  Medium | Adobe, Amazon, Facebook, Google, Microsoft |
// Leetcode 005,647.

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


      public static int countPalindromicSubsequence(String str, int i, int j, int[][] dp) {
        if (i > j)
            return dp[i][j] = 0;

        if (i == j)
            return dp[i][j] = 1;

        if (dp[i][j] != 0)
            return dp[i][j];

        int a = countPalindromicSubsequence(str, i + 1, j - 1, dp);
        int b = countPalindromicSubsequence(str, i, j - 1, dp);
        int c = countPalindromicSubsequence(str, i + 1, j, dp);

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = (a + 1) + (b + c - a);
        else
            return dp[i][j] = b + c - a;
    }

    public static int countPalindromicSubsequence_DP(String str, int i, int j, int[][] dp) {

        for (int gap = 0; gap < str.length(); gap++) {
            for (i = 0, j = gap; j < str.length(); i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                int a = dp[i + 1][j - 1];// countPalindromicSubsequence(str, i + 1, j - 1, dp);
                int b = dp[i][j - 1];// countPalindromicSubsequence(str, i, j - 1, dp);
                int c = dp[i + 1][j];// countPalindromicSubsequence(str, i + 1, j, dp);

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = (a + 1) + (b + c - a);
                else
                    dp[i][j] = b + c - a;
            }
        }

        return dp[0][str.length() - 1];
    }

    // leetcode 940
    public static int distinctSubseqII(String str) {
        int mod = (int) 1e9 + 7;
        str = '$' + str;
        int n = str.length();
        long[] dp = new long[n];

        int[] loc = new int[26];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = (2 * dp[i - 1]% mod)% mod ;
            int idx = str.charAt(i) - 'a';

            if (loc[idx] != -1) {
                dp[i] = (dp[i] % mod - dp[loc[idx] - 1] % mod + mod)% mod;
            }

            loc[idx] = i;
        }

        return (int) dp[n - 1]%mod;

    }

    public static void countPalindromicSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        // System.out.println(countPalindromicSubsequence(str, 0, n - 1, dp));
        System.out.println(countPalindromicSubsequence_DP(str, 0, n - 1, dp));

        display2D(dp);
    }

        //Leetcode 647
    public int countSubstrings(String s) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0; 
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){
                if(gap == 0) dp[i][j] = true;
                else if(gap == 1) dp[i][j] = str.charAt(i) == str.charAt(j);
                else dp[i][j] = str.charAt(i) == str.charAt(j)  && dp[i+1][j-1];
            
                if(dp[i][j]) count++; 
            }
        }
        return count;
    }

    // Leetcode 005
    public String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        int si = 0,ei = 0,length = 0; // starting index, ending index of longest palindromic susbtring.
        
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){

                if(gap == 0) dp[i][j] = 1;
                else if(gap == 1 && str.charAt(i) == str.charAt(j)) dp[i][j] = 2;
                else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] > 0) dp[i][j] = dp[i+1][j-1] + 2;
            
                if(dp[i][j] > length){
                    length = dp[i][j];
                    si = i;
                    ei = j;
                } 
            }
        }

        return str.substring(si,ei+1);
    }

    // Leetcode 516
    
    public int longestPalindromeSubseq(String s,int i,int j,int[][] dp) {
        if( i > j || i == j) return dp[i][j] = (i == j) ? 1: 0;

        if(dp[i][j]!=0) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) dp[i][j] = longestPalindromeSubseq(s,i+1,j-1,dp) + 2;
        else dp[i][j] = Math.max(longestPalindromeSubseq(s,i+1,j,dp),longestPalindromeSubseq(s,i,j-1,dp));

        return dp[i][j];
    }

    
    public int longestPalindromeSubseqDP(String s,int I,int J,int[][] dp) {
        int n = s.length();
        String[][] sdp = new String[n][n];
        for(String[] d: sdp) Arrays.fill(d,"");

        for(int gap = 0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                
                if(i == j) {
                    dp[i][j] = (i == j) ? 1: 0;
                    sdp[i][j] = s.charAt(i) + "";
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    sdp[i][j] = s.charAt(i) + sdp[i+1][j-1] +s.charAt(i);
                }
                else{
                    if(dp[i+1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i+1][j];
                        sdp[i][j] = sdp[i+1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                        sdp[i][j] = sdp[i][j-1];
                    }
                }               
            }
        }

        return dp[I][J];
    }

     // ls = left palindrome string,rs = right palindrome string
     public static void generateString(int[][] dp,String s,int i,int j,LinkedList<Character> ls,LinkedList<Character> rs){
        if(i > j || i == j){
            if(i==j){
                ls.addLast(s.charAt(i));
            }

            System.out.print(ls);
            System.out.print(rs);
            System.out.println();
            
            if(i==j){
                ls.removeLast();
            }
 
            return;
        }

        if(s.charAt(i) == s.charAt(j)){            
            ls.addLast(s.charAt(i));
            rs.addFirst(s.charAt(i));

            generateString(dp,s,i+1,j-1,ls,rs);

            ls.removeLast();
            rs.removeFirst();
        } 
        else{

            if(dp[i+1][j] > dp[i][j-1]) generateString(dp,s,i+1,j,ls,rs);
            else if(dp[i+1][j] < dp[i][j-1]) generateString(dp,s,i,j-1,ls,rs);
            else{
                generateString(dp,s,i,j-1,ls,rs);
                generateString(dp,s,i+1,j,ls,rs);
            }
        }
    }

    public static void generateString(int[][] dp,String s,int i,int j,String ls,String rs){
        if(i > j || i == j){
            if(i==j){
                ls += s.charAt(i);
            }
            System.out.println(ls + rs);
            return;
        }

        if(s.charAt(i) == s.charAt(j)){            
            generateString(dp,s,i+1,j-1,ls + s.charAt(i),s.charAt(i) + rs);
        } 
        else{
            if(dp[i+1][j] > dp[i][j-1]) generateString(dp,s,i+1,j,ls,rs);
            else if(dp[i+1][j] < dp[i][j-1]) generateString(dp,s,i,j-1,ls,rs);
            // else{
            //     generateString(dp,s,i,j-1,ls,rs);
            //     generateString(dp,s,i+1,j,ls,rs);
            // }
        }
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // int ans = longestPalindromeSubseq(s,0,n-1,dp);
        int ans = longestPalindromeSubseqDP(s,0,n-1,dp);

        return ans;
    }

    public int palindromePartition(int si,int ei,int k,int[][] dp,int[][] pdp){
    if(k == 0) return dp[k][ei] = 0;
    if(k == 1) return dp[k][ei] = pdp[si][ei];
    if(ei - si + 1 <= k) return dp[k][ei] = (ei-si+1 < k) ? (int)1e8 : 0;
    
    if(dp[k][ei] != -1) return dp[k][ei];
    
    int min_ = (int)1e8; 
    for(int cut = si; cut < ei;cut++){
        int recAns = palindromePartition(si,cut,k-1,dp,pdp);
        
        min_ = Math.min(min_, pdp[cut + 1][ei] + recAns);
    }
    
    return dp[k][ei] = min_;
}


public int palindromePartition(String str, int k) {
    if(str.length() == 0 || k == 0 || str.length() <= k) return 0;
    int n = str.length();
    int[][] pdp = new int[n][n];
    
    for(int gap = 1;gap<n;gap++){
        for(int i=0,j=gap;j<n;i++,j++){
            pdp[i][j] = pdp[i+1][j-1];
            if(str.charAt(i) != str.charAt(j)) pdp[i][j]++;
        }
    }
    
    int[][] dp = new int[k + 1][n + 1];
    for(int[] d: dp) Arrays.fill(d,-1);
    
    return palindromePartition(0,n-1,k,dp,pdp);
    
}

//longest Plaindromic Subsequence
    // 516
    public static int longestPSS(String str,int i ,int j,int[][] dp){
        if(i >= j){
            return dp[i][j] = (i == j ? 1 : 0);
        }

        if(dp[i][j] != 0) return dp[i][j];

        if(str.charAt(i) == str.charAt(j)) return dp[i][j] = longestPSS(str,i+1,j-1,dp) + 2;
        else return dp[i][j] = Math.max(longestPSS(str,i+1,j,dp),longestPSS(str,i,j-1,dp));
    }

    public static int longestPSS_DP(String str,int i ,int j,int[][] dp){
        int n = str.length();
        for(int gap = 0;gap < n;gap++){
            for(i=0,j=gap;j<n;i++,j++){
                if(i == j) dp[i][j] = 1;
                else if(str.charAt(i) == str.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
    
          return dp[0][n-1];
    }
    

    public static void longestPSS_String(String str,int i ,int j,int[][] dp,char[] ans,int si,int ei){
        if(i >= j){
            if(i == j) {   
                ans[si] = str.charAt(i);
                for(char ch : ans) System.out.print(ch);
                System.out.println();
            }

            return;
        }
       
        if(str.charAt(i) == str.charAt(j)){
            ans[si] = ans[ei] = str.charAt(i);
            longestPSS_String(str,i+1,j-1,dp,ans,si+1,ei-1);
        }else if(dp[i+1][j] > dp[i][j-1]){
            longestPSS_String(str,i+1,j,dp,ans,si,ei);
        }else{
            longestPSS_String(str,i,j-1,dp,ans,si,ei);
        }
    }

    public static int lCSS(String s1,String s2,int i,int j,int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return dp[i][j] = 0;
        }

        if(dp[i][j] != 0) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = lCSS(s1,s2,i+1,j+1,dp) + 1;
        else return dp[i][j] = Math.max(lCSS(s1,s2,i+1,j,dp),lCSS(s1,s2,i,j+1,dp));        
    }

    public static int lCSS_02(String s1,String s2,int n,int m,int[][] dp){
        if(n == 0 || m == 0){
            return dp[i][j] = 0;
        }

        if(dp[i][j] != 0) return dp[i][j];

        if(s1.charAt(n-1) == s2.charAt(m-1)) return dp[i][j] = lCSS(s1,s2,m-1,,m-1,dp) + 1;
        else return dp[i][j] = Math.max(lCSS(s1,s2,n-1,j,dp),lCSS(s1,s2,i,m-1,dp));        
    }

    public static int lCSS_DP(String s1,String s2,int i,int j,int[][] dp){
        for(int i = s1.length() - 1; i >= 0; i--){
            for(int i = s2.length() - 1; j >= 0; j--){

                if(i == s1.length() || j == s2.length()){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1] + 1;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);        
            }
        }

        return dp[0][0];
    }

    // Leetcode 1278
    public int palindromePartition(String s,int k,int si,int ei,int[][] dp,int[][] pdp){
        if(k >= (ei-si+1)){
            return dp[k][ei] = (k == (ei-si+1))?0:(int)1e8;
        }
        
        if(k == 1 || si  == ei){
            return dp[k][ei] = ( si == ei ) ? 0 : pdp[0][ei];
        }
        
        if(dp[k][ei] != -1) return dp[k][ei];
        
        int ans = (int)1e8;
        for(int cut = si; cut < ei;cut++){
            int recAns = palindromePartition(s,k-1,si,cut,dp,pdp);
            
            if(recAns!=(int)1e8)
            ans = Math.min(ans,recAns + pdp[cut+1][ei]);
        }
        
        return dp[k][ei] =  ans;
    }
    
    
    public int palindromePartition(String s, int k) {
        int n = s.length();
        if(k==0 || k == n ) return 0;
        
        int[][] dp = new int[k+1][n+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        int[][] pdp = new int[n][n];
        
        for(int gap = 1 ;gap <n;gap++){
            for(int i =0,j=gap;j<n;i++,j++){
                pdp[i][j] += pdp[i+1][j-1];
                if(s.charAt(i) != s.charAt(j)) pdp[i][j] += 1;
            }
        }
        
        
        int ans = palindromePartition(s,k,0,n-1,dp,pdp);
        return ans; 
    }
 */