/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;
class Solution {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    boolean flag = false;
    int total;
    int getSum(TreeNode n)
    {
        if (n == null)
            return 0;
        else
        {
            int left = getSum(n.left);
            int right = getSum(n.right);
            map.put(n,n.val+left+right);
            return n.val+left+right;
        }
    }
    public void checker(TreeNode n, int inherited)
    {
        if (n.left == null && n.right == null)
            return;
        else
        {
            if (n.left != null)
            {
                checker(n.left,map.get(n));
                if (total-map.get(n.left)==map.get(n.left))
                    flag = true;
            }
            if (n.right != null)
            {
                checker(n.right,map.get(n));
                if (total-map.get(n.right)==map.get(n.right))
                    flag = true;
            }
            return;
        }
    }
    public boolean checkEqualTree(TreeNode root) {
        if (root == null)
            return flag;
        total = getSum(root);
        checker(root,0);
        return flag;
    }
}
