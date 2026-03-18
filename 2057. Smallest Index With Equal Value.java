class Solution {
    public int smallestEqual(int[] nums) {
        int min=Integer.MAX_VALUE;
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(i%10==nums[i]){
                min=Math.min(i,min);
                flag=1;
            }
        }
        if(flag==0) return -1;
        else return min;
    }
}
