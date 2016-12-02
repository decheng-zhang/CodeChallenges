package apsp;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.LinkedList;
public class solution {
	
	static class edge
	{
		int src,cost,dst;
		public edge(int src,int dst,int cost)
		{
			this.src = src;
			this.dst = dst;
			this.cost = cost;
		}
	}
	static class graph
	{
		int numVerts;
		Hashtable<Integer,LinkedList<edge>> L;
		LinkedList<edge> edge_list = new LinkedList<edge>();
		public graph(int numVerts)
		{
			this.numVerts = numVerts;
			L = new Hashtable<Integer,LinkedList<edge>>();
			for (int i=0;i<numVerts;i++)
			{
				L.put(i, new LinkedList<edge>());
			}
		}
		
		public void addEdge(int src, int dst, int cost)
		{
			edge e = new edge(src,dst,cost);
			L.get(src).add(e);
			edge_list.add(e);
		}
	}
	
	static class bellman
	{
		int[]B;
		graph G;
		int src;
		
		public bellman(int src,graph G)
		{
			this.G = G;
			this.src = src;
			B= new int[G.numVerts];
			for (int i=0;i<B.length;i++)
			{
				B[i]=Integer.MAX_VALUE;
			}
			B[src]=0;
		}
		
		public void trigger()
		{
			for (int i=1;i<G.numVerts;i++)
			{
				for (edge e:G.edge_list)
				{
					int src = e.src;
					int dst = e.dst;
					int cost = e.cost;
					if (B[src]!=Integer.MAX_VALUE && B[dst] > B[src]+cost)
						B[dst]=B[src]+cost;
				}
			}
		}//end trigger
		
		public boolean checkNegativeCycle()
		{
			int[]B_new = B.clone();
			for (edge e:G.edge_list)
			{
				int src = e.src;
				int dst = e.dst;
				int cost = e.cost;
				if (B_new[src]!=Integer.MAX_VALUE && B_new[dst] > B_new[src]+cost)
					B_new[dst]=B_new[src]+cost;
			}
			boolean flag = false;
			for (int i=0;i<B.length;i++)
			{
				if (B_new[i]<B[i])
				{
					flag = true;
					break;
				}
			}
		
			return flag;
		}
		
		public int[] get_vertIndices()
		{
			return B;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		String filename = args[0];
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		line = br.readLine();
		String[]inputs = line.split(" ");
		int numVerts = Integer.parseInt(inputs[0]);
		int numEdges = Integer.parseInt(inputs[1]);
		graph G = new graph(numVerts+1);//extra 1 vertex for dummy vertex
		for (int i=0;i<numEdges;i++)
		{
			line = br.readLine();
			inputs = line.split(" ");
			int src = Integer.parseInt(inputs[0]);
			int dst = Integer.parseInt(inputs[1]);
			int cost = Integer.parseInt(inputs[2]);
			G.addEdge(src,dst,cost);
		}
		br.close();
		//add dummy  extra edges
		for (int i=1;i<=numVerts;i++)
		{
			G.addEdge(0,i,0);
		}
		bellman B = new bellman(0,G);
		B.trigger();
		System.out.println(B.checkNegativeCycle());
		int counter = 0;
		for (int i:B.get_vertIndices())
			System.out.println((counter++)+"\t"+i);
	}

}
