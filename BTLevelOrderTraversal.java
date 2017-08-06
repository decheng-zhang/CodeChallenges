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
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    private class node
    {
        int level;
        TreeNode tn;
        public node(TreeNode tn, int l)
        {
            this.tn = tn;
            level = l;
        }
    }
    Stack<node> S = new Stack<>();
    Queue<node> Q = new LinkedList();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> L = new ArrayList<>();
        if (root==null)
            return L;
        Q.offer(new node(root,0));
        while (!Q.isEmpty())
        {
            node temp = Q.poll();
            if (temp.tn.right!=null)
                Q.offer(new node(temp.tn.right,temp.level+1));
            if (temp.tn.left!=null)
                Q.offer(new node(temp.tn.left,temp.level+1));
            S.push(temp);
        }
        
        int currL = -1;
        List<Integer> LL=null;
        while (!S.isEmpty())
        {
            node n = S.pop();
            if (n.level!=currL)
            {
                if (LL!=null)
                    L.add(LL);
                LL = new ArrayList<>();
                currL = n.level;
            }
            LL.add(n.tn.val);
        }
        L.add(LL);
        return L;
    }
}
