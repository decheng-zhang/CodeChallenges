public class Solution {
    int[][]map; 
    int[][]matrix;
    List<Integer> path = new ArrayList<>();
    private void move(int row, int col, int dir)
    {
        //System.out.println(row+", "+col);
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || map[row][col]==1)
            return;
        path.add(matrix[row][col]);
        map[row][col]=1;
        switch(dir) //0 up,1 down, 2 left, 3 right
        {
            case 0://up
                while (row-1>=0 && map[row-1][col]==0)
                {
                    row = row-1;
                    path.add(matrix[row][col]);
                    map[row][col]=1;                                      
                } 
                row = (row==-1)?0:row;
                move(row,col+1,3);
            case 1://down
                while (row+1<matrix.length && map[row+1][col]==0)
                { 
                    row=row+1;
                    path.add(matrix[row][col]);
                    map[row][col]=1;                               
                }
                row = (row==matrix.length)?row-1:row;   
                move(row,col-1,2);
            case 2:
                while (col-1>=0 && map[row][col-1]==0)
                {
                    col = col-1;
                    path.add(matrix[row][col]);
                    map[row][col]=1;                                 
                }
                col = (col==-1)?0:col;   
                move(row-1,col,0);
            case 3:
                while(col+1<matrix[0].length && map[row][col+1]==0)
                { 
                    col=col+1;
                    path.add(matrix[row][col]);
                    map[row][col]=1;                   
                }
                col = (col==matrix[0].length)?col-1:col; 
                move(row+1,col,1);
            default:
                break;
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0)
            return path;
        map =  new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        
        move(0,0,3);
        return path;
    }
}
