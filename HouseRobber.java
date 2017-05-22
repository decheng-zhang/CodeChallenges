public class Solution {
    public int rob(int[] nums) {
        if (nums.length==0)
            return 0;
        int[] moolah = new int[nums.length];
        moolah[0] = nums[0];
        for(int i=1;i<moolah.length;i++)
        {
            int cas1=0;int cas2=0;
            if (i-2>=0)
                cas1 = moolah[i-2];
            if (i-1>=0)
                cas2= moolah[i-1];
            moolah[i]=Math.max(nums[i]+cas1,cas2);
        }
        
        return moolah[nums.length-1];
        
    }
}
