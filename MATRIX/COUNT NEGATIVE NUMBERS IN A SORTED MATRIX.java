/**
 * 
Count Negative Numbers in a Sorted Matrix
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the 
number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
 */


class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int r = m-1;
        int c = 0;
        
        int ans = 0;
        
        while(r>=0 && c<n){
            if(grid[r][c]<0){
                ans+=n-c;
                r--;
            }else{
                c++;
            }
        }
        
        return ans;
    }
}