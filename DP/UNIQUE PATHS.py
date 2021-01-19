'''
Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of 
the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for j in range(n)] for i in range(m)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i==m-1 and j==n-1:  #last cell
                    dp[i][j] = 1
                elif i==m-1: #last row
                    dp[i][j] = 1
                elif j == n-1: #last col
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i+1][j]+dp[i][j+1]
                    
        return (dp[0][0])

'''
Unique Paths II
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of 
the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
'''
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        
        dp = [[0 for j in range(n)] for i in range(m)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if obstacleGrid[i][j]==1 and i!=m-1 and j!=n-1:
                    dp[i][j]=0
                else:
                    if i==m-1 and j==n-1:  #last cell
                        dp[i][j] = 1
                    elif i==m-1: #last row
                        dp[i][j] = 1
                    elif j == n-1: #last col
                        dp[i][j] = 1
                    else:
                        dp[i][j] = dp[i+1][j]+dp[i][j+1]
                    
        return  (dp[0][0])

