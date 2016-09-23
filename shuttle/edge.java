package shuttle;
public class edge implements Comparable<Object>{
	String src,dst;
	double weight;
	
	public edge(String src, String dst,double weight)
	{
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}
	
	public boolean equals(edge E)
	{
		if (this.src == E.src && this.dst==E.dst)
			return true;
		else
			return false;
	}
	

	@Override
	public int compareTo(Object E) {
		edge e = (edge) E;
		if (this.weight > e.weight)
			return 1;
		else if (this.weight < e.weight)
			return -1;
		else
			return 0;
	}
	

}
