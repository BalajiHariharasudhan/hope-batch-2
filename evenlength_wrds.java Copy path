import java.util.Scanner;

public class evenlength_wrds {
    public static void main(String[] args){
        try(Scanner ip = new Scanner(System.in)){
            String S = ip.nextLine();
            int count=0;
            StringBuilder s1 = new StringBuilder(); // StringBuilder to store the current word
            for(int i=0;i<S.length();i++){
                if(S.charAt(i)!=' '){
                    count++;
                    s1.append(S.charAt(i)); // append tthe character to the current word
                }
                else{
                    if(count>0 && count%2==0){ // check if the word has even length
                        System.out.print(s1.toString()+" "); // print the word followed by a space
                    }
                    count=0;
                    s1.setLength(0);
                }
            }
            if(count%2==0){// check for the last word if it has even length
                System.out.print(s1.toString());
            }   
        }
    }
}
