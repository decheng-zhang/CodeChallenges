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
import java.util.LinkedList;
public class Solution {
    Queue<Node> Q = new LinkedList<>();
    LinkedList<Integer> result  = new LinkedList<>();
    private class Node
    {
        TreeNode tn;
        int l;
        public Node(TreeNode TN, int level)
        {
            tn = TN;
            l = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        int curr_lev = 0;
        if (root == null)
            return result;
        Q.offer(new Node(root,1));
        Node RN;
        while (!Q.isEmpty())
        {
            Node N = Q.poll();
            if (N.l>curr_lev)
            {
                result.add(N.tn.val);
                curr_lev = N.l;
            }
            if (N.tn.right!=null)
                Q.offer(new Node(N.tn.right,N.l+1));
            if (N.tn.left!=null)
                Q.offer(new Node(N.tn.left,N.l+1));
        }
        return result;
    }
}
