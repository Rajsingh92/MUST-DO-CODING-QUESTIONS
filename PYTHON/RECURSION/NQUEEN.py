#  (N Queen Problem) O(N!)
N=4
def isValidQueen(board,row,col):
    for i in range(row):
        if board[i][col] == 1:
            return False

    i,j = row,col
    while i>=0 and j>=0 and i<N and j<N:
        if board[i][j]==1:
            return False
        i-=1
        j-=1

    i,j = row,col
    while i>=0 and j>=0 and i<N and j<N:
        if board[i][j]==1:
            return False
        i-=1
        j+=1

    return True


def solveNQueen(board,row):
    #solution found
    if row==N:
        for row in board:
            print(row)
        return      

    for col in range(N):
        if isValidQueen(board,row,col):
            board[row][col] = 1
            solveNQueen(board,row+1) 
            board[row][col] = 0