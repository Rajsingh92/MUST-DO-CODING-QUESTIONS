'''
| 70 | Climbing Stairs |  Easy | Adobe, Alibaba, Amazon, Apple, Facebook, Microsoft |

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
'''

class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0]*(n+1)
        dp[0] =1
        dp[1] =1
        
        for i in range(2,n+1):
            dp[i]+=dp[i-1]+dp[i-2]
        
        return (dp[n])



'''

Min Cost Climbing Stairs

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you 
can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
'''


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [0]*n
        
        dp[0] = cost[0]
        dp[1] = cost[1]
        
        for i in range(2,n):
            dp[i] = min(dp[i-1],dp[i-2])+cost[i]
        
        return min(dp[n-1],dp[n-2])


# climb stairs with variable jumps
def climbStairs2(arr):
    n = len(arr)
    dp = [0]*(n+1)
    dp[n] = 1

    for i in range(n-1,-1,-1):
        for j in range(1,arr[i]+1):
            if i+j<n+1:
                dp[i] += dp[i+j]

    print(dp[0])

# climb stairs with minimum moves
def climbStairs3(arr):
    n = len(arr)
    dp = [None]*(n+1)
    dp[n] = 0

    for i in range(n-1,-1,-1):
        if arr[i]>0:
            minMoves = float('inf')
            for j in range(1,arr[i]+1):
                if i+j<n+1 and dp[i+j]!=None:
                    minMoves = min(minMoves,dp[i+j])
            
            if minMoves!= float('inf'):
                dp[i] = minMoves+1

    print(dp)

