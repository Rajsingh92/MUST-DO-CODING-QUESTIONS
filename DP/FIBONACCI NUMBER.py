'''
| 509 | Fibonacci Number |  Easy | Adobe, Amazon, Microsoft |
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the 
sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
'''


def fib(n):
    if n==0 or n==1:
        return n
    
    return fib(n-1)+fib(n-2)

def fib_MEMO(n,lookup):
    if n==0 or n==1:
        return n
    
    if lookup[n]!=0:
        return lookup[n]
    else:
        lookup[n] = fib_MEMO(n-1)+fib_MEMO(n-2)
        return lookup[n]


def fib_DP(n) :
    if n==0:
        return 0
        
    dp = [0]*(n+1)
    dp[0] = 0
    dp[1] = 1
        
    for i in range(2,n+1):
        dp[i]+=dp[i-1]+dp[i-2]
            
    return dp[n]


def fib_opti(n):
    if n == 0:
        return 0

    a = 0
    b = 1
    sum = 0

    for i in range(2,n):
        sum = a+b
        a = b
        b = sum

    return b