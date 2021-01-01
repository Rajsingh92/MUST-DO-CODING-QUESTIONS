#Print matrix in snake pattern
def snakeOrder(mat,row,col): 
    for r in range(row):
        if r%2==0:
            for c in range(col):
                print(mat[r][c],end=" ")

        else:
            for c in range(col-1,-1,-1):
                print(mat[r][c],end= " ")