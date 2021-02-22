'''
| 200 | Number of Islands |  Medium | Adobe, Affirm, Alibaba, Amazon, appdynamics, Facebook, Google, Microsoft |
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
| 695 | Max Area of Island |  Medium | Adobe, Affirm, Alibaba, Amazon, Facebook, Google, Microsoft |

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
| 463 | Island Perimeter |  Easy | Amazon, Apple, Facebook, Google |
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













'''
| 694 | Number of Distinct Islands |  Medium | Amazon, Facebook, Google, Microsoft |
| 711 | Number of Distinct Islands II |  Hard | Amazon |
| 827 | Making A Large Island |  Hard | Google |

// Leetcode 305
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        // par.resize(n*m,0);
        
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        par = new int[n*m];
        for(int i=0;i<n*m;i++) par[i] = i;
        int count = 0;
        List<Integer> ans = new ArrayList<>();
            
        int[][] grid = new int[n][m];
        for(int[] p : positions){
            int i = p[0];
            int j = p[1];
            if(grid[i][j] == 0){
            
            grid[i][j] = 1;
            count++;
            
            int p1 = findPar(i*m+j);
            
            for(int d =0;d<4;d++){
                int r = i + dir[d][0];
                int c = j + dir[d][1];
                
                if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                    int p2 = findPar(r*m+c);
                    if(p1!=p2){
                        count--;
                        par[p2] = p1;
                    }
                }
              }
            }
            ans.add(count);
        }
        
        return ans;
    }


     HashSet<String> map = new HashSet<>();
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    char[] dirS = {'r','d','l','u'};
    String shape = "";
    int n=0,m=0;
    
    public void dfs(int i,int j,int[][] grid){
        
        grid[i][j] = 0;
        for(int d = 0;d<4;d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r>=0 && c>=0 && r< n && c<m && grid[r][c] == 1){
                shape += dirS[d];
                dfs(r,c,grid);
                shape += "b";
            }
        }
         
    }
    
    public int numDistinctIslands(int[][] grid) {
        if(grid.length ==0 || grid[0].length == 0) return 0;
        n = grid.length;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    map.add(shape);
                    shape = "";
                }
            }
        }
        
        return map.size();
        
    }
'''