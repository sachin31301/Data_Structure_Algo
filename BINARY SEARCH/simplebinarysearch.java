import java.util.*;
public class simplebinarysearch{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int no= sc.nextInt();
        int test= sc.nextInt();
        int arr[] = new int[no];
        for(int i=0;i<no;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(search(arr,test));

    }
    static boolean search (int arr[],int find){
        int s,e,mid=0;
        s=0;
        e= arr.length-1;
        
        while(s<e){
            mid=(s+e)/2;
            if(arr[mid]>find){
                e=mid-1;
            }
            else if(arr[mid]<find){
                s=mid+1;
            }
            else{
                return true;
            }

        }
        return false;


    }
}