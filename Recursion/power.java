import java.util.Scanner;
public class power {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(pow(n,p));
    }
    static int pow(int n,int p){
       if (p==0)
       return 1;
       else
       return n*pow(n, p-1);
    }
}
