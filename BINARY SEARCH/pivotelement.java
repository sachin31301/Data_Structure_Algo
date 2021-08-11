import java.util.*;
public class pivotelement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int no= sc.nextInt();
        int solu[] = new int[no];
        for(int i=0;i<no;i++){
            solu[i]= sc.nextInt();
        }
        System.out.println(pivot(solu));

    }
    static int pivot(int solu[]){
        int s=0;
        int e= solu.length-1;
        int n = solu.length -1;
        int ans=0;
        int mid =0;
        while(s<=e){
            mid=(s+e)/2;
            if(solu[mid]>solu[n]){
                s= mid+1;
            }
            else{
                ans=solu[mid];
                e=mid-1;
            }
        }
        return ans;

    }
}
