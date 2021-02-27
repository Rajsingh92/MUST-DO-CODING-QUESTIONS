import math


class Matrix:
    def transpose(self, A: List[List[int]]) -> List[List[int]]:
        return [[A[i][j] for i in range(len(A))] for j in range(len(A[0]))]


    def addMat(self,mat1,mat2): # addition of two matrices
        mat =  [[0 for i in range(len(mat1))] for j in range(len(mat1))]

        for i in range(len(mat1)):
            for j in range(len(mat1[0])):
                mat[i][j] += mat1[i][j] + mat2[i][j]

        return (mat)

    def subMat(self,mat1,mat2): # subtraction of two matrices
        mat =  [[0 for i in range(len(mat1))] for j in range(len(mat1))]

        for i in range(len(mat1)):
            for j in range(len(mat1[0])):
                mat[i][j] += mat1[i][j] - mat2[i][j]

        return (mat)


    def matMul(self,mat1,mat2):     # multiplication of two matrices
        mat =  [[0 for i in range(len(mat1))] for j in range(len(mat1))]

        for i in range(len(mat)): 
            for j in range(len(mat)):
                for k in range(len(mat)): 
                    mat[i][j] += mat1[i][k] * mat2[k][j] 

        return (mat)

    def scalarMatMul(self,mat,k):  # scalar multiplication of a matrix
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                mat[i][j] = mat[i][j]*k
    
        return (mat)
    
    # | 766 | Toeplitz Matrix |  Easy | Facebook, Google |
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[i])):
                if matrix[i][j]!=matrix[i-1][j-1]:
                    return False
                
        return True

    def trace(self,mat): # Trace of a matrix
        result = 0

        for i in range(len(mat)):
            result +=mat[i][i]

        return (result)

    def normal(self,mat): # #Program to find Normal of a matrix
        result  = 0

        for i in range(len(mat)):
            for j in range(len(mat)):
                a=mat[i][j]*mat[i][j]
                result+=a

        return (math.floor(math.sqrt(result)))

    def swapDiagonal(self,mat): #Swap major and minor diagonals of a square matrix
        N = len(mat)
        for i in range(N):
            mat[i][i],mat[i][N-i-1] = mat[i][N-i-1],mat[i][i]

        print(mat)

    def isUpperTriangle(self,mat): #Program to check if matrix is upper triangular
        for i in range(1,len(mat)):
            for j in range(i):
                if mat[i][j]!=0:
                    return False

        return True

    def isLowerTriangle(self,mat): #Program to check if matrix is lower triangular
        for i in range(len(mat)):
            for j in range(i+1,len(mat)):
                if mat[i][j]!=0:
                    return False

        return True



'''
exit point
form coils
number of palindromic paths
find median in a row wise sorted matrix
find specific fair
find orientation
find common elements
saddle point
Print maximum sum square sub-matrix of given size
Find the largest square sub-matrix which is surrounded by all 1’sMedium
Generate list of possible words from a character matrixHard
Find all occurrences of given string in a character matrixHard
Find Duplicate rows in a binary matrixMedium
'''