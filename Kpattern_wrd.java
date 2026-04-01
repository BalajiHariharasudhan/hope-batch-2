/*public class Kpattern_wrd {
    public static void main(String[] args) {
        String s = "Hello";
        int n = s.length();
        for(int i=0;i<n;i++){
            System.out.print(s.charAt(i));
            int spaces;
            if(i<=n/2){
                spaces = 2*(n-i-1)-1;
            }
            else{
                spaces = 2*n-1;
            }
            for (int j=0;j<spaces;j++){
                System.out.print(" ");
            }
            System.out.println(s.charAt(n-i-1));
            //System.out.println();     
        }
    }
}*/
public class Kpattern_wrd {
    public static void main(String[] args) {
        String s = "Hello";
        int n = s.length();

        for(int i = 0; i < n; i++) {

            // LEFT
            System.out.print(s.charAt(i));

            // SPACES
            int spaces;
            if(i <= n/2){
                spaces = 2*(n-i-1)-1;   // top → decreasing
            }
            else{
                spaces = 2*(n-i-1)+1;   // bottom → increasing (fixed)
            }

            for (int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            // RIGHT
            System.out.println(s.charAt(n-i-1));
        }
    }
}
