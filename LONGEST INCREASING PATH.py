# 329. Longest Increasing Path in a Matrix
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
        