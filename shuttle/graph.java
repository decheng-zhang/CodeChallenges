package shuttle;
import java.util.Hashtable;
import java.util.ArrayList;
public class graph {
	Hashtable<String,ArrayList<edge>>adjList;
	
	public graph()
	{
		adjList = new Hashtable<String,ArrayList<edge>>();
	}
	
	public void  addV(String vertex)
	{
		adjList.put(vertex,new ArrayList<edge>());
	}
	
	public void addEdge(String src, String dst, double weight)
	{
		edge E1 = new edge(src,dst,weight);
		edge E2 = new edge(dst,src,weight);
		adjList.get(src).add(E1);
		adjList.get(dst).add(E2);
	}
	
	public boolean containsV(String V)
	{
		return adjList.containsKey(V);
	}
	
}
