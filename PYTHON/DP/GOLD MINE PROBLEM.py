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
def goldMine_Dp(gold, m, n):
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
    
        