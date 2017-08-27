import java.lang.Math;
class Solution {
    //max_sum[i] = Max(max_sum[i-1]+nums[i],nums[i])
    int max_so_far = 0;
    int []max_sum;
    public int maxSubArray(int[] nums) {
        if (nums.length ==0 )
            return 0;
        max_sum = new int[nums.length];
        max_sum[0]=nums[0];
        max_so_far = nums[0];
        for (int i=1;i<nums.length;i++)
        {
            max_sum[i] = Math.max(max_sum[i-1]+nums[i], nums[i]);
            max_so_far = Math.max(max_so_far,max_sum[i]);
        }
        return max_so_far;
    }
}
