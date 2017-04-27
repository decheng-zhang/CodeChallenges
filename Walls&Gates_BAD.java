import java.util.Queue;
import java.util.LinkedList;
import java.util.Hashtable;
import java.lang.Math;
public class Solution {
	
	Queue<pair> Q;
	Hashtable <pair,Integer> seen;
	int[][]rooms;
	private class pair
	{
		int x,y;
		boolean gate;
		public pair(int x, int y, boolean gate)
		{
			this.x = x;
			this.y = y;
			this.gate = gate;
		}
		@Override
		public int hashCode()
		{
			return (int)(Math.pow(31, 1)*this.x+Math.pow(31, 2)*this.y);
		}
		@Override
		public boolean equals(Object o)
		{
			pair p = (pair) o;
			if (this.x == p.x && this.y == p.y)
				return true;
			else
				return false;
		}
	}
	
	private int BFS(int x, int y)
	{
		Q = new LinkedList<pair>();
		seen = new Hashtable<>();
		pair p = new pair(x,y,false);
		Q.add(p);
		seen.put(p,0);
		
		while (!Q.isEmpty())
		{
			pair temp = Q.poll();
			int dist = seen.get(temp);
			if (temp.gate)
				return seen.get(temp);
			else
			{
				if (temp.x>=1 && this.rooms[temp.x-1][temp.y]!=-1)
				{
					pair cand ;
					if (this.rooms[temp.x-1][temp.y]==0)
						cand= new pair(temp.x-1, temp.y,true);
					else
						cand= new pair(temp.x-1, temp.y,false);
					if (!seen.containsKey(cand))
						{
							Q.add(cand);
							seen.put(cand,dist+1);
						}
				}
				if (temp.x<this.rooms.length-1 && this.rooms[temp.x+1][temp.y]!=-1)
				{
					pair cand ;
					if (this.rooms[temp.x+1][temp.y]==0)
						cand= new pair(temp.x+1, temp.y,true);
					else
						cand= new pair(temp.x+1, temp.y,false);
					if (!seen.containsKey(cand) )
					{
						Q.add(cand);
						seen.put(cand,dist+1);
					}
				}
				if (temp.y>=1 && this.rooms[temp.x][temp.y-1]!=-1)
				{
					pair cand ;
					if (this.rooms[temp.x][temp.y-1]==0)
						cand= new pair(temp.x, temp.y-1,true);
					else
						cand= new pair(temp.x, temp.y-1,false);
					if (!seen.containsKey(cand))
					{
						Q.add(cand);
						seen.put(cand,dist+1);
					}
				}
				if (temp.y<rooms[0].length-1 && this.rooms[temp.x][temp.y+1]!=-1)
				{
					pair cand ;
					if (this.rooms[temp.x][temp.y+1]==0)
						cand= new pair(temp.x, temp.y+1,true);
					else
						cand= new pair(temp.x, temp.y+1,false);
					if (!seen.containsKey(cand))
					{
						Q.add(cand);
						seen.put(cand,dist+1);
					}
				}
					
					
			}
		}
		return Integer.MAX_VALUE;
	}
	public void wallsAndGates(int[][] rooms) {
		
		this.rooms= rooms;
			for (int i=0;i<rooms.length;i++)
			{
				for (int j=0;j<rooms[0].length;j++)
				{
					if (rooms[i][j]==Integer.MAX_VALUE)
						{
							int dist = BFS(i,j);
							
							rooms[i][j]= dist;
						}
				}
			}
		
	    }
	
	public static void main(String[]args)
	{
		//int[][]rooms = {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
		int[][]rooms = {{0,0,-1,2147483647,-1,-1,-1,0,-1},
		                 {-1,0,-1,-1,2147483647,0,-1,2147483647,2147483647},
		                 {-1,2147483647,2147483647,0,2147483647,2147483647,2147483647,2147483647,-1},
		                 {0,2147483647,2147483647,2147483647,0,2147483647,2147483647,0,2147483647},
		                 {-1,2147483647,2147483647,2147483647,0,-1,-1,0,2147483647},
		                 {2147483647,2147483647,-1,0,2147483647,2147483647,2147483647,0,2147483647},
		                 {-1,2147483647,-1,2147483647,0,-1,-1,2147483647,-1},
		                 {-1,2147483647,-1,2147483647,-1,-1,0,2147483647,2147483647},
		                 {2147483647,0,-1,0,2147483647,-1,2147483647,0,2147483647},
		                 {-1,2147483647,0,0,-1,-1,2147483647,2147483647,-1},
		                 {2147483647,0,-1,-1,2147483647,0,0,2147483647,2147483647},
		                 {2147483647,0,0,-1,-1,-1,2147483647,-1,0}};
		Solution S = new Solution();
		S.wallsAndGates(rooms);
		for (int i=0;i<rooms.length;i++)
		{
			System.out.println();
			for (int j=0;j<rooms[0].length;j++)
			{
				System.out.print(rooms[i][j]+"\t");
			}
		}
	}
}
