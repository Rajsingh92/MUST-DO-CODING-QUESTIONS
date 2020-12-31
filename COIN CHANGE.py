'''
Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest 
number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the 
coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1


Coin Change 2
You are given coins of different denominations and a total amount of money. Write a function to compute the number of 
combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
'''
def coinChange(arr,n,amt):
    #base cases
    if amt == 0: # amt become 0 - solution found
        return 1
    if amt<0 : # amt become negative-No solution
        return 0
    if n<=0 and amt>=1: #no coin but has some amt- No solution
        return 0

    return coinChange(arr,n,amt-arr[n-1])+coinChange(arr,n-1,amt)

def coinChange_MEMO(arr,n,amt,lookup):
    #base cases
    if amt == 0: # amt become 0 - solution found
        return 1
    if amt<0 : # amt become negative-No solution
        return 0
    if n<=0 and amt>=1: #no coin but has some amt- No solution
        return 0
    
    key = (n,amt)

    if key in lookup:
        return lookup[key]
    else:
        lookup[key] = coinChange_MEMO(arr,n,amt-arr[n-1],lookup)+coinChange_MEMO(arr,n-1,amt,lookup)
        return lookup[key]

def coinChange_DP(arr,n,amt):
    dp = [[0 for j in range(amt+1)] for i in range(n+1)]

    for i in range(n+1):
        dp[i][0] = 1

    for i in range(n+1):
        for j in range(amt+1):
            if arr[i-1]>j:
                dp[i][j] = dp[i-1][j]
            else: 
                dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j]

    return dp[n][amt]
    
# space optimization
def coinChangeCombination(arr,amt):
    dp = [0]*(amt+1)
    dp[0] = 1

    for i in range(len(arr)):
        for j in range(arr[i],amt+1):
            dp[j] += dp[j-arr[i]]
           

    print(dp[amt-1])


def coinChangePermutation(arr,amt):  
    dp = [0]*(amt+1)
    dp[0] = 1

    for i in range(1,len(dp)):
        for j in range(len(arr)):
            if arr[j]<=i:
                dp[i]+=dp[i-arr[j]]

    print(dp)

