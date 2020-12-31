# Min cost path
# Unique paths in a Grid
def minCostpath_Dp(mat, m, n):
    dp = [[0 for i in range(n)] for j in range(m)]

    for i in range(m-1, -1, -1):
        for j in range(n-1, -1, -1):
            if i == m-1 and j == n-1:  # last cell
                dp[i][j] = mat[i][j]
            elif i == m-1:  # last row
                dp[i][j] = mat[i][j]+dp[i][j+1]
            elif j == n-1:  # last col
                dp[i][j] = mat[i][j]+dp[i+1][j]
            else:
                dp[i][j] = mat[i][j]+min(dp[i+1][j], dp[i][j+1])

    print(dp)