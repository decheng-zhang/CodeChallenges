public class Solution {
    public void nextPermutation(int[] nums) {
        
        int break_point=0;
        for (int i=nums.length-1;i>=1;i--)
            {
                if (nums[i-1]<nums[i])
                    {
                        break_point = i; 
                        break;
                    }
            }
        if (break_point==0)
            Arrays.sort(nums);
        else
        {
            int target = nums[break_point-1];
            //Rightward from breakpoint the array is sorted in descending order
            //so we are essentially trying to find the smallest number larger than 
            //target.
            int IndexSmallestLargerThanTarget = break_point;
            for (int i = break_point;i<nums.length;i++)
                {
                    if (nums[i]>target)
                        IndexSmallestLargerThanTarget=i;
                }
            int temp = nums[IndexSmallestLargerThanTarget];
            nums[IndexSmallestLargerThanTarget] = nums[break_point-1];
            nums[break_point-1]=temp;
            Arrays.sort(nums,break_point,nums.length);
        }
        
    }
}
