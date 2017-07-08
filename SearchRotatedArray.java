public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (target > nums[nums.length-1] && target < nums[0] )
            return -1;
        if (nums.length == 1)
        {
            if (nums[0]==target)
                return 0;
            else
                return -1;
        }
        int loc = -1;
        if (nums[nums.length-1]>nums[0])
        {
            loc = Arrays.binarySearch(nums,0,nums.length,target);
            if (loc>=0) return loc;
            return -1;
        } 
        int lo = 0;
        int hi = nums.length-1;
        
        while (lo<hi)
        {
            int mid = (lo+hi)/2;
            if (nums[mid]<nums[0])
            {
                hi = mid;
            }
            else
                lo = mid+1;
        }
                
        if (target > nums[nums.length-1])
            loc =  Arrays.binarySearch(nums,0,lo,target);
        else
            loc =  Arrays.binarySearch(nums,lo,nums.length,target);
        
        loc = loc>=0?loc:-1;
        
        return loc;
    }
}
