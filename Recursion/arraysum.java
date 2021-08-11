import java.util.Scanner;
public class arraysum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
    int no=sc.nextInt();
    int solu[]= new int[no];
    for(int i=0;i<no;i++){
        solu[i]=sc.nextInt();

    }
    System.out.println(sum(solu,no));
    }
    static int sum(int solu[], int no){
        if(no==0)
        return 0;
        else
        return solu[no-1]+sum(solu, no-1);
    }

}
