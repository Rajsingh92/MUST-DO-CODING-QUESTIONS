'''
Rotting Oranges
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
'''

import collections
class Solution:         # O( R *C)  , O(R*C). 
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        
        m,n = len(grid),len(grid[0])
        queue = collections.deque()
        
        # store rotten oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    queue.append((i,j,0))
                    
        minute = self.bfs(grid,queue)
        for row in grid:
            if 1 in row:
                return -1
            
        return minute
                    
    def bfs(self,grid,queue):
        
        max_time = 0
        
        while queue:
            row,col,time = queue.popleft()
            max_time =max(max_time,time)
            
            directions = [[1,0],[-1,0],[0,1],[0,-1]]
            
            for dr,dc in directions:
                r,c = row+dr ,col+dc
                if r in range(len(grid)) and c in range(len(grid[0])) and grid[r][c]==1:
                    queue.append((r,c,time+1))
                    grid[r][c] = 2
                    
        return max_time
                    

