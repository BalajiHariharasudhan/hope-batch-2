class Solution {
    public int lastRemaining(int n) {
        int count=0;
        int steps=1;
        int start=1;
        while(n!=1){
            if(count%2==0){
                start=start+steps;
            }            
            else if(count%2==1 && n%2==1){
                start=start+steps;
            }
            steps=2*steps;
            count+=1;
            n=n/2;
        }
        return start;
    }
}
