'''
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
'''
class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        m,n = len(str1),len(str2)
        lookup = [[-1 for j in range(n)] for i in range(m)]
        return self.PRINT_SCS(str1,str2,m,n)
        
    
    def SCS(self,X,Y,m,n):
        if m==0 or n==0:
            return m+n
        
        if X[m-1] == Y[n-1]:
            return 1+self.SCS(X,Y,m-1,n-1)
        else:
            return min(1+self.SCS(X,Y,m-1,n),1+self.SCS(X,Y,m,n-1))
        
    
    def SCS_MEMO(self,X,Y,m,n,lookup):  #fill lookup with -1
        if m==0 or n==0:
            return m+n
        
        if lookup[m-1][n-1]!=-1:
            return lookup[m-1][n-1]
        
        if X[m-1] == Y[n-1]:
            lookup[m-1][n-1] = 1+self.SCS_MEMO(X,Y,m-1,n-1,lookup)
            return lookup[m-1][n-1]
        else:
            lookup[m-1][n-1] = min(1+self.SCS_MEMO(X,Y,m-1,n,lookup),1+self.SCS_MEMO(X,Y,m,n-1,lookup))
            return lookup[m-1][n-1]
        
    def SCS_DP(self,X,Y,m,n):
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
            
        dp[m][n]
    
    def LCS(self,X,Y,m,n):
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if X[i-1]==Y[j-1]:
                    dp[i][j] = 1+dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                    
        return dp[m][n]
                    
    def SCS_LCS(self,X,Y,m,n):
        lcs = self.LCS(X,Y,m,n)
        return m+n-lcs
        
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
                
            
        