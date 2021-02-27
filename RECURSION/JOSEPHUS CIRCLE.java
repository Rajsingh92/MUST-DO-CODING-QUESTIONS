public class Solution {
    // recursion
    public static int solve(int n,int k){
        int x = solve(n-1,k);
        int y = (x+k)%n;
        return y;
    }

    // linkedlist based solution
    public static void circularlist(int m) {
		tail.next = head;
		Node curr = head;
		Node prev=null;
		while (size != 1) {
			for (int i = 0; i < m - 1; i++) {
				prev=curr;
				curr = curr.next;
			}
			// remove curr
			curr.data = curr.next.data;
			curr.next = curr.next.next;
			size--;
		}
		System.out.println(prev.data);
	}

    // bit manipulation
    public static int solve2(int n) {
        int x = nearestPowerOf2(n);
        int l = n - x;
        return (2 * l) + 1;
    }

    public static int nearestPowerOf2(int n) {
        int ans = 0;
        while ((1 << ans) <= n) {
            ans++;
        }
        return 1 << (ans - 1);
    }
}
