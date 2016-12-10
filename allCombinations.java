package allCombinations;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Given a list of integers and a number n, generate all possible
 * combinations of cardinality n
 * leverage functionality provided by sets
 *  */
public class getCombinations {
	
	List<Set<Integer>> result = new LinkedList<Set<Integer>>();
	int[]input;
	Set<Integer> temp = new HashSet<Integer>();
	int counter = 0;
	public getCombinations(int[] seq, int len)
	{
		input = seq;
		genComb(0,len,temp);
	}
	
	private void genComb(int start, int n, Set<Integer> S)
	{
		counter ++;
		if (n == 0)
		{
			result.add(new HashSet<Integer>(S));
		}
		else if (start >= input.length)
		{
			return;
		}
		else
		{
			S.add(input[start]);
			genComb(start+1,n-1,S);
			S.remove(input[start]);
			genComb(start+1,n,S);
		}
	}
	
	public void display()
	{
		for (Set<Integer> t:result)
		{
			
			for (int i:t)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println(counter + " number of method calls.");
	}
	
	public static void main(String[]args)
	{
		int[]input = {1,2,3,4,5};
		getCombinations G = new getCombinations(input,4);
		G.display();
	}
}
