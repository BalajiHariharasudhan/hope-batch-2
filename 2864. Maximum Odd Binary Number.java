class Solution {
    public String maximumOddBinaryNumber(String s) {
        String str="";
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                str=str+ch;
            }
        }
        int len=s.length()-str.length();
        for(int i=0;i<len;i++){
            str=str+'0';
        }
        char ch=str.charAt(0);
        String res=str.substring(1);
        return res+ch;
    }
}
