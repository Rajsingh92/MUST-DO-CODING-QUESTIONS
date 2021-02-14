

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