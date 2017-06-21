public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> memo = new ArrayList<>(triangle.get(triangle.size()-1));
        for (int i=triangle.size()-2;i>=0;i--)
        {
            ArrayList<Integer> temp = new ArrayList<>(triangle.get(i));
            for (int j =0;j<temp.size();j++)
                {
                    temp.set(j,temp.get(j)+Math.min(memo.get(j),memo.get(j+1)));
                }
            memo = temp;
        }
        return memo.get(0);
    }
}
