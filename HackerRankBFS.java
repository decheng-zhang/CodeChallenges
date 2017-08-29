import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Queue;
import java.util.LinkedList;
public class bfs {
	
	
	private  static class Graph
	{
		int[] distance;
		boolean[]visited;
		Hashtable<Integer,ArrayList<Integer>> map = new Hashtable<>();
		public Graph(int n, int m)
		{
			for (int i=0;i<n;i++)
				map.put(i+1, new ArrayList<Integer>());
			distance = new int[n+1];
			Arrays.fill(distance, -1);
			visited = new boolean[n+1];
			Arrays.fill(visited, false);
		}
		
		public void addEdge(int s, int d)
		{
			map.get(s).add(d);
			map.get(d).add(s);
		}
		
		public int[] BFS(int source)
		{
			Queue<int[]> Q = new LinkedList<>();
			Q.add(new int[]{source,0});
			while (!Q.isEmpty())
			{
				int[]polled = Q.poll();
				int s = polled[0];
				visited[s]=true;
				distance[s]=polled[1];
				for (int d:map.get(s))
				{
					if (!visited[d])
					{
						int dist = polled[1]+6;
						Q.add(new int[]{d,dist});
					}
					
				}
			}
			return distance;
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		String filename = args[0];
		BufferedReader br = new BufferedReader(new FileReader(filename));
		ArrayList<String> input = new ArrayList<>();
		int queries = Integer.parseInt(br.readLine());
		for (int i=0;i<queries;i++)
		{
			int v,e;
			String[]ve = br.readLine().split(" ");
			v = Integer.parseInt(ve[0]);
			e = Integer.parseInt(ve[1]);
			Graph G = new Graph(v,e);
			for (int j=0;j<e;j++)
			{
				String[]sd = br.readLine().split(" ");
				G.addEdge(Integer.parseInt(sd[0]), Integer.parseInt(sd[1]));
			}
			int source = Integer.parseInt(br.readLine());
			int[] dist = G.BFS(source);
			System.out.println();
			for (int k=1;k<dist.length;k++)
				{
					if (k==source)
						continue;
					System.out.print("\t"+dist[k]);
				}
		}
	}

}
