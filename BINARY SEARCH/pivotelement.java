import java.util.*;
public class pivotelement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int no= sc.nextInt();
        int arr[] = new int[no];
        for(int i=0;i<no;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(pivot(arr));

    }
    static int pivot(int arr[]){
        int s=0;
        int e= arr.length-1;
        int n = arr.length -1;
        int ans=0;
        int mid =0;
        while(s<=e){
            mid=(s+e)/2;
            if(arr[mid]>arr[n]){
                s= mid+1;
            }
            else{
                ans=arr[mid];
                e=mid-1;
            }
        }
        return ans;

    }
}
