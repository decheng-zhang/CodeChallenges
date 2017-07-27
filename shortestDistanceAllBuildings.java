
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
	
	int[][]matrix;
	int[][]dist;
	
	private class node
	{
		int row,col;
		public node(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}
	private int[][] BFS(int row, int col)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		Queue<node> q = new LinkedList<>();
		
		int[][]distance = new int[rows][cols];
		for (int i = 0;i<rows;i++)
		{
			for (int j = 0;j<cols;j++)
			{
				distance[i][j]=-9;
			}
		}
		q.add(new node(row,col));
		distance[row][col]=0;
		
		while (!q.isEmpty())
		{
			node temp = q.poll();
			//move up
			if (temp.row-1 >=0 && matrix[temp.row-1][temp.col]==0 && distance[temp.row-1][temp.col] ==-9)
			{
				distance[temp.row-1][temp.col]= distance[temp.row][temp.col]+1;
				q.add(new node(temp.row-1,temp.col));
			}
			//move down
			if (temp.row+1 < rows && matrix[temp.row+1][temp.col]==0 && distance[temp.row+1][temp.col] ==-9)
			{
				distance[temp.row+1][temp.col]= distance[temp.row][temp.col]+1;
				q.add(new node(temp.row+1,temp.col));
			}
			//move left
			if (temp.col-1 >= 0 && matrix[temp.row][temp.col-1]==0 && distance[temp.row][temp.col-1] ==-9)
			{
				distance[temp.row][temp.col-1]= distance[temp.row][temp.col]+1;
				q.add(new node(temp.row,temp.col-1));
			}
			//move right
			if (temp.col+1 < cols  && matrix[temp.row][temp.col+1]==0 && distance[temp.row][temp.col+1] ==-9)
			{
				distance[temp.row][temp.col+1]= distance[temp.row][temp.col]+1;
				q.add(new node(temp.row,temp.col+1));
			}
		}		
		
		return distance;
	}
	
	public int shortestDistance(int[][] grid) {
		matrix = grid;
		dist = new int[matrix.length][matrix[0].length];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0;i<dist.length;i++)
		{
			for (int j = 0;j<dist[0].length;j++)
				dist[i][j]=0;
		}
		
		for (int i = 0;i<matrix.length;i++)
		{
			for (int j = 0;j<matrix[0].length;j++)
			{
				if (matrix[i][j]==1)
				{
						int[][] distance = BFS(i,j);
						
						for (int m = 0;m<dist.length;m++)
						{
							for (int n = 0;n<dist[0].length;n++)
							{
								if (distance[m][n]>=0 && dist[m][n]!=Integer.MAX_VALUE )
									dist[m][n]+=distance[m][n];
								else
									dist[m][n]=Integer.MAX_VALUE;
							}
						}
				}
			}
		}
		
		for (int i = 0;i<dist.length;i++)
		{
			for (int j = 0;j<dist[0].length;j++)
			{
				if (dist[i][j] < min && matrix[i][j]== 0)
					min = dist[i][j];
			}
		}
		if (min == Integer.MAX_VALUE)
		    return -1;
	    else
		    return min;
    }
	
	public static void main(String[] args)
	{
		int[][] input = {{0,2,1},{1,0,2},{0,1,0}};
		Solution S = new Solution();
		System.out.println(S.shortestDistance(input));
		System.out.println(Integer.MAX_VALUE);
	}
}
