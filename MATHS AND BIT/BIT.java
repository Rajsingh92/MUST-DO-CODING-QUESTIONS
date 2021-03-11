/**
| 231 | Power of Two |  Easy | Amazon |

Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n > 0 && (n & n - 1) == 0) {
            return true;
        }

        return false;
    }
}

// Calculate 7n/8 without using division and multiplication operators
public class Main {
    public void solve(int n) {
        int ans = ((n << 3) - n) >> 3;
        System.out.println(ans);
    }
}

//  check odd even
class Solution{
    public void isOddEven(int n){
        if(n&1 == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}


// check have same sign or not
class Solution{
    public void hasSameSign(int m,int n){
        if(m^n > 0){
            System.out.println("Same Sign");
        }else{
            System.out.println("Different Sign");
        }
    }
}


