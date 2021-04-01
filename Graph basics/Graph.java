import java.util.*;
public class Graph {
    static int V;
    public Graph(int v){
        V=v;

    }
    static ArrayList<LinkedList<Integer>> alist= new ArrayList<>();
    

    public  void addedge(int u, int v,boolean dir){
        alist.get(u).add(v);
        if(dir==true){
            alist.get(v).add(u);
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
    public static void bfs(int src,int dest) {
        boolean visited[]= new boolean[V];
        int dist[]= new int[V+1];
        int parent[]= new int[V+1];
        Arrays.fill(parent, -1);

        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        visited[src]=true;
        
        while(q.size()!=0){
            int p=q.poll();
            System.out.println(p);
            q.remove(p);
            for(int nbour:alist.get(p)){
                if(!visited[nbour]){
                    q.add(nbour);
                    visited[nbour]=true;
                    dist[nbour] = dist[p]  + 1;
     				parent[nbour] = p;
                }
            }


        }
        System.out.println("Shortest dist is "+dist[dest]);

    }
    public static void dfs(int src){
        boolean visited[] = new boolean[V];
        System.out.println(src+" ");
        Stack<Integer> st= new Stack<>();
        st.push(src);
        visited[src]=true;
        while(!st.isEmpty()){
            int p=st.pop();
            System.out.println(p);
            for(int nbour:alist.get(p)){
                if(!visited[nbour]){
                    st.push(nbour);
                    visited[nbour]=true;
                }
            }
        }
        


    }
    public static int dijksta(int src, int dest){


    }
    public static void main(String args[]) {
        Graph g= new Graph(7);
        for (int i = 0; i < V; i++) 
            alist.add(new LinkedList<Integer>());
        g.addedge(0, 1, true);
        g.addedge(1, 2, true);
        g.addedge(3, 1, true);
        g.addedge(4, 1, true);
        g.addedge(2, 1, true);
        g.addedge(3, 1, true);
        g.addedge(3, 4, true);
        print();
        dfs(0);
    }
}
