import java.util.*;
class Graphco{
  boolean visited[];
  ArrayList<ArrayList<node>> graph;
  int distance[];
  public Graphco(int nodes){
      visited= new boolean[nodes];
      graph= new ArrayList<>();
      distance = new int[nodes];
      for(int i=0;i<nodes;i++){
      graph.add(i,new ArrayList<>());
      distance[i]=Integer.MAX_VALUE;
      }
  }
  public  void addedge(int u, int v,boolean dir,int dist){
      graph.get(u).add(new node(v,dist));
      if(dir==true){
          graph.get(v).add(new node(u,dist));
      }
  }
  class SortComparator implements Comparator<node>{
    @Override
    public int compare(node e1, node e2){
        if(graph.get(e1.target).size()<graph.get(e2.target).size())
        return 1;
        else if(graph.get(e1.target).size()>graph.get(e2.target).size())
        return -1;
        else{
        if(depth(e1.target)<depth(e2.target))
        return 1;
        else
        return -1;
        }
    }

}

  public void sort(ArrayList<node>al){
    Collections.sort(al,new SortComparator());
  }

  public int depth(int k){
    if(graph.get(k).size()==0)
    return 0;
    int mdepth=0;
    for(node p:graph.get(k)){
        mdepth=Math.max(mdepth, depth(p.target));
    }
    return 1+mdepth;
  }
}
class node{
  int target;
  int distance;
  public node(int t,int d){
      target=t;
      distance=d;

  }
}

public class Main {

  

  public static void main(String args[]) {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    while(t>0){
     // System.out.println(t);
      int nodes=sc.nextInt();
      int val=sc.nextInt();
      node root= new node(1,val);
      Graphco g= new Graphco(nodes+1);

      for(int i=0;i<nodes-1;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();      
        g.addedge(u, v, false, 0);
        //System.out.println(i);
      }
      Queue<Integer>q= new LinkedList<>();
      int dist[]= new int[nodes+1];
      dist[1]=val;
      q.add(1);
      while(!q.isEmpty()){
        int temp=q.poll();
        g.sort(g.graph.get(temp));
        int m=1;
        for(node p:g.graph.get(temp)){
          dist[p.target]=dist[temp]*m;
          m++;
        }

        for(node pair:g.graph.get(temp)){
          q.add(pair.target);
        }
      }
      int sum=0;
      for(int s=1;s<dist.length;s++){
            sum+=dist[s];
           // System.out.println(dist[s]);
      }

      System.out.println(sum%1000000007);
      t=t-1;

    }


  }
}