/*
 * solved leveraging bottoms up approach.
 * scanning the candidate set to get the optimum result for each subproblem is linear, so linear work done per subproblem.
 * to be noted the scanning process-- in the logical structure of the solution, pay attention as to how the size of the subproblem
 * is used to impose a implicit order on the computation of subproblems.
 * for a given range bounded by left and right indexes, candidates are evaluated with root set at every index from left to right bound.
 * --------------------------------------------------
 * Consider an instance of the optimal binary search tree problem with 7 keys (say 1,2,3,4,5,6,7 in sorted order) 
 * and frequencies w1=.2,w2=.05,w3=.17,w4=.1,w5=.2,w6=.03,w7=.25.
 * What is the minimum-possible average search time of a binary search tree with these keys?
 * a. 2.33 b. 2.23 c. 2.18 d. 2.29
 */
public class OST {
	
	double [] freq;
	int input_size;
	double[][]cost;
	public OST(double freq[])
	{
		this.freq = freq;
		input_size = freq.length;
		cost = new double[input_size][input_size];
	}
	
	public double sum_freq(int start, int end)
	{
		double sum = 0;
		for (int i = start;i<= end;i++)
			sum = sum+freq[i];
		return sum;
	}
	
	public void solve()
	{
		int size = input_size-1;
		for (int s = 0;s<=size;s++)
		{
			for (int i = 0;i<input_size;i++)
			{
				if (i+s>=input_size)
					continue;
				if (s==0)
					cost[i][i+s]=freq[i];
				else
				{
					double min = Double.MAX_VALUE;
					for (int r=i;r<=i+s;r++)
					{
						double left = i>(r-1)?0:cost[i][r-1];
						double right = (r+1)>(i+s)?0:cost[r+1][i+s];
						
						if (left+right < min)
							min = left+right;
					}
					cost[i][i+s]= min + sum_freq (i,i+s);
				}
			}
		}
	}
	
	public void answer()
	{
		System.out.println(cost[0][input_size-1]);
	}
	
	
	public static void main(String[] args)
	{
		double[] frequency = {.2,.05,.17,.1,.2,.03,.25};
		OST ost = new OST(frequency);
		ost.solve();
		ost.answer();
		
	}

}
