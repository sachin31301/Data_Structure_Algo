import java.util.*;

//import jdk.tools.jmod.resources.jmod_zh_CN;
public class zonekanp {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int arr[]={4,2,1,3};
        String s="sasmamnansc";
        System.out.println(recmcm(arr, 0, 3));
        System.out.println(dpmcm(arr));
        System.out.println(palinpart(s));
    }


public static int zoknap(int w[],int v[],int n,int W,int dp[][]) {
    if(n==0||W==0){
        return 0;
    }
    if(dp[n]!=-1){
        return dp[n];
    }
    if(w[n-1]>W){
        return dp[n]=zoknap(w, v, n-1, W, dp);
    }
    else{
        return dp[n]=Math.max(zoknap(w, v, n-1, W, dp), zoknap(w, v, n-1, W-w[n-1], dp)+val[n-1]);
    }
}
public static int bzoknap(int w[],int v[],int n,int W) {
    int dp[][]= new int[n+1][W+1];
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            if(i==0&&j==0){
                dp[i][j]=0;
            }
            if(w[i-1]<=j){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
    }
}


public static boolean subsetsum(int arr[],int s) {
    int n=arr.length;
    boolean dp[][]= new boolean[n+1][sum+1];
    for(int e=0;e<=n;e++){
        for(s=0;s<=sum;s++){
            if(s==0)
            dp[e][s]=true;
            else if(e==0){
                dp[e][s]=false;
            }
            else{
                if(arr[e-1]>sum){
                    dp[e][s]=dp[e-1][s];
                }
                else{
                    dp[e][s]=dp[e-1][s-arr[e-1]]||dp[e-1][s];
                }
            }

        }
    }
}


public static boolean eqpart(int arr[]) {
    int s= sum(arr)/2;
    if(subsetsum(arr, s)==true){
        return true;
    }
    else{
        return false;
    }
}


public static int countofsubsets(int arr[],int sum) {
    int n=arr.length;
     int dp[][]= new int[n+1][sum+1];
     for(int e=0;e<=n;e++){
         for(int s=0;s<=sum;s++){
             if(s==0)
             dp[e][s]=1;
             else if(e==0)
             dp[e][s]=0;
             else{
                 if(arr[e-1]>s){
                     dp[e][s]=dp[e-1][s];

                 }
                 else{
                     dp[e][s]=dp[e-1][s]+dp[e-1][s-arr[n-1]];
                 }
             }

         }
     }

}

public static int minsubsetdifference(int arr[]) {
    int n=arr.length;
    int range= sum(arr);
    int dp[][]= new int[n+1][range/2+1];
    for(int e=0;e<=n;e++){
        for(int s=0;s<=range/2;s++){
            if(s==0||n==0){
                return 0;
            }
            if(arr[n-1]>s){
                dp[e][s]=dp[e-1][s];

            }
            else{
                dp[e][s]=Math.max(dp[e-1][s], dp[e-1][j-arr[e-1]]) ;
            }
        }
    }
    
}

public static int recmcm(int arr[],int i,int j) {
    if(j-i<2){
        return 0;
    }
    int min=Integer.MAX_VALUE;
    for(int k=i+1;k<j;k++){
        int temp=recmcm(arr, i, k)+recmcm(arr, k+1, j)+arr[i]*arr[k]*arr[j];
        min =Math.min(temp, min);
    }
    return min;
}
public static int dpmcm(int arr[]) {
    int n=arr.length;
    int dp[][]= new int[n][n];

    for(int ar[]:dp){
        Arrays.fill(ar, Integer.MAX_VALUE);
    }
    for(int i=0;i<n;i++){
        dp[i][i]=0;
    }

    for(int l=2;l<=n;l++){
    for (int i = 0; i+l-1 < dp.length; i++) {
        
            int j=i+l-1;
            if(l==2)
            dp[i][j]=0;
            else{
            for(int k=i+1;k<j;k++){
                dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+arr[i]*arr[k]*arr[j]);
            }
        }
        }
    }
    return dp[0][n-1];
}


public static int palinpart(String s) {
    int n=s.length();
    int dp[][]= new int[n][n];
    for(int ar[]:dp){
        Arrays.fill(ar, Integer.MAX_VALUE);
    }
    for(int i=0;i<n;i++){
        dp[i][i]=0;
    }
    for(int l=2;l<=n;l++){
        for (int i = 0; i+l-1 < dp.length; i++) {
            int j=i+l-1;
            if(ispalind(s.substring(i, j+1))){
                dp[i][j]=0;
            }
            else{
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+1);
                }
            }

        }
    }
    return dp[0][n-1];

}

public static boolean ispalind(String s) {
    int i=0;
    int j=s.length()-1;
    while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
}