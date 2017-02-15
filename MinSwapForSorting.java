package minSwaps;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;

public class minSwap {
	
	ArrayList<pair<Integer,Integer>> bank = new ArrayList<pair<Integer,Integer>>();
	
	private class pair<T1,T2>
	{
		T1 val1;
		T2 val2;
		
		public pair(T1 v1, T2 v2)
		{
				val1 = v1;
				val2 = v2;
		}
		
		public void print()
		{
			System.out.print(val1+","+val2+" ");
		}
		
	}
	
	public int MS(int [] input)
	{
		for (int i= 0 ;i < input.length;i++)
		{
			bank.add(new pair<Integer,Integer>(input[i],i));
		}
		
		bank.sort(
				new Comparator<pair<Integer,Integer>>()
				{
					@Override
					public int compare(pair<Integer,Integer>o1, pair<Integer,Integer> o2)
					{
						if (o1.val1 > o2.val1)
							return 1;
						else if (o1.val1.equals(o1.val2))
							return 0;
						else 
							return -1;
					}
				});
		
		boolean[]visited = new boolean[input.length];
		boolean closed = false;
		int nextPos;
		Arrays.fill(visited,false);
		int counter = 0;
		for (int i = 0;i<bank.size();i++)
		{
			if (visited[i])
				continue;
			visited[i] = true;
			nextPos = bank.get(i).val2;
			closed = false;
			while (!closed)
			{
				
				if (visited[nextPos])
					{
						closed = true;
						continue;
					}
				counter+=1;
				visited[nextPos] = true;
				nextPos = bank.get(nextPos).val2;
				
			}
			
		}
		
		
		for (int i=0;i<bank.size();i++)
			bank.get(i).print();
		System.out.println("counter "+counter);
		return counter; 
	}
	
	
	public static void main(String[] args)
	{
		int[] input = {1, 5, 4, 3, 2};
		minSwap M = new minSwap();
		System.out.println("Swaps required to sort " + M.MS(input));
	}

}
