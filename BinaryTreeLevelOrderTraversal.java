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
    Queue<Node> Q = new LinkedList<>();
    List<List<Integer>> L = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int curr_lev = 0;
        List<Integer> LL = null;
        if (root == null)
            return L;
        else
        {
            Q.offer(new Node(root,1));
            while (!Q.isEmpty())
            {
                Node N = Q.poll();
                if (N.l>curr_lev)
                {
                    if (LL!=null)
                        L.add(LL);
                    curr_lev = N.l;
                    LL = new LinkedList<>();
                }
                LL.add(N.tn.val);
                if (N.tn.left!=null)
                    Q.offer(new Node(N.tn.left,N.l+1));
                if (N.tn.right!=null)
                    Q.offer(new Node(N.tn.right,N.l+1));
            }
            L.add(LL); //add last level list
            return L;
        }
        
    }
}
