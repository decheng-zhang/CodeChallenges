
public class Solution {
	
	int[][]map;
	int[]visited;
	int lowerLimit,higherLimit;
	public Solution()
	{
		map = new int[10][10];
	    map[1][3]=map[3][1]=2;
	    map[1][7]=map[7][1]=4;
	    map[7][9]=map[9][7]=8;
	    map[3][9]=map[9][3]=6;
	    map[2][8]=map[8][2]=map[4][6]=map[6][4]=map[1][9]=map[9][1]=map[3][7]=map[7][3]=5;
	    visited = new int[10];
	    
	}
	
	 	
	    
	    public int dfs(int num, int len, int count)
	    {
	        if (len>higherLimit)
	            return count;
	        if (len>=lowerLimit)
	            count++;
	        len++;
	        visited[num]=1;
	        for (int next = 1;next<=9;next++)
	        {
	            if (visited[next]!=1 && (visited[map[num][next]]==1 || map[num][next]==0))
	                count=dfs(next,len,count);
	        }
	        visited[num]=0;
	        return count;
	    }
	    
	    public int numberOfPatterns(int m, int n) {
	        lowerLimit = m;
	        higherLimit = n;
	        int patterns = 0;
	        //owing to symmetry
	        patterns += 4*dfs(2,1,0); //2,4,6,8 has symmetrical patterns
	        patterns +=4*dfs(1,1,0); //1,3,7,9 has similar patterns
	        patterns += dfs(5,1,0);
	        
	        return patterns;
	    }
	
	/*public static void main(String[] args)
	{
		int[][] map = new int[2][2];
		map[0][0]=1;
		return;
	}*/

}
