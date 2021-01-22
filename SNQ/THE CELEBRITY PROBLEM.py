'''
The Celebrity Problem 
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if 
there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to
1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 


private static int celebrity(int[][] arr) {
		Stack<Integer> st = new Stack();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			int val1 = st.pop();
			int val2 = st.pop();
			if (knows(arr, val1, val2)) {
				st.push(val2);
			} else {
				st.push(val1);
			}
		}

		int c = st.pop();
		for (int i = 0; i < arr.length; i++) {
			// If any person doesn't
			// know 'c' or 'a' doesn't
			// know any person, return -1
			if (i != c && (knows(arr, c, i) || !knows(arr, i, c)))
				return -1;
		}
		return c;
	}

	private static boolean knows(int[][] arr, int val1, int val2) {
		if (arr[val1][val2] == 1) {
			return true;
		}
		return false;
	}
'''

class Solution:
    def celebrity(self, M, n):
        stack = []
        
        for i in range(n):
            stack.append(i)
            
        while len(stack)>=2:
            i = stack.pop()
            j = stack.pop()
            
            if M[i][j] == 1 : # i knows j -> i cannot be celebrity
                stack.append(j)
            else:
                stack.append(i)
        
        potential = stack.pop()
        
        for i in range(n):
            if i!=potential:
                if M[i][potential] == 0 or M[potential][i]==1:
                    return -1
                    
        return potential



