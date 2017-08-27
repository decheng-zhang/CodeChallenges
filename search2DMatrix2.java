import java.util.Arrays;
class Solution {
    
    int[][]matrix;
    public boolean BS(int lo_row, int hi_row, int target)
    {
        if (lo_row > hi_row)
            return false;
        if (lo_row == hi_row)
        {
            return (Arrays.binarySearch(matrix[lo_row],target)>=0?true:false);
        }
        else
        {
            int mid_row = lo_row + (hi_row-lo_row)/2;
            if (target<=matrix[mid_row][matrix[0].length-1])
                return BS(lo_row,mid_row,target);
            else
                return BS(mid_row+1,hi_row,target);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        this.matrix = matrix;
        int num_rows = matrix.length;
        return BS(0,matrix.length-1,target);
        
    }
}
