import java.lang.*;
import java.util.Arrays;
import java.util.Hashtable;
public class solution {
	
	Hashtable<pair,Integer> H = new Hashtable<pair,Integer>();
	private class pair
	{
		int a,b;
		public pair(int a, int b)
		{
			this.a = a; this.b = b;
		}
		@Override
		public int hashCode()
		{
			return (int)(a*Math.pow(13, 0)+b*Math.pow(13, 1));
		}
	}
	
	int [] input;
	public solution(int[] in)
	{
		input = in;
	}
	
	int optimal(int start, int end)
	{
		pair p = new pair(start, end);
		
		if (H.contains(p))
			return H.get(p);
		else
		{
			if (start>end)
				return 0;
			else
			{
				//Maximum of minimums-my rival makes selections to minimize my gains.
				int result = Math.max(input[start]+Math.min(optimal(start+2,end), optimal(start+1,end-1)),
						input[end]+Math.min(optimal(start+1,end), optimal(start, end-2)));
				H.put(p, result);
				return result;
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		int []input = {8, 15, 3, 7};
		solution s = new solution(input);
		System.out.println(s.optimal(0, input.length-1));
	}

}
