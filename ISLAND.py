'''
Number of Islands
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may 
assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


'''

import collections
class Solution: # O( R *C) 
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        
        visited = [[False for j in range(cols)] for i in range(rows)]
        
        islands = 0
                        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and visited[r][c]==False:
                    self.bfs(grid,visited,r, c)
                    islands += 1
        return islands
    
    def bfs(self,grid,visited,i,j):
        visited[i][j]=True
        queue = collections.deque()
        queue.append((i,j))
        
        while queue:
            row,col = queue.popleft()
            
            directions = [[1,0],[-1,0],[0,1],[0,-1]]
            for dr,dc in directions:
                r,c = row+dr,col+dc
                if r in range(len(grid)) and c in range(len(grid[0])) and grid[r][c]=="1" and visited[r][c]==False:
                    queue.append((r,c))
                    visited[r][c]=True

    def dfs(self,grid,visited,i,j):
        visited[i][j]=True
        stack = []
        stack.append((i,j))
        
        while stack:
            row,col = stack.pop()
            
            directions = [[1,0],[-1,0],[0,1],[0,-1]]
            for dr,dc in directions:
                r,c = row+dr,col+dc
                if r in range(len(grid)) and c in range(len(grid[0])) and grid[r][c]=="1" and visited[r][c]==False:
                    stack.append((r,c))
                    visited[r][c]=True


'''
Max Area of Island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally 
(horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

'''

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m,n = len(grid),len(grid[0])
        maxArea = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 :
                    maxArea = max(maxArea,self.dfs(grid,i,j))
        return maxArea
    
    def dfs(self,grid,row,col):
        grid[row][col] = 0
        count = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        for dr,dc in dirs:
            r = row+dr
            c = col+dc
            
            if r in range(len(grid)) and c in range(len(grid[0])) and grid[r][c]==1:
                count+=self.dfs(grid,r,c)
                
        return count+1
            
'''
Island Perimeter
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is 
exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square 
with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
'''
class Solution:
    def __init__(self):
        self.permeter = 0
        
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    self.dfs(grid,i,j)
                    break
                    
        return self.permeter
    
    def dfs(self,grid,i,j):
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j]==0:
            self.permeter+=1
            return
        if grid[i][j]==-1:
            return 
        
        grid[i][j] = -1
        self.dfs(grid,i+1,j)
        self.dfs(grid,i-1,j)
        self.dfs(grid,i,j+1)
        self.dfs(grid,i,j-1)


