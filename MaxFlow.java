import java.util.Queue;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class MF {
	
	int[][]RC;
	graph G;
	
	public MF(graph G)
	{
		//create a local copy of the array
		RC = new int[G.C.length][G.C.length];
		for (int i=0;i<G.C.length;i++)
		{
			for (int j=0;j<G.C.length;j++)
				RC[i][j]=G.C[i][j];
		}
		this.G = G;
	}
	
	public int Maxflow(int source, int sink)
	{
		int result = 0;
		while (true)
		{
			// find a path from source to sink and return its capacity 
			int path_capacity = findPath(source,sink);
			if (path_capacity ==0)
				break;
			else
				result +=path_capacity;
		}
		return result;
	}
	
	public void MinCut(int src)
	{
		Queue Q = new LinkedList<Integer>();
		boolean[] visited = new boolean[RC.length];
		for (int i=0;i<RC.length;i++)
			visited[i]=false;
		Q.add(src);
		visited[src]=true;
		while (!Q.isEmpty())
		{
			int v = (int)Q.poll();
			for (int i=0;i<RC.length;i++)
			{
				if (RC[v][i]>0 && !visited[i])
				{
					Q.add(i);
					visited[i]= true;
				}
			}
		}
		for (int i=0;i<RC.length;i++)
		{
			for (int j=0;j<RC.length;j++)
			{
				if (visited[i]==true && visited[j]==false  && G.C[i][j]>0)
					System.out.println(i+"--->"+j);
					
			}
		}
	}
	public int findPath(int src,int dst)
	{
		//implements a bfs search to find a path 
		Queue Q = new LinkedList<Integer>();
		boolean []visited = new boolean[RC.length];
		int[]From = new int[RC.length];
		boolean flag= false;
		//initilize visited
		for (int i=0;i<RC.length;i++)
			{
				visited[i]=false;
				From[i]=-1;
			}
		Q.add(src);
		visited[src]=true;
		while (!Q.isEmpty() && !flag)
		{
			int v = (int)Q.poll();
			for (int j=0;j<RC.length;j++)
			{
				if (!visited[j] && RC[v][j]>0)
					{
						Q.add(j);
						visited[j]=true;
						From[j]=v;
						if (j==dst)
						{
							flag = true;
							break;
						}
					}
			}
		}
		//compute path capacity, which is the minimum edge in the path
		int pathcap = Integer.MAX_VALUE;
		int where=dst;
		int prev;
		
		while (From[where]!=-1)
		{
			prev=From[where];
			pathcap = pathcap<RC[prev][where]?pathcap:RC[prev][where];
			where=prev;
		}
		// reduce residual capacities for all edges in the path.
		where=dst;
		while(From[where]!=-1)
		{
			prev = From[where];
			RC[prev][where]-=pathcap;
			RC[where][prev]+=pathcap ;// signifies the flow
			where = prev;
		}
		

		//if no flow is found the capacity will be infinity
		if (pathcap==Integer.MAX_VALUE)
				return 0;
		else
			return pathcap;
	}
	
	public static void main(String[] args)throws FileNotFoundException,IOException
	{
		String filename = args[0];
		String line;
		graph G;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		G = new graph(Integer.parseInt(br.readLine()));
		while ((line = br.readLine()) != null)
		{
			String[] A = line.split(" ");
			int src = Integer.parseInt(A[0]);
			int dst = Integer.parseInt(A[1]);
			int weight = Integer.parseInt(A[2]);
			G.addEdge(src,dst,weight);
		}
		MF mf = new MF(G);
		System.out.println(mf.Maxflow(1, 4)); 
		mf.MinCut(1);
	}

}
