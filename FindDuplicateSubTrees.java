/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public void inOrder(TreeNode tn,StringBuffer log)
    {
        if (tn.left==null && tn.right == null)
            log.append(tn.val);
        else
        {
            if (tn.left!=null)
                inOrder(tn.left,log);
            else
                log.append("null");
            
            
            if (tn.right!=null)
                inOrder(tn.right,log);
            else
                log.append("null");
            
            log.append(tn.val);
            
        }
    }
    
    public void traverse(TreeNode tn,Set<TreeNode> duplicates)
    {
        if (tn.left == null && tn.right==null)
        {
            StringBuffer sb = new StringBuffer();
            inOrder(tn,sb);
            if (map.containsKey(sb.toString()))
            {
                int count = map.get(sb.toString());
                if (count==1)
                    duplicates.add(tn);
                map.put(sb.toString(),count+1);
            }
            else
                map.put(sb.toString(),1);
            return;
        }
        if (tn.left!=null)
            traverse(tn.left,duplicates);
        StringBuffer sb = new StringBuffer();
        inOrder(tn,sb);
         if (map.containsKey(sb.toString()))
            {
                int count = map.get(sb.toString());
                if (count==1)
                    duplicates.add(tn);
                map.put(sb.toString(),count+1);
            }
        else
            map.put(sb.toString(),1);
        if (tn.right!=null)
            traverse(tn.right,duplicates);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashSet<TreeNode> duplicates = new HashSet<>();
        if (root == null) return new ArrayList<TreeNode>(duplicates);
        traverse(root,duplicates);
        return new ArrayList<TreeNode>(duplicates);
    }
}
