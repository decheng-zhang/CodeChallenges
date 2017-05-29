public class NumMatrix {

    int[][]rangeSum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0)
            {
                rangeSum = null;
                return;
            }
        rangeSum = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                int fromTop= (i-1)>=0?rangeSum[i-1][j]:0;
                int fromLeft= (j-1)>=0?rangeSum[i][j-1]:0;
                int northWest = ((i-1)>=0 && (j-1)>=0)?rangeSum[i-1][j-1]:0;
                rangeSum[i][j]= fromTop+fromLeft-northWest+matrix[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
        if (rangeSum==null)
            return 0;
        int topShave = (row1-1)>=0?rangeSum[row1-1][col2]:0;
        int leftShave = (col1-1)>=0?rangeSum[row2][col1-1]:0;
        int deficit = ((row1-1)>=0 && (col1-1)>=0)?rangeSum[row1-1][col1-1]:0;
        return rangeSum[row2][col2]-topShave-leftShave+deficit;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
