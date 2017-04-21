import java.util.Hashtable;
public class Solution {
	
	private class pair 
    {
        int a,b;
        public pair(int a, int b)
        {
            this.a = a; this.b = b;
        }
        
        @Override
        public int hashCode()
        {
            return (int) (a*Math.pow(13,0)+b*Math.pow(13,1));
        }
        
        @Override
		public boolean equals(Object o)
		{
			pair that = (pair) o;
			
			if (this.a == that.a && this.b == that.b)
				return true;
			else
				return false;
		}
    }
	
	int[][]G;
	Hashtable<pair,Integer> H = new Hashtable<>();
	
public int solve(int row, int col)
{
	int val;
	pair p = new pair(row,col);
	if (row ==0 && col == 0)
	{
		return G[0][0];
	}
	else if (H.containsKey(p))
			return H.get(p);
	else
	{
		val = G[row][col];
		int option1 = Integer.MAX_VALUE;
		int option2 = option1;
		if (row>=1)
			 option1 = solve(row-1,col);
		if (col>=1)
			option2 = solve(row,col-1);
		val = val + Math.min(option1, option2);
		H.put(p, val);
		return H.get(p);
	}
}
	
public int minPathSum(int[][] grid) {
	G = grid;
	return solve(grid.length-1,grid[0].length-1); 
    }

}
