import java.util.*;
public class Codechef {
    public static void main(String args[]) {
        int N=4000005;
    int solu[]=new int[N];
    int sol[]=new int[N];
    for(int i=0;i<N;i++){
        solu[i]=i;
        sol[i]=0;
    }
    for(int p=2;p<N;p++){
        if(solu[p]==p){
            solu[p]=p-1;
            for(int i=2*p;i<N;i+=p)
                solu[i]=(solu[i]/p)*(p-1);
        }
    }
    for(int i=1;i<N;i++){
        sol[i]+=i-1;
        for(int j=2*i;j<N;j+=i){
            sol[j]+=i*((1+solu[j/i])/2);
        }
    }
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    
    while(t>0){
        int k=sc.nextInt();
        System.out.println(sol[4*k+1]);
        t=t-1;
    }
    }
}
