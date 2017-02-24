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
    
    private int counter (TreeNode n)
    {
        if (n == null)
            return 0;
        else
        {
            return 1+counter(n.left)+counter(n.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        
        int rank = 1+counter(root.left);
        if (rank == k)
            return root.val;
        else if (k > rank)
        {
            k = k - rank;
            return kthSmallest(root.right,k);
        }
        else
        {
            return kthSmallest(root.left,k);
        }
        
    }
}
