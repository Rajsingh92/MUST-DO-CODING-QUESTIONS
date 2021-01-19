'''
Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
'''

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:  # some issues notpassing all test cases
       
        start_row = 0
        start_col = 0
        end_row = len(matrix)
        end_col = len(matrix[0])
        
        final_array = []
    
        while end_row>start_row and end_col>start_col:
            
            for c in range(start_col,end_col): 
                final_array.append(matrix[start_row][c])
            start_row+=1
            
            
            for r in range(start_row,end_row): 
                final_array.append(matrix[r][end_col-1])
            end_col-=1
            
            
            if end_col>start_col: 
                for c in range(end_col-1,start_col-1,-1):
                    final_array.append(matrix[end_row-1][c])
                end_row-=1
                
            
            if end_row>start_row: 
                for r in range(end_row-1,start_row-1,-1):
                    final_array.append(matrix[r][start_col])
                start_col+=1
                
                
        return final_array

    def spiralOrder_rec(self):
        pass
                
                 