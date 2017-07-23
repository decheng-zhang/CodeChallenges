/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;
public class Solution {
    Stack<TreeNode> S1 = new Stack<>();
    Stack<TreeNode> S2 = new Stack<>();
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> l1 = null;
    LinkedList<Integer> l2 = null;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null)
            return result;
        S1.push(root);
        Boolean s1 = true; 
        while (!S1.isEmpty() || !S2.isEmpty())
        {
            if (!S1.isEmpty())
                l1 = new LinkedList<>();
            while (!S1.isEmpty())
            {
                TreeNode temp = S1.pop();
                if (temp.left!=null)
                    S2.push(temp.left);
                if (temp.right!=null)
                    S2.push(temp.right);
                l1.add(temp.val);
            }
            if (l1!=null)
            {
                result.add(l1);
                l1 = null;
            }
            if (!S2.isEmpty())
                l2 = new LinkedList<>();
            while (!S2.isEmpty())
            {
                TreeNode temp = S2.pop();
                if (temp.right!=null)
                    S1.push(temp.right);
                if (temp.left!=null)
                    S1.push(temp.left);                
                l2.add(temp.val);
            }
             if (l2!=null)
            {
                result.add(l2);
                l2 = null;
            }
        }
        return result;
    }
}
