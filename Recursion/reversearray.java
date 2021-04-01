import java.util.Scanner;
public class reversearray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
    int no=sc.nextInt();
    int arr[]= new int[no];
    for(int i=0;i<no;i++){
        arr[i]=sc.nextInt();

    }
    System.out.println(reverseArray(arr,0,no-1));
    }
}
public static int[] reverseArray(int[] a,int i,int j){
    //Tail Recursion.
    if(i<j){
        //swap elements a[i],a[j]
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        reverseArray(a, i+1, j-1);
    }
    return a;
}
