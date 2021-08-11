import java.util.*;

class Pgraph{
    int V;
    private ArrayList<ArrayList<Integer>> al;
    public Pgraph(int v){
      V=v;
      al= new ArrayList<>();
      for (int i = 0; i < v; i++) {
          
          al.add(i, new ArrayList<>());
      }

    }

    public void addedge(int u,int v,boolean bid) {
        al.get(u).add(v);
        if(bid==true){
            al.get(v).add(u);
        }
    }
    public void bfs(int src) {
        boolean visited[]= new boolean[V];
        Queue<Integer>q= new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            System.out.println(temp);
            
            
            for(int nbour:al.get(temp)){
                if(visited[nbour]==false){
                q.add(nbour);
                visited[nbour]=true;
                }
            }
        }

    }

    public void bfspath(int src) {
        boolean visited[]= new boolean[V];
        int distance[]= new int[V];
        Queue<Integer>q= new LinkedList<>();
        q.add(src);
        visited[src]=true;
        distance[src]=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            System.out.println(temp);
            
            
            for(int nbour:al.get(temp)){
                if(visited[nbour]==false){
                q.add(nbour);
                visited[nbour]=true;
                distance[nbour]=distance[temp]+1;
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("distnce of "+ i+ " is "+ distance[i]);
        }
    }

    public void dfs(int src) {
        boolean visited[]= new boolean[V];
        dfshelper(src,visited );
    }
    public void dfshelper(int src,boolean vis[]) {
        vis[src]=true;
        System.out.println(src);
        for(int nbour:al.get(src)){
            if(vis[nbour]==false){
                dfshelper(nbour, vis);
            }
        }
    }
    public int conn(int src) {
        boolean visited[]= new boolean[V];
        int comp=0;
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfshelper(i, visited);
                comp++;

            }
        }
        return comp;
    }

    public  void dfstopo() {
        ArrayList<Integer>top= new ArrayList<>();
        boolean visited[]= new boolean[V];
        for (int i = 0; i < V; i++) {
            if(visited[i]==false){
            dfshelpertopo(i, visited,top);
            }
        }
        System.out.println(top);
    }
    public void dfshelpertopo(int src,boolean vis[],ArrayList<Integer>top) {
        vis[src]=true;
        //System.out.println(src);
        for(int nbour:al.get(src)){
            if(vis[nbour]==false){
                dfshelpertopo(nbour, vis,top);
            }
        }
        top.add(0, src);
    }

    public void bfstopo() {
        boolean vis[]= new boolean[V];
        int indeg[]= new int[V];
        Queue<Integer>q= new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (Integer nbour : al.get(i)) {
                indeg[nbour]=indeg[nbour]+1;
            }
        }
        for (int i = 0; i < V; i++) {
            if(indeg[i]==0){
            q.add(i);
            vis[i]=true;
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();

            for(int nbour:al.get(temp)){
                indeg[nbour]=indeg[nbour]-1;
            }

        }

    }

    public void articulatio(){
        int vis[]= new int[V+1];
        int tin[]= new int[V+1];
        int low[]= new int[V+1];
        int isarticulation[]= new int[V+1];
        int timer=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){

            }
        }



    }
    public void printart(int node,int par,int timer,int vis[],int tin[],int low[],int art[]){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        int chi=0;
        for(int child:al.get(node)){
            if(child==par)
            continue;
            if(vis[child]==0){
                printart(child, node, timer, vis, tin, low, art);
                low[node]=Math.min(low[node], low[child]);
                if(low[child]>tin[node]&&par!=-1)
                art[node]=1;
                chi++;
            }
            else {
                low[node]=Math.min(low[node],tin[child]);
            }
        }
        if(par==1&&chi>1)
        art[node]++;
    }

}

public class Graphpractice {
    public static void main(String args[]) {
        Pgraph gp= new Pgraph(11);
        gp.addedge(0, 1, true);
        gp.addedge(0, 3, true);
        gp.addedge(0, 5, true);
        gp.addedge(0, 2, true);
        gp.addedge(2, 5, true);
        gp.addedge(3, 5, true);
        gp.addedge(3, 4, true);
        gp.addedge(1, 4, true);
        gp.addedge(5, 6, true);
        gp.addedge(7, 8, true);
        gp.addedge(9, 10, true);
       // gp.bfs(0);
       //gp.bfspath(0);
       //System.out.println(gp.conn(0)); 
       gp.dfstopo();

    }
}
