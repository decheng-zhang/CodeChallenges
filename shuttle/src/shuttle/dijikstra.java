package shuttle;
import java.util.Hashtable;
import java.util.PriorityQueue;
public class dijikstra {
	graph G;
	Hashtable <String,Double> knownV;
	String src;
	PriorityQueue<edge> PQ;
	
	public dijikstra(graph G,String src)
	{
		this.G = G;
		this.src = src;
		PQ = new PriorityQueue<edge>();
		knownV = new Hashtable<String,Double>();
		trigger();
	}
	
	private void trigger()
	{
		knownV.put(this.src,0.0);
		for (edge E:G.adjList.get(src))
			PQ.add(E);
		while (knownV.keySet().size() != G.adjList.keySet().size())
		{
			edge pickedEdge;
			do
			{
				pickedEdge = PQ.poll();
			}while(knownV.containsKey(pickedEdge.dst));
			knownV.put(pickedEdge.dst, pickedEdge.weight+knownV.get(pickedEdge.src));
			for (edge E:G.adjList.get(pickedEdge.dst))
			{
				PQ.add(E);
			}
		}
	}
	
	public double getDistance(String dst)
	{
		return knownV.get(dst);
	}
	
	

}
