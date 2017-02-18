import java.lang.*;
public class Mad {
	
	int [] input ;
	
	public Mad(int[] in)
	{
		input = in;
	}
	
	public int MaxContiguousSum(int start_index, int end_index)
	{
		int size = end_index - start_index + 1;
		int MaxSoFar = input[start_index]; 
		int MaxEndingHere = input[start_index];
		
		for (int i = start_index+1;i<size;i++)
		{
			MaxEndingHere = Math.max(input[i],input[i]+MaxEndingHere);
			if (MaxEndingHere > MaxSoFar)
				MaxSoFar = MaxEndingHere;
		}
		return MaxSoFar;
	}
	
	public void invert()
	{
		for (int i=0;i<input.length;i++)
			input[i] = -input[i];
	}
	
	public int MaxDiffSum()
	{
		int []MaxLeft = new int[input.length];
		MaxLeft[0] = input[0];
		for (int i = 1;i<input.length;i++)
		{
			MaxLeft[i] = MaxContiguousSum(0,i);
		}
		
		int []MaxRight = new int[input.length];
		MaxRight[input.length-1]=input[input.length-1];
		for (int i = 0;i<input.length-1;i++)
		{
			MaxRight[i] = MaxContiguousSum(i+1,input.length);
		}
		
		invert();
		
		int []MinLeft = new int[input.length];
		MinLeft[0] = -input[0];
		for (int i = 1;i<input.length;i++)
		{
			MinLeft[i] = -MaxContiguousSum(0,i);
		}
		
		int []MinRight = new int[input.length];
		MinRight[input.length-1]= -input[input.length-1];
		for (int i = 0;i<input.length-1;i++)
		{
			MinRight[i] = -MaxContiguousSum(i+1,input.length);
		}
		
		invert(); //undo inversion.
		
		int result = Integer.MIN_VALUE;
		int temp;
		for (int i =0 ;i < input.length;i++)
		{
			temp = Math.max(Math.abs(MaxLeft[i]-MinRight[i]), Math.abs(MaxRight[i]-MinLeft[i]));
			if (temp > result)
				result = temp;
		}
		
		return result;
	}
	
	
	public static void main(String[] args)
	{
		int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
		Mad M = new Mad(input);
		System.out.println(M.MaxContiguousSum(4,input.length-1));
		
		System.out.println(M.MaxDiffSum());
		
	}

}
/*http://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/*/
