'''
Common elements in all rows of a given matrix
Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.

Example:

Input:
mat[4][5] = {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };

Output: 
1 8 or 8 1
8 and 1 are present in all rows.

'''



class Solution :
    def commonInRow(self,mat):
        m,n = len(mat),len(mat[0])
        dict = {}

        for i in range(m):
            for j in range(n):
                if i==0:
                    dict[mat[i][j]] = 1
                else:
                    if mat[i][j] in dict and dict[mat[i][j]] == i:
                        dict[mat[i][j]]+=1
                        if i == m-1:
                            print(mat[i][j],end=" ")



