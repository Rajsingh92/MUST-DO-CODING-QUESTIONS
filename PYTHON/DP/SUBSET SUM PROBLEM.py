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