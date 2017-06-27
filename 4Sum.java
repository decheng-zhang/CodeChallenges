import java.util.ArrayList;
import java.util.Hashtable;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        Hashtable<String,Boolean> H = new Hashtable<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++)
        {
            for(int j = i+1;j<nums.length-2;j++)
            {
                String str_first_second = ""+nums[i]+nums[j];
                if (H.containsKey(str_first_second))
                    continue;
                H.put(str_first_second,true);
                int partial_sum = nums[i]+nums[j];
                int to_find = target - partial_sum;
                int lo = j+1;
                int hi = nums.length-1;
                int third = Integer.MIN_VALUE;
                int fourth = Integer.MIN_VALUE;
                while (lo<hi)
                {
                    if (nums[lo]+nums[hi]==to_find)
                    {
                        if (nums[lo]==third && nums[hi]==fourth)
                            {
                                lo++;hi--;
                                continue;
                            }
                        third = nums[lo];
                        fourth = nums[hi];
                        ArrayList<Integer> cand = new ArrayList<>();
                        cand.add(nums[i]);cand.add(nums[j]);cand.add(third);cand.add(fourth);
                        sol.add(cand);
                        lo++;
                        hi--;
                    }
                    else if (nums[lo]+nums[hi]>to_find)
                        hi--;
                    else
                        lo++;
                }
            }
        }
        
        return sol;
    }
}
