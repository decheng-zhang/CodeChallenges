import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Solution {
	
	int[][]maze;
	int[][]distance;
	static int [][]directions = {{1,0},{-1,0},{0,-1},{0,1}};
	PriorityQueue<int[]> PQ = new PriorityQueue<>((o1,o2)->distance[o1[0]][o1[1]]-distance[o2[0]][o2[1]]);
	
	public int bfs(int[] start, int[]dest)
	{
		distance[start[0]][start[1]]=0;
		PQ.offer(new int[]{start[0],start[1]});
		
		while (!PQ.isEmpty())
		{
			int[]stoppedHere = PQ.poll();
			if (Arrays.equals(stoppedHere,dest))
				return distance[stoppedHere[0]][stoppedHere[1]];
			else
			{
				for (int[] dir:directions)
				{
					int[] nextStop = roll(stoppedHere[0],stoppedHere[1],dir);
					int dist=nextStop[2]+distance[stoppedHere[0]][stoppedHere[1]];
					if (dist >= distance[nextStop[0]][nextStop[1]])
						continue;
					distance[nextStop[0]][nextStop[1]]=dist;
					PQ.offer(new int[]{nextStop[0],nextStop[1]});
				}
			}
		}
		return -1;
	}
	
	public int[] roll(int row,int col, int[]dir)
	{
		int count_rolls = 0;
		while(canRoll(row+dir[0], col+dir[1]))
		{
			row +=dir[0];
			col +=dir[1];
			count_rolls+=1;
		}
		
		return (new int[]{row,col,count_rolls});
	}
	
	public boolean canRoll(int row, int col)
	{
		if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length)
			return false;
		else
			return (maze[row][col]!=1);
	}
	
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) 
		{
			distance = new int[maze.length][maze[0].length];
			for(int i = 0; i < distance.length; i++) {
			    Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			this.maze = maze;
			return bfs(start,destination);
	        
	    }
	
	public static void main(String[] args)
	{
		int[][]maze = {{0, 0, 1, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{1, 1, 0, 1, 1},{0, 0, 0, 0, 0}};
		int[]start={0,4};
		int[]destination={4,4};
		Solution s = new Solution();
		System.out.println(s.shortestDistance(maze, start, destination));
	}

}
