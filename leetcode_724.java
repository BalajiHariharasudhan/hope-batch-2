class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum=0,l_sum=0,r_sum=0;
        
        for(int j=0;j<nums.length;j++)
            {
                total_sum+=nums[j];
            }
       for(int i=0;i<nums.length;i++)
       {
            if(l_sum == total_sum - l_sum - nums[i])
            {
                return i;
            }
            l_sum+=nums[i];            
       }
       return -1;

    }
}
