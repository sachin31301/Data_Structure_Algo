import java.util.*;
public class graph1 {
   static class Graph{
        static int V;
        static List<List<Integer>>alist;
        public Graph(int v){
            V=v;
            alist=new ArrayList<>();

        }
    

    public  void addedge(int u,int v,boolean bid) {
        if(bid==true){
            alist.get(u).add(v);
            alist.get(v).add(u);
        }
        else{
            alist.get(u).add(v);
        }
    }
    public static void print() {
        for(int i=0;i<V;i++) {
             System.out.println("\nAdjacency list of vertex" + i); 
            for(int no:alist.get(i)){
                System.out.print(no+"-");

            }
        }
    } 
        public  void bfs(int src){
            boolean visited[]= new boolean[V];
            //System.out.println(src+" ");
            Queue<Integer>q= new LinkedList<>();
            q.add(src);
            visited[src]=true;
            while(!q.isEmpty()){
                int temp=q.poll();
                System.out.println(temp);
               for(int nbour:alist.get(temp)){
                  // System.out.println(nbour);
                   if(visited[nbour]!=true){
                       q.add(nbour);
                       visited[nbour]=true;

                   }
               }
                

            }   
    }
    public  void bfspath(int src){
        int dist[]= new int[V];
        int parent[]= new int[V];
        Arrays.fill(dist,-1);
        Arrays.fill(parent, -1);
        //System.out.println(src+" ");
        Queue<Integer>q= new LinkedList<>();
        q.add(src);
        dist[src]=0;
        parent[src]=src;
        while(!q.isEmpty()){
            int temp=q.poll();
            System.out.println(temp);
           for(int nbour:alist.get(temp)){
              // System.out.println(nbour);
               if(dist[nbour]==-1){
                   q.add(nbour);
                   parent[nbour]=temp;
                   dist[nbour]=dist[temp]+1;

               }
           }
        
        }   
}
    public static void dfs(int src){
        boolean visited[]= new boolean[V];
            //System.out.println(src+" ");
            Stack<Integer>q= new Stack<>();
            q.push(src);
            visited[src]=true;
            while(!q.isEmpty()){
                int temp=q.pop();
                System.out.println(temp);
               for(int nbour:alist.get(temp)){
                  // System.out.println(nbour);
                   if(visited[nbour]!=true){
                       q.push(nbour);
                       visited[nbour]=true;

                   }
               }
                

            }   
    }

    public static void dfs2(int src,boolean visited[]){
        System.out.println(src);
        visited[src]=true;
        for(int nbour:alist.get(src)){
            if(visited[nbour]==false)
            dfs2(nbour,visited);
        }
    }

    
    public static void main(String args[]) {
        Graph g= new Graph(7);
        for (int i = 0; i < V; i++) 
            alist.add(new ArrayList<Integer>());
        g.addedge(0, 1, true);
        g.addedge(1, 2, true);
        g.addedge(3, 1, true);
        g.addedge(4, 1, true);
        g.addedge(2, 1, true);
        g.addedge(3, 1, true);
        g.addedge(3, 4, true);
       // print();
       // g.bfs(1);
        boolean vis[]= new boolean[V];
       // dfs(0);
       dfs2(0,vis);
    }
}
}
