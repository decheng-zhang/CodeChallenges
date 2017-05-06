import java.util.Arrays;
public class Solution {
	
	int[][]maze;
	static int[][]directions={{1,0},{-1,0},{0,1},{0,-1}};

	
	public boolean dfs(int [][]beginning, int []start, int []destination)
	{
		System.out.println("row "+start[0]+" col "+start[1]+" visited "+beginning[start[0]][start[1]]);

		if (Arrays.equals(start,destination))
			return true;
		if (beginning[start[0]][start[1]]==1)
			return false;
		beginning[start[0]][start[1]]=1;
		for (int[]dir:directions)
		{
			int []restart = roll(start,dir); //returns point where ball stops rolling.
			if (dfs(beginning, restart, destination))
				return true;
		}
		return false;
	}
	
	public int[] roll(int[] start, int[]dir)
	{
		int row = start[0];
		int col = start[1];
		while (canRoll(row+dir[0],col+dir[1]))
		{
			row = row+dir[0];
			col = col+dir[1];
		}
		return new int[]{row,col};
	}
	
	public boolean canRoll(int row, int col)
	{
		if (row<0 || row>=maze.length || col < 0 || col >=maze[0].length)
			return false;
		else
			return (maze[row][col]!=1);
	}
	
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) 
		{
			int[][]beginning = new int[maze.length][maze[0].length];
			this.maze = maze;
			return dfs(beginning,start,destination);
	        
	    }
	
	public static void main(String[] args)
	{
		int[][]maze = {{0, 0, 1, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{1, 1, 0, 1, 1},{0, 0, 0, 0, 0}};
		int[]start={0,4};
		int[]destination={4,4};
		Solution s = new Solution();
		System.out.println(s.hasPath(maze, start, destination));
	}

}
