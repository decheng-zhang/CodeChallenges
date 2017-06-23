public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][]obs = obstacleGrid;
        if (obs.length==0 || obs[0].length==0)
            return 0;
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        paths[0][0]=1;
        
        for (int i=0;i<paths.length;i++)
        {
            for (int j = 0;j<paths[0].length;j++)
            {
                //if obstacle 0
                if (obs[i][j]==1)
                    {
                        paths[i][j]=0;
                        continue;
                    }
                //from top
                if (i>0)
                    paths[i][j]+=paths[i-1][j];
                //from left
                if (j>0)
                    paths[i][j]+=paths[i][j-1];
            }
        }
        
        return paths[paths.length-1][paths[0].length-1];
    }
}
