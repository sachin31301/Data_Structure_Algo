import java.util.*;
import java.lang.*;

class ekospoj
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int nta= sc.nextInt();
		long M= sc.nextLong();
		long arr[]= new long[nt];
		for(int i=0;i<nt;i++){
			arr[i]= sc.nextLong();
		
		}
	
		System.out.println(output(arr,M));
	}
	static long output(long arr[],long amt){
		long s=0;
		long e=0;
		long mid=0;
		long ans=0;
		for(int j=0;j<arr.length;j++){
			e=Math.max(e,arr[j]);
        }
       // System.out.prlongln(e);
		while(s<=e){
			mid=(s+e)/2;
			if(ispossible(arr,mid,amt)){
                ans=mid;
                //System.out.prlongln(ans);
				s=mid+1;
			}
			else{
				e=mid-1;
			}
		}
		return ans;
	}
	static boolean ispossible(long array[],long value,long amount){
		long sum=0;
		for(int i=0;i<array.length;i++){
			if((array[i]-value)<0){
				sum=sum;
			}
			else{
				sum=sum+(array[i]-value);
			}
		}
		if(sum>=amount)
		return true;
		else
		return false;
	}
}
