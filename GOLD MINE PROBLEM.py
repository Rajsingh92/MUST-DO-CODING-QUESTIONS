# Gold Mine problem
def goldMine_Dp(gold, m, n):
    dp = [[0 for i in range(n)] for j in range(m)]

    for col in range(n-1, -1, -1):
        for row in range(m):
            if col == n-1:  # last col
                dp[row][col] = gold[row][col]
            elif row == 0:  # first row
                dp[row][col] = gold[row][col] + \
                    max(dp[row][col+1], dp[row+1][col+1])
            elif row == m-1:  # last row
                dp[row][col] = gold[row][col] + \
                    max(dp[row][col+1], dp[row-1][col+1])
            else:
                dp[row][col] = gold[row][col] + \
                    max(dp[row][col+1], dp[row-1][col+1], dp[row+1][col+1])

    max_gold = dp[0][0]
    for row in range(m):
        max_gold = max(max_gold, dp[row][0])

    print(max_gold)