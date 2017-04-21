import java.util.List;
import java.util.LinkedList;
import java.lang.StringBuffer;

public class Solution {
    
    int[][]board;
	int col = 0;
	int N;
	List<List<String>> solution;

	
	public void display()
	{
	
		for (List<String> L:solution)
		{
			System.out.println();
			for (String s:L)
				System.out.println(s);
		}
		
		
	}
	
	public List<String> getSolution()
	{
		List<String> sol = new LinkedList<String>();
		StringBuffer temp;
		for (int i=0;i<N;i++)
		{
			temp = new StringBuffer();
			for (int j=0;j<N;j++)
			{
				if (board[i][j]==1)
					temp.append('Q');
				else
					temp.append('.');
			}
			sol.add(temp.toString());
		}
		return sol;
	}
	
	public boolean isSafe(int row, int col)
	{
		//check the row to left.
		for (int i = col;i>=0;i--)
		{
			if (board[row][i]==1)
				return false;
		}
		//check top diagonal to left
		for (int i = row,j = col;i>=0 && j>=0;i--,j--)
		{
			if (board[i][j]==1)
				return false;
		}
		//check bottom diagonal to left
		for (int i = row,j = col;i<N && j>=0;i++,j--)
		{
			if (board[i][j]==1)
				return false;
		}
		return true;
	}
	
	void place(int col)
	{
		if (col >= N)
			{
				solution.add(getSolution());
			}
		else
		{
			for (int row = 0;row<N;row++)
			{
				if (isSafe(row,col))
				{
					board[row][col]=1;
					place(col+1);
					board[row][col]=0;
				}
			}
		}
	}
    public List<List<String>> solveNQueens(int n) {
        
        this.N = n;
		board = new int[n][n];
		solution = new LinkedList<List<String>>();
		place(0);
		return solution;
		
		  
    }
}
