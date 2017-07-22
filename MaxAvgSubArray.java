public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length<k)
            return 0.0;
        double init_sum = 0.0;
        for (int i=0;i<k;i++)
            init_sum+=nums[i];
        double init_avg = init_sum/k;
        double bsf = init_avg;
        for (int i=k;i<nums.length;i++)
        {
            
            init_sum  =  init_sum - nums[i-k] + nums[i];
            bsf = (init_sum/k)>bsf?(init_sum/k):bsf;
            
        }
        
        return bsf;
    }
}
