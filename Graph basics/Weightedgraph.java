import java.util.ArrayList;
import java.util.PriorityQueue;



public class Weightedgraph {
    public static void main(String args[]) {
        Graphc gp= new Graphc(6);
        gp.addedge(0, 1, true, 3);
        gp.addedge(0, 3, true, 7);
        gp.addedge(0, 5, true, 18);
        gp.addedge(0, 2, true, 4);
        gp.addedge(2, 5, true, 5);
        gp.addedge(3, 5, true, 3);
        gp.addedge(3, 4, true, 6);
        gp.addedge(1, 4, true, 5);

        //System.out.println(gp.prim(0));
      /*  System.out.println(gp.dijksta(0, 1));
        System.out.println(gp.dijksta(0, 2));
        System.out.println(gp.dijksta(0, 3));
        System.out.println(gp.dijksta(0, 4));
        System.out.println(gp.dijksta(0, 5));*/
        long a=System.currentTimeMillis();
        gp.dijksta(0, 5);
        long b=System.currentTimeMillis();
        System.out.println(b-a);
        
    }
    
}

class edge{
    int target;
    int distance;
    public edge(int t,int d){
        target=t;
        distance=d;

    }
}
class Graphc{
    boolean visited[];
    ArrayList<ArrayList<edge>> graph;
    int distance[];
    public Graphc(int nodes){
        visited= new boolean[nodes];
        graph= new ArrayList<>();
        distance = new int[nodes];
        for(int i=0;i<nodes;i++){
        graph.add(i,new ArrayList<>());
        distance[i]=Integer.MAX_VALUE;
        }
    }
    public  void addedge(int u, int v,boolean dir,int dist){
        graph.get(u).add(new edge(v,dist));
        if(dir==true){
            graph.get(v).add(new edge(u,dist));
        }
    }
    
    public  int  dijksta(int src,int dest) {
        if(src==dest)
        return 0;
        PriorityQueue<edge>minheap= new PriorityQueue<>((e1,e2)->e1.distance-e2.distance);
        distance[src]=0;
        minheap.add(new edge(0,0));
        while(!minheap.isEmpty()){
            for(edge check:minheap){
                System.out.print("queue is:-");
                System.out.print(check.target+" - "+check.distance);
                System.out.println();
            }
            System.out.println("end");
            int v=minheap.poll().target;
            if(visited[v])
            continue;
            visited[v]=true;
            ArrayList<edge> al=graph.get(v);
            for(edge Edge:al){
                int dist=Edge.distance;
                int child=Edge.target;
                if(!visited[child]&&(distance[v]+dist<distance[child])){
                    distance[child]=distance[v]+dist;
                    Edge.distance=distance[v]+dist;
                    minheap.add(Edge);
                }
            }
        }
       return distance[dest];



    }
    public int prim(int src){
        PriorityQueue<edge>minheap= new PriorityQueue<>((e1,e2)->e1.distance-e2.distance);
        visited[src]=true;
        ArrayList<edge>chilofsrc= graph.get(src);
        for(edge Edge: chilofsrc){
            minheap.add(Edge);
        }
        int mincost=0;
        while (!minheap.isEmpty()) {
            for(edge check:minheap){
                System.out.print("queue is:-");
                System.out.print(check.target+" - "+check.distance);
                System.out.println();
            }
            edge minvaledge= minheap.poll();
            if(visited[minvaledge.target])
            continue;
            visited[minvaledge.target]=true;
            System.out.print(minvaledge.distance+"-");
            System.out.print(" "+minvaledge.target+" ");
            mincost+=minvaledge.distance;
            System.out.println(visited[3]);
            ArrayList<edge>chilList= graph.get(minvaledge.target);
            for(edge Edge:chilList){
                System.out.println(Edge.target);
                if(!visited[Edge.target])
                minheap.add(Edge);
            }
        }
        return mincost;
    }


}