/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.Queue;
public class Solution {
    LinkedList<Integer>result = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root==null)
            return result;
        Queue<TreeNode> QN = new LinkedList<>();
        Queue<Integer> QL = new LinkedList<>();
        int current=0;
        int max = root.val;
        QN.add(root);
        QL.add(current);
        while (!QN.isEmpty())
        {
            TreeNode cand = QN.poll();
            int level = QL.poll();
            if (level==current)
            {
                if (max<cand.val)
                    max=cand.val;
            }
            else
            {
                result.add(max);
                current=level;
                max = cand.val;
            }
            if (cand.left!=null)
            {
                QN.add(cand.left);
                QL.add(level+1);
            }
            if (cand.right!=null)
            {
                QN.add(cand.right);
                QL.add(level+1);
            }
        }
        result.add(max);
        return result;
    }
}
