/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
public class Solution {
    
    LinkedList<Integer> sums = new LinkedList<>();
    
    public void dfs(TreeNode N, String num)
    {
        if (N.left==null && N.right==null)
            sums.add(Integer.parseInt(num+N.val));
        if (N.left!=null)
            dfs(N.left,num+N.val);
        if (N.right!=null)
            dfs(N.right,num+N.val);
    }
    public int sumNumbers(TreeNode root) {
        int net_sum = 0;
        if (root == null)
            return net_sum;
        dfs(root,"");
        for (int nums:sums)
            net_sum+=nums;
        return net_sum;
        
    }
}
