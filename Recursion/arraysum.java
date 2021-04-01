import java.util.Scanner;
public class arraysum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
    int no=sc.nextInt();
    int arr[]= new int[no];
    for(int i=0;i<no;i++){
        arr[i]=sc.nextInt();

    }
    System.out.println(sum(arr,no));
    }
    static int sum(int arr[], int no){
        if(no==0)
        return 0;
        else
        return arr[no-1]+sum(arr, no-1);
    }

}
