/**
| 54 | Spiral Matrix |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
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


/**
 * 
 1     2     3     4
 5     6     7     8
 9    10    11    12
 13    14    15    16
 17    18    19    20
 -------------------------------
1 
5 2 
9 6 3 
13 10 7 4 
17 14 11 8 
18 15 12 
19 16 
20


 */



public class Solution {
	public static void zigzagtraversal(int[][] arr){
	    //diagonals start with first row
	    for(int r = 0;r<arr.length;r++){
	        int i = r;
	        int j=  0;
	        while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){
	            System.out.print(arr[i][j]+" ");
	            i--;
	            j++;
	        }
	        System.out.println();
	    }
	    //diagonals start with last col
	    for(int c = 1;c<arr.length;c++){
	        int i = arr.length-1;
	        int j = c;
	        while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){
	            System.out.print(arr[i][j]+" ");
	            i--;
	            j++;
	        }
	        System.out.println();
	    }
	}
}


/**
 * 
Print matrix in snake pattern
Given an n x n matrix .In the given matrix, you have to print the elements of the matrix in the snake pattern.

Examples :

Input :mat[][] = { {10, 20, 30, 40},
                   {15, 25, 35, 45},
                   {27, 29, 37, 48},
                   {32, 33, 39, 50}};
              
Output : 10 20 30 40 45 35 25 15 27 29 37 48 50 39 33 32 
 */

class Solution{
    public static void snake(int[][] mat,int m,int n){
        for(int i = 0;i<m;i++){
            if(i%2 == 0){
                for(int j = 0;j<n;j++){
                    System.out.println(mat[i][j]);
                }
            }else{
                for(int j = n-1;j>=0;j--){
                    System.out.println(mat[i][j]);
                }
            }
        }
    }
}
