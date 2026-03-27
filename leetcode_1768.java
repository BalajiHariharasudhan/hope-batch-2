class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int n1=word1.length();
        int n2=word2.length();
        char[] result=new char[n1+n2];
        int index=0,i=0,j=0;
        while(i<n1||j<n2)
        {
            if(i<n1)
            {
                result[index++]=w1[i++];
            }
            if(j<n2)
            {
                result[index++]=w2[j++];
            }
        }            
       return new String(result);

    }
}
