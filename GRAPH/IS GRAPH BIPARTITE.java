

public class Main {
   
   public static boolean isBiapartiteUtil(ArrayList<Edge>[] graph,int src,int[] visited){
       ArrayDeque<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(src,src+"",0));
       
       while(queue.size()>0){
           Pair rem = queue.remove();
           
           if(visited[rem.v] != -1){
               if(visited[rem.v] != rem.level){
                   return false;
               }
           }else{
               visited[rem.v] = rem.level;
           }
           
           for(Edge e : graph[rem.v]){
               if(visited[e.nbr]==-1){
                   queue.add(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));
               }
           }
       }
       
       return true;
   }
   
   public static void isBiapartite(ArrayList<Edge>[] graph,int vtces){
    
    int[] visited = new int[vtces];
    Arrays.fill(visited,-1);
    
    for(int v=0;v<vtces;v++){
        if(visited[v] == -1){
            boolean bip = isBiapartiteUtil(graph,v,visited);
            if(bip == false){
                System.out.println(false);
                return;
            }
        }
    }
    
    System.out.println(true);
    
   }
}



/**
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (colors[i]  == 1 || colors[i]  == -1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;  
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          
                        colors[next] = -colors[cur];  
                        queue.add(next);
                    } 
                    
                    if(colors[next] == colors[cur])  return false;
                    
                }
            }
        }
        
        return true;
    }
}


// leetcode
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
       
        int[] color = new int[N+1];
        List<Integer>[] graph = new List[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] v: dislikes) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        
        for(int i = 1; i <= N; i++) {
            if(color[i] == 0) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while(queue.size() != 0) {
                    int top = queue.removeFirst();
                    for(int neighbor: graph[top]) {
                        if(color[neighbor] == color[top]) return false;
                        if(color[neighbor] == 0) {
                            color[neighbor] = -color[top];
                             queue.add(neighbor);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
 */