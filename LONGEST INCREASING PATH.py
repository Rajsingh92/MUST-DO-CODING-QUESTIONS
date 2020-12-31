'''
Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside 
of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
'''
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        def dfs(i,j):
            if not dp[i][j]:
                path = []
                for x,y in ((i,j-1),(i-1,j),(i,j+1),(i+1,j)):
                    if 0<=x<m and 0<=y<n and matrix[x][y]>matrix[i][j]:
                        path.append(dfs(x,y))
                dp[i][j] = 1+max(path,default=0)
                        
            return dp[i][j]
                        
                    
                
        if not matrix:
            return 0
        
        m,n = len(matrix),len(matrix[0])
        dp = [[0 for j in range(n)] for i in range(m)]
        return max(dfs(i,j) for i in range(m) for j in range(n))
        