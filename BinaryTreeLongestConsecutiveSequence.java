/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.Collections;
public class Solution {
    private class MAX
    {
        int val=1;
    }
    MAX max = new MAX();
    List<Integer>cas = new ArrayList<Integer>();
    public void utility(TreeNode node,int par_val,int current)
    {
       if (node.left == null && node.right == null)
            {
                if (node.val == par_val+1)
                    current = current+1;
                max.val = Math.max(max.val,current);
                cas.add(max.val);
            }
        else
        {
            if (node.val == par_val+1)
                    current = current+1;
            else
                current = 1;
            max.val = Math.max(max.val,current);
            if (node.left!=null)
                utility(node.left,node.val,current);
            if (node.right!=null)
                utility(node.right,node.val,current);
        }
    }
    
    public int longestConsecutive(TreeNode root) {
        
        if (root == null)
            return 0;
        if (root.left == null && root.right==null)
            return 1;
        if (root.left!=null)
            utility(root.left,root.val,1);
        if (root.right!=null)
            utility(root.right,root.val,1);
        return Collections.max(cas);
        
    }
}
