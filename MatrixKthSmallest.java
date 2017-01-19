import java.util.PriorityQueue;
public class Solution {
    
    
    PriorityQueue <node> pq = new PriorityQueue<node>();
    private class node implements Comparable<Object>
    {
        int val,row,col;
        
        public node(int val,int row,int col)
        {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        
        public int compareTo(Object other)
        {
            node that = (node) other;
            if (this.val > that.val)
                return 1;
            else if (this.val < that.val)
                return -1;
            else
                return 0;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        
        for (int i = 0;i<matrix[0].length;i++)
            pq.offer(new node(matrix[0][i], 0,i));
            
        node temp = new node(-99,-1,-1);
        
        for (int j=0;j<k;j++)
        {
            temp = pq.poll();
            if (temp.row+1 < matrix.length)
                pq.offer(new node(matrix[temp.row+1][temp.col], temp.row+1, temp.col));
        }
        
        return temp.val;
        
    }
}
