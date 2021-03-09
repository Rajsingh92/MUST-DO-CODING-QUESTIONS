/*
Sum of dependencies in a graph			https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph/0
*/

class Solution {

    public static int sumOfDependencies(Vector<Integer> adj[], int V) {
        int sum = 0;
        for (int u = 0; u < V; u++)
            sum += adj[u].size();

        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {
            int V = scn.nextInt(), E = scn.nextInt();
            Vector<Integer> adj[] = new Vector[V];

            for (int i = 0; i < adj.length; i++) {
                adj[i] = new Vector<>();
            }

            for (int i = 0; i < E; i++) {
                adj[scn.nextInt()].addElement(scn.nextInt());
            }

            System.out.println(sumOfDependencies(adj, V));
        }

    }
}