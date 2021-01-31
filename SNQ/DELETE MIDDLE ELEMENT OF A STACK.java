public class Solution {
    public static void deleteMiddle(Stack<Integer> st,int n,int curr){
        if(n == 0 || curr == n){
            return;
        }
        int x = st.pop();
        deleteMiddle(st, n, curr+1);
        if(curr!=n/2){
            st.push(x);
        }
    }
}
