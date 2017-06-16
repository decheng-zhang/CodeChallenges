/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<List<Integer>> sol;
    int target_sum;
    public void dfs(List<Integer> list, int running_sum, TreeNode N)
    {
        if (N==null)
            return;
        if (N.left == null && N.right == null)
            {
                if (running_sum + N.val == target_sum)
                {
                    list.add(N.val);
                    sol.add(new LinkedList<>(list));
                    list.remove(list.size()-1);
                }
            }
        else
        {
            list.add(N.val);
            dfs(list,running_sum+N.val,N.left);
            dfs(list,running_sum+N.val,N.right);
            list.remove(list.size()-1);
        }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sol = new LinkedList<>();
        target_sum = sum;
        dfs(new LinkedList<Integer>(),0,root);
        return sol;
    }
}
