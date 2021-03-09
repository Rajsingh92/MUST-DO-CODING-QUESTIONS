
//  Min sum formed by digits				

class Solution {
    void solve(int[] arr, int n) {

        Arrays.sort(arr);

        long num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }

        System.out.print(num1 + num2);
    }
}