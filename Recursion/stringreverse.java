import java.util.Scanner;
public class stringreverse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String p=sc.nextLine();
        reverse(p);
    }
    static void reverse (String q){
        if(q.length()==0)
        return;
        else
        System.out.println(q.charAt(q.length()-1));
        reverse(q.substring(0, q.length()-1));
    }
}
