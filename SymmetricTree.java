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
import java.util.Stack;
public class Solution {
    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();

    public void dfs1(TreeNode tn)//lr
    {
        if (tn == null)
        {
            l1.add(-1);
            return;
        }
        l1.add(tn.val);
        dfs1(tn.left);
        dfs1(tn.right);      
    }
    
    public void dfs2(TreeNode tn)//rl
    {
         if (tn == null)
         {
             l2.add(-1);
             return;
         }
        l2.add(tn.val);
        dfs2(tn.right);
        dfs2(tn.left);     
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        dfs1(root.left);
        dfs2(root.right);
        
        if (l1.size()!=l2.size())
            return false;
        for (int i=0;i<l1.size();i++)
        {
            if (l1.get(i)!=l2.get(i))
                return false;
        }
        return true;
    }
}
