package stockMaximize;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class solution {
	
	static class profitMax
	{
		int days; ArrayList<Integer>costs;
		int[][] profit;
		public profitMax(int numdays, ArrayList<Integer> prices)
		{
			days = numdays;
			costs = prices;
			profit = new int[numdays+1][numdays+1];
			for (int i=0;i<=numdays;i++)
				profit[0][i] =0;
		}
		
		public int trigger()
		{
			for (int day = 1 ;day<=days;day++)
			{
				for (int stock = 0;stock <= day;stock++)
				{
					ArrayList<Integer>candidates = new ArrayList<Integer>();
					
					if (stock < day)
					{
						//did nothing
						candidates.add(profit[day-1][stock]);
						//sold
						for (int j = stock+1;j<=day-1;j++)
							candidates.add(profit[day-1][j]+costs.get(day-1)*(j-stock));
						//bought
						if (stock >= 1)
						candidates.add(profit[day-1][stock-1]-costs.get(day-1));
					}
					else if (stock == day)
					{
						//bought
						candidates.add(profit[day-1][stock-1]-costs.get(day-1));
					}
					
					profit[day][stock]=Collections.max(candidates);
					if (stock > day)
						profit[day][stock]=Integer.MIN_VALUE;
					
				}
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
			
			ArrayList<Integer>result = new ArrayList<Integer>();
			for (int i =0;i<=days;i++)
			{
				result.add(profit[days][i]);
			}
			return Collections.max(result);
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		//String filename = args[0];
		String line;
		//BufferedReader br = new BufferedReader(new FileReader(filename));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		for (int i=0;i<testcases;i++)
		{
			int days = Integer.parseInt(br.readLine());
			line = br.readLine();
			String[] inputs = line.split(" ");
			ArrayList<Integer> costs = new ArrayList<Integer>();
			for (int j=0;j<inputs.length;j++)
				costs.add(Integer.parseInt(inputs[j]));
			profitMax P = new profitMax(days,costs);
			System.out.println(P.trigger());
		}
	}

}
