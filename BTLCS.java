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
    
    int maximum = 0;
   int[] pathCounter(TreeNode n)
   {
       int[] result = new int[]{0,0};
       if (n == null)
            return result;
        
        int[]left = pathCounter(n.left);
        int[]right = pathCounter(n.right);
        
        if (n.left!=null)
        {
            if (n.left.val - n.val==1)
                result[0]=Math.max(result[0],left[0]);
            else if (n.val - n.left.val ==1)
                result[1]=Math.max(result[1],left[1]);
        }
   
        if (n.right!=null)
        {
            if (n.right.val-n.val==1)
                result[0]=Math.max(result[0],right[0]);
            else if (n.val - n.right.val ==1)
                result[1]=Math.max(result[1],right[1]);
        }
        
        if (maximum < 1+ result[0]+result[1])
            maximum = 1+ result[0]+result[1];
            
        result[0]+=1;result[1]+=1;
        return result;
       
   }
    
    
    int longestConsecutive(TreeNode n)
    {
        pathCounter(n);
        return maximum;
    }
    
    
}
