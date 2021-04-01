


import java.util.*;



class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nofsol = sc.nextInt();
        int arr[] = new int[nofsol];
        for(int i=0; i<nofsol;i++){
            arr[i]= sc.nextInt();
        }
        int nofrnd= sc.nextInt();
        int power[] = new int[nofrnd];
        for(int i=0; i<nofrnd;i++){
            power[i]= sc.nextInt();
        }
       /* System.out.print(nofsol);
        for(int i=0; i<nofsol;i++){
            System.out.println (arr[i]);
        }
        for(int i=0; i<nofrnd;i++){
            System.out.println (power[i]);
        }
        System.out.print(nofrnd);*/

         for(int i=0; i<nofrnd;i++){
             int s=0;
             int e=nofsol-1;
             int mid=0;
             int ans=0;
             int total=0;
             while(s<=e){
                mid=(s+e)/2;
                if(arr[mid]>power[i]){
                    e=mid-1;
                }
                else if(arr[mid]<power[i]){
                    s=mid+1;
                }
                else{
                    ans=mid+1;
                    //System.out.println(ans);
                    break;
                }
    
            }
                 System.out.print(nofsol-ans);
                 for(int j=ans; j<nofsol; j++){
                     total+=arr[j];}
                 
             System.out.println(total);
             //System.out.println(ans);
             }
         
            }
    }

