'''
Find the row with maximum number of 1s
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example:

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2
'''

class Solution:
    def maxOnesInRow(self,mat):
        m,n = len(mat),len(mat[0])
        i,j = 0,len(mat)-1
        index = -1

        while i>=0 and i<m and j>=0 and j<n:
            if mat[i][j] == 1:
                j-=1
                index = i
            else:
                i+=1

        if index!=-1:
            return index+1
        else:
            return index

