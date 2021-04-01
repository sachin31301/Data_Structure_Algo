import java.util.*;
public class aggcows {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noofcows= sc.nextInt();
        int noofpos = sc.nextInt();
        int pos[] = new int[noofpos];
        for (int i = 0; i < pos.length; i++) {
            pos[i]= sc.nextInt();
        }
        Arrays.sort(pos);
        System.out.println(output(pos,noofcows,noofpos));

    }
    static int output(int arr[],int ncows,int npos){
        int min=0;
        int max=arr[npos-1];
        int ans=0;
        int mid=0;
        while(min<=max){
            mid =(min+max)/2;
            if(ispossible(arr,mid,ncows)){
                ans=mid;
                min=mid+1;
            }
            else{
                max=mid-1;

            }
        }
        return ans;
    }
    static boolean ispossible(int arr[],int value,int ncowes){
        int pre=arr[0],c=1;
        for(int i=1;i<arr.length;i++){
        if(arr[i]-pre>=value){
        pre=arr[i];
        c++;
        if(c==ncowes){
        return true;
        }
        }
        }
        return false;

    }
}
