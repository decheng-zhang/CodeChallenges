import java.util.ArrayList;
public class Solution {
    
    
    public void calculate(List<List<Integer>> permutations, List<Integer> temp,int [] nums)
    {
        if (temp.size()==nums.length)
            permutations.add(new ArrayList(temp));
        for (int i=0;i<nums.length;i++)
        {
            if (temp.contains(nums[i]))
                continue;
            else
            {
                temp.add(nums[i]);
                calculate(permutations,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        calculate(permutations,temp,nums);
        return permutations;
        
    }
}
