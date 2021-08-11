import java.util.*;

     class Graphhm<E>{
    
    int V;
    public Graphhm(int v){
        V=v;
    }
    private HashMap<E,List<E>>hm= new HashMap<>();

    public void addedge(E u,E v,boolean bid){
       // System.out.println("called");
        if(!hm.containsKey(u)) hm.put(u, new ArrayList<>());
        hm.get(u).add(v);
        //hm.getOrDefault(u, new ArrayList<E>()).add(v);
       // System.out.println(hm.get(u));
        if(bid==true){
            //hm.getOrDefault(v, new ArrayList<E>()).add(u);
            if(!hm.containsKey(v)) hm.put(v, new ArrayList<>());
        hm.get(v).add(u);
        }

    }
    public void print(){
      //  System.out.println("print called");
        for (E l:hm.keySet()) {
           // System.out.println("print called");
            System.out.println("\nAdjacency list of vertex" + l);
            for(E list:hm.get(l)){
                System.out.print(list+" ");
            }
        }
    }
    public  void bfs(E src){
        //boolean visited[]= new boolean[V];
        //System.out.println(src+" ");
        Map<E,Boolean>map= new HashMap<>();
        Queue<E>q= new LinkedList<>();
        q.add(src);
        map.put(src,false);
        while(!q.isEmpty()){
            E temp=q.poll();
            System.out.println(temp);
           for(E nbour:hm.get(temp)){
              // System.out.println(nbour);
              // System.out.println(nbour);
               if(map.getOrDefault(nbour,false)!=false){
                   q.add(nbour);
                   map.put(nbour,false);

               }
           }
            

        }
        
       
}

public  void bfspath(E src){
    //boolean visited[]= new boolean[V];
    //System.out.println(src+" ");
    Map<E,Integer>map= new HashMap<>();
    Map<E,E>par= new HashMap<>();
    Queue<E>q= new LinkedList<>();
    q.add(src);
    map.put(src,0);
    par.put(src,src);
    while(!q.isEmpty()){
        E temp=q.poll();
        //System.out.println(temp);
        if(hm.get(temp).size()==0)
        continue;
       for(E nbour:hm.get(temp)){
          // System.out.println(nbour);
          // System.out.println(nbour);
           if(map.getOrDefault(nbour,-1)==-1){
               q.add(nbour);
               par.put(nbour,temp);
               map.put(nbour,map.get(temp)+1);

           }
       }
        

    }
    
    for(E node:hm.keySet()){

        System.out.println("distance is"+" "+node+" "+map.get(node));

    }
}

        public  int dfs(E src){
            Map<E,Boolean>hmap= new HashMap<>();
            dfshelper(src,hmap);
            int cmpt=0;
            for(E node:hm.keySet()){
                if(hmap.getOrDefault(node,false)==false){
                dfshelper(node,hmap);
                cmpt++;
                }
            }
            return cmpt;

        }
        public void dfshelper(E src,Map<E, Boolean> hmap){
            hmap.put(src, false);
            System.out.println(src);
            for(E node:hm.get(src)){
                if(hmap.getOrDefault(node,false)==false)
                dfshelper(node, hmap);
            }
        }

        public void toposort(){
            Map<E,Boolean>tmap= new HashMap<>();
            List<E>order= new ArrayList<>();

            for(E node:hm.keySet()){
                if(tmap.getOrDefault(node, false)==false){
                    dfshelpertopo(node, tmap,order);
                }
            }

            for(E node:order){
                System.out.print(node+" ->");
            }

        }
        public void dfshelpertopo(E node,Map<E,Boolean>tmap,List<E>al){
            tmap.put(node,true);
            if(hm.get(node)!=null){
               
            for(E nbour:hm.get(node)){
                if(tmap.getOrDefault(nbour, false)==false){
                    dfshelpertopo(nbour, tmap, al);
                }
            }
        }
            al.add(0, node);
        }

        public void bfstopo(){
            Map<E,Boolean>vis= new HashMap<>();
            Map<E,Integer>indeg= new HashMap<>();
            Queue<E>q= new LinkedList<>();

            for(E node:hm.keySet()){
                vis.put(node,false);
                indeg.put(node,0);
            }
            System.out.print(indeg);

            for(E node:hm.keySet()){
                if(hm.get(node)!=null){
                for(E val:hm.get(node)){

                    indeg.put(val,indeg.getOrDefault(val,0)+1);
                }
            }
            }

            for(E node:hm.keySet()){
                if(indeg.get(node)==0){
                    q.add(node);
                }

            }
            while(!q.isEmpty()){
                E temp=q.poll();
                System.out.println(temp+"->");
                if(hm.get(temp)!=null){
                    for(E nbour:hm.get(temp)){
                        indeg.put(nbour,indeg.get(nbour)-1);
                        if(indeg.get(nbour)==0)
                        q.add(nbour);
                    }
                }
            }

        }
        public  boolean bfscycle(E src){
            System.out.println(hm);
            //boolean visited[]= new boolean[V];
            //System.out.println(src+" ");
            Map<E,Boolean>map= new HashMap<>();
            Map<E,E>pare= new HashMap<>();
            Queue<E>q= new LinkedList<>();
            q.add(src);
            pare.put(src,src);
            map.put(src,false);
            while(!q.isEmpty()){
                E temp=q.poll();
                //System.out.println(temp);
               for(E nbour:hm.get(temp)){
                  // System.out.println(nbour);
                  // System.out.println(nbour);
                  if(map.getOrDefault(nbour,false)==false&&pare.get(temp)!=nbour)
                  return true;
                   if(map.getOrDefault(nbour,false)!=false){
                       q.add(nbour);
                       map.put(nbour,false);
                       pare.put(nbour, temp);
    
                   }
               }
                
    
            }
        return false;    
           
    }
    public boolean dfscyclic(){
        System.out.println(hm);
        Map<E,Boolean> mp= new HashMap<>();
        Map<E,Boolean>instack= new HashMap<>();
        boolean cyc;

        for(E node:hm.keySet()){
            if(mp.getOrDefault(node, false)==false){
                cyc =cyclehelper(mp,instack,node);
                if(cyc==true){
                    System.out.println(cyc);
                return true;
                }
            }
        }
      return false;
    }
    public boolean cyclehelper(Map<E,Boolean>vis,Map<E,Boolean>insta,E node){
        vis.put(node, true);
        insta.put(node,true);
        System.out.println(vis);
        System.out.println(insta);

        if(hm.get(node)!=null){
            for(E val:hm.get(node)){
                if((vis.getOrDefault(val, false)==false&&cyclehelper(vis, insta, val)==true)||insta.get(val)==true)
                return true;
            }
        }
        insta.put(node,false);
        System.out.println(vis);
        System.out.println(insta);
        return false;
    }
    
    
    }

    
    
    
public class graphusinghm{
    public static void main(String args[]) {
        
        Graphhm<String> g= new Graphhm<String>(8);
      //  System.out.println(g.hm);
        //g.print();
        g.addedge("agra", "luck",   false);
        g.addedge("agra", "mathurs", false);
        g.addedge("delhi", "kolkata", false);
        g.addedge("punjab", "kolkata", false);
        g.addedge("delhi", "mathurs", false);
        g.addedge("kolkata", "haryana", false);
        g.addedge("haryana", "ranchi", false);
        g.addedge("punjab", "kanpur", false);
        g.addedge("massi", "ludhi", false);
        g.addedge("kali", "mael", false);
        //System.out.println(g.hm);

       // g.print();
       // System.out.println(g.hm);
       //g.bfs("agra");
       //g.bfspath("agra");
       //System.out.println(g.dfs("agra"));
      // g.toposort();
       //System.out.println(" ");
       //g.bfstopo();
       System.out.println(g.dfscyclic()); 
       
       
    }
}
