import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


//https://www.hackerrank.com/challenges/bfsshortreach
public class Solution
	{
		int V,E;
		int[][] M;
		public Solution(int V,int E)
		{
			this.V = V;
			this.E = E;
			M = new int[V][V];
			for (int i=0;i<V;i++)
			{
				for (int j=0;j<V;j++)
				{
					if (i!=j)
						M[i][j] = -1;
					else
						M[i][j] = 0;
				}
			}
		}
		
		
		public void addE(int src,int dst) //adds bidirectional edge
		{
			src--;dst--;
			M[src][dst] = 6;
			M[dst][src] = 6;
			
		}
		
		public void bfs(int source)
		{
			source--;
			Queue <Integer> Q = new LinkedList<Integer>();
			Boolean[] seen = new Boolean[V];
			for (int i=0;i<V;i++)
				seen[i]=false;
			Q.add(source);
			seen[source]=true;
			while (!Q.isEmpty())
			{
				int vert = Q.poll();
				for (int i =0;i<V;i++)
				{
					if (M[vert][i]!=-1 && seen[i]==false)
					{
						seen[i]=true;
						M[source][i] = M[source][vert]+M[vert][i];
						Q.add(i);
					}
				}
				
			}
			for (int i=0;i<V;i++)
				{
					if (i!= source)
						System.out.print(M[source][i]+" ");
				}
			System.out.println("");
			
		}
		
		public static void main(String[] args) throws FileNotFoundException,IOException
		{
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String line;
			int numQueries = Integer.parseInt(b.readLine());
			for (int i=0;i<numQueries;i++)
			{
				line = b.readLine();
				int numNodes = Integer.parseInt(line.split(" ")[0]);
				int numEdges = Integer.parseInt(line.split(" ")[1]);
				//create a new graph
				Solution G= new Solution(numNodes,numEdges);
				for (int j=0;j<numEdges;j++)
				{
					line = b.readLine();
					int src = Integer.parseInt(line.split(" ")[0]);
					int dst = Integer.parseInt(line.split(" ")[1]);
					//Add edge to the graph
					G.addE(src, dst);
				}
				int start = Integer.parseInt(b.readLine().split(" ")[0]);
				G.bfs(start);
			}
		}
	}
