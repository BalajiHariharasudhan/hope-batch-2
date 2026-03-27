class Solution {
    public boolean canAliceWin(int[] nums) {
        int A_single_sum=0,A_double_sum=0;
        int B_single_sum=0,B_double_sum=0; 

        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]<10)
            {
                A_single_sum= A_single_sum+nums[i];
                B_single_sum= B_single_sum+nums[i];
            }
            else
            {
                A_double_sum=A_double_sum+nums[i];
                B_double_sum=B_double_sum+nums[i];
            }
        }
        if(A_single_sum> B_double_sum || A_double_sum>B_single_sum)
        {
            return true;
        }
       return false;

        
    }
}
