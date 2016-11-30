
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
	
	static class profitMax
	{
		int days; ArrayList<Long>costs;
		Long[][] profit;
		public profitMax(int numdays, ArrayList<Long> prices)
		{
			days = numdays;
			costs = prices;
			profit = new Long[numdays+1][numdays+1];
			for (int i=0;i<=numdays;i++)
				profit[0][i] =0L;
		}
		
		public Long trigger()
		{
			for (int day = 1 ;day<=days;day++)
			{
				for (int stock = 0;stock <= days;stock++)
				{
					if (stock > day)
						{
							profit[day][stock]=Long.MIN_VALUE; 
						}
					else
					{
					ArrayList<Long>candidates = new ArrayList<Long>();
					
					
						//did nothing
						if (stock < day)
							candidates.add(profit[day-1][stock]);
						//sold
						for (int j = stock+1;j<=day-1;j++)
							candidates.add(profit[day-1][j]+costs.get(day-1)*(j-stock));
						//bought
						if (stock >= 1)
							candidates.add(profit[day-1][stock-1]-costs.get(day-1));
					
					
					profit[day][stock]=Collections.max(candidates);
					
				}
				}//else
			}
			
//			System.out.println("");
//			for (int day=0;day<=days;day++)
//			{
//				for(int stock =0; stock<=day;stock++)
//				{
//					System.out.print(profit[day][stock]+"\t");
//				}
//				System.out.println("");
//			}
			
			ArrayList<Long>result = new ArrayList<Long>();
			for (int i =0;i<=days;i++)
			{
				result.add(profit[days][i]);
			}
			return Collections.max(result);
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		String filename = args[0];
		String line;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		for (int i=0;i<testcases;i++)
		{
			int days = Integer.parseInt(br.readLine());
			line = br.readLine();
			String[] inputs = line.split(" ");
			ArrayList<Long> costs = new ArrayList<Long>();
			for (int j=0;j<inputs.length;j++)
				costs.add(Long.parseLong(inputs[j]));
			profitMax P = new profitMax(days,costs);
			System.out.println(P.trigger());
		}
	}

}
