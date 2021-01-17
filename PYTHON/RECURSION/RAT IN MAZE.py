
M=N=8
# find shortest path
def isValidPath(board,solution,i,j):
    if i>=0 and j>=0 and i<M and j<N and board[i][j] == 1 and solution[i][j]==0 :
        return True
    return False


def solveMazePathProblem(board,solution,i,j,x,y,min_dist,dist):

    # solution found
    if i==x and j==y:
        return min(min_dist,dist)

    solution[i][j]=1

    if isValidPath(board,solution,i+1,j):
        min_dist = solveMazePathProblem(board,solution,i+1,j,x,y,min_dist,dist+1)
    if isValidPath(board,solution,i,j+1):
        min_dist = solveMazePathProblem(board,solution,i,j+1,x,y,min_dist,dist+1)
    if isValidPath(board,solution,i-1,j):
        min_dist = solveMazePathProblem(board,solution,i-1,j,x,y,min_dist,dist+1)
    if isValidPath(board,solution,i,j-1):
        min_dist = solveMazePathProblem(board,solution,i,j-1,x,y,min_dist,dist+1)

    solution[i][j] = 0   #backtrack
    return (min_dist)

# find longest path
def solveMazePathProblemLongest(board,solution,i,j,x,y,max_dist,dist):
    
    #solution found
    if i==x and j==y:
        return max(max_dist,dist)

    solution[i][j]=1

    if isValidPath(board,solution,i+1,j):
        max_dist = solveMazePathProblemLongest(board,solution,i+1,j,x,y,max_dist,dist+1)
    if isValidPath(board,solution,i,j+1):
        max_dist = solveMazePathProblemLongest(board,solution,i,j+1,x,y,max_dist,dist+1)
    if isValidPath(board,solution,i-1,j):
        max_dist = solveMazePathProblemLongest(board,solution,i-1,j,x,y,max_dist,dist+1)
    if isValidPath(board,solution,i,j-1):
        max_dist = solveMazePathProblemLongest(board,solution,i,j-1,x,y,max_dist,dist+1)

    solution[i][j] = 0   #backtrack

    return max_dist

# # Rat in a Maze with multiple steps or jump allowed
def canJump(board,i,j):
    if i>=0 and j>=0 and i<N and j<N and board[i][j]!=0:
        return True
    return False

def ratWithMultipleJumps(board,visited,i,j):
    #solution found
    if i==N-1 and j==N-1:
        for r in visited:
            print(r)
        return

    if canJump(board,i,j):
        visited[i][j]=1
        for k in range(1,N):
            if board[i][j]>=i:
                ratWithMultipleJumps(board,visited,i+k,j)
                ratWithMultipleJumps(board,visited,i,j+k)
        visited[i][j]=0

        