/**
 introduction-to-recursion:
 Print Decreasing Easy
 Print Increasing Easy
 Print Increasing Decreasing Easy
 Factorial Easy
 Power-linear Easy
 Power-logarithmic Easy
 Print Zigzag Easy
 Tower Of Hanoi Easy





 recursion-on-the-way-up:
 Print Subsequence Easy
 Print Kpc Easy
 Print Stair Paths Easy
 Print Maze Paths Easy
 Print Maze Paths With Jumps Easy
 Print Permutations Easy
 Print Encodings Easy

 recursion-backtracking:
 Flood Fill Easy
 Target Sum Subsets Easy
 N Queens Easy
 Knights Tour Easy



 Abbreviation Using Backtracking Medium
 N Queens - Branch And Bound Hard
 Max Score Hard
 Josephus Problem Easy
 Lexicographical Numbers Medium
 Gold Mine - 2 Easy
 Solve Sudoku Hard
 Crossword Puzzle Easy
 Cryptarithmetic Easy
 Magnets Easy
 Friends Pairing - 2 Easy
 K-partitions Easy
 All Palindromic Permutations Medium
 All Palindromic Partitions Medium
 K Subsets With Equal Sum Medium
 Tug Of War Easy
 Pattern Matching Medium
 Word Break - I Easy
 Remove Invalid Parenthesis Hard
 Largest Number Possible After At Most K Swaps Easy


 Permutation -  1 Easy
 Combinations - 1 Medium
 Permutations - 2 Medium
 Combinations - 2 Medium
 Queens Combinations - 2d As 2d - Box Chooses Medium
 Queens Permutations - 2d As 2d - Queen Chooses Medium
 Queens Permutations - 2d As 2d - Box Chooses Medium
 Queens Combinations - 2d As 2d - Queen Chooses Medium
 Queens Combinations - 2d As 1d - Queen Chooses Medium
 Nqueens Combinations - 2d As 1d - Queen Chooses Medium
 Nknights Combinations - 2d As 1d - Knight Chooses Medium
 Nqueens Permutations - 2d As 1d - Queen Chooses Easy
 Permutations - Words - 1 Easy
 Permutations - Words - 2 Easy


Backtracking Set 1 The Knights Tour Problem
Backttracking Set 2 Rat In A Maze
Backtracking Set 7 Suduku
Remove Invalid Parentheses
Word Break Problem Using Backtracking
Print Palindromic Partitions String
Find Shortest Safe Route In A Path With Landmines
Combinational Sum
Partition Set K Subsets Equal Sum
Longest Possible Route In A Matrix With Hurdles
Backtracking Set 8 Solving Cryptarithmetic Puzzles
Find If There Is A Path Of More Than K Length From A Source
Backtracking Set 7 Hamiltonian Cycle
Tug Of War
Find Maximum Number Possible By Doing At Most K Swaps
Find Paths From Corner Cell To Middle Cell In Maze
Arithmetic Expressions
Crossword Puzzle
m Coloring Problem
Print all permutations of a string 
Print all possible paths from top left to bottom right of a mXn matrix
Partition of a set intoK subsets with equal sum
Find the K-th Permutation Sequence of first N natural numbers
Print all Subsequences of a string.
Print all the permutations of the given string
Count of number of given string in 2D character array


public static int permuatationWithDuplicates(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1); // rest of string
            count += permuatationWithDuplicates(ros, ans + ch);
        }
        return count;
    }

    public static int permuatationWithoutDuplicates(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!vis[ch - 'a']) {
                vis[ch - 'a'] = true;
                String ros = str.substring(0, i) + str.substring(i + 1); // rest of string
                count += permuatationWithoutDuplicates(ros, ans + ch);
            }
        }

        return count;
    }


 */