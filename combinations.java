import java.util.ArrayList;
public class Solution {
    
    int [] nums;
    int dim;
     public void backtrack(List<List<Integer>> combinations, List<Integer>candidate, int start)
        {
            if (candidate.size()==dim)
                combinations.add(new ArrayList(candidate));
            else
            {
                for (int i=start;i<nums.length;i++)
                {
                    candidate.add(nums[i]);
                    backtrack(combinations,candidate,i+1);
                    candidate.remove(candidate.size()-1);
                }
            }
        }
        
    public List<List<Integer>> combine(int n, int k) {
        
        nums = new int[n];
        dim = k;
        for (int i=0;i<n;i++)
            nums[i]=i+1;
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> candidate = new ArrayList<Integer> ();
        
        backtrack(combinations,candidate,0);
        
        return combinations;
       
        
    }
}
