public class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if (nums.length==0)
            return 0;
        int []cache = new int[nums.length];
        cache[0]=1;
        int result = 1;
        for (int i=1;i<nums.length;i++)
        {
           int j = i-1;
           int max = 0;
           while (j>=0)
           {
               if (nums[i]>nums[j])
               {
                   max = max>cache[j]?max:cache[j];
               }
               j--;
           }
           cache[i]= 1+max;
           result = result>cache[i]?result:cache[i];
        }
        
        return result;
        
    }
}
