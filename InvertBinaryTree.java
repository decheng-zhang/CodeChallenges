public class Solution {
    
    public void invert(TreeNode node)
    {
        if (node.left == null && node.right == null)
            return;
        else
        {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null)
                invert(node.left);
            if (node.right!=null)
                invert(node.right);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null)
            return root;
        else
        {
            invert(root);
            return root;
        }
        
    }
}
