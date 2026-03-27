import java.util.Scanner;

public class wordscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (i == 0|| str.charAt(i - 1) == ' ') {
                    count++;
                }
            }
        }
        System.out.println("Number of words in the string is: " + count);
    }

}
