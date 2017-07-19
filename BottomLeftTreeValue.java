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
    
    private class Node {
        TreeNode TN;
        int level;
        public Node(TreeNode tn, int L)
        {
            TN = tn;
            level = L;
        }
    }
    Queue<Node> Q = new LinkedList<>();
    public int findBottomLeftValue(TreeNode root) {
        int curr_level = 0;
        Q.offer(new Node(root,1));
        Node BLN=null;
        while (!Q.isEmpty())
        {
            Node N = Q.poll();
            if (N.level>curr_level)
            {
                curr_level = N.level;
                BLN = N;
            }
            if (N.TN.left!=null)
                Q.offer(new Node(N.TN.left,N.level+1));
            if (N.TN.right!=null)
                Q.offer(new Node(N.TN.right,N.level+1));
        }        
        return BLN.TN.val;
        
    }
}
