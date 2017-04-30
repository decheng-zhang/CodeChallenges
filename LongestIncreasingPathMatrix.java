import java.util.Stack;
public class Solution {
	int[][]grid;
	int[][]matrix;
	private int dfs(int m,int n)
	{
		Stack<int[]>stack = new Stack<int[]>();
		int result=1;
		if (m>1 && grid[m-1][n]!=0)
			result = Math.max(result, 1+grid[m-1][n]);
		if (n>1 && grid[m][n-1]!=0)
			result = Math.max(result, 1+grid[m][n-1]);
		if (m<grid.length-1 && grid[m+1][n]!=0)
			result = Math.max(result, 1+grid[m+1][n]);
		if (n<grid[0].length-1 && grid[m][n+1]!=0)
			result = Math.max(result, 1+grid[m][n+1]);
		stack.push(new int[]{m,n,1});
		while (!stack.isEmpty()) 
		{
			int[]temp = stack.pop();
			int row = temp[0];
			int col = temp[1];
			int dist = temp[2];
			result = Math.max(result, dist);
			if (row >0 && matrix[row-1][col]>matrix[row][col] && grid[row-1][col]==0)
				{
					stack.push(new int[]{row-1,col,dist+1});
				}
			if (col >0 && matrix[row][col-1]>matrix[row][col] && grid[row][col-1]==0)
				{
					stack.push(new int[]{row,col-1,dist+1});
				}
			if (row < matrix.length-1 && matrix[row+1][col]>matrix[row][col] && grid[row+1][col]==0)
				{	
					stack.push(new int[]{row+1,col,dist+1});
				}
			if (col < matrix[0].length-1 && matrix[row][col+1]>matrix[row][col] && grid[row][col+1]==0)
				{
					stack.push(new int[]{row,col+1,dist+1});
				}
		}
		return result;
	}
	
	 public int longestIncreasingPath(int[][] matrix) {
		 
		 if (matrix.length==0 || matrix[0].length==0)
			 return 0;
		 
		 grid = new int[matrix.length][matrix[0].length];
		 this.matrix = matrix;
		 int result = 1;
		 
		 for (int i=0;i<grid.length;i++)
		 {
			 for (int j=0;j<grid[0].length;j++)
			 {
				 if (grid[i][j]!=0)
					 result= Math.max(result, grid[i][j]);
				 else
				 {
					 result = Math.max(result, dfs(i,j));
				 }
			 }
		 }
		 System.out.println("answer is "+result);
		 return result;
	        
	    }
	 public static void main(String[] args)
	 {
		 //int[][]input = {{9,9,4},{6,6,8},{2,1,1}};
		 int[][]input={{1}};
		 Solution s = new Solution();
		 s.longestIncreasingPath(input);
		 //System.out.println(s.dfs(2, 1));
	 }

}


/*

DFS-recursive, make note of direction array for traversal, forbidden conditions, for(int[]d:directions), 
no need for visited info, if asked for nondecreasing use visited matrix to keep track of visited slots.

import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
public class Solution {
	int[][]grid;
	int[][]matrix;
	int[][]directions= {{0,1},{0,-1},{1,0},{-1,0}};
	private int dfs(int m,int n)
	{
		if (grid[m][n]!=0)
			return grid[m][n];
		int dist =1;
		for (int[]dir:directions)
		{
			int row=m+dir[0];
			int col=n+dir[1];
			if (row<0|| col<0 || row>=matrix.length||col>=matrix[0].length || matrix[m][n]>=matrix[row][col])
				continue;
			dist=Math.max(dist, 1+dfs(row,col));
		}
		grid[m][n]=dist;
		return grid[m][n];
	}
	
	 public int longestIncreasingPath(int[][] matrix) {
		 if (matrix.length==0 || matrix[0].length==0)
			 return 0;
		 grid = new int[matrix.length][matrix[0].length];
		 this.matrix = matrix;
		 int result = 1;
		 
		 for (int i=0;i<grid.length;i++)
		 {
			 for (int j=0;j<grid[0].length;j++)
			 {
					 result = Math.max(result, dfs(i,j));
			 }
		 }
		 System.out.println(result);
		 return result;
	        
	    }
	 public static void main(String[] args)
	 {
		 int[][]input = {{9,9,4},{6,6,8},{2,1,1}};
		 //int[][]input={{1}};
		 Solution s = new Solution();
		 s.longestIncreasingPath(input);
		 //System.out.println(s.dfs(2, 1));
	 }

}


*/
