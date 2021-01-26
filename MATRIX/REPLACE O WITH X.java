/**
Replace O's with X's 
Given a matrix of size NxM where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’. 
A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations just below, 
just above, just left and just right of it.

Examples:

Input: mat[N][M] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'O', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                     {'O', 'O', 'X', 'O', 'O', 'O'},
                    };
Output: mat[N][M] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                      {'X', 'O', 'X', 'X', 'X', 'X'},
                      {'X', 'X', 'X', 'X', 'X', 'X'},
                      {'O', 'X', 'X', 'X', 'X', 'X'},
                      {'X', 'X', 'X', 'O', 'X', 'O'},
                      {'O', 'O', 'X', 'O', 'O', 'O'},
                    };
 */


import java.io.*; 

public class Solution {
    public static void floodfill(char[][] mat,int x,int y,char prevV,char newV){
        if(x<0 || y<0 || x>=mat.length || y>=mat[0].length || mat[x][y] != prevV){
            return;
        }
        mat[x][y] = newV;

        floodfill(mat, x+1, y, prevV, newV);
        floodfill(mat, x-1, y, prevV, newV);
        floodfill(mat, x, y+1, prevV, newV);
        floodfill(mat, x, y-1, prevV, newV);
    }

    public static void replaceSurrounded(char[][] mat){
        int M = mat.length;
        int N = mat[0].length;

        //replace 'O' with '-'
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(mat[i][j] == 'O'){
                    mat[i][j] = '-';
                }
            }
        }

        //call flood fill for all '-' lying on edges
        //left side
        for(int i = 0;i<M;i++){
            if(mat[i][0] == '-'){
                floodfill(mat, i, 0, '-', 'O');
            }
        }

        //right side
        for(int i = 0;i<M;i++){
            if(mat[i][N-1] == '-'){
                floodfill(mat, i, N-1, '-', 'O');
            }
        }

        //top side
        for(int i = 0;i<N;i++){
            if(mat[0][i] == '-'){
                floodfill(mat, 0, i, '-', 'O');
            }
        }

        //bottom side
        for(int i = 0;i<N;i++){
            if(mat[M-1][i] == '-'){
                floodfill(mat, M-1, i, '-', 'O');
            }
        }


        //replace '-' with 'X'
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(mat[i][j] == '-'){
                    mat[i][j] = 'X';
                }
            }
        }
    }
    
}
