import java.util.ArrayList;
public class Solution {
    
    public void calculate(List<List<Integer>> subsets, List<Integer> temp, int[] nums, int start)
    {
        subsets.add(new ArrayList(temp));
        for (int i = start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            calculate(subsets,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        calculate(subsets,temp,nums,0);
        return subsets;
        
    }
}
