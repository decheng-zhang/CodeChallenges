import java.util.Arrays;
import java.lang.Math;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int des_sum = 0;
        int delta = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++)
        {
            int j = i+1;
            int k = nums.length-1;
            while (j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if (Math.abs(sum-target)<delta)
                {
                    delta = Math.abs(target-sum);
                    des_sum = sum;
                }
                if (sum == target)
                {
                    break;
                }
                else if (sum < target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        
        return des_sum;
        
    }
}
