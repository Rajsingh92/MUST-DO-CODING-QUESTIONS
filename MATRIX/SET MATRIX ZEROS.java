/**
Set Matrix Zeroes / A Boolean Matrix Question
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    self.placeOnes(matrix,i,j)
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]== float('inf'):
                    matrix[i][j]=0
                    
        
    def placeOnes(self,mat,row,col):
        
        for j in range(len(mat[0])):  #update row
            if mat[row][j]!=0:
                mat[row][j] = float('inf')
                
        for i in range(len(mat)):  #update col
            if mat[i][col]!=0:
                mat[i][col] = float('inf')


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m,n = len(matrix),len(matrix[0])
        row = [None]*m
        col = [None]*n
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    row[i] = 0
                    col[j] = 0
                
        for i in range(m):
            for j in range(n):
                if row[i]==0 or col[j]==0:
                    matrix[i][j] = 0     

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m,n  = len(matrix),len(matrix[0])
        rowFlag = colFlag = False # make true if first row and col consist of any zero
        
        for j in range(n):
            if matrix[0][j] == 0:
                rowFlag = True
                break
                
        for i in range(m):
            if matrix[i][0] == 0:
                colFlag = True
                break
                
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j]==0:
                    matrix[0][j] = matrix[i][0] = 0
                    
        for i in range(1,m):
            for j in range(1,n):
                  if matrix[0][j] ==0 or matrix[i][0] == 0:
                        matrix[i][j] = 0
                    
        
        if colFlag:
            for i in range(m):
                matrix[i][0] = 0
        if rowFlag:
            for j in range(n):
                matrix[0][j] = 0 
 */


class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean flagforrow1 = false;
		boolean flagforcol1 = false;
        
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				flagforcol1 = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				flagforrow1 = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (flagforcol1) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (flagforrow1) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
    }
}