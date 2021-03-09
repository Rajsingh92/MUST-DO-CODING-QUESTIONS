#                               DP ON 2D GRID
#                               DP ON 2D GRID
#                               DP ON 2D GRID




'''
Path with Maximum Gold

In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 
0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.

'''
class Solution:
    def __init__(self):
        self.max_gold = 0
        
    def getMaximumGold(self, grid):
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]!=0:
                    self.dfs(grid,i, j, 0)
        return self.max_gold 
    
    def dfs(self,grid,i,j,bag):
        if i<0 or j<0 or j>=len(grid[0]) or i>=len(grid) or grid[i][j]==0:
            return 
        
        self.max_gold = max(self.max_gold, bag+grid[i][j])
        val = grid[i][j]
        grid[i][j] = 0 
        
        self.dfs(grid,i+1,j,bag+val)
        self.dfs(grid,i-1,j,bag+val)
        self.dfs(grid,i,j+1,bag+val)
        self.dfs(grid,i,j-1,bag+val)
        
        grid[i][j]=val
    









'''
| 62 | Unique Paths |  Medium | Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
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
| 63 | Unique Paths II |  Medium | Amazon, Facebook, Microsoft |
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
        










'''
Gold Mine Problem
Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. 
Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a 
given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out 
maximum amount of gold he can collect.

Examples:

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)


'''
class Solution:
    def goldMine_Dp(self,gold, m, n):
        dp = [[0 for i in range(n)] for j in range(m)]

        for col in range(n-1, -1, -1):
            for row in range(m):
                if col == n-1:  # last col
                    dp[row][col] = gold[row][col]
                elif row == 0:  # first row
                    dp[row][col] = gold[row][col] + \
                        max(dp[row][col+1], dp[row+1][col+1])
                elif row == m-1:  # last row
                    dp[row][col] = gold[row][col] + \
                        max(dp[row][col+1], dp[row-1][col+1])
                else:
                    dp[row][col] = gold[row][col] + \
                        max(dp[row][col+1], dp[row-1][col+1], dp[row+1][col+1])

        max_gold = dp[0][0]
        for row in range(m):
            max_gold = max(max_gold, dp[row][0])

        print(max_gold)



