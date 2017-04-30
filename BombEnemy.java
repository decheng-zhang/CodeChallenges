
public class Solution {
	
	public int maxKilledEnemies(char[][] grid) {
		
			if (grid.length==0 || grid[0].length==0)
	        	return 0;
			int[]col_kills = new int[grid[0].length];
	        int row_kills=0,result=0;
	        for (int i=0;i<grid.length;i++)
	        {
	        	for (int j= 0;j<grid[0].length;j++)
	        	{
	        		if (i == 0 || grid[i-1][j]=='W')
	        		{
	        			col_kills[j]=0;
	        			for (int row = i;row<grid.length && grid[row][j]!='W';row++)
	        			{
	        				if (grid[row][j]=='E')
	        					col_kills[j]+=1;
	        			}
	        		}
	        		if (j==0 || grid[i][j-1]=='W')
	        		{
	        			row_kills=0;
	        			for (int col = j;col<grid[0].length && grid[i][col]!='W';col++)
	        			{
	        				if (grid[i][col]=='E')
	        					row_kills+=1;
	        			}
	        		}
	        		if (grid[i][j]=='0')
	        		{
	        			result = Math.max(result, row_kills+col_kills[j]);
	        		}
	        	}
	        }
	        System.out.println ("kills are "+result);
			return result;
	    }
	
	public static void main (String[] args)
	{
		Solution s = new Solution();
		//char[][] input = {{'0','E','0','0'}};
		char[][] input = {};
		System.out.println(input.length);
		s.maxKilledEnemies(input);
	}

}
