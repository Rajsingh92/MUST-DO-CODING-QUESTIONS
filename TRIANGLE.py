'''
Triangle
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number on the row below.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [0]*n
        
        for i in range(n-1,-1,-1):
            for j in range(len(triangle[i])):
                if i==n-1:  #last row
                    dp[j] = triangle[i][j]
                else:
                    dp[j] = triangle[i][j]+min(dp[j],dp[j+1])
                    
        return (dp[0])
        