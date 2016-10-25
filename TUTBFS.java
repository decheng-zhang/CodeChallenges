/*http://www.spoj.com/problems/TUTBFS/*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
public class Main {
	private class tuple {
		int a,b;
		public tuple(int a, int b)
		{
			this.a = a;
			this.b = b;
		}

	}
	
	public static void main(String[] args) throws IOException,FileNotFoundException
	{
		//String filename = args[0];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(br.readLine());
		for (int i=0;i<numTests;i++)
		{
			String  grid_size = br.readLine();
			int grid_rows = Integer.parseInt(grid_size.split(" ")[0]);
			int grid_cols = Integer.parseInt(grid_size.split(" ")[1]);
			int[][]seen = new int[grid_rows][grid_cols];
			int[][]grid = new int[grid_rows][grid_cols];
			Queue<tuple>  Q = new LinkedList<tuple>();
			for (int j=0;j<grid_rows;j++)
			{
				for (int k=0;k<grid_cols;k++)
				{
					seen[j][k]= -1;
				}
			}
			for (int j=0;j<grid_rows;j++)
			{
				char[]col = br.readLine().toCharArray();
				for (int k=0;k<grid_cols;k++)
				{
					if (col[k]=='.')
						grid[j][k]=1;
					else
						grid[j][k]=0;
				}
			}
			
//			for (int j=0;j<grid_rows;j++)
//			{
//				for (int k=0;k<grid_cols;k++)
//				{
//					System.out.print(grid[j][k]+" ");
//				}
//				System.out.println("");
//			}
			Q.add(new Main().new tuple(0,0));
			seen[0][0]=0;
			while (!Q.isEmpty())
			{
				tuple temp = Q.poll();
				//can i go up
				if (temp.a-1>=0 && seen[temp.a-1][temp.b]==-1 && grid[temp.a-1][temp.b]==1)
					{
						Q.add(new Main().new tuple(temp.a-1,temp.b));
						seen[temp.a-1][temp.b]=1+seen[temp.a][temp.b];
					}
				//can i fo down
				if (temp.a+1<grid_rows && seen[temp.a+1][temp.b]==-1 && grid[temp.a+1][temp.b]==1)
					{
						Q.add(new Main().new tuple(temp.a+1,temp.b));
						seen[temp.a+1][temp.b]=1+seen[temp.a][temp.b];
					}
				//can i go left
				if (temp.b-1>=0 && seen[temp.a][temp.b-1]==-1 && grid[temp.a][temp.b-1]==1)
					{
						Q.add(new Main().new tuple(temp.a,temp.b-1));
						seen[temp.a][temp.b-1]=1+seen[temp.a][temp.b];
					}
				//can i go right
				if (temp.b+1<grid_cols && seen[temp.a][temp.b+1]==-1 && grid[temp.a][temp.b+1]==1)
					{
						Q.add(new Main().new tuple(temp.a,temp.b+1));
						seen[temp.a][temp.b+1]=1+seen[temp.a][temp.b];
					}
				//can i go nw
				if (temp.b-1>=0 && temp.a-1>=0 && seen[temp.a-1][temp.b-1]==-1 && grid[temp.a-1][temp.b-1]==1)
					{
						Q.add(new Main().new tuple(temp.a-1,temp.b-1));
						seen[temp.a-1][temp.b-1]=1+seen[temp.a][temp.b];
					}
				//can i go ne
				if (temp.b+1<grid_cols && temp.a-1>=0  && seen[temp.a-1][temp.b+1]==-1 && grid[temp.a-1][temp.b+1]==1)
					{
						Q.add(new Main().new tuple(temp.a-1,temp.b+1));
						seen[temp.a-1][temp.b+1]=1+seen[temp.a][temp.b];
					}
				//can i go sw
				if (temp.b-1>=0 && temp.a+1<grid_rows  && seen[temp.a+1][temp.b-1]==-1 && grid[temp.a+1][temp.b-1]==1)
					{
						Q.add(new Main().new tuple(temp.a+1,temp.b-1));
						seen[temp.a+1][temp.b-1]=1+seen[temp.a][temp.b];
					}
				//can i go se
				if (temp.b+1<grid_cols && temp.a+1<grid_rows  && seen[temp.a+1][temp.b+1]==-1 && grid[temp.a+1][temp.b+1]==1)
					{
						Q.add(new Main().new tuple(temp.a+1,temp.b+1));
						seen[temp.a+1][temp.b+1]=1+seen[temp.a][temp.b];
					}
			}
//			System.out.println("---------------------------");
//			for (int j=0;j<grid_rows;j++)
//			{
//				for (int k=0;k<grid_cols;k++)
//				{
//					System.out.print(seen[j][k]+" ");
//				}
//				System.out.println("");
//			}
			int max = -1;
			for (int j=0;j<grid_rows;j++)
			{
				for (int k=0;k<grid_cols;k++)
				{
					if (seen[j][k]> max)
						max = seen[j][k];
				}
			}
			System.out.println(max);
			
		}
	}

}
