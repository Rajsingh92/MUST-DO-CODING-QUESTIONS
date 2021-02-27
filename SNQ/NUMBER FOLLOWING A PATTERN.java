/**
Number following a pattern 
Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Digits from 1-9 and digits can't repeat.

Input
5
D
I
DD
IIDDD
DDIDDIID

Output
21
12
321
126543
321654798
 */


class Solution {

    public static String sequence(String str) {
        Stack<Integer> st = new Stack<>();
        String ans = "";

        for (int i = 0; i <= str.length(); i++) {
            st.push(i + 1);
            if (i == str.length() || str.charAt(i) == 'I') {
                while (!st.empty()) {
                    ans += st.pop();
                }
            }
        }

        return ans;
    }
}