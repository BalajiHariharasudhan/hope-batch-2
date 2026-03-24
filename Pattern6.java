import java.util.*;
public class Pattern6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            int spaces=4*(n-i)-2;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                if(i==n && j==i) continue;
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
