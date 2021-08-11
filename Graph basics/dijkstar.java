import java.util.*;


class Graphd<T>{
    
    int V;
    public Graphd(int v){
        V=v;
    }
     class Pair{
        T node;
        int dist;
        public Pair(T node,int dis){
            this.node=node;
            this.dist=dis;

        }
    }
    private HashMap<T,List<Pair>>hm= new HashMap<>();

    public void addedge(T u,T v,boolean dir,int dist){
        if(!hm.containsKey(u)) hm.put(u, new ArrayList<>());
        hm.get(u).add(new Pair(v,dist));
        if(dir==true){
            //hm.getOrDefault(v, new ArrayList<E>()).add(u);
            if(!hm.containsKey(v)) hm.put(v, new ArrayList<>());
        hm.get(v).add(new Pair(u,dist));
        }
    }
    public void dikstra(T src){
        Map<T,Boolean>vis= new HashMap<>();
        Map<T,Integer>dis= new HashMap<>();
        TreeSet<Pair>set= new TreeSet<>((e1,e2)->e1.dist-e2.dist);
        
        for(T node:hm.keySet()){
            dis.put(node,Integer.MAX_VALUE);
        }
        set.add(new Pair(src,0));
        vis.put(src, true);
        dis.put(src, 0);

        while(set.size()>0){
            Pair p=set.pollFirst();
           // System.out.println(p.node);
           // System.out.println(p.dist);

            //System.out.println(dis);
            if(vis.getOrDefault(p.node,false)==false);
            {
                vis.put(p.node, true);
            if(hm.get(p.node)!=null){
            for(Pair nbour:hm.get(p.node)){
                if(vis.getOrDefault(nbour.node,false)==false&&(dis.get(p.node)+nbour.dist)<dis.getOrDefault(nbour.node,Integer.MAX_VALUE)){
                    dis.put(nbour.node,dis.get(p.node)+nbour.dist );
                    set.remove(nbour);
                    nbour.dist=dis.get(p.node)+nbour.dist;
                    set.add(nbour);
                    
                }
                
            }
            
        }
            }
           //System.out.println(dis);
        }
        System.out.println(dis);


    }

    public int prim(T src){
        //System.out.println(hm);
        PriorityQueue<Pair>p= new PriorityQueue<>((e1,e2)->e1.dist-e2.dist);
        Map<T,Boolean>vis= new HashMap<>();
        vis.put(src,true);
        if(hm.get(src)!=null){
            for(Pair edge:hm.get(src)){
                p.add(edge);
            }

        }
        int minc=0;
        while(!p.isEmpty()){
            for(Pair check:p){
                System.out.print("queue is:-");
                System.out.print(check.node+" - "+check.dist);
                System.out.println();
            }
            Pair min=p.poll();
            if(vis.getOrDefault(min.node, false)==false){
                System.out.print(" "+min.dist+" -");
                System.out.print(" "+min.node);
                minc+=min.dist;
                vis.put(min.node, true);
                if(hm.get(min.node)!=null){
                for(Pair cedge:hm.get(min.node)){
                    if(vis.getOrDefault(cedge.node, false)==false)
                    p.add(cedge);
                }
            }
            }

        }
        return minc;
        
    }

    public int kruskal(T src){
       // System.out.println(hm);
        PriorityQueue<Pair>pq= new PriorityQueue<>((e1,e2)->e1.dist-e2.dist);
        Map<T,Boolean>vis= new HashMap<>();
       // Map<T,Boolean>par= new HashMap<>();
        for(T node:hm.keySet()){
           // par.put(node, true);

            for(Pair p:hm.get(node)){
               // if(par.getOrDefault(p.node, false)==false)
                 pq.add(p);
            }
        }
        for(Pair check:pq){
            System.out.println(check.node+" - "+check.dist);
        }
        int mincost=0;

        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            if(vis.getOrDefault(temp.node, false)==false){
                System.out.print(temp.dist+" -");
                System.out.print(temp.node);
                mincost+=temp.dist;
                vis.put(temp.node, true);

            }
        }

        return mincost;


    }

}

public class dijkstar{
    public static void main(String args[]) {
        Graphd<Integer>g= new Graphd<>(5);
        g.addedge(0, 1, true, 3);
        g.addedge(0, 3, true, 7);
        g.addedge(0, 5, true, 18);
        g.addedge(0, 2, true, 4);
        g.addedge(2, 5, true, 5);
        g.addedge(3, 5, true, 3);
        g.addedge(3, 4, true, 6);
        g.addedge(1, 4, true, 5);
      //long a=System.currentTimeMillis();
        System.out.println(g.prim(0)); 
       // long b=System.currentTimeMillis();
       // System.out.println(b-a);
       // System.out.println(g.prim(0)); 
       // System.out.println(g.kruskal("agra"));
        

    }
}

