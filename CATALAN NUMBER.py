'''
Nth catalan number 

Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Note: Positions start from 0 as shown above.

Example 1:

Input:
N = 5
Output: 42

'''


def findCatalan(n):
    if n<=1:
        return 1
    
    res = 0
    for i in range(n):
        seriesSum = findCatalan(i)*findCatalan(n-i-1)
        res+=seriesSum
    
    return res



def findCatalan(n):
    if (n == 0 or n == 1): 
        return 1
  
    dp = [0] *(n+1)
    dp[0] = 1
    dp[1] = 1
  
    for i in range(2, n + 1): 
        for j in range(i): 
            dp[i] +=  dp[j] * dp[i-j-1] 
  
    return dp[n] 



