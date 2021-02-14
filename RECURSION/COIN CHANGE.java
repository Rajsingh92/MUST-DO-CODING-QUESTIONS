/**
Coin change combination
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (non-duplicate) using which the amount "amt" can be paid.
 

2 3 5 6 7   amt = 12

output:
2-3-7-.
5-7-.

*/

public class Main {
    // coin change combination -- No duplicate
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf+".");
            }
            return;
        }
        
        coinChange(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
        coinChange(i+1,coins,amtsf,tamt,asf);
    }
}


/**
Coin change combination
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used again any number of times) using which the amount "amt" can be paid.
 

2 3 5 6 7   amt = 12

output:
2-2-2-2-2-2-.
2-2-2-3-3-.
2-2-2-6-.
2-2-3-5-.
2-3-7-.
2-5-5-.
3-3-3-3-.
3-3-6-.
5-7-.
6-6-.


*/

public class Main {
    // coin change combination -- With duplicate
    public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf) {
        
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf+".");
            }
            return;
        }
        for(int j = tamt/coins[i];j>=1;j--){
            String part= "";
            for(int k =0;k<j;k++){
                part+= coins[i]+"-"; 
            }
            coinChange(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
        }
        coinChange(i+1,coins,amtsf,tamt,asf);
    }
}


/**
 Coin Change - Permutations - 1 Medium
 Coin Change - Permutations - 2 Medium
 */