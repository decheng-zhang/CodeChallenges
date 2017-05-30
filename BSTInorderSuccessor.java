/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.ArrayList;
public class Solution {
    List<TreeNode> rightmove;
    List<TreeNode> leftmove;
    boolean leftchild;

    public TreeNode LeftMostSuccessor(TreeNode node)
    {
        if (node.left==null)
            return node;
        else
            return LeftMostSuccessor(node.left);
    }
    
    public boolean find(TreeNode start, TreeNode target)
    {
        if (start.val == target.val)
            return true;
        else if (start == null)
            return false;
        else
        {
            if (target.val < start.val)
            {
                leftchild=true;
                leftmove.add(start);
                return find(start.left,target);
            }
            else
            {
                leftchild=false;
                rightmove.add(start);
                return find(start.right,target);
            }
        }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        rightmove = new ArrayList<TreeNode>();
        leftmove = new ArrayList<TreeNode>();
        find(root,p);
        if (p.right!=null)
            return LeftMostSuccessor(p.right);
        else if (leftchild)
            return leftmove.get(leftmove.size()-1);
        else
        {
            if (leftmove.isEmpty())
                return null;
            else
                return leftmove.get(leftmove.size()-1);
        }
            
        
        
    }
}
