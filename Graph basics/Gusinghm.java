import java.util.*;
public class Gusinghm {
    static int V;
    public Graph(int v){
        V=v;

    }
    static HashMap<String,LinkedList<String>> alist= new HashMap<>();
    

    public  void addedge(String u, String v,boolean dir){
        alist.get(u).add(v)
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
    public static void main(String args[]) {
        Graph g= new Graph(5);
        for (int i = 0; i < V; i++) 
            alist.add(new LinkedList<Integer>());
        g.addedge(0, 1, true);
        g.addedge(1, 2, true);
        g.addedge(3, 1, true);
        g.addedge(4, 1, true);
       // g.addedge(2, 1, true);
       // g.addedge(3, 1, true);
       // g.addedge(3, 4, true);
        print();
    }
}
