
public class Solution {
	
	count[][] cache;
	private class count
	{
		int left=0,up=0,ul=0,ur=0;
		public void print()
		{
			System.out.print(this.left+","+this.up+","+this.ul+","+this.ur+"\t");
		}
		public int max()
		{
			int max = this.left;
			if (this.up>max)
				max = this.up;
			if (this.ul>max)
				max = this.ul;
			if (this.ur>max)
				max = this.ur;
			return max;
		}
	}
	public void longestLine(int[][] M) 
	{
		if (M.length==0 || M[0].length==0)
			return ;
		int MAX=Integer.MIN_VALUE;
		cache = new count[M.length][M[0].length];
		 for (int i=0;i<cache.length;i++)
	        {
	        	for (int j=0;j<cache[0].length;j++)
	        		cache[i][j] = new count();
	        }
		if (M[0][0]==1)
			cache[0][0].up=cache[0][0].left=cache[0][0].ul=cache[0][0].ur=1;
		else
			cache[0][0].up=cache[0][0].left=cache[0][0].ul=cache[0][0].ur=0;
		
        for (int i=0;i<cache.length;i++)
        {
        	for (int j=0;j<cache[0].length;j++)
        	{
        		if (M[i][j]==0)
        			cache[i][j].up=cache[i][j].left=cache[i][j].ul=cache[i][j].ur=0;
        		else
        		{
        			cache[i][j].up=cache[i][j].ul=cache[i][j].left=cache[i][j].ur=1;
        			if (j>0)
        					cache[i][j].left+=cache[i][j-1].left;
        			if (i>0)
        					cache[i][j].up+=cache[i-1][j].up;
        			if (i>0 && j >0)
        					cache[i][j].ul+=cache[i-1][j-1].ul;
        			if (i>0 && j < cache[0].length-1)
        					cache[i][j].ur+=cache[i-1][j+1].ur;
        		}
        		if (cache[i][j].max()>MAX)
        			MAX=cache[i][j].max();
        	}
        }
        for (int i=0;i<cache.length;i++)
        {
        	System.out.println("");
        	for (int j=0;j<cache[0].length;j++)
        		{
        			cache[i][j].print();
    			}
        }
        System.out.println("\nMax "+MAX);
    }
	
	public static void main(String[] args)
	{
		Solution s = new Solution();
		int[][]input = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
		//int[][]input = {{1}};

		s.longestLine(input);
	}
	
	
}
