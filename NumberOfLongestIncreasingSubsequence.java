import java.util.Arrays;
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length==0)
            return 0;
        int[] MLS = new int[nums.length]; //longest sequence ending here
        int[] ways = new int[nums.length]; //ways to get here 
        int max =1;
        Arrays.fill(MLS,1);
        Arrays.fill(ways,1);
        int WTLS=1; //ways to longest seq.
        for (int i=1;i<nums.length;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if (nums[i]>nums[j])
                {
                    if (1+MLS[j]>MLS[i])
                    {
                        ways[i]=ways[j];
                        MLS[i]=1+MLS[j];
                    }
                    else if (MLS[j]==MLS[i]-1)
                        ways[i]+=ways[j];
                }
            }
            if (MLS[i]>max)
            {
                max = MLS[i];
                WTLS = ways[i];
            }
            else if (MLS[i]==max)
            {
                WTLS += ways[i];
            }
        }
        
        if (max==1)
            return nums.length;
        
       return WTLS;
    }
}
