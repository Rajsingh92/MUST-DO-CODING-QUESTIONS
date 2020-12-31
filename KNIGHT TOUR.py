# The Knight’s tour problem   O(8^(N^2))

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

