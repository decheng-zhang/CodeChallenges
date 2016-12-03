package apsp;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
	static class vertex implements Comparable
	{
		int id,value;
		public vertex(int ID,int val)
		{
			id = ID;
			value = val;
		}
		
		public int compareTo(Object that)
		{
			vertex v2 = (vertex)that;
			if (this.value > v2.value)
				return 1;
			else if (this.value < v2.value)
				return -1;
			else return 0;
				
		}
		
		public boolean equals(Object v2)
		{
			vertex that = (vertex)v2;
			if (this.id == that.id)
				return true;
			else return false;
		}
	}
	
	static class dijikstra
	{
		PriorityQueue<vertex> pq = new PriorityQueue<vertex>();
		Hashtable<Integer,Integer> known = new Hashtable<Integer,Integer>();
		Hashtable<Integer,Integer> costs = new Hashtable<Integer,Integer>();
		graph G;
		int src;
		public dijikstra(graph G, int src)
		{
			this.G = G;
			this.src = src;
			known.put(src, 0);
			for (edge e:G.L.get(src))
			{
				pq.add(new vertex(e.dst,known.get(src)+e.cost));
				costs.put(e.dst,known.get(src)+e.cost);
			}
		}
		
		public void trigger()
		{
			//known.keySet().size()!=G.numVerts-1
			while (!pq.isEmpty()) //will not be able to reach dummy vertex
			{
				vertex v = pq.poll();
				known.put(v.id, v.value);
				//System.out.println("picked "+v.id+" with cost "+v.value);
				for (edge e:G.L.get(v.id))
				{
					int dst = e.dst;
					int new_cost = known.get(e.src)+e.cost;
					vertex temp = new vertex(e.dst,new_cost);
					if (costs.containsKey(e.dst) && new_cost < costs.get(e.dst))
					{
						pq.remove(temp);
						pq.add(temp);
						costs.put(e.dst, new_cost);
					}
					else if (!costs.containsKey(e.dst))
					{
						pq.add(temp);
						costs.put(e.dst, new_cost);
					}
					
				}
			}
		}
		public Hashtable<Integer,Integer> getDistances()
		{
			return known;
		}
		
		public void display()
		{
			for (int v:known.keySet())
			{
				System.out.println(v+"\t"+known.get(v));
			}
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
		if (B.checkNegativeCycle())
			{
				System.out.println("Input Graph has cycle.");
				return;
			}
		
		//new vertex weights
		int[] vert_weights = B.get_vertIndices();
		//update edge costs so that no edge has negative edge costs
		//System.out.println("edge_costs");
		for (int v:G.L.keySet())
		{
			if (v!=0)
			{
				for (edge e:G.L.get(v))
				{
					e.cost = e.cost + vert_weights[e.src]-vert_weights[e.dst];
					//System.out.println(e.cost);
				}
			}
		}
		//apply dijikstra for all vertices other than the dummy vertex
		int minVal = Integer.MAX_VALUE;
		int dist = 0;
		for (int i = 1;i<G.numVerts;i++)
		{
			dijikstra D = new dijikstra(G,i);
			D.trigger();
			Hashtable<Integer,Integer> H = D.getDistances();
			for (int key:H.keySet())
			{
				dist = H.get(key)-vert_weights[i]+vert_weights[key];
				if (dist < minVal && key!=i)
				{
						minVal = dist;
				}
			}
		}
		System.out.println(minVal);
		
	}

}
