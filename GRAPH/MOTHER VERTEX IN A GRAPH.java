

public class Main {

    public static void dfs(ArrayList < Edge > [] graph,boolean[] visited,int v){
        visited[v] = true;

        for(Edge e : graph[v]){
            if(!visited[e.nbr]){
                dfs(graph,visited,e.nbr);
            }
        }
    }


    public static void motherVertex(ArrayList < Edge > [] graph,int vtces){
        boolean[] visited = new boolean[vtces];

        int potentialMotherVertex = -1;
        for(int v =0;v<vtces;v++){
            if(visited[v] == false){
                dfs(graph,visited,v);
                potentialMotherVertex = v;
            }
        }

        boolean[] check = new boolean[vtces];
        dfs(graph,visited,potentialMotherVertex);

        for(boolean val : check){
            if(val == false){
                System.out.println("No Mother vertex");
            }
        }

        System.out.println(potentialMotherVertex);
    }


}