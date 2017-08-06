// linear space 
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
        if (nums.length==0)
            return false;
        int[]sums = new int[nums.length];
        // r::start c::end
        for (int r=0;r<nums.length;r++)
        {
            for (int c=r;c<nums.length;c++)
            {
                if (c==r)
                {
                    sums[c]=nums[c];
                }
                else
                {
                    sums[c]=nums[c]+sums[c-1];
                    if (k!=0 && sums[c]%k==0)
                        return true;
                    else if (k==0 && sums[c]==0)
                        return true;
                }
                
            }
        }
        return false;  
    }
}

// o(n2) space
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
        if (nums.length==0)
            return false;
        int[][]sums = new int[nums.length][nums.length];
        for (int r=0;r<nums.length;r++)
        {
            for (int c=r;c<nums.length;c++)
            {
                if (c==r)
                {
                    sums[c][r]=nums[c];
                }
                else
                {
                    sums[c][r]=nums[c]+sums[c-1][r];
                    if (k!=0 && sums[c][r]%k==0)
                        return true;
                    else if (k==0 && sums[c][r]==0)
                        return true;
                }
                
            }
        }
        return false;
        
    }
}
