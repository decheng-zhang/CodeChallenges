package bellman;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
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
			L.get(src).add(new edge(src,dst,cost));
		}
	}
	
	static class bellman
	{
		Queue<Integer> q;
		int[]B;
		graph G;
		int src;
		
		public bellman(int src,graph G)
		{
			this.G = G;
			this.src = src;
			B= new int[G.numVerts];
			q = new LinkedList<Integer>();
			for (int i=0;i<B.length;i++)
			{
				B[i]=Integer.MAX_VALUE;
			}
			B[src] = 0;
			for (edge e:G.L.get(src))
			{
				B[e.dst] = e.cost;
				q.add(e.dst);
			}
		}
		
		public void trigger()
		{
			for (int i=1;i<G.numVerts-2;i++)
			{
				int size = q.size();
				for (int j=0;j<size;j++)
				{
					int cand = q.poll();
					for (edge e:G.L.get(cand))
					{
						if (B[e.dst]>e.cost+B[e.src])
						{
							B[e.dst] = e.cost+B[e.src];
							q.add(e.dst);
						}
					}
				}
			}//end for
		}//end trigger
	}
	
	public static void main(String[] args)
	{
		graph G = new graph(5);
		G.addEdge(0,1,-1);
		G.addEdge(0,2,4);
		G.addEdge(1,2,3);
		G.addEdge(1,3,2);
		G.addEdge(1,4,2);
		G.addEdge(3,2,5);
		G.addEdge(3,1,1);
		G.addEdge(4,3,-3);
		bellman B = new bellman(0,G);
		B.trigger();
		for (int i=0;i<B.B.length;i++)
		{
			System.out.print(B.B[i]+"\t");
		}
	}

}
