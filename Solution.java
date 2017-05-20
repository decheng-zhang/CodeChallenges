
public class Solution {
	
	int numIslands=0;
	char[][]grid;
	int[][]visited;
	public boolean dfs(int row, int col)
	{
		if (row<0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]==1 || grid[row][col]=='0')
			return false;
		else
		{
			visited[row][col]=1;
			dfs(row-1,col);
			dfs(row+1,col);
			dfs(row,col-1);
			dfs(row,col+1);
			return true;
		}
	}
	
	 public int numIslands(char[][] grid) {
		 
		 	
		 
		 	this.grid = grid;
	        visited = new int[grid.length][grid[0].length];
	        for (int i=0;i<grid.length;i++)
	        {
	        	for (int j=0;j<grid[0].length;j++)
	        	{
	        		if (dfs(i,j))
	        			numIslands++;
	        	}
	        }
	        return numIslands;
	    }
	 
	 public static void main(String[]args)
	 {
		 //char[][] input={{'1','1','1'},{'0','0','0'},{'1','1','1'}};
		 char[][] input={{}};
		 Solution s = new Solution();
		 System.out.println(s.numIslands(input));
	 }

}
