public class nonrepeat_first {
    public static void main(String[] args) {
        String s = "ABCBADabcbad";
        int[] count = new int[26]; // it is an array to store thr count of each char in the str and it is initialized to 0
        // then if a letter is found the count incresed
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // coverts chae to index 
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) { //first non repeating char will have count 1
                System.out.println(s.charAt(i)); 
                break; // Exit the loop 
            }
        }
    }
}
