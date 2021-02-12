'''
Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of 
all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

'''
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m,n = len(grid),len(grid[0])
        
        dp =  [[0 for j in range(n)] for i in range(m)]
        
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i==m-1 and j==n-1:  #last cell
                    dp[i][j] = grid[i][j]
                elif i == m-1: #last row
                    dp[i][j] = grid[i][j]+dp[i][j+1]
                elif j == n-1: #last col
                    dp[i][j] = grid[i][j]+dp[i+1][j]
                else:
                    dp[i][j] = grid[i][j]+min(dp[i+1][j],dp[i][j+1])
                    
        return dp[0][0]
                    
                

'''
Triangle
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number on the row below.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [0]*n
        
        for i in range(n-1,-1,-1):
            for j in range(len(triangle[i])):
                if i==n-1:  #last row
                    dp[j] = triangle[i][j]
                else:
                    dp[j] = triangle[i][j]+min(dp[j],dp[j+1])
                    
        return (dp[0])
        