import java.util.*;
class Kgraph{
    int V;
    
    public Kgraph(int v){
        V=v;
    }

    class edge{
        int u;
        int v;
        int w;
        public edge(int a,int b,int c){
            u=a;v=b;w=c;
        }
        public int getu(){
            return u;
        }
        public int getv(){
            return v;
        }
        public int getw(){
            return w;
        }

        
    
    }
     
    class SortComparator implements Comparator<edge>{
        @Override
        public int compare(edge e1,edge e2){
            if(e1.getw()<e2.getw())
            return -1;
            if(e1.getw()>e2.getw())
            return 1;
            return 0;
        }

    }

    private ArrayList<edge> al= new ArrayList<>();

    public void addedge(int u,int v,int w){
        al.add(new edge(u,v,w));
    }

    public int kruskalf(){
        Collections.sort(al,new SortComparator());
        int parent[]= new int[V+1];
        int rank[]= new int[V+1];
        for (int i = 0; i < V; i++) {
            parent[i]=i;
            rank[i]=0;
        }
        ArrayList<edge> myal= new ArrayList<>();
        int cost=0;
        for(edge ed:al){
            if(findpar(ed.getu(),parent)!=findpar(ed.getv(),parent)){
                cost+=ed.getw();
                union(ed.getu(), ed.getv(), rank, parent);
                myal.add(ed);
            }
        }

        for(edge e:myal){
            System.out.println(" "+ e.getu()+ " -"+e.getv()+"-"+e.getw());
        }
        return (cost);
    }

    public int findpar(int u,int par[]){
        if(par[u]==u)
        return u;
        return findpar(par[u], par);

    }

    public void union (int u,int v, int rank[],int par[]){
        u=findpar(u, par);
        v=findpar(v, par);
        if(rank[u]==rank[v]){
            par[v]=u;
            rank[u]++;

        }
        else if(rank[u]>rank[v]){
            par[v]=u;
        }
        else{
            par[u]=v;
        }
        
    }
}
public class kruskal {

    public static void main(String args[]) {
        Kgraph gp= new Kgraph(6);
        gp.addedge(0, 1,  3);
        gp.addedge(0, 3,  7);
        gp.addedge(0, 5,  18);
        gp.addedge(0, 2,  4);
        gp.addedge(2, 5,  5);
        gp.addedge(3, 5,  3);
        gp.addedge(3, 4,  6);
        gp.addedge(1, 4,  5);
       System.out.println(gp.kruskalf()); 
    }
    
}
