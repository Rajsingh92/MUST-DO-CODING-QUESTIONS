#                   TARGET SUM
#                   TARGET SUM
#                   TARGET SUM




'''
Subset Sum Problem 
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is 
the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination: 
The two parts are {1, 5, 5} and {11}.

Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be 
partitioned into two such parts.
'''

def subsetsum(arr, sum, n): #knapsack variation
    if n == 0:
        return False
    if sum == 0:
        return True

    if sum < arr[n-1]:
        return subsetsum(arr,sum,n-1)

    return subsetsum(arr, sum-arr[n-1], n-1) or subsetsum(arr, sum, n-1)


def subsetsum_Dp(arr, sum, n):
    dp = [[False for j in range(sum+1)] for i in range(n+1)]

    for j in range(1, sum+1):
        dp[0][j] = False
    for i in range(n+1):
        dp[i][0] = True

    for i in range(n+1):
        for j in range(sum+1):
            if j < arr[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j-arr[i-1]]

    print(dp[n][sum])


    

# 0 – 1 Knapsack problem
def knapSack(val,wt,W,n):
    if n==0 or W==0:
        return 0

    if wt[n-1]>W:
        return knapSack(val,wt,W,n-1)
    else:
        return max(val[n-1]+knapSack(val,wt,W-wt[n-1],n-1), knapSack(val,wt,W,n-1))


def knapSack_MEMO(val,wt,W,n,lookup): #fill lookup with -1
    if n==0 or W==0:
        return 0
    if lookup[n][W]!=-1:
        return lookup[n][W]

    if wt[n-1]>W:
        lookup[n][W] =  knapSack(val,wt,W,n-1,lookup)
        return lookup[n][W]
    else:
        lookup[n][W] =  max( val[n-1]+knapSack_MEMO(val,wt,W-wt[n-1],n-1,lookup), knapSack_MEMO(val,wt,W,n-1,lookup) )
        return lookup[n][W]

    

def knapSack_DP(val,wt,W,n):
    dp = [[0 for j in range(W+1)] for i in range(n+1)]

    for i in range(n+1):
        for j in range(W+1):
            if i==0 or j==0:
                dp[i][j]=0
            if wt[i-1]>j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max( val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j] )

    print(dp[n][W])






# unbounded knapsack
def unboundedKnapsack_DP1(val,wt,W,n):
    dp = [[0 for j in range(W+1)] for i in range(n+1)]

    for i in range(n+1):
        for j in range(W+1):
            if i==0 or j==0:
                dp[i][j]=0
            if wt[i-1]>j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j])  #small change

    print(dp[n][W])

def unboundedKnapsack_DP2(val,wt,W,n):
    dp = [ 0 for i in range(W+1)]
    dp[0] = 0

    for i in range(1,len(dp)):
        for j in range(n):
            if wt[j]<=i:
                dp[i] = max(dp[i],dp[i-wt[j]]+val[j])

    return dp[W]








