
// coin change combination
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        
        for(int i = 0;i<arr.length;i++){
            for(int j = arr[i];j<dp.length;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        
        System.out.println(dp[amt]);
    }
}



// coin change permutation
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(i>=arr[j]){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        
        System.out.println(dp[amt]);
    }
}

// | 322 | Coin Change |  Medium | Adobe, Airbnb, Amazon, Apple, Facebook, Microsoft |
// | 518 | Coin Change 2 |  Medium | Amazon, Facebook, Google, Microsoft |