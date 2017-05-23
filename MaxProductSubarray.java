public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length==0)
            return 0;
        int max_ending_here= nums[0];
        int min_ending_here=nums[0];
        int max_so_far = nums[0];
        int max,min;
        for (int i=1;i<nums.length;i++)
        {
            if (nums[i]>=0)
                {
                    max = nums[i]*Math.max(max_ending_here,min_ending_here);
                    min = nums[i]*Math.min(max_ending_here,min_ending_here);
                }
            else
                {
                    max = nums[i]*Math.min(max_ending_here,min_ending_here);
                    min = nums[i]*Math.max(max_ending_here,min_ending_here);
                }
            min_ending_here = Math.min(min,nums[i]);
            max_ending_here = Math.max(max,nums[i]);
            
            max_so_far = Math.max(max_ending_here,max_so_far);
        }
        return max_so_far;
        
    }
}
