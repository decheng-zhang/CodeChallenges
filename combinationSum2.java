import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    
   List<List<Integer>> solution_set = new ArrayList<>();
    int[]candidates;
    int target;
    void backtracking(int sum, int start, ArrayList<Integer>running)
    {
        sum = sum+candidates[start];
        if (sum>target)
            return;
        else if (sum == target)
        {
            running.add(candidates[start]);
            solution_set.add(new ArrayList<Integer>(running));
            running.remove(running.size()-1);
        }
        else
        {
            running.add(candidates[start]);
            for (int i=start+1;i<candidates.length;i++)
            {
                if (i!=start+1 && candidates[i]==candidates[i-1])
                    continue;
                backtracking(sum,i,running);
            }
            running.remove(running.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> running  = new ArrayList<>();   
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        this.target = target;
        for (int i=0;i<this.candidates.length;i++)
        {
            if (i!=0 && this.candidates[i]==this.candidates[i-1])
                continue;
            backtracking(0,i,running);
        }
        return solution_set;
    }
}
