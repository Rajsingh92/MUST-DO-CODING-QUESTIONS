# The Knight’s tour problem   O(8^(N^2))
'''
Problem Statement:
Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must 
visit each square exactly once. Print the order of each the cell in which they are visited.

Example:

Input : 
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12

'''

xMove = [2, 1, -1, -2, -2, -1, 1, 2]
yMove = [1, 2, 2, 1, -1, -2, -2, -1]

def knightTour(board,x,y,pos):
    board[x][y] = pos

    if pos>=N*N:
        for i in board:
            print(i)
        print()
        return 


    for i in range(8):
        r = x+xMove[i]
        c = y+yMove[i]

        if r in range(N) and c in range(N) and board[r][c]==0:
            knightTour(board,r,c,pos+1)


    board[x][y] = 0  #backtrack


if __name__ == '__main__':
    N = 5
    board = [[0 for x in range(N)] for y in range(N)]
    pos = 1
    knightTour(board, 0, 0, pos)

