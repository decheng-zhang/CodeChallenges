public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> L = new ArrayList<>();
        List<Integer> temp;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++)
        {
            if (i > 0 && nums[i]==nums[i-1])
                continue;
            int target = -nums[i];
            int lo = i+1;
            int hi = nums.length-1;
            
            int middle=Integer.MIN_VALUE,last=Integer.MIN_VALUE;
            while (lo<hi)
            {
                if (nums[lo]+nums[hi]==target)
                    {
                        if (nums[lo]==middle && nums[hi]==last)
                            {
                                lo++;hi--;
                                continue;
                            }
                        temp = new ArrayList<>();
                        middle = nums[lo]; last = nums[hi];
                        temp.add(-target);temp.add(middle);temp.add(last);
                        L.add(temp);
                        lo++;hi--;
                    }
                else if (nums[lo]+nums[hi]>target)
                    hi--;
                else
                    lo++;
            }
        }
        
        return L;
    }
}
