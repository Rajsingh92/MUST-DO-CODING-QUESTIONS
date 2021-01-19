'''
Flood Fill

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image 
(from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting 
pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with 
the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the 
newColor.
At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

'''
import collections
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:  #DFS
        
        oldColor = image[sr][sc]
        visited = [[False for j in range(len(image[0]))] for i in range(len(image))]
        self.flood(image,sr,sc,oldColor,newColor,visited)
        
        return (image)
        
    def flood(self,image,i,j,oldColor,newColor,visited):
        if i<0 or j<0 or i>=len(image) or j>=len(image[0]) or image[i][j]!=oldColor or visited[i][j]==True:
            return
        
        image[i][j] = newColor
        visited[i][j] = True
        
        self.flood(image,i+1,j,oldColor,newColor,visited)
        self.flood(image,i-1,j,oldColor,newColor,visited)
        self.flood(image,i,j+1,oldColor,newColor,visited)
        self.flood(image,i,j-1,oldColor,newColor,visited)
        
    
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:  #BFS
        oldColor = image[sr][sc]
        queue = collections.deque()
        visited = [[False for j in range(len(image[0]))] for i in range(len(image))]
        queue.append((sr,sc))
        visited[sr][sc] = True
        image[sr][sc] = newColor
        
        while queue:
            row,col = queue.popleft()
            directions = [[-1,0],[1,0],[0,1],[0,-1]]
            
            for dr,dc in directions:
                r,c = row+dr,col+dc
                if r in range(len(image)) and c in range(len(image[0])) and visited[r][c]==False and image[r][c]==oldColor:
                    queue.append((r,c))
                    visited[r][c] = True
                    image[r][c] = newColor
                    
        return (image)
            
            
