/**
Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */


public class Solution{
    public static void spiral(int[][] mat,int m ,int n){
        int row = 0;
        int col = 0;

        while(row<m && col<n){
            // print first row
            for(int i = col;i<n;i++){
                System.out.println(mat[row][i]);
            }
            row++;

            //print last column
            for(int i = row;i<m;i++){
                System.out.println(mat[i][n-1]);
            }
            n--;

            //print last row
            if(row<m){
                for(int i = n-1;i>=col;i--){
                    System.out.println(mat[m-1][i]);
                }
            }
            m--;

            //print first col
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    System.out.println(mat[i][col]);
                }
            }
            col++;
        }
    }
}

/**
 * 
Create a matrix with alternating rectangles of O and X
Write a code which inputs two numbers m and n and creates a matrix of size m x n (m rows and n columns) in 
which every elements is either X or 0. The Xs and 0s must be filled alternatively, the matrix should have outermost rectangle of Xs, then a rectangle of 0s, then a rectangle of Xs, and so on.

Examples:

Input: m = 3, n = 3
Output: Following matrix 
X X X
X 0 X
X X X
 */


public class Solution{
    public static void fillmatrix(int m ,int n){
        int row = 0;
        int col = 0;
        char[][] mat = new char[m][n];
        char ch = 'X';

        while(row<m && col<n){
            //  first row
            for(int i = col;i<n;i++){
                mat[row][i] = ch;
            }
            row++;

            // last column
            for(int i = row;i<m;i++){
                mat[i][n-1] = ch;
            }
            n--;

            // last row
            if(row<m){
                for(int i = n-1;i>=col;i--){
                    mat[m-1][i] = ch;
                }
            }
            m--;

            // first col
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    mat[i][col] = ch;
                }
            }
            col++;

            ch = (ch == 'O')?'X':'O';
        }
    }
}


/**
Rotate Matrix Elements
Given a matrix, clockwise rotate elements in it.

Input:
1    2    3    4    
5    6    7    8
9    10   11   12
13   14   15   16

Output:
5    1    2    3
9    10   6    4
13   11   7    8
14   15   16   12
 */


public class Solution{
    public static void rotate(int[][] mat,int m,int n){
        int row = 0;
        int col = 0;
        int prev,curr;

        while(row<m && col<n){

            if(row+1 == m || col+1 == n){
                break;
            }

            prev = mat[row+1][col];

            //move first row
            for(int i = col;i<n;i++){
                curr = mat[row][i];
                mar[row][i] = prev;
                prev = curr;
            }
            row++;

            //move last column
            for(int i = row;i<m;i++){
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;

            //move last row
            if(row<m){
                for(int i =n-1;i>=col;i--){
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            //move first column
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;

        }
        
    }
}
