import java.util.*;
import java.util.Map.Entry;


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
      //bfs(root);
      //replacesum(root);
      //bfs(root);
     // System.out.println(dia(root)); 
      //dpdia(root);
      LinkList l=flatten(root);
      System.out.println(l.tail.data);
      
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

    public static Node buildbalanced(int solu[], int s, int e) {
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root= new Node(solu[mid]);
        root.left=buildbalanced(solu, s, mid-1);
        root.right=buildbalanced(solu, mid+1, e);
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
     public static Node deleteinbst(Node root,int key) {
        if(root==null)
        return null;
         if(root.data>key){
        root.left=deleteinbst(root.left, key);
        return root;
        }
        else if(root.data==key){
            //one
            if(root.left==null&&root.right==null){
               
                return null;
            }
            if(root.left!=null&&root.right==null){
                Node temp=root.left;
                return temp;
            }
            if(root.right!=null&&root.left==null){
                Node temp=root.right;
                return temp;
            }
            Node replace=root.right;
            while(replace.left!=null){
                replace=replace.left;
            }
            root.data=replace.data;
            root.right=deleteinbst(root.right, replace.data);
            return root;


        }
        else if (root.data<key){
            root.right=deleteinbst(root.right, key);
            return root;
        }
        return root;
    }

    static class LinkList{
        Node head;
        Node tail;
    }
    
    public static LinkList flatten(Node root) {
        LinkList l = new LinkList();
        if(root==null){
            l.head=l.tail=null;
            return l;
        }
        if(root.left==null&&root.right==null){
            l.head=root;
            l.tail=root;
            return l;
        }
        if(root.left!=null&&root.right==null){
            LinkList left= flatten(root.left);
            left.tail.right=root;
            l.head=left.head;
            l.tail=root;
            return l;
        }
        if(root.left==null&&root.right!=null){
            LinkList right= flatten(root.right);
            root.right=right.head;
            l.head=root;
            l.tail=right.tail;
            return l;

        }
        LinkList left= flatten(root.left);
        LinkList right=flatten(root.right);
        left.tail.right=root;
        root.right=right.head;
        l.head=left.head;
        l.tail=right.tail;
        return l;
        
    }

    public  static void inorderiterative(Node root) {
        if(root==null){
            return;
        }
        Stack<Node>st= new Stack<>();
        Node curr=root;
        while(curr!=null||st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            curr=curr.right;
            
        }
    }
    public static void preiterative(Node root) {
        if(root==null)
        return;
        Stack<Node>st= new Stack<>();
        st.push(root);
        while(st.size()>0){
            Node temp=st.pop();
            System.out.println(temp.data);
            if(temp.right!=null)
            st.push(temp.right);
            if(temp.left!=null)
            st.push(temp.left);

        }

    }

        public static void postiterative(Node root){
            if(root==null)
            return;
            Stack<Node>st1= new Stack<>();
            Stack<Node>st2= new Stack<>();
            st1.push(root);
            while(st1.size()>0){
                Node temp=st1.pop();
                st2.push(temp);
                if(temp.left!=null){
                    st1.push(temp.left);

                }
                if(temp.right!=null){
                    st1.push(temp.right);
                }
            }
            while(st2.size()>0){
                System.out.println(st2.pop().data);
            }


    }

    public static void leftview(Node root) {
        if(root==null)
        return;
        Queue<Node>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for (int i = 1; i <=n; i++) {
                Node temp=q.poll();
                if(i==1)
                System.out.println(root.data);
                if(temp.left!=null){
                    

                }
            }
        }

    }
    public static Node buildfromlevel(){
        Scanner sc1= new Scanner(System.in);
        int d=sc1.nextInt();
        if(d==-1)
        return null;
        Node root = new Node(d);
        

    }
    static class Qobj{
        Node node;
        int hd;
        public Qobj(Node node,int hdis){
            this.node=node;
            hd=hdis;
        }
        public static void topview(Node root){
            if(root==null)
            return;
            HashMap<Integer,Node>hm= new HashMap<>();
            Queue<Qobj>q= new LinkedList<>();
            q.add(new Qobj(root, 0));
            while(!q.isEmpty()){
                Qobj temp=q.poll();
                if(!hm.containsKey(temp.hd))
                hm.put(temp.hd, temp.node);
                if(temp.node.left!=null)
                q.add(new Qobj(temp.node.left, temp.hd-1));
                if(temp.node.right!=null)
                q.add(new Qobj(temp.node.right, temp.hd+1));

            }

            for(Entry<Integer,Node> e:hm.entrySet()){
                System.out.println(e.getKey() +""+ e.getValue());
            }

        }
    }

    static class Ans{
        int a;
        public Ans(int v){
            a=v;
        }
    }

    public static void dpdia(Node root) {
        Ans dia= new Ans(0);
        dpdiah(root,dia);
        System.out.println(dia.a);
    }

    public static int dpdiah(Node root, Ans dia) {
        if(root==null)
        return 0;
        int l=dpdiah(root.left, dia);
        int r=dpdiah(root.right, dia);
        int temp= Math.max(l, r);
        int ans= Math.max(temp, l+r);
        dia.a= Math.max(dia.a, ans);
        return temp +1;

    }
     public static void maxsumpath(Node root) {
        Ans a= new Ans(0);
        maxsum(root,a);


    }
    public static int maxsum(Node root,Ans a) {
        if(root==null){
            return 0;
        }
        int l=maxsum(root.left, a);
        int r= maxsum(root.right, a);
        int temp= Math.max(Math.max(l, r)+root.data, root.data);
        int ans= Math.max(temp, l+r+root.data);
        a.a=Math.max(ans, a.a);
        return temp;
    }

    public static Node lca(Node root,Node r1, Node r2){
        if(root==null)
        return null;
        if(root==r1||root==r2)
        return root;
        Node left=lca(root.left, r1, r2);
        Node right=lca(root.right,r1,r2);
        if(left!=null&&right!=null)
        return root;
        if(left==null&&right==null)
        return null;
        return left==null?right:left;

    }

    public static ArrayList<Node>  path(Node root,Node node) {
        ArrayList<Node>al= new ArrayList<>();
        if(root==null)
        return;
        if(root==node){
            al.add(root);
            return al;
        }
        A


    }
}
