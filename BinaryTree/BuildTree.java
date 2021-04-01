import java.util.*;


public class BuildTree {
    static int inpre=0;
   static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    public static void main(String args[]) {
      
        Node root=buildtree();
       // print(root);
        //inorder(root);
        //System.out.println("here");
       // preorder(root);
       // System.out.println("here");
        //postorder(root);
        //System.out.println(height(root)); 
       /* alllevels(root);
        System.out.println();
        bfs(root);
        System.out.println();
        bfsline(root);*/
     //  System.out.println(dia(root));
      // pair ans= optdia(root);
      // System.out.println(ans.dia);
      bfs(root);
      replacesum(root);
      bfs(root);
        
    }
    public static Node buildtree() {
        Scanner sc = new Scanner(System.in);
        int d=sc.nextInt();
        if(d==-1){
           // sc.close();
            return null;
        }
        
        Node root= new Node(d);
        root.left= buildtree();
        root.right=buildtree();
       // sc.close();
        return root;

    }
    public static void print(Node root) {
        if(root==null)
        return;
        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    public static void inorder(Node root) {
        if(root==null)
        return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
        
    }
    public static void preorder(Node root) {
        if(root==null)
        return;
        System.out.println(root.data);
        inorder(root.left);
        
        inorder(root.right);
        
    }
    public static void postorder(Node root) {
        if(root==null)
        return;
        inorder(root.left);
       
        inorder(root.right);
        System.out.println(root.data);
        
    }
    public static int height(Node root) {
        if(root==null)
        return 0;
        int heig=Math.max(height(root.left),height(root.right))+1;
        return heig;
        
    }
    public static void klevel(Node root, int k) {
        if(root==null)
        return;
        if(k==1){
            System.out.print(root.data);
            return;
        }
        klevel(root.left, k-1);
        klevel(root.right, k-1);
        
        
    }
    public static void alllevels(Node root) {
        int h=height(root);
        for (int i = 1; i <=h ; i++) {
            klevel(root, i);
        }
    }
    public static void bfs(Node root) {
        if(root==null)
        return;
        Queue<Node>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.data);
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
        }

    }
    public static void bfsline(Node root) {
        if(root==null)
        return;
        Queue<Node>q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp=q.peek();
            if(temp==null){
                System.out.println();
                q.poll();
                if(!q.isEmpty())
                q.add(null);
            }
            else{
            System.out.println(temp.data);
            q.poll();
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
            }
        }
    }
    public static int dia(Node root) {
        if(root==null)
        return 0;
        int h1=height(root.left);
        int h2=height(root.right);
        int ht=h1+h2;
        int fdia= Math.max(ht,Math.max(dia(root.left),dia(root.right)));
        return fdia;
        
    }
    static class pair{
        int height;
        int dia;

    }
    public static pair optdia(Node root) {
        pair p= new pair();
        if(root==null){
            p.height=0;
            p.dia=0;
            return p;

        }

        pair l= optdia(root.left);
        pair r= optdia(root.right);
        p.height= Math.max(l.height, r.height)+1;
        p.dia= Math.max((l.height+r.height),Math.max(l.dia, r.dia));
        return p;

        
    }
    public static int replacesum(Node root){
        if(root==null)
        return 0;
        if(root.left==null&&root.right==null)
        return root.data;
        int left=replacesum(root.left);
        int right=replacesum(root.right);
        int temp=root.data;
        root.data=left+right;
        return temp+root.data;
    }
    static class Hpair{
        int height;
        boolean isbal; 
    }

    public static Hpair isbalanced(Node root) {
        Hpair hp= new Hpair();
        if(root==null){
            hp.height=0;
            hp.isbal=true;
            return hp;
        }

        Hpair left= isbalanced(root.left);
        Hpair right= isbalanced(root.right);
        hp.height= Math.max(left.height, right.height)+1;
        boolean bal=true;
        if(Math.abs(left.height-right.height)>1)
        bal=false;
        hp.isbal=(bal&&left.isbal&&right.isbal);
        return hp;


    }

    public static Node buildbalanced(int arr[], int s, int e) {
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root= new Node(arr[mid]);
        root.left=buildbalanced(arr, s, mid-1);
        root.right=buildbalanced(arr, mid+1, e);
        return root;
    }

    public static Node treefrominpre(int in[],int pre[], int s,int e) {
        
        if(s>e)
        return null;
        Node root= new Node(pre[inpre]);
        int index=-1;
        for (int j = s; j <=e;j++) {
            if(in[j]==pre[inpre]){
            index=j;
            break;
            }
        }
        inpre++;

        root.left=treefrominpre(in, pre, s, index-1);
        root.right=treefrominpre(in, pre, index+1, e);
        return root;

        
    }
    
}
