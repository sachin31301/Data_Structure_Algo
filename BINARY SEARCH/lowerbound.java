import java.util.*;
public class lowerbound {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int no= sc.nextInt();
        int test= sc.nextInt();
        int arr[] = new int[no];
        for(int i=0;i<no;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(lowerb(arr,test));

    }
    // for upper bound = comes like <=
    static int lowerb(int arr[],int value){
        int s=0;
        int e= arr.length-1;
        int mid=0;
        int ans=-1;
        while(s<=e){
            mid=(s+e)/2; 
            if(arr[mid]>=value){
                ans=arr[mid];
                e=mid-1;
            }  
             if( arr[mid]<value){
                s=mid+1;
            }   
                          
        }
        return ans;
    }
}
