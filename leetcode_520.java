class Solution {
    public boolean detectCapitalUse(String word) {
       int uppercount=0;
       for(int i=0;i<word.length();i++)
       {
        if(Character.isUpperCase(word.charAt(i))) uppercount++;
       }
       if(uppercount==word.length()) return true;
       else if(uppercount==0) return true;
       else if(uppercount==1 && Character.isUpperCase(word.charAt(0))) return true;
        return false;
        
    }
}
