import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    
    
    public void calculate(List<List<Integer>> combinations, List<Integer> temp,int[] candidates,int start, int remaining)
    {
        if (remaining==0)
            combinations.add(new ArrayList(temp));
        else if (remaining < 0)
            return;
        else
        {
            for (int i=start;i<candidates.length;i++)
            {
                temp.add(candidates[i]);
                calculate(combinations,temp,candidates,i,remaining-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        calculate(combinations,temp,candidates,0,target);
        return combinations;
        
    }
}
