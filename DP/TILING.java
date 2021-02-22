/**
1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */



public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i =3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        System.out.println(dp[n]);
    }
}


/**
1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[] dp = new int[n+1];

        
        for(int i =0;i<n+1;i++){
            if(i<m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1]+dp[i-m];
            }
        }
        
        System.out.println(dp[n]);
    }
}