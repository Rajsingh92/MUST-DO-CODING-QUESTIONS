//                  CATALAN NUMBER BASED
//                  CATALAN NUMBER BASED
//                  CATALAN NUMBER BASED




/**
Nth catalan number 

Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Note: Positions start from 0 as shown above.

Example 1:

Input:
N = 5
Output: 42

 */

public class Main {

    // Nth catalan number 
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        System.out.println(dp[n]);
    }

    // circle and chords 
    public static long NumberOfChords(int n) {
        long[] dp = new long[2 * n + 1];
        dp[0] = dp[2] = 1;
        for (int i = 4; i < dp.length; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }
        return dp[dp.length - 1];
    }

}

// number of bsts
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        System.out.println(dp[n]);
    }

}

/**
No Changes same solution:

counting valleys and mountanis
count brackets
Number of ways of triangulation
maze paths above diagonal
 */