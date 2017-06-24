public class Solution {
    
    int[]data;
    public int recurse(int lo, int hi)
    {
        if (lo == hi)
            return lo;
        else
        {
            int mid1 = (lo+hi)/2;
            int mid2 = mid1+1;
            
            if (data[mid1]>data[mid2])
                return recurse(lo,mid1);
            else
                return recurse(mid2,hi);
        }
    }
    public int findPeakElement(int[] nums) {
        data = nums;
        return recurse(0,nums.length-1);
    }
}
