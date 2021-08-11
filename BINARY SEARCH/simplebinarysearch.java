import java.util.*;
public class simplebinarysearch{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int no= sc.nextInt();
        int test= sc.nextInt();
        int solu[] = new int[no];
        for(int i=0;i<no;i++){
            solu[i]= sc.nextInt();
        }
        System.out.println(search(solu,test));

    }
    static boolean search (int solu[],int find){
        int s,e,mid=0;
        s=0;
        e= solu.length-1;
        
        while(s<e){
            mid=(s+e)/2;
            if(solu[mid]>find){
                e=mid-1;
            }
            else if(solu[mid]<find){
                s=mid+1;
            }
            else{
                return true;
            }

        }
        return false;


    }
}