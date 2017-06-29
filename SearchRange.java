public class Solution {
    
    int[]bank;
    public int finder(int target, int lo, int hi)
    {
        if (lo > hi)
            return -1;
        else {
            int mid = (lo+hi)/2;
            if (bank[mid]==target)
                return mid;
            else if (bank[mid]>target)
                return finder(target,lo,hi-1);
            else
                return finder(target,lo+1,hi);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        
        bank = nums;
        int left_loc = finder(target,0,nums.length-1);
        
        if (left_loc == -1)
            return (new int[]{-1,-1});
        int right_loc = left_loc;
        while (left_loc-1>=0 && nums[left_loc-1]==target)
        {
            left_loc = finder(target,0,left_loc-1);
        }
        
        while (right_loc+1< nums.length && nums[right_loc+1]==target)
        {
            right_loc = finder(target,right_loc+1, nums.length-1);
        }
        
        return (new int[]{left_loc,right_loc});
        
    }
}
