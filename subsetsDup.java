import java.util.Hashtable;
import java.util.ArrayList;
public class Solution {
    
    Hashtable<String,Boolean> H = new Hashtable<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    
    public void backtrack(List<List<Integer>> result, List<Integer>temp,int start,int[] nums)
    {
        String S;
        StringBuilder seq = new StringBuilder();
        for (int i=0;i<temp.size();i++)
            seq.append(temp.get(i)+" ");
        S = seq.toString();
        if (!H.containsKey(S))
            {
                result.add(new ArrayList<>(temp));
                H.put(S,true);
            }
        if (start>=nums.length)
            return;
        for (int i=start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(result,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(result,temp,0,nums);
        return result;
        
    }
}
