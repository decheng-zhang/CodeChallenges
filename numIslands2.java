import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
public class Solution {
	
	int rows,cols;
	int[] parent;
	int[] serial_no;
	List<Integer> L;
	int[][]grid;
	List<Integer>Islands;
	Set<Integer> components;
	int num_islands=0;
	
	public int find(int id)
	{
		int temp = id;
		while (parent[temp]!=temp)
		{
			temp = parent[temp];
		}
		return temp;
	}
	
	public void union(int id1, int id2)
	{
		int par1 = find(id1);
		int par2 = find(id2);
		
		if (serial_no[par1] < serial_no[par2])
			parent[par2] = par1;
		else
			parent[par1] = par2;
	}
	
	public int ID(int row, int col)
	{
		return (row*cols)+col+1;
	}
	
	public void addLand(int row, int col, int seq)
	{
		grid[row][col]=1;
		num_islands+=1;
		int id1,id2;
		id1 = ID(row,col);
		Islands.add(id1);
		if (row >0)
		{
			if (grid[row-1][col]==1)
			{
				id2 = ID(row-1,col);
				if (find(id1)!=find(id2))
					{
						union(id1,id2);
						num_islands--;
					}
			}
			
		}
		if (col < cols-1)
		{
			if (grid[row][col+1]==1)
			{
				id2 = ID(row,col+1);
				if (find(id1)!=find(id2))
				{
					union(id1,id2);
					num_islands--;
				}
			}
				
		}
		if (row < rows-1)
		{
			if (grid[row+1][col]==1)
			{
				id2 = ID(row+1,col);
				if (find(id1)!=find(id2))
				{
					union(id1,id2);
					num_islands--;
				}
			}
		}
		if (col > 0)
		{
			if (grid[row][col-1]==1)
			{
				id2 = ID(row,col-1);
				if (find(id1)!=find(id2))
				{
					union(id1,id2);
					num_islands--;
				}
			}		
		}
		//components.add(find(id1));
		L.add(num_islands);
	}
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) 
		{
			this.rows = m;
			this.cols = n;
			int seq=1;
			components= new HashSet<Integer>();
			parent = new int[rows*cols+1];
			serial_no = new int[rows*cols+1];
			Arrays.fill(serial_no, Integer.MAX_VALUE);
			for (int i = 0;i<parent.length;i++)
				parent[i] = i;
			L = new LinkedList<>();
			Islands = new LinkedList<>();
			grid = new int[m][n];
	        for (int []pos:positions)
	        	addLand(pos[0],pos[1],seq++);	
	        return L;
	    }

}
